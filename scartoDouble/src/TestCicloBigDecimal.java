import java.math.BigDecimal;

public class TestCicloBigDecimal {
    BigDecimal num1 = new BigDecimal("10.00");
    BigDecimal num2 = new BigDecimal("0.20");

    public void prova() {
        for (int i = 0; i < 5; i++) {
            num1 = num1.subtract(num2);
            System.out.println(num1);
        }
    }

    public static void main(String[] args) {
        TestCicloBigDecimal myTest = new TestCicloBigDecimal();
        myTest.prova();
    }
}
