package Lab3;

import java.util.Scanner;

/**
 * @author Maldin0
 * @created 2/3/2023 - 12:45 AM
 * @project OOP-Lab
 */
public class Fifth2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please insert a number : ");
        int num = input.nextInt();
        for (int i = 1; i <= num; i++) {
            System.out.print("|");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }
}
