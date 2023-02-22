package Lab6;

/**
 * @author Maldin0
 * @created 2/22/2023 - 1:17 PM
 * @project OOP-Lab
 */
public class Employee {
    private static String nationality = "Thai";
    private String name;
    private Wallet wallet;
    private int energy;

    public static String getNationality() {
        return nationality;
    }

    public static void setNationality(String nationality) {
        Employee.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void eat(Food f) {
        this.energy += f.getEnergy();
    }

    public boolean buyFood(Seller s) {
        Food f = s.sell(this);
        if (f == null) {
            return false;
        }
        this.eat(f);
        return true;
    }

    public boolean equals(Employee e) {
        return this.getName().equals(e.getName());
    }

    public String toString() {
        return "My name is " + this.getName() + ". \n" +
                "I have " + this.getEnergy() + " energy left.\n" +
                "I have a balance of " + this.getWallet().getBalance() + " baht.";
    }

}
