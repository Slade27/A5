package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import commands.AddPatient;
import commands.DropDoctor;
import commands.AssignDoctor;
import containers.DoctorMapAccess;
import containers.PatientMapAccess;
import entities.Doctor;
import entities.Patient;
import entities.BasicDoctor;

/**
 * The panel to display the information for a patient, and accept operations on the patient. The
 * panel gives the patient's name and health number. If the patient has bed in the ward, it is given
 * and the user has the option to remove the patient from the bed. If the patient does not have a
 * bed, a create is created for the ward information, so that the patient can be added to an empty
 * bed. The doctors of the patient are given, and the user has the option to add another doctor or
 * remove a doctor.
 */
public class DoctorPanel extends JPanel {
    /**
     * Create the panel to display the patient's information and accept operations on the patient.
     *
     * @param doctor the patient whose information is to be displayed and on whom operations can be
     *        done
     */
    public DoctorPanel(Doctor doctor) {
        /*
         * The creation of the panel is placed in another method as it needs to be invoked whenever
         * the doctor information of the patient is changed.
         */
        build(doctor);
    }

    /**
     * Fill in the panel to display the patient's information and accept operations on the patient.
     *
     * @param d the patient whose information is to be displayed and on whom operations can be
     *        done
     */
    private void build(Doctor d) {

        add(new JLabel("Name: " + d.getName()));

        add(new JLabel("  ")); // blank line in the panel for spacing
        add(new JLabel("Patients"));

        JPanel p = listPatientPanel(d);
        add(p);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);


        // add an empty panel to force the add doctor and exit components to the bottom
        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel addDoctorPanel = addPatientPanel(d);
        add(addDoctorPanel);
        addDoctorPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addDoctorPanel.setMaximumSize(addDoctorPanel.getPreferredSize());

        PatientAccessPanel accessPanel = new PatientAccessPanel();
        add(accessPanel);
        add(Box.createVerticalGlue());



        add(new JLabel("  ")); // blank line in the panel for spacing
        final JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
    }

    /**
     * A panel to display the name of a doctor for the patient. Also, a button is provided to remove
     * the association of this patient with the doctor.
     *
     * @param doctor a doctor of this patient
     *  the current patient
     * @return the panel to display the name of the doctor, with a button to remove the
     *         patient-doctor association
     */
    private JPanel listPatientPanel(final Doctor doctor) {
        JPanel doctorPanel = new JPanel();
        doctorPanel.add(new JLabel("  "));
        //doctorPanel.add(new JLabel(doctor.toString()));
        doctorPanel.add(new JLabel("Remove Pat, Enter HN"));
        final JTextField textField = new JTextField(10);
        doctorPanel.add(textField);
        //JButton removeButton = new JButton("remove");
        //doctorPanel.add(removeButton);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                String pat = textField.getText();
                int healthnum = Integer.parseInt(pat);
                DropDoctor dropAssoc = new DropDoctor();
                dropAssoc.dropAssociation(doctor.getName(), healthnum);
                if (dropAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(doctor);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog(DoctorPanel.this, dropAssoc.getErrorMessage());
                }
            }
        });
        return doctorPanel;
    }

    /**
     * A panel to add a doctor-patient association for this doctor. The panel as a prompt to enter
     * the doctor's name, and a field to enter the name.
     *
     * @param d the current patient
     * @return a panel to associate a new doctor with this patient
     */

    private JPanel addPatientPanel(final Doctor d) {
        JPanel addPatientPanel = new JPanel();
        addPatientPanel.add(new JLabel("Add Patient, Enter HN"));
        final JTextField textField = new JTextField(10);
        addPatientPanel.add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                String pat = textField.getText();
                int healthnum = Integer.parseInt(pat);
                AssignDoctor addAssoc = new AssignDoctor();
                addAssoc.assignDoctor(d.getName(), healthnum);
                if (addAssoc.wasSuccessful()) {
                    // recreate the panel as it has changed
                    removeAll();
                    build(d);
                    revalidate();
                } else {
                    JOptionPane.showMessageDialog(DoctorPanel.this, addAssoc.getErrorMessage());
                }
            }
        });
        return addPatientPanel;
    }

    public static final long serialVersionUID = 1;
}
