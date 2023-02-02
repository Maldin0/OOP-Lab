package Lab3;

import java.util.Scanner;

/**
 * @author Maldin0
 * @created 2/3/2023 - 12:40 AM
 * @project OOP-Lab
 */
public class Fifth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please insert a number : ");
        int num = input.nextInt();
        for (int i = 1; i <= num; i++) {
            if (i % 5 == 0) {
                System.out.print("/");
            } else {
                System.out.print("|");
            }
        }
    }
}
