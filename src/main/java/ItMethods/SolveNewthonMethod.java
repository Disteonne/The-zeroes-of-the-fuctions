package ItMethods;
import ItMethods.Polynom;

public class SolveNewthonMethod extends Function{
    private double inApprox;
    private double epsilon,error;
    private boolean b1,b2,b3,b4;
    private double res,tmp1,tmp2,tmp3;
    Polynom obj1;

                // КОНСТРУКТОР
    SolveNewthonMethod(int power,double leftBorA,double rightBorB,double epsilon) {
        super(power, leftBorA, rightBorB);
        this.epsilon = epsilon;
        tmp1=getLeftBorderA();
        tmp2=getRightBorderB();
        tmp3=getPower();
    }

    SolveNewthonMethod(Polynom obj,double epsilon){
        super(obj.getPower(),obj.getLeftBorderA(),obj.getRightBorderB());
        this.epsilon=epsilon;
        obj1=obj;
        tmp1=getLeftBorderA();
        tmp2=getRightBorderB();
        tmp3=getPower();
    }

    void choseApprox(){
        for (double i = tmp1; i <= tmp2; i +=epsilon) {
            if (obj1.getDiffFun1(i) > 0 &&
                    obj1.getDiffFun2(i) > 0 ||
                    obj1.getDiffFun1(i) < 0 &&
                            obj1.getDiffFun2(i) < 0){
                inApprox = tmp2;
            } else inApprox = tmp1;
        }
    }

            //МЕТОДЫ ДОСТУПА К ПРЕМЕННОЙ ЭКЗ.КЛАССА


    public double getTmp3() {
        return tmp3;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public double getEpsilon() {
        return epsilon;
    }

                //ПЕРЕОПРЕДЕЛЕНИЕ ФУНКЦИЙ
    /*
    double getFun(double inApprox) {
        return Math.pow(inApprox,tmp3)-3*Math.pow(inApprox,tmp3-2)
                -4*Math.pow(inApprox,tmp3-3)+2*inApprox+4;
    }

    double getDiffFun1(double inApprox) {
        return tmp3*Math.pow(inApprox,tmp3-1)
                -3*(tmp3-2)*Math.pow(inApprox,tmp3-3)
                -4*(tmp3-3)*Math.pow(inApprox,tmp3-4)+2;
    }

    double getDiffFun2(double inApprox){
        return tmp3*(tmp3-1)*Math.pow(inApprox,tmp3-2)
                -3*(tmp3-2)*(tmp3-3)*Math.pow(inApprox,tmp3-4)
                -4*(tmp3-3)*(tmp3-4)*Math.pow(inApprox,tmp3-5);
    }

     */
                // ДОСТАТОЧНЫЕ УСЛОВИЯ

    // 1е достаточное условие: f(a)*f(b)<0
    boolean checkFun(){
        if(obj1.getFun(tmp1)*obj1.getFun(tmp2)<0){
            System.out.println("Уравнение точно имеет хотя бы один корень.");
            b1=true;
        }
        return b1;
    }

    // 2e достаточное условие: x0 должно удовлетворять f(x0)*f``(x0)>0
    boolean checkInApprox() {
        if (obj1.getFun(inApprox) * obj1.getDiffFun2(inApprox) > 0) {
            System.out.println("Верное приближение");
            return b2 = true;
        } else {
            System.out.println("Начальное приближнение не удовлетворяет условию f`(x0)*f``(x0)>0.");
            return false;
        }
    }

    //3е достаточное условие: 1я Производная не должна = 0 и должна сохр знак для всех х
    // из промежутка от а до b. В качестве шага взята точность.
    boolean checkDiff(){

        for(double i=tmp1;i<=tmp2;i+=epsilon){
            if(obj1.getDiffFun1(i)!=0 && (obj1.getDiffFun1(i)>0 || obj1.getDiffFun1(i)<0)){
                b3=true;
            }
        }
        return b3;
    }

    //4е достаточное условие: 2я Производная должна сохранять знак на всем интервале
    boolean checkDiff1() {
        for (double i = tmp1; i <= tmp2; i += epsilon) {
            if (obj1.getDiffFun2(i) > 0 || obj1.getDiffFun2(i) < 0) {
                b4 = true;
            }
        }
        return b4;
    }

    void solve(){
        if(b1 && b2 && b3 && b4  ) {
            do {
                res = inApprox - obj1.getFun(inApprox) / obj1.getDiffFun1(inApprox);
                error=res-inApprox;
                inApprox=res;
                System.out.println(+res);
            } while (Math.abs(error) > epsilon );

        }
        else System.out.println("Не выполненно одно из достаточных условий!");
    }
}


