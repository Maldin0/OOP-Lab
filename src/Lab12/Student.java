package Lab12;

import java.io.Serializable;
/**
 * @author Maldin0
 * @created 4/20/2023 - 8:26 PM
 * @project OOP-Lab
 */
public class Student implements Serializable{
    private String name;
    private int ID;
    private int money;
    public Student() {
        this("", 000000, 0);
    }

    public Student(String name, int ID, int money) {
        setName(name);
        setID(ID);
        setMoney(money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
