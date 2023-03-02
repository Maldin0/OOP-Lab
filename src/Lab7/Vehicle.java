package Lab7;

/**
 * @author Maldin0
 * @created 3/3/2023 - 3:18 AM
 * @project OOP-Lab
 */
public abstract class Vehicle implements Dieselable {
    protected double fuel;

    public Vehicle() {
        this(0);
    }

    public Vehicle(double fuel) {
        this.setFuel(fuel);
    }

    public void addFuel(double fuel) {
        if (fuel > 0) {
            this.setFuel(this.getFuel() + fuel);
        } else {
            System.out.println("Fuel is empty.");
        }
    }

    public abstract void honk();

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
}
