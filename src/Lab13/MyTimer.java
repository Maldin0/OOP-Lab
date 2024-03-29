package Lab13;

import javax.swing.*;
import java.awt.*;


/**
 * @author Maldin0
 * @created 5/4/2023 - 8:18 PM
 * @project OOP-Lab
 */
public class MyTimer extends JLabel implements Runnable {
    private int sec;
    private int min;
    private int hour;
    public boolean isEnable = true;

    public MyTimer() {
        this.sec = 0;
        this.min = 0;
        this.hour = 0;
    }
    public synchronized void resumeTimer() {
        isEnable = true;
        this.notify();
    }

    public synchronized void pauseTimer() {
        isEnable = false;

    }

    private synchronized void checkPause() {
        while (!isEnable) {
            try {

                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void run() {
        while (true){
//            if (!isEnable) {
//                this.setForeground(Color.RED);
//            } else {
//                this.setForeground(Color.BLACK);
//            }
            checkPause();
            this.setFont(new Font("Tahoma", Font.BOLD, 30));
            this.setText(String.format("%02d : %02d : %02d", hour, min, sec));

            try {
                // Wait for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            if (isEnable){
//            this.setForeground(Color.BLACK);
            sec++;
            if (sec == 60) {
                sec = 0;
                min++;
                if (min == 60) {
                    min = 0;
                    hour++;
                }
            }
//            }   else {
//                this.setForeground(Color.RED);
//            }

        }
    }

//    public void setEnable(boolean enable) {
//        isEnable = enable;
//    }
//
//    public boolean isEnable() {
//        return isEnable;
//    }
}

