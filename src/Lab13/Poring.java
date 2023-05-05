package Lab13;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Maldin0
 * @created 5/4/2023 - 7:26 PM
 * @project OOP-Lab
 */
public class Poring extends JFrame implements Runnable{
    private JPanel panel;
    private JLabel poring;
    private JLabel countPoring;

    public Poring(int count) {
        panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(500,400));

        ImageIcon icon = new ImageIcon("C:/Users/Doomf/OneDrive - KMITL/1st year/ss2/OOP/Java/OOP-Lab/src/Lab13/poyo-kirby.gif");

        poring = new JLabel(icon);

        countPoring = new JLabel(String.valueOf(count));

        panel.add(poring, BorderLayout.CENTER);
        panel.add(countPoring, BorderLayout.EAST);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Random rand = new Random();
        int x =rand.nextInt(screenSize.width-this.getWidth());
        int y = rand.nextInt(screenSize.height-this.getHeight());

        this.setContentPane(panel);
        this.setLocation(x,y);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int dx = new Random().nextInt(5)-2;
            setLocation(getX()+dx, getY()+dx);
        }
    }
}