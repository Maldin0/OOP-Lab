package Lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

/**
 * @author Maldin0
 * @created 4/20/2023 - 8:32 PM
 * @project OOP-Lab
 */
public class StudentView implements ActionListener, WindowListener {
    private JFrame frame;
    private Container container;
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel thirdPanel;
    private JPanel fourthPanel;
    private JLabel ID;
    private JLabel Name;
    private JLabel Money;
    private JTextField IDTextField;
    private JTextField StdTextField;
    private JTextField MoneyTextField;
    private JButton depositButton;
    private JButton withdrawButton;
    private Student student;

    public StudentView() {
        student = new Student();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(200, 180));
        frame.setResizable(false);
        frame.addWindowListener(this);

        container = frame.getContentPane();
        container.setLayout(new GridLayout(4, 1));

        firstPanel = new JPanel(new GridLayout(1, 2));
        secondPanel = new JPanel(new GridLayout(1, 2));
        thirdPanel = new JPanel(new GridLayout(1, 2));
        fourthPanel = new JPanel(new FlowLayout());

        ID = new JLabel("ID:");
        Name = new JLabel("Name:");
        Money = new JLabel("Money:");

        IDTextField = new JTextField();
        StdTextField = new JTextField();
        MoneyTextField = new JTextField(String.valueOf(student.getMoney()));
        MoneyTextField.setEditable(false);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        depositButton.addActionListener(this);

        withdrawButton.addActionListener(this);

        firstPanel.add(ID);
        firstPanel.add(IDTextField);

        secondPanel.add(Name);
        secondPanel.add(StdTextField);

        thirdPanel.add(Money);
        thirdPanel.add(MoneyTextField);

        fourthPanel.add(depositButton);
        fourthPanel.add(withdrawButton);

        container.add(firstPanel);
        container.add(secondPanel);
        container.add(thirdPanel);
        container.add(fourthPanel);

        frame.pack();
        frame.setVisible(true);
        loadStdLog();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new StudentView();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(depositButton)) {
            student.setID(Integer.parseInt(IDTextField.getText()));
            student.setName(StdTextField.getText());
            student.setMoney(student.getMoney() + 100);
            MoneyTextField.setText(String.valueOf(student.getMoney()));
        } else if ((e.getSource().equals(withdrawButton)) & (student.getMoney() > 0)) {
            student.setMoney(student.getMoney() - 100);
            MoneyTextField.setText(String.valueOf(student.getMoney()));
        }
    }

    public void saveStdLog() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentM.data"))) {
            student.setID(Integer.parseInt(IDTextField.getText()));
            student.setName(StdTextField.getText());
            student.setMoney(Integer.parseInt(MoneyTextField.getText()));
            oos.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStdLog() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentM.data" +
                ""))) {
            Student loadedStudent = (Student) ois.readObject();
            student.setID(loadedStudent.getID());
            student.setName(loadedStudent.getName());
            student.setMoney(loadedStudent.getMoney());
            IDTextField.setText(String.valueOf(student.getID()));
            StdTextField.setText(student.getName());
            MoneyTextField.setText(String.valueOf(student.getMoney()));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        saveStdLog();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
