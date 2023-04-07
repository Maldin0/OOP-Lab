package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Maldin0
 * @created 3/31/2023 - 1:20 AM
 * @project OOP-Lab
 */

public class TellerGUI {
    public TellerGUI(){
        JFrame frame = new JFrame("Teller GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setResizable(false);

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(4, 1));

        JPanel firstPanel = new JPanel(new GridLayout(1,2));
        JPanel secondPanel = new JPanel(new GridLayout(1,2));
        JPanel thirdPanel = new JPanel(new FlowLayout());

        JLabel balance = new JLabel("Balance");
        JLabel amount = new JLabel("Amount");

        JTextField bTextField = new JTextField("0");
        JTextField aTextField = new JTextField();
        bTextField.setEditable(false);

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(bTextField.getText());
                double num2 = Double.parseDouble(aTextField.getText());
                double result = num1+num2;
                bTextField.setText(Double.toString(result));
                aTextField.setText("");
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(bTextField.getText());
                double num2 = Double.parseDouble(aTextField.getText());
                if (num1-num2 < 0) {return;}
                double result = num1-num2;
                bTextField.setText(Double.toString(result));
                aTextField.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        firstPanel.add(balance);
        firstPanel.add(bTextField);

        secondPanel.add(amount);
        secondPanel.add(aTextField);

        thirdPanel.add(depositButton);
        thirdPanel.add(withdrawButton);
        thirdPanel.add(exitButton);

        container.add(firstPanel);
        container.add(secondPanel);
        container.add(thirdPanel);

        frame.setVisible(true);
    }
}
