package Lab5;

/**
 * @author Maldin0
 * @created 2/14/2023 - 3:25 PM
 * @project OOP-Lab
 */
public class FootballPLayer extends Player {
    private int playerNumber;
    private String position;

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public void setPlayerNumber(int n) {
        this.playerNumber = n;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String p) {
        this.position = p;
    }

    public boolean isSamePosition(FootballPLayer p) {
//        return this.isSameTeam(p)&(this.getPosition().equals(p.getPosition()));
        return (p.getPosition().equals(this.getPosition())) &
                (p.getTeam().equals(this.getTeam()));
//        if((p.getPosition().equals(this.position))&
//                (p.getTeam().equals(this.team))){
//            return true;
//        }else{
//            return false;
//        }

    }
}
