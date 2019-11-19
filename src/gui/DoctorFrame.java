package gui;

import javax.swing.JFrame;

import containers.DoctorMapAccess;
import containers.PatientMapAccess;
import entities.Doctor;
import entities.Patient;

/**
 * The frame for the window to display the information for a patient, and accept operations on the
 * patient.
 */
public class DoctorFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display the information for a patient.
     *
     * @param name the health number of the patient
     * @precond healthNum is the health number of a patient
     */
    public DoctorFrame(String name) {
        Doctor doc = DoctorMapAccess.dictionary().get(name);
        if (doc != null) {
            setTitle(doc.getName());
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            System.out.println(doc+ "HERE");
            DoctorPanel panel = new DoctorPanel(doc);
            add(panel);
        } else
            throw new RuntimeException("Invalid name " + name);
    }

    public static final long serialVersionUID = 1;
}
