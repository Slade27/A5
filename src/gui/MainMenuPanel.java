package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import containers.PatientMapAccess;
import entities.Ward;

/**
 * The panel for the operations involving patients. There is a button to add a new patient, a field
 * to access a specific patient, a button to list all patients, and an exit button to hide the
 * window with this frame.
 */
public class MainMenuPanel extends JPanel {
    /**
     * Create the panel for the operations involving patients. There is a button to add a new
     * patient, a field to access a specific patient, a button to list all patients, and an exit
     * button to hide the window with this frame.
     */
    public MainMenuPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a button to add a new patient
        JButton p = new JButton("Access Patients");
        p.setMaximumSize(p.getPreferredSize());
        add(p);
        p.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                PatientOpsFrame frame = new PatientOpsFrame(); // Access Patient stuff
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());


        // add a button to display all the patients
        JButton doc = new JButton("Access Doctors");
        doc.setMaximumSize(doc.getPreferredSize());
        add(doc);
        doc.setAlignmentX(Component.CENTER_ALIGNMENT);
        doc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DoctorOpsFrame frame = new DoctorOpsFrame(); // Access Patient stuff
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a button to display all the patients
        JButton ward = new JButton("Access Ward");
        ward.setMaximumSize(ward.getPreferredSize());
        add(ward);
        ward.setAlignmentX(Component.CENTER_ALIGNMENT);
        ward.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                WardFrame frame = new WardFrame(); // Access Patient stuff
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a button to exit from the window containing this panel
        final JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
        add(Box.createVerticalGlue());

        // add a button to exit from the window containing this panel
        final JButton t = new JButton("TERMINATE");
        t.setMaximumSize(t.getPreferredSize());
        add(t);
        t.setAlignmentX(Component.CENTER_ALIGNMENT);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
        add(Box.createVerticalGlue());
    }

    public static final long serialVersionUID = 1;
}

