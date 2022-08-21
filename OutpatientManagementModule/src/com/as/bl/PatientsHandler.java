
package com.as.bl;

import com.as.model.Appointment;
import com.as.model.Bill;
import com.as.model.Medicine;
import com.as.model.Patient;
import javafx.util.Pair;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class PatientsHandler extends HandlerBase {
    
//    public List<Patient> getPatientsForDoctor(int doctorId) {
//        return repository.getPatientsForDoctor(doctorId);
//    }
    public void insertPatient(Patient p)
    {
        repository.insertPatient(p);
    }
    public Map<Integer, String> getSex(){
        return repository.getSex();
    }
    public void insertPatientFull(Patient p) {repository.insertPatientFullDetails(p);}
    public Map<Integer, String> getPredominatingEating(){return repository.getPredominatingEating();}
    public List<Patient> getPatients(){return repository.getPatients();}
    public Map<Integer, String> getPaymentType() {return repository.getPaymentType();}
    public void insertBill(Bill b) { repository.insertBill(b);}
    public List<Bill> getBills(int patientID){return repository.getBills(patientID);}
    public void insertAppointment(Appointment a) { repository.insertAppointment(a);}
    public Date insertMedicine(Medicine m, int patientID, int doctorID) {return repository.insertMedicine(m, patientID, doctorID);}
    public Map<Integer, String> getMedicine(){return repository.getMedicine();}
    public List<Patient> getPatientsForDoctor(int doctorID){return repository.getPatientsForDoctor(doctorID);}
}
