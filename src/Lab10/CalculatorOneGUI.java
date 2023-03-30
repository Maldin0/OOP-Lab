package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Maldin0
 * @created 3/30/2023 - 4:08 PM
 * @project OOP-Lab
 */
public class CalculatorOneGUI {
    public CalculatorOneGUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(0,1));

        JTextField textField1 = new JTextField(50);
        JTextField textField2 = new JTextField(50);
        JTextField resultField = new JTextField(50);

        Font buttonFont = new Font("Tahoma", Font.BOLD, 14);

        JButton addButton = new JButton("บวก");
        JButton subtractButton = new JButton("ลบ");
        JButton multiplyButton = new JButton("คูณ");
        JButton divideButton = new JButton("หาร");

        addButton.setFont(buttonFont);
        subtractButton.setFont(buttonFont);
        multiplyButton.setFont(buttonFont);
        divideButton.setFont(buttonFont);

        frame.setTitle("เครื่องคิดเลข");
        resultField.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                double result = num1 + num2;
                resultField.setText(Double.toString(result));
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                double result = num1 - num2;
                resultField.setText(Double.toString(result));
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                double result = num1 * num2;
                resultField.setText(Double.toString(result));
            }
        });

        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                double result = num1 / num2;
                resultField.setText(Double.toString(result));
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        panel.add(textField1);
        panel.add(textField2);
        panel.add(buttonPanel);
        panel.add(resultField);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
