package Lab3;

import java.util.Scanner;

/**
 * @author Maldin0
 * @created 2/3/2023 - 12:22 AM
 * @project OOP-Lab
 */
public class OddEven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int odd = 0, even = 0, num;
        while (true) {
            num = input.nextInt();
            if (num != -1) {
                if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            } else {
                break;
            }
        }
        System.out.println("Odd number = " + odd + " and Even number = " + even);
    }
}
