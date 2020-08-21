package ItMethods;
import  ItMethods.Polynom;
public class SolveHalfDiv extends Function{

   private double pointDiv,error;
   private double epsilon;
   private double tmp1,tmp2,tmp3;
   Polynom obj1;

            //КОНСТРУКТОР С ПАРАМЕТРАМИ
    SolveHalfDiv(int power,double leftBorA,double rightBorB ,double epsilon){
        super(power,leftBorA,rightBorB);
        this.epsilon=epsilon;
        tmp1=getLeftBorderA();
        tmp2=getRightBorderB();
        tmp3=getPower();
    }

    SolveHalfDiv(Polynom obj,double epsilon){
        super(obj.getPower(),obj.getLeftBorderA(),obj.getRightBorderB());
        obj1=obj;
        this.epsilon=epsilon;
        tmp1=getLeftBorderA();
        tmp2=getRightBorderB();
        tmp3=getPower();
    }

            //КОНСТРУКТОР С ОБЪЕКТОМ*
    SolveHalfDiv(Function obj1,double epsilon) {
        super(obj1);
        this.epsilon=epsilon;
    }

            //МЕТОДЫ ДОСТУПА К ПЕРЕМЕННЫМ ЭКЗЕМПЛЯРА

    public double getTmp3() {
        return tmp3;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public double getEpsilon() {
        return epsilon;
    }
            //ПЕРЕОПРЕДЕЛЕНИЕ АБСТРАКТНЫХ МЕТОДОВ
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
    //Function s= new Function(5,1.8,2.3);
    //Function obg=new SolveHalfDiv(0.02);
    void solve(){

        if(obj1.getFun(tmp1)*obj1.getFun(tmp2)<0){
            pointDiv=(tmp1+tmp2)/2;
            do{
                if(obj1.getFun(tmp1)*obj1.getFun(pointDiv)<0){
                    tmp2=pointDiv;
                    error=tmp1-pointDiv;
                }
                if(obj1.getFun(tmp2)*obj1.getFun(pointDiv)<0){
                    tmp1=pointDiv;
                    error=tmp2-pointDiv;
                }
                pointDiv=(tmp1+tmp2)/2;


                System.out.println();
                System.out.println(+pointDiv);
            }while (Math.abs(error)>epsilon);
        }
        else System.out.println("Не выполняются требования для использования данного метода.");

    }
}

