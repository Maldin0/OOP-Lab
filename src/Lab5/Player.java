package Lab5;

/**
 * @author Maldin0
 * @created 2/14/2023 - 1:35 PM
 * @project OOP-Lab
 */
public class Player {
    private String name;
    private String team;

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String t) {
        this.team = t;
    }

    public boolean isSameTeam(Player p) {
        return this.getTeam().equals(p.getTeam());
    }
}
