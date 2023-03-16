package Lab8;

/**
 * @author Maldin0
 * @created 3/16/2023 - 8:05 PM
 * @project OOP-Lab
 */
public class Bank {
    private final Account[] acct;
    private int numAcct;

    public Bank() {
        acct = new Account[10];
    }

    public void addAccount(Account ac) {
        for (int i = 0; i < 10; i++) {
            if (acct[i] == null) {
                acct[i] = ac;
                numAcct++;
                return;
            }
        }
    }

    public Account getAccount(int index) {
        return acct[index];
    }

    public int getNumAccount() {
        return numAcct;
    }
}
