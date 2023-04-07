package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Maldin0
 * @created 3/31/2023 - 9:22 AM
 * @project OOP-Lab
 */
public class MDIFromGUI {
    private int count = 1;
    public MDIFromGUI(){
        JFrame frame = new JFrame("SubMenuitem Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,600));
        frame.setResizable(false);

        JDesktopPane jdp = new JDesktopPane();

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");
        JMenu newWin = new JMenu("New");

        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem window = new JMenuItem("Window");
        JMenuItem message = new JMenuItem("Message");

        newWin.add(window);
        newWin.add(message);

        file.add(newWin);
        file.add(open);
        file.add(save);
        file.add(exit);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);


        frame.setJMenuBar(menuBar);

        for (int i = 1; i <= 3; i++) {
            JInternalFrame application = new JInternalFrame("Application "+String.format("%02d", count++),
                    true, true, true, true);
            application.setPreferredSize(new Dimension(200, 100));
            application.pack();
            application.setVisible(true);
            jdp.add(application);
        }

        frame.add(jdp);

        window.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JInternalFrame application = new JInternalFrame("Application "+String.format("%02d", count++),
                        true, true, true, true);
                application.setPreferredSize(new Dimension(200, 100));
                application.pack();
                application.setVisible(true);
                jdp.add(application);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
