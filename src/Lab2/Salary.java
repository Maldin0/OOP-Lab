/**
 * @author Maldin0
 * @created 1/23/2023 - 2:17 PM
 * @project OOP-Lab
 */
package Lab2;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please insert your name : ");
        String name = input.nextLine();
        System.out.print("Please insert your age : ");
        int age = input.nextInt(), numDay1, numDay2;
        System.out.print("Please insert number of working days : ");
        numDay1 = input.nextInt();
        System.out.print("Please insert number of absent days : ");
        numDay2 = input.nextInt();
        System.out.print("Please insert your body weight : ");
        double weight = input.nextDouble(), salary = 0;
        System.out.println("Hi, " + name);
        if (21 <= age & age <= 31) {
            salary = (numDay1 * 300) - (numDay2 * 50);
        } else if (31 <= age & age <= 40) {
            salary = (numDay1 * 500) - (numDay2 * 50);
        } else if (41 <= age & age <= 50) {
            salary = (numDay1 * 1000) - (numDay2 * 25);
        } else if (51 <= age & age <= 60) {
            salary = (numDay1 * 3000);
        }
        System.out.println("Your salary is " + (int) salary + " Baht");
        if (10 <= weight & weight <= 60) {
            salary += 5000;
        } else if (61 <= weight & weight <= 90) {
            salary += 5000 - ((weight - 60) * 10);
        }
        System.out.println("Your salary and bonus is " + (int) salary + " Baht");
    }

}

