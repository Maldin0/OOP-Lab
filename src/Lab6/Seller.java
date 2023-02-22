package Lab6;

/**
 * @author Maldin0
 * @created 2/22/2023 - 1:32 PM
 * @project OOP-Lab
 */
public class Seller extends Employee{
    public Food sell(Employee e) {
        if (e.getWallet().getBalance() < Food.getPrice()) {
            System.out.println("Your money is not enough.");
            return null;
        }
        this.getWallet().setBalance(this.getWallet().getBalance()+Food.getPrice());
        e.getWallet().setBalance(e.getWallet().getBalance() - Food.getPrice());
        return new Food();
    }
}
