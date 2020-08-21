package ItMethods;

public class Function {

        private int power; //Наивысшая степень многочлена
        private double leftBorderA, rightBorderB, temp;
        private int counter;
        /*
        *   leftBorderA-левая граница интервала;
        *   rightBorderB- правая граница интервала;
        *   temp-временная переменная для присваивания значения;
         */


               // КОНСТРУКТОР С ПАРАМЕТРАМИ

        Function(int power, double leftBorderA, double rightBorderB) {
            this.power = power;
            this.leftBorderA = leftBorderA;
            this.rightBorderB = rightBorderB;
        }

                // КОНСТРУКТОР ИСП.В КАЧ.АРГ ОБЪЕКТ*
        Function(Function obj) {
            this.power = obj.power;
            this.leftBorderA = obj.leftBorderA;
            this.rightBorderB = obj.rightBorderB;
        }
                //  МЕТОДЫ ДОСТУПА К ПЕРЕМЕННЫМ РОДИТ.КЛАССА


    public void setPower(int power) {
        this.power = power;
    }

    public void setLeftBorderA(double leftBorderA) {
        this.leftBorderA = leftBorderA;
    }

    public void setRightBorderB(double rightBorderB) {
        this.rightBorderB = rightBorderB;
    }

    public int getPower() {
        return power;
    }

    public double getLeftBorderA() {
        return leftBorderA;
    }

    public double getRightBorderB() {
        return rightBorderB;
    }

                // ЗАМЕЧАНИЕ И ПРОВЕРКА

        void checkIntervalBoundary(){
            if (power % 2 == 1) System.out.println("Так как старшая степень " +
                    "полинома равна " + power + " ,то следует,что полином \n" +
                    " имеет хотя-бы один действительный корень. ");

            if (leftBorderA > rightBorderB) {
                temp = rightBorderB;
                rightBorderB = leftBorderA;
                leftBorderA = temp;
            }
            System.out.println("Интервал: ["+leftBorderA+";"+rightBorderB+"]");

        }


    //    abstract double getFun(double inApprox);

    //    abstract double getDiffFun1(double inApprox);

    //    abstract double getDiffFun2(double inApprox);

    }


