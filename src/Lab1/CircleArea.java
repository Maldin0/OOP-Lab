/**
 * @author Maldin0
 * @created 1/23/2023 - 2:17 PM
 * @project OOP-Lab
 */
package Lab1;

import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radius = input.nextDouble(), area;
        area = Math.PI * Math.pow(radius, 2);
        System.out.println(area);
    }
}
