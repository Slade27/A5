package gui;

import entities.Doctor;

import javax.swing.JFrame;

/**
 * The frame for the window to enter data for a new patient, and cause the creation of the patient.
 */
public class DoctorOpsAddFrame extends JFrame {
    /** The standard width for the frame. */
    public static final int DEFAULT_WIDTH = 350;

    /** The standard height for the frame. */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame to add a patient.
     */
    public DoctorOpsAddFrame() {
        setTitle("Doctor Addition");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        DoctorAddPanel panel = new DoctorAddPanel();
        add(panel);
    }

    public static final long serialVersionUID = 1;
}

