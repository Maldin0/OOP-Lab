package Lab6;

/**
 * @author Maldin0
 * @created 2/22/2023 - 1:08 PM
 * @project OOP-Lab
 */
public class Food {
    private static final int energy = 10;
    private static double price = 50;

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        if (Food.price >= price) {
            System.out.println("Cannot update the food price.");
            return;
        }
        Food.price = price;
    }

    public static int getEnergy() {
        return energy;
    }
}
