package Lab8;

import java.util.ArrayList;

/**
 * @author Maldin0
 * @created 3/3/2023 - 12:47 AM
 * @project OOP-Lab
 */
public class Customer {
    private final String firstName;
    private final String lastName;
    //    private Account acct[];
    private final ArrayList acct;
    private int numOfAccount;

    public Customer() {
        this("", "");
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        acct = new Account[5];
        acct = new ArrayList<>();
    }

    public void addAccount(Account ac) {
        if (numOfAccount > 5) {
            System.out.println("limited only 5 account per customer.");
            return;
        }
//        for (int i = 0; i < 5; i++) {
//            if (acct[i] == null) {
//                acct[i] = ac;
//                numOfAccount++;
//                return;
//            }
//        }
        acct.add(ac);
        numOfAccount++;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " has " + this.getNumOfAccount() + " accounts.";
    }

    public Account getAccount(int index) {
        return (Account) acct.get(index);
    }

    public int getNumOfAccount() {
        return acct.size();
    }
}
