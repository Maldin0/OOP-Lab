package Lab4;

/**
 * @author Maldin0
 * @created 2/9/2023 - 2:19 PM
 * @project OOP-Lab
 */
public class Account {
    public double balance;
    public String name;

    public void deposit(double b) {
        if (b >= 0) {
            this.balance += b;
        } else {
            System.out.println("The balance variable must be greater than or equal to zero.");
        }
    }

    public double withdraw(double b) {
        if ((this.balance - b) >= 0) {
            if (b >= 0) {
                this.balance -= b;
                return b;
            } else {
                System.out.println("The balance variable must be greater than or equal to zero.");
                return 0;
            }
        } else {
            System.out.println("Your account balance is insufficient.");
            return 0;
        }
    }

    public void showinfo() {
        System.out.println("In " + name + " account, there is a balance equal to " + balance + " baht");
    }
}
