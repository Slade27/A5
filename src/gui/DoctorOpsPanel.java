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

import containers.DoctorMapAccess;
import entities.Doctor;

/**
 * The panel for the operations involving patients. There is a button to add a new patient, a field
 * to access a specific patient, a button to list all patients, and an exit button to hide the
 * window with this frame.
 */
public class DoctorOpsPanel extends JPanel {
    /**
     * Create the panel for the operations involving patients. There is a button to add a new
     * patient, a field to access a specific patient, a button to list all patients, and an exit
     * button to hide the window with this frame.
     */
    public DoctorOpsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // add a button to add a new patient
        JButton addButton = new JButton("Add Doctor");
        addButton.setMaximumSize(addButton.getPreferredSize());
        add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DoctorOpsAddFrame frame = new DoctorOpsAddFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        // add a panel with a field to access a specific Doctor
        DoctorAccessPanel accessPanel = new DoctorAccessPanel();
        add(accessPanel);
        add(Box.createVerticalGlue());

        // add a button to display all the patients
        JButton listAllButton = new JButton("List all Doctors");
        listAllButton.setMaximumSize(listAllButton.getPreferredSize());
        add(listAllButton);
        listAllButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, DoctorMapAccess.dictionary().values());
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
    }

    public static final long serialVersionUID = 1;
}
