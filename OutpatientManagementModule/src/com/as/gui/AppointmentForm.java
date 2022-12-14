package com.as.gui;

import com.as.bl.DoctorsHandler;
import com.as.bl.PatientsHandler;
import com.as.main.BaseForm;
import com.as.model.Appointment;
import com.as.model.Doctor;
import com.as.model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class AppointmentForm extends BaseForm {
    private JPanel panel;
    private JTextField txtRepresentative;
    private JFormattedTextField ftfDateAppointed;
    private JTextArea txtaDetails;
    private JCheckBox secondOpinionCheckBox;
    private JButton addButton;
    private JComboBox<Patient> cbPatients;
    private JComboBox<Doctor> cbDoctor;
    private List<Doctor> doctors;
    private List<Patient> patients;

    private static final DoctorsHandler DH = new DoctorsHandler();
    private static final PatientsHandler PH = new PatientsHandler();

    public AppointmentForm() throws HeadlessException {
        super("Appointment form", 600, 400);
        setContentPane(panel);

        doctors = DH.getDoctors();

        cbDoctor.setModel(new DefaultComboBoxModel<>(doctors.toArray(new Doctor[0])));

        patients = PH.getPatients();

        cbPatients.setModel(new DefaultComboBoxModel<>(patients.toArray(new Patient[0])));

        addButton.addActionListener(e -> {
            try {
                DateFormat format = new SimpleDateFormat("dd.MM.yyyy.");

                Appointment a = new Appointment();
                Patient p = (Patient) cbPatients.getSelectedItem();
                Doctor d = (Doctor) cbDoctor.getSelectedItem();

                a.setPatientID(p.getId());
                a.setDoctorID(d.getId());
                a.setRepresentative(txtRepresentative.getText());
                a.setDate(format.parse(ftfDateAppointed.getText()));
                a.setDetails(txtaDetails.getText());
                a.setSecondOpinion(secondOpinionCheckBox.isSelected());

                PH.insertAppointment(a);
                JOptionPane.showMessageDialog(this, "Appointment inserted successfully!!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Couldn't insert appointment!!");
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Representative:");
        panel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtRepresentative = new JTextField();
        panel.add(txtRepresentative, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Date appointed:");
        panel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ftfDateAppointed = new JFormattedTextField();
        ftfDateAppointed.setText("");
        panel.add(ftfDateAppointed, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Details:");
        panel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtaDetails = new JTextArea();
        panel.add(txtaDetails, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(200, -1), new Dimension(150, 50), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Second opinion:");
        panel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        secondOpinionCheckBox = new JCheckBox();
        secondOpinionCheckBox.setText("Second opinion");
        panel.add(secondOpinionCheckBox, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addButton = new JButton();
        addButton.setText("Add ");
        panel.add(addButton, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Patient:");
        panel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Doctor:");
        panel.add(label6, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbPatients = new JComboBox();
        panel.add(cbPatients, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), null, null, 0, false));
        cbDoctor = new JComboBox();
        panel.add(cbDoctor, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
