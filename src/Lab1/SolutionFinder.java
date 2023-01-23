/**
 * @author Maldin0
 * @created 1/23/2023 - 2:17 PM
 * @project OOP-Lab
 */
package Lab1;

public class SolutionFinder {
    public static void main(String[] args) {
        double a = 4, b = 8, c = 3, x1, x2, ans;
        ans = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        x1 = (-b + ans) / (2 * a);
        x2 = (-b - ans) / (2 * a);
        System.out.println(x1 + "\n" + x2);
    }
}
