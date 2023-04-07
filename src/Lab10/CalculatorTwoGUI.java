package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Maldin0
 * @created 3/30/2023 - 10:12 PM
 * @project OOP-Lab
 */
public class CalculatorTwoGUI {
    public CalculatorTwoGUI() {
        JFrame frame = new JFrame("My Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(400,600));
        frame.setResizable(false);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.setEditable(false);
        container.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        ActionListener buttonListener = new ActionListener() {
            private String currentNumber = "";
            private String firstOperand = "";
            private String secondOperand = "";
            private String currentOperation = "";

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String buttonText = source.getText();

                if (buttonText.matches("\\d")) { // If the button is a digit
                    currentNumber += buttonText;
                    textField.setText(currentNumber);
                } else if (buttonText.matches("[+\\-*/]")) { // If the button is an operation
                    if (!currentNumber.isEmpty()) {
                        firstOperand = currentNumber;
                        currentNumber = "";
                    }
                    currentOperation = buttonText;
                    textField.setText(firstOperand + " " + currentOperation);
                } else if (buttonText.equals("=")) { // If the button is the equals sign
                    if (!currentNumber.isEmpty() && !firstOperand.isEmpty() && !currentOperation.isEmpty()) {
                        secondOperand = currentNumber;
                        double result = performOperation();
                        textField.setText(String.valueOf(result));
                        currentNumber = String.valueOf(result);
                        firstOperand = "";
                        secondOperand = "";
                        currentOperation = "";
                    }
                } else if (buttonText.equals("C")) { // If the button is the clear button
                    currentNumber = "";
                    firstOperand = "";
                    secondOperand = "";
                    currentOperation = "";
                    textField.setText("");
                }
            }

            private double performOperation() {
                double first = Double.parseDouble(firstOperand);
                double second = Double.parseDouble(secondOperand);

                switch (currentOperation) {
                    case "+":
                        return first + second;
                    case "-":
                        return first - second;
                    case "*":
                        return first * second;
                    case "/":
                        if (second != 0) {
                            return first / second;
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                            return 0;
                        }
                    default:
                        throw new IllegalStateException("Unexpected operation: " + currentOperation);
                }
            }
        };


        for (int i = 7; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }

        JButton addButton = new JButton("+");
        addButton.addActionListener(buttonListener);
        buttonPanel.add(addButton);

        for (int i = 4; i <= 6; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }

        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(buttonListener);
        buttonPanel.add(subtractButton);

        for (int i = 1; i <= 3; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }

        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(buttonListener);
        buttonPanel.add(multiplyButton);

        String[] operations = {"0", "C", "=", "/"};
        for (String operation : operations) {
            JButton button = new JButton(operation);
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }

        container.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
