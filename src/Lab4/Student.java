package Lab4;

/**
 * @author Maldin0
 * @created 2/8/2023 - 3:46 PM
 * @project OOP-Lab
 */
public class Student {
    public String name;
    public double mScore, fScore;

    public void showGrade() {
        double score;
        score = (mScore * 0.4) + (fScore * 0.4) + 20;
        System.out.println("Your grade :" + score);
    }
}

