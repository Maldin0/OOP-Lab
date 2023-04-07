package Lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Maldin0
 * @created 3/31/2023 - 1:20 AM
 * @project OOP-Lab
 */

public class TellerGUI implements ActionListener{
    private JFrame frame;
    private Container container;
    private JPanel firstPanel, secondPanel, thirdPanel;
    private JLabel balance, amount;
    private JTextField bTextField,aTextField;
    private JButton depositButton, withdrawButton, exitButton;
    public TellerGUI(){
        frame = new JFrame("Teller GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setResizable(false);

        container = frame.getContentPane();
        container.setLayout(new GridLayout(4, 1));

        firstPanel = new JPanel(new GridLayout(1,2));
        secondPanel = new JPanel(new GridLayout(1,2));
        thirdPanel = new JPanel(new FlowLayout());

        balance = new JLabel("Balance");
        amount = new JLabel("Amount");

        bTextField = new JTextField("0");
        aTextField = new JTextField();
        bTextField.setEditable(false);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        exitButton = new JButton("Exit");


        depositButton.addActionListener(this);

        withdrawButton.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(bTextField.getText());
        double num2 = Double.parseDouble(aTextField.getText());
        if (e.getSource().equals(depositButton)) {
            double result = num1+num2;
            bTextField.setText(Double.toString(result));
            aTextField.setText("");
        } else if ((e.getSource().equals(withdrawButton)) & (num1-num2 >= 0)) {
            double result = num1-num2;
            bTextField.setText(Double.toString(result));
            aTextField.setText("");
        }
    }
}
