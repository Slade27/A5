package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import commands.AddPatient;
import commands.DropDoctor;
import commands.AssignDoctor;
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
        ;
        add(new JLabel("Name: " + d.getName()));

        //BedPanel bedPanel = new BedPanel(patient);
        //add(bedPanel);
        //bedPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        //bedPanel.setMaximumSize(bedPanel.getPreferredSize());
        JButton addButton = new JButton("Add patient");
        addButton.setMaximumSize(addButton.getPreferredSize());
        add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                PatientAddFrame frame = new PatientAddFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());


        // add an empty panel to force the add doctor and exit components to the bottom
        JPanel emptyPanel = new JPanel();
        add(emptyPanel);
        emptyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

//        JPanel addDoctorPanel = addDoctorPanel(d);
//        add(addDoctorPanel);
//        addDoctorPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        addDoctorPanel.setMaximumSize(addDoctorPanel.getPreferredSize());      ADD THIS BACK

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
     * @param patient the current patient
     * @return the panel to display the name of the doctor, with a button to remove the
     *         patient-doctor association
     */
//    private JPanel listDoctorPanel(final BasicDoctor doctor, final Patient patient) {
//        JPanel doctorPanel = new JPanel();
//        doctorPanel.add(new JLabel("  "));
//        doctorPanel.add(new JLabel(doctor.getName()));
//        JButton removeButton = new JButton("remove");
//        doctorPanel.add(removeButton);
//        removeButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                DropDoctor dropAssoc = new DropDoctor();
//                dropAssoc.dropAssociation(doctor.getName(), patient.getHealthNumber());
//                if (dropAssoc.wasSuccessful()) {
//                    // recreate the panel as it has changed
//                    removeAll();
//                    build(patient);
//                    revalidate();
//                } else {
//                    JOptionPane.showMessageDialog(PatientPanel.this, dropAssoc.getErrorMessage());
//                }
//            }
//        });
//        return doctorPanel;
//    }

    /**
     * A panel to add a doctor-patient association for this doctor. The panel as a prompt to enter
     * the doctor's name, and a field to enter the name.
     *
     * @param patient the current patient
     * @return a panel to associate a new doctor with this patient
     */
//    private JPanel addPatientPanel(final Doctor doctor) {
//        JPanel addDoctorPanel = new JPanel();
//        addDoctorPanel.add(new JLabel("Add doctor"));
//        final JTextField textField = new JTextField(10);
//        addDoctorPanel.add(textField);
//        textField.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                String PatName = textField.getText();
//                AddPatient addAssoc = new AddPatient();
//                addAssoc.addPatient(PatName, patient.getHealthNumber());
//                if (addAssoc.wasSuccessful()) {
//                    // recreate the panel as it has changed
//                    removeAll();
//                    build(patient);
//                    revalidate();
//                } else {
//                    JOptionPane.showMessageDialog(PatientPanel.this, addAssoc.getErrorMessage());
//                }
//            }
//        });
//        return addDoctorPanel;
//    }

    public static final long serialVersionUID = 1;
}
