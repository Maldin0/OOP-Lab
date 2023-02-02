package Lab3;

import java.util.Scanner;

/**
 * @author Maldin0
 * @created 2/2/2023 - 11:57 PM
 * @project OOP-Lab
 */
public class BoBTheBuilder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("กรุณาระบุความสูงตึก : ");
        int height = input.nextInt();
        for (int i = 1; i <= height; i++) {
            System.out.println("#-#-#-#-#");
        }
    }
}
