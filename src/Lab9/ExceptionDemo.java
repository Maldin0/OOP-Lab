package Lab9;

/**
 * @author Maldin0
 * @created 4/20/2023 - 4:11 PM
 * @project OOP-Lab
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            double numA = Double.parseDouble(args[0]);
            double numB = Double.parseDouble(args[1]);
            double numC = Double.parseDouble(args[2]);
            double sqrt_disc = Math.sqrt((numB * numB) - 4 * (numA * numC));
            double numX1 = (-numB + sqrt_disc) / (2 * numA);
            double numX2 = (-numB - sqrt_disc) / (2 * numA);
            System.out.println("x1: " + numX1 + "\nx2: " + numX2);
        } catch (NumberFormatException ex) {
            System.out.println("Please input data in number format only.");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Please enter 3 numbers as a, b, and c respectively.");
        }
    }
}
