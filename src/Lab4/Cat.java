package Lab4;

/**
 * @author Maldin0
 * @created 2/8/2023 - 10:17 PM
 * @project OOP-Lab
 */
public class Cat {
    public double height, weight;
    private String name, color;

    private void setWeight(double w) {
        if (w > 0) {
            this.weight = w;
        } else {
            System.out.println("Error");
        }
    }

    private void setHeight(double h) {
        if (h > 0) {
            this.height = h;
        } else {
            System.out.println("Error");
        }
    }

    private void setName(String n) {
        this.name = n;
    }

    private void setColor(String c) {
        this.color = c;
    }

    public void upWeight(double w) {
        if (w > 0) {
            this.setWeight(this.weight + w);
        } else {
            System.out.println("Error");
        }
    }

    public void downWeight(double w) {
        if (w > 0) {
            this.setWeight(this.weight - w);
        } else {
            System.out.println("Error");
        }
    }

    public void upHeight(double h) {
        if (h > 0) {
            this.setHeight(this.height + h);
        } else {
            System.out.println("Error");
        }
    }

    public void defineCat(String n, String c) {
        this.setName(n);
        this.setColor(c);
    }

    public void speak() {
        System.out.println("Name : " + this.name);
        System.out.println("Color : " + this.color);
        System.out.println("Height : " + this.height);
        System.out.println("Weight : " + this.weight);
    }
}

class TestCat {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.defineCat("Mew", "White");
        c.speak();
        c.upWeight(5);
        c.upHeight(10);
        c.speak();
        c.upWeight(-5);
        c.upHeight(-10);
        c.speak();
    }
}