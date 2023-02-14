package Lab5;

/**
 * @author Maldin0
 * @created 2/14/2023 - 4:31 PM
 * @project OOP-Lab
 */
public class Plane extends Vehicle {
    public void showPlaneInfo() {
        System.out.print("Plane detail is, ");
        this.showInfo();
    }

    public void setPlaneInfo(int s, String t) {
        this.setFuel(s);
        this.setTopSpeed(t);
    }

    public void fly() {
        if (this.getFuel() - 200 >= 0) {
            this.setFuel(this.getFuel() - 200);
            System.out.println("Fly.");
        } else {
            System.out.println("Please add fuel.");
        }
    }
}
