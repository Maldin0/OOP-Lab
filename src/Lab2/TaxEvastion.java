/**
 * @author Maldin0
 * @created 1/23/2023 - 2:17 PM
 * @project OOP-Lab
 */

package Lab2;

import java.util.Scanner;

public class TaxEvastion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double income = sc.nextDouble();
        if (income > 50000.00) {
            System.out.println(income * (10.0 / 100));
        } else {
            System.out.println(income * (5.0 / 100));
        }
    }
}
