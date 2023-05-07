package Recap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author Maldin0
 * @created 5/7/2023 - 10:59 PM
 * @project OOP-Lab
 */
public class TextEditor implements ActionListener {
    private JFrame fr;
    private JFileChooser fc = new JFileChooser();
    private JTextArea textArea;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu files;
    private JMenuItem newBtn, saveBtn, openBtn, closeBtn;
    public TextEditor() {
        fr = new JFrame("My Text Editor");
        fr.getContentPane().setPreferredSize(new Dimension(500, 400));
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(true);

        textArea = new JTextArea();
        textArea.setLineWrap(true);

        scrollPane = new JScrollPane(textArea);
        panel = new JPanel(new BorderLayout());

        menuBar = new JMenuBar();
        files = new JMenu("File");

        newBtn = new JMenuItem("New");
        saveBtn = new JMenuItem("Save");
        openBtn = new JMenuItem("Open");
        closeBtn = new JMenuItem("Close");

        newBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        openBtn.addActionListener(this);
        closeBtn.addActionListener(this);

        files.add(newBtn);
        files.add(saveBtn);
        files.add(openBtn);
        files.add(closeBtn);

        menuBar.add(files);

        panel.add(scrollPane, BorderLayout.CENTER);
        fr.setJMenuBar(menuBar);

        fr.add(panel);
        fr.pack();
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(TextEditor::new);
    }

    public void save() {
        fc.showSaveDialog(fr);
        File file = fc.getSelectedFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        fc.showOpenDialog(fr);
        File file = fc.getSelectedFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                textArea.append(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newBtn)) {
            textArea.setText("");
        } else if (e.getSource().equals(saveBtn)) {
            save();
        } else if (e.getSource().equals(openBtn)) {
            textArea.setText("");
            load();
        } else if (e.getSource().equals(closeBtn)) {
            System.exit(0);
        }
    }
}
