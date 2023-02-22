package Lab6;

/**
 * @author Maldin0
 * @created 2/22/2023 - 3:01 PM
 * @project OOP-Lab
 */
public class SeniorProgrammer extends Programmer {
    public void coding(String str) {
        if (this.getEnergy() >= 10) {
            System.out.println("I'm coding about " + str);
        } else {
            System.out.println("ZzZzZz");
        }
        this.setEnergy(this.getEnergy() - 5);
        this.setHappiness(this.getHappiness() - 5);
    }

    public void coding(String str, int num) {
        for (int i = 1; i <= num; i++) {
            this.coding(str);
        }
    }

    public void compliment(Programmer p) {
        p.setHappiness(p.getHappiness() + 20);
        System.out.println(p.getName() + " in a good mood");
    }

    public void blame(Programmer p) {
        p.setHappiness(p.getHappiness() - 20);
        System.out.println(p.getName() + " in a bad mood");
    }
}
