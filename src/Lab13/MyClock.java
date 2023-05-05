package Lab13;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 * @author Maldin0
 * @created 5/4/2023 - 7:43 PM
 * @project OOP-Lab
 */
public class MyClock extends JLabel implements Runnable{
    @Override
    public void run() {
        while (true){
            Calendar d = Calendar.getInstance();
            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);
            this.setFont(new Font("Tahoma", Font.BOLD, 30));
            this.setText(String.format("%02d : %02d : %02d", hour, min, sec));

            try {
                // Wait for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
