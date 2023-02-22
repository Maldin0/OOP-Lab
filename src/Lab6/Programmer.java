package Lab6;

/**
 * @author Maldin0
 * @created 2/22/2023 - 2:45 PM
 * @project OOP-Lab
 */
public class Programmer extends Employee {
    private int happiness;

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void coding(String str) {
        int num = 30;
        SeniorProgrammer sp = new SeniorProgrammer();
        if (this.getEnergy() >= 30) {
            System.out.println("Your code is " + str);
        } else {
            System.out.println("Error Error Error");
        }
        if (this.getClass() == sp.getClass()) {
            num = 5;
        }
        this.setEnergy(this.getEnergy() - num);
        this.setHappiness(this.getHappiness() - num);
    }

    public void coding(char str) {
        this.coding(String.valueOf(str));
    }
}
