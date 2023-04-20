package Lab9;

/**
 * @author Maldin0
 * @created 4/20/2023 - 5:26 PM
 * @project OOP-Lab
 */
public class WithdrawException extends Exception{
    public int temp;
    public WithdrawException() {
        super();
    }
    public WithdrawException(String s) {
        super(s);
    }
}
