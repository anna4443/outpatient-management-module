/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.dal.repository;

import com.as.model.*;

import javax.print.Doc;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface IRepository {    
//    int insertDoctor(Doctor doctor);
//    void updateDoctor(Doctor dummy, int idDoctor);
//    void deleteDoctor(int idDoctor);
//    Doctor getDoctor(int idDoctor);
//    List<Doctor> getDoctors();
//    List<Patient> getPatientsForDoctor(int idDoctor);
    void insertPatient(Patient p);
    void insertPatientFullDetails(Patient p);
    Map<Integer,String> getSex();
    Map<Integer, String> getPredominatingEating();

    void insertAppointment(Appointment a);
    List<Appointment> getAppointments(int patientID);

    List<Patient> getPatients();
    List<Patient> getPatientsForDoctor(int doctorID);
    List<Doctor> getDoctors();

    Map<Integer, String> getPaymentType();
    void insertBill(Bill b);
     List<Bill> getBills(int patientID);

    Date insertMedicine(Medicine m, int patientID, int doctorID);
    List<Medicine> getMedicineForPatient(int patientID);
    Map<Integer,String> getMedicine();
}
