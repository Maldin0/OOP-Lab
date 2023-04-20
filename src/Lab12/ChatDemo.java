package Lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Maldin0
 * @created 4/20/2023 - 6:22 PM
 * @project OOP-Lab
 */
public class ChatDemo extends JFrame implements ActionListener, WindowListener {
    private final JTextArea textArea;
    private final JScrollPane scrollPane;
    private final JTextField textField;
    private final JButton submitButton;
    private final JButton resetButton;
    private final JPanel buttonPanel;
    private final JPanel bottomPanel;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public ChatDemo() {
        this.getContentPane().setPreferredSize(new Dimension(400, 350));
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(this);


        textArea = new JTextArea(0, 45);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);

        textField = new JTextField(45);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);

        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(textField, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);


        this.add(scrollPane, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);

        loadChatLog();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new ChatDemo();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String chat = textField.getText();

        if (e.getSource().equals(submitButton)) {
            textArea.append(dtf.format(LocalDateTime.now()) + " : " + chat + "\n");
            textField.setText("");
        } else if (e.getSource().equals(resetButton)) {
            textArea.setText("");
        }
    }

    private void saveChatLog() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ChatDemo.dat"))) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadChatLog() {
        try (BufferedReader reader = new BufferedReader(new FileReader("ChatDemo.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        saveChatLog();
        System.exit(0);
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
