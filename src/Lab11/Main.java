package Lab11;

import Lab11.CalculatorOneGUI;
import Lab11.CalculatorTwoGUI;
import Lab11.TellerGUI;

import javax.swing.*;

/**
 * @author Maldin0
 * @created 3/30/2023 - 4:17 PM
 * @project OOP-Lab
 */
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
        new CalculatorOneGUI();
        new CalculatorTwoGUI();
        new TellerGUI();
        });
    }
}
