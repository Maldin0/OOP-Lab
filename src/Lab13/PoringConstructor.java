package Lab13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Maldin0
 * @created 5/4/2023 - 6:56 PM
 * @project OOP-Lab
 */
public class PoringConstructor extends JFrame implements ActionListener {
    public int poringCount = 0;
    public JButton addBtn;
    public PoringConstructor() {
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(200, 50));
        this.setResizable(false);

        addBtn = new JButton("Add");
        addBtn.addActionListener(this);

        this.add(addBtn);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Poring poring = new Poring(++poringCount);
        Thread thread = new Thread(poring);
        thread.start();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(PoringConstructor::new);
    }
}
