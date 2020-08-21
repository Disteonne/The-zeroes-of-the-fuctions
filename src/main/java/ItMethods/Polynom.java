package ItMethods;
import ItMethods.SolveNewthonMethod;
import ItMethods.SolveChordMethod;
import ItMethods.SolveHalfDiv;

final public class Polynom extends Function{

    Polynom(int power,double leftBordA, double rightBordB){
        super(power,leftBordA,rightBordB);
    }


    public double getFun(double inApprox) {
        return Math.pow(inApprox,getPower())-3*Math.pow(inApprox,getPower()-2)
                -4*Math.pow(inApprox,getPower()-3)+2*inApprox+4;
    }

    public double getDiffFun1(double inApprox) {
        return getPower()*Math.pow(inApprox,getPower()-1)
                -3*(getPower()-2)*Math.pow(inApprox,getPower()-3)
                -4*(getPower()-3)*Math.pow(inApprox,getPower()-4)+2;
    }

    public  double getDiffFun2(double inApprox){
        return getPower()*(getPower()-1)*Math.pow(inApprox,getPower()-2)
                -3*(getPower()-2)*(getPower()-3)*Math.pow(inApprox,getPower()-4)
                -4*(getPower()-3)*(getPower()-4)*Math.pow(inApprox,getPower()-5);
    }
}
