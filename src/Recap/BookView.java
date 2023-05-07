package Recap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Maldin0
 * @created 5/7/2023 - 11:59 PM
 * @project OOP-Lab
 */
public class BookView implements ActionListener, WindowListener {
    private JFrame frame, fr;
    private JPanel namePanel, pricePanel, typePanel, pagePanel, btnPanel;
    private JLabel nameLbl, priceLbl, typeLbl;
    private JTextField nameText1, priceText1, pageText, nameText2, priceText2;
    private JComboBox<String> comboBox, addComboBox;
    private String[] items = {"General", "Computer", "Math&Sci", "Photo"};
    private JButton prevBtn, nextBtn, addBtn, upBtn, delBtn, insBtn;
    private Book book;
    private ArrayList<Book> booksList = new ArrayList<>();
    public BookView() {
        frame = new JFrame();
        frame.setLayout(new GridLayout(5,1));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setPreferredSize(new Dimension(300,200));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        namePanel = new JPanel(new GridLayout(1, 2));
        pricePanel = new JPanel(new GridLayout(1,2));
        typePanel = new JPanel(new GridLayout(1,2));
        pagePanel = new JPanel(new FlowLayout());
        btnPanel = new JPanel(new FlowLayout());

        nameLbl = new JLabel("  Name");
        priceLbl = new JLabel("  Price");
        typeLbl = new JLabel("  Type");

        nameText1 = new JTextField();
        priceText1 = new JTextField();
        pageText = new JTextField("0", 5);
        pageText.setEnabled(false);

        comboBox = new JComboBox<>(items);

        prevBtn = new JButton("<<<");
        nextBtn = new JButton(">>>");
        addBtn = new JButton("Add");
        upBtn = new JButton("Update");
        delBtn = new JButton("Delete");

        prevBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        addBtn.addActionListener(this);
        upBtn.addActionListener(this);
        delBtn.addActionListener(this);

        namePanel.add(nameLbl);
        namePanel.add(nameText1);

        pricePanel.add(priceLbl);
        pricePanel.add(priceText1);

        typePanel.add(typeLbl);
        typePanel.add(comboBox);

        pagePanel.add(prevBtn);
        pagePanel.add(pageText);
        pagePanel.add(nextBtn);

        btnPanel.add(addBtn);
        btnPanel.add(upBtn);
        btnPanel.add(delBtn);

        frame.add(namePanel);
        frame.add(pricePanel);
        frame.add(typePanel);
        frame.add(pagePanel);
        frame.add(btnPanel);

        frame.addWindowListener(this);
        frame.pack();
        frame.setVisible(true);
        load();
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Book.data"))) {
            oos.writeObject(booksList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Book.data"))) {
            booksList = (ArrayList<Book>) ois.readObject();
            book = booksList.get(0);
            nameText1.setText(book.getName());
            priceText1.setText(book.getName());
            comboBox.setSelectedItem(book.getType());
            pageText.setText("0");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(BookView::new);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addBtn)) {
            fr = new JFrame();
            fr.setLayout(new GridLayout(2,1));
            fr.setLocationRelativeTo(null);
            fr.getContentPane().setPreferredSize(new Dimension(300,150));
            fr.setResizable(false);
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel1 = new JPanel(new GridLayout(3,2));
            JPanel panel2 = new JPanel(new FlowLayout());

            JLabel addNameLbl = new JLabel("  Name");
            JLabel addPriceLbl = new JLabel("  Price");
            JLabel addTypeLbl = new JLabel("  Type");


            nameText2 = new JTextField();
            priceText2 = new JTextField();

            addComboBox = new JComboBox<>(items);

            panel1.add(addNameLbl);
            panel1.add(nameText2);
            panel1.add(addPriceLbl);
            panel1.add(priceText2);
            panel1.add(addTypeLbl);
            panel1.add(addComboBox);

            insBtn = new JButton("Insert");
            insBtn.addActionListener(this);
            panel2.add(insBtn);

            fr.add(panel1);
            fr.add(panel2);
            fr.pack();
            fr.setVisible(true);
        } else if (e.getSource().equals(insBtn)) {
            book = new Book(nameText2.getText(), Double.parseDouble(priceText2.getText()), (String) addComboBox.getSelectedItem());
            booksList.add(book);
            JOptionPane.showConfirmDialog(fr, "Done it", "Add Command" , JOptionPane.DEFAULT_OPTION);
            fr.dispose();
        } else if (e.getSource().equals(upBtn)) {
            book = booksList.get(Integer.parseInt(pageText.getText()));
            book.setName(nameText1.getText());
            book.setPrice(Double.parseDouble(priceText1.getText()));
            book.setType((String) comboBox.getSelectedItem());
            booksList.set(Integer.parseInt(pageText.getText()), book);
            JOptionPane.showConfirmDialog(fr, "Done it", "Update Command" , JOptionPane.DEFAULT_OPTION);
        } else if (e.getSource().equals(delBtn)) {
            booksList.remove(Integer.parseInt(pageText.getText()));
            JOptionPane.showConfirmDialog(fr, "Done it", "Delete Command" , JOptionPane.DEFAULT_OPTION);
        } else if (e.getSource().equals(prevBtn)) {
            if (booksList.isEmpty()) {
                nameText1.setText("");
                priceText1.setText("");
                comboBox.setSelectedIndex(0);
                pageText.setText("0");
                return;
            }
            if (pageText.getText().equals("0")) {
                book = booksList.get(Integer.parseInt(pageText.getText()));
            } else {
                book = booksList.get(Integer.parseInt(pageText.getText()) - 1);
                pageText.setText(String.valueOf(Integer.parseInt(pageText.getText())-1));
            }
            nameText1.setText(book.getName());
            priceText1.setText(String.valueOf(book.getPrice()));
            comboBox.setSelectedItem(book.getType());
        } else if (e.getSource().equals(nextBtn)) {
            if (booksList.isEmpty()) {
                nameText1.setText("");
                priceText1.setText("");
                comboBox.setSelectedIndex(0);
                pageText.setText("0");
                return;
            }
            if (pageText.getText().equals(String.valueOf(booksList.size()-1))) {
                book = booksList.get(Integer.parseInt(pageText.getText()));
            } else {
                book = booksList.get(Integer.parseInt(pageText.getText()) + 1);
                pageText.setText(String.valueOf(Integer.parseInt(pageText.getText())+1));
            }
            nameText1.setText(book.getName());
            priceText1.setText(String.valueOf(book.getPrice()));
            comboBox.setSelectedItem(book.getType());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        save();
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
