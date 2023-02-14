package Lab5;

/**
 * @author Maldin0
 * @created 2/14/2023 - 4:17 PM
 * @project OOP-Lab
 */
public class Car extends Vehicle {
    private String typeEngine;

    public String getTypeEngine() {
        return this.typeEngine;
    }

    public void setTypeEngine(String t) {
        this.typeEngine = t;
    }

    public void showCarInfo() {
        System.out.println("Car engine is " + this.getTypeEngine() + ".");
        this.showInfo();
    }

    public void setCarInfo(int s, String t, String y) {
        this.setFuel(s);
        this.setTopSpeed(t);
        this.setTypeEngine(y);
    }

    public void move() {
        if (this.getFuel() - 50 >= 0) {
            this.setFuel(this.getFuel() - 50);
            System.out.println("Move.");
        } else {
            System.out.println("Please add fuel.");
        }
    }
}
//class test {
//    public static void main(String[] args) {
//        Car nissan = new Car();
//        nissan.setCarInfo(50, "High", "Diesel");
//        nissan.showCarInfo();
//        nissan.move();
//        nissan.showCarInfo();
//    }
//}
