public class testCicloDouble {
    double num1 = 10.00 , num2 = 0.20;

    public void prova(){
        for (int i = 0; i < 5; i++) {
            num1 = num1-num2;
            System.out.println(num1);
        }
    }

    public static void main(String[] args) {
        testCicloDouble myTest = new testCicloDouble();
        myTest.prova();
    }
}

