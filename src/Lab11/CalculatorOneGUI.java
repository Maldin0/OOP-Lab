package Lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Maldin0
 * @created 3/30/2023 - 4:08 PM
 * @project OOP-Lab
 */
public class CalculatorOneGUI implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JTextField textField1, textField2, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    public CalculatorOneGUI() {
        frame = new JFrame();
        panel = new JPanel(new GridLayout(0,1));

        textField1 = new JTextField(50);
        textField2 = new JTextField(50);
        resultField = new JTextField(50);

        Font buttonFont = new Font("Tahoma", Font.BOLD, 14);

        addButton = new JButton("บวก");
        subtractButton = new JButton("ลบ");
        multiplyButton = new JButton("คูณ");
        divideButton = new JButton("หาร");

        addButton.setFont(buttonFont);
        subtractButton.setFont(buttonFont);
        multiplyButton.setFont(buttonFont);
        divideButton.setFont(buttonFont);

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        frame.setTitle("เครื่องคิดเลข");
        resultField.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        String bText = ((JButton) ae.getSource()).getText();
        Double num1 = Double.parseDouble(textField1.getText());
        Double num2 = Double.parseDouble(textField2.getText());
        Double res = 0.0;
        if(ae.getSource().equals(addButton)){
            res = num1+num2;
        }else if(ae.getSource().equals(subtractButton)){
            res = num1-+num2;
        }else if(ae.getSource().equals(multiplyButton)){
            res = num1*num2;
        }else if(ae.getSource().equals(divideButton)){
            res = num1/num2;
        }
        resultField.setText(String.valueOf(res));

    }
}
