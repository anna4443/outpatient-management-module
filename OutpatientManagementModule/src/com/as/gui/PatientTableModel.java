package com.as.gui;

import com.as.model.Patient;

import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.List;

public class PatientTableModel extends AbstractTableModel {


    private String[] headers = {
            "Registration date",
            "Patient's name",
            "OutpatientID",
            "Date of birth",
            "Sex",
            "Patient's mobile"
    };

    private List<Patient> patients;

    public PatientTableModel(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public int getRowCount() {
        return patients.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex < 0)
            return null;

        Patient p = patients.get(rowIndex);

        switch (columnIndex)
        {
            case 0:
                return p.getRegistrationDate();

            case 1:
                return p.getName();

            case 2:
                return p.getOutpatientID();

            case 3:
                return p.getDateOfBirth();

            case 4:
                return p.getSex();

            case 5:
                return p.getMobile();

                default:
                    return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex)
        {
            case 0:
                return Date.class;

            case 1:
                return String.class;

            case 2:
                return String.class;

            case 3:
                return Date.class;

            case 4:
                return String.class;
            case 5:
                return String.class;

            default:
                return null;
        }
    }
}
