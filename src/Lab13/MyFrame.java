package Lab13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Maldin0
 * @created 5/4/2023 - 7:43 PM
 * @project OOP-Lab
 */
public class MyFrame implements MouseListener {
    private Thread t;
    private MyTimer myTimer;
    private boolean isPause = false;
    public MyFrame() {
        JFrame frame = new JFrame("My Clock");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setPreferredSize(new Dimension(300, 50));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        MyClock clock = new MyClock();
//        Thread t = new Thread(clock);
        myTimer = new MyTimer();
        t = new Thread(myTimer);
        t.start();

        myTimer.addMouseListener(this);
        frame.setLayout(new FlowLayout());
//        frame.add(clock);
        frame.add(myTimer);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if (t.isAlive()) {
//            synchronized (t) {
//                try {
//                    t.wait();
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        } else {
//            synchronized (t) {
//                t.notify();
//            }
//        }n
        if (myTimer.isEnable) {
            myTimer.setForeground(Color.RED);
            myTimer.pauseTimer();
//            myTimer.setForeground(Color.RED);
        } else {
            myTimer.setForeground(Color.BLACK);
            myTimer.resumeTimer();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
