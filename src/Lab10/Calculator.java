package Lab10;

/**
 * @author Maldin0
 * @created 3/30/2023 - 4:10 PM
 * @project OOP-Lab
 */
public class Calculator {
    private float num1;
    private float num2;
    public Calculator() {
        this(0, 0);
    }
    public Calculator(float num1, float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public float plus() {
        return num1+num2;
    }

    public float minus() {
        return num1-num2;
    }

    public float multiply() {
        return num1*num2;
    }

    public float divide() {
        return num1/num2;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }
}
