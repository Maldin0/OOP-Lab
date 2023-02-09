package Lab4;

/**
 * @author Maldin0
 * @created 2/9/2023 - 2:43 PM
 * @project OOP-Lab
 */
public class Customer {
    public String name;
    public MyDate DOB;
    public Account acct;

}

class TestCus {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.name = "Taravichat";

        MyDate dob = new MyDate();
        dob.day = 8;
        dob.month = 11;
        dob.year = 2023;

        Account acct = new Account();
        acct.name = c.name;
        acct.balance = 500;

        c.DOB = dob;
        c.acct = acct;

        System.out.println("My name is " + c.name + ".");

        c.acct.showinfo();
        c.DOB.showDate();

        c.acct.deposit(500);
        c.acct.showinfo();
        c.acct.withdraw(3000);
        c.acct.showinfo();
    }
}
