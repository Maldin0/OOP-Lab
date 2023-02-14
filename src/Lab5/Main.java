package Lab5;

import java.util.Scanner;

/**
 * @author Maldin0
 * @created 2/14/2023 - 2:54 PM
 * @project OOP-Lab
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        while (true) {
            System.out.print("Please input number : ");
            int num = input.nextInt();
            System.out.print("Please input case : ");
            int cas = input.nextInt();
            System.out.println("-----------------------------------------------------------------------");
            if (num == 1) {
                testPlayer(cas);
            } else if (num == 2) {
                testFootball(cas);
            } else if (num == 3) {
                testVehicle(cas);
            }
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Are you done? ");
            String don = input2.nextLine();
            if (don.equals("Yes")) {
                break;
            }
        }
    }

    public static void testPlayer(int c) {
        Player p1 = new Player();
        p1.setName("Bank");
        p1.setTeam("Gate OR");

        Player p2 = new Player();
        p2.setName("Khim");

        if (c == 1) {
            p2.setTeam("Gate OR");
        } else if (c == 2) {
            p2.setTeam("Gate AND");
        }

        if (p1.isSameTeam(p2))
            System.out.println(p1.getName() + " is a same team with " + p2.getName());
        else
            System.out.println(p1.getName() + " is not a same team with " + p2.getName());
    }

    public static void testFootball(int c) {
        FootballPLayer p1 = new FootballPLayer();
        p1.setName("Harry");
        p1.setTeam("Gryffindor");
        p1.setPlayerNumber(1);
        p1.setPosition("keeper");
        FootballPLayer p2 = new FootballPLayer();
        p2.setName("Jame");
        p2.setTeam("Gryffindor");
        p2.setPlayerNumber(1);
        if (c == 1) {
            p2.setPosition("keeper");
        } else if (c == 2) {
            p2.setPosition("fullback");
        }

        System.out.println("We are same position : " + p1.isSamePosition(p2));
        System.out.println("We are same team : " + p1.isSameTeam(p2));
    }

    public static void testVehicle(int c) {
        if (c == 1) {
            Plane p1 = new Plane();
            p1.setPlaneInfo(500, "High");
            p1.showPlaneInfo();
            Car c1 = new Car();
            c1.setCarInfo(500, "High", "Diesel");
            c1.showCarInfo();
        } else if (c == 2) {
            Plane p1 = new Plane();
            p1.setPlaneInfo(300, "High");
            p1.showPlaneInfo();
            p1.fly();
            p1.showPlaneInfo();
            p1.fly();
            p1.showPlaneInfo();
        } else if (c == 3) {
            Car c1 = new Car();
            c1.setCarInfo(60, "High", "Diesel");
            c1.showCarInfo();
            c1.move();
            c1.showCarInfo();
            c1.move();
            c1.showCarInfo();
        }

    }
}