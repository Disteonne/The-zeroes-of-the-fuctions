package ItMethods;
import ItMethods.Polynom;

public class SolveChordMethod extends Function{
    private double inApprox;
    private double epsilon,res,error;
    private double tmp1,tmp2,tmp3;
    Polynom obj1;

                //КОНСТРУКТОР С ПАРАМЕТРАМИ
    SolveChordMethod(int power,double leftBorA,double rightBorB,double epsilon) {
        super(power, leftBorA, rightBorB);
        this.epsilon = epsilon;
        tmp1 = getLeftBorderA();
        tmp2 = getRightBorderB();
        tmp3 = getPower();
    }

    SolveChordMethod(Polynom obj,double epsilon){
        super(obj.getPower(),obj.getLeftBorderA(),obj.getRightBorderB());
        obj1= obj;
        this.epsilon=epsilon;
        tmp1 = getLeftBorderA();
        tmp2 = getRightBorderB();
        tmp3 = getPower();
    }


    public double getTmp3() {
        return tmp3;
    }

    // ОПРЕДЕЛЕНИЕ НАЧАЛЬНОГО ПРИБЛИЖЕНИЯ inApprox
    void checkInApprox(){
        for (double i = tmp1; i < tmp2; i += epsilon) {
            if (obj1.getDiffFun2(i) * obj1.getFun(tmp1) > 0) {
                inApprox = tmp2;
            }
            if (obj1.getDiffFun2(i) *obj1.getFun(tmp2) > 0) {
                inApprox = tmp1;
            }
        }
    }
            //ПЕРЕОПРЕДЕЛЕНИЕ МЕТОДОВ
    //@Override
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

                //МЕТОД РЕШЕНИЯ


    void solve(){
        if(inApprox==tmp2){
            do{
                res=inApprox -obj1.getFun(inApprox)/(obj1.getFun(inApprox)-obj1.getFun(tmp1))*(inApprox-tmp1);
                error=res-inApprox;
                System.out.println(+res);
                inApprox=res;
            }while (Math.abs(error)>=epsilon);

        }
        if(inApprox==tmp1){
            do{
                res=inApprox-obj1.getFun(inApprox)/(obj1.getFun(tmp2)-obj1.getFun(inApprox))*(tmp2-inApprox);
                error=res-inApprox;
                System.out.println(+res);
                inApprox=res;
            }while (Math.abs(error)>=epsilon);
        }
        else System.out.println("Ошибка");
    }
}


