package Lab2;
import java.util.Scanner;
/**
 * @author Maldin0
 * @created 1/23/2023 - 3:59 PM
 * @project OOP-Lab
 */
public class MySwitch {
    public static void main(String[] args) {
        int x;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        x = sc.nextInt();
        switch (x)
        {
            case 1: case 2:
                System.out.print("Green");
                break;
            case 3: case 4: case 5:
                System.out.print("Blue");
                break;
            default:
                System.out.print("numbers 1-5 only");
        }
        System.out.print("Red");
    }
}
