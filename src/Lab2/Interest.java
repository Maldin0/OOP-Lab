/**
 * @author Maldin0
 * @created 1/23/2023 - 2:17 PM
 * @project OOP-Lab
 */
package Lab2;

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputs = new Scanner(System.in);
        System.out.print("Input your money : ");
        int income = inputs.nextInt();
        double out = income;
        System.out.print("Input your account type(Please type A B C or X in uppercase) : ");
        String type = input.nextLine();
        switch (type) {
            case "A", "C" -> out = income + income * (1.5 / 100);
            case "B" -> out = income + income * (2.0 / 100);
            case "X" -> out = income + income * (5.0 / 100);
        }
        System.out.println("Your total money in one year = " + (int) out);
    }
}
