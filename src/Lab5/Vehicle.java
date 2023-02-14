package Lab5;

/**
 * @author Maldin0
 * @created 2/14/2023 - 4:06 PM
 * @project OOP-Lab
 */
public class Vehicle {
    private int fuel;
    private String topSpeed;

    protected int getFuel() {
        return this.fuel;
    }

    protected void setFuel(int i) {
        this.fuel = i;
    }

    protected String getTopSpeed() {
        return this.topSpeed;
    }

    protected void setTopSpeed(String n) {
        this.topSpeed = n;
    }

    public void showInfo() {
        System.out.println("Fuel is " + this.getFuel() + " litre and Top Speed is " + this.getTopSpeed() + " m/s.");
    }
}
//class test{
//    public static void main(String[] args) {
//        Vehicle ven = new Vehicle();
//        ven.setFuel(100);
//        ven.setTopSpeed("100");
//        ven.showInfo();
//    }
//}