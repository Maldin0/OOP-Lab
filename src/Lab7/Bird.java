package Lab7;

/**
 * @author Maldin0
 * @created 3/3/2023 - 1:56 AM
 * @project OOP-Lab
 */
public abstract class Bird implements Flyable {
    private double wingSize;
    private double weight;
    private double height;

    public Bird() {
        this(0, 0, 0);
    }

    public Bird(double wingSize, double weight, double height) {
        this.setWingSize(wingSize);
        this.setHeight(height);
        this.setWeight(weight);
    }

    public double getWingSize() {
        return wingSize;
    }

    public void setWingSize(double wingSize) {
        this.wingSize = wingSize;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void eat(double food) {
        if (food > 0) {
            this.setWeight(this.getWeight() + food);
        } else {
            System.out.println("Input cannot be negative number.");
        }
    }
}
