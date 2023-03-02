package Lab7;

/**
 * @author Maldin0
 * @created 3/3/2023 - 12:47 AM
 * @project OOP-Lab
 */
public class Customer {
    private String firstName;
    private String lastName;
    private CheckingAccount acct;

    public Customer() {
        this("", "", null);
    }

    public Customer(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public Customer(String firstName, String lastName, CheckingAccount acct) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAcct(acct);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CheckingAccount getAcct() {
        return acct;
    }

    public void setAcct(CheckingAccount acct) {
        this.acct = acct;
    }

    public String toString() {
        if (acct == null) {
            return this.getFirstName() + " " + this.getLastName() + " doesn't have account.";
        } else {
            return "The " + this.getFirstName() + " account has " + acct.getBalance() + " baht and " + acct.getCredit() + " credits.";
        }
    }

    public boolean equals(Customer c) {
        if (!getFirstName().equals(c.getFirstName())) {
            return false;
        }
        return getLastName().equals(c.getLastName());
    }
}
