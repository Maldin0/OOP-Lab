package Lab8;

/**
 * @author Maldin0
 * @created 3/2/2023 - 11:40 PM
 * @project OOP-Lab
 */
public class CheckingAccount extends Account {
    private double credit;

    public CheckingAccount() {
        this(0, "", 0);
    }

    public CheckingAccount(double balance, String name, double credit) {
        super(balance, name);
        this.setCredit(credit);
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void withdraw(double a) {
        if (this.getBalance() - a < 0 & a > 0) {
            if (this.getBalance() + this.getCredit() - a < 0) {
                System.out.println("Not enough money!");
            } else {
                this.setCredit(this.getCredit() + this.getBalance() - a);
                this.setBalance(0);
                System.out.println("" + a + " baht is withdrawn from " + this.getName() + " and your credit balance is " + this.getCredit() + ".");
            }
        } else {
            if (a > 0) {
                this.setBalance(this.getBalance() - a);
                System.out.println("" + a + " baht is withdrawn from " + this.getName() + " and your credit balance is " + this.getCredit() + ".");
            } else {
                System.out.println("Input number must be a positive integer.");
            }
        }
    }

    public void withdraw(String a) {
        this.withdraw(Double.parseDouble(a));
    }

    public String toString() {
        return "The " + this.getName() + " account has " + this.getBalance() + " baht and " + this.getCredit() + " credits.";
    }
}
