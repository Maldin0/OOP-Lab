package Lab4;

/**
 * @author Maldin0
 * @created 2/10/2023 - 10:10 AM
 * @project OOP-Lab
 */
public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.defineCat("Mew","White");
        c.speak();
        c.upWeight(5);
        c.upHeight(10);
        c.speak();
        c.upWeight(-5);
        c.upHeight(-10);
        c.speak();
    }
}
