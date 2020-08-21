package ItMethods;

public class Test {
    public static void main(String[] args) {

                    // Проверка SolveHalfDiv
        Polynom p= new Polynom(5,1.8,2.3);
        //SolveHalfDiv obj = new SolveHalfDiv(5, 1.8, 2.3, 0.01);
        SolveHalfDiv obj1=new SolveHalfDiv(p,0.01);
        obj1.checkIntervalBoundary();
        obj1.solve();


                    // Проверка SolveChordMethod
    /*
       // SolveChordMethod obj1=new SolveChordMethod(5,1.8,2.3,0.01);
        Polynom p = new Polynom(5,1.8,2.3);
        SolveChordMethod obj1 = new SolveChordMethod(p,0.01);
        obj1.checkIntervalBoundary();
        obj1.checkInApprox();
        obj1.solve();
     */


                    // Проверка SolveNewtonMethod
        /*
        Polynom p = new Polynom(5,1.8,2.3);
       // SolveNewthonMethod obj2=new SolveNewthonMethod(5,1.8,2.3,0.01);
        SolveNewthonMethod obj2= new SolveNewthonMethod(p,0.01);
        obj2.checkIntervalBoundary();
        obj2.choseApprox();
        obj2.checkInApprox();
        obj2.checkFun();
        obj2.checkDiff();
        obj2.checkDiff1();
        obj2.solve();

         */


    }
}

