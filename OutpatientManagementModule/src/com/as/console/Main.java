/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.console;

import com.as.bl.DoctorsHandler;
import com.as.bl.PatientsHandler;
import com.as.model.Bill;
import com.as.model.Doctor;
import com.as.model.Patient;
import java.util.List;

public class Main {
    
    private static final DoctorsHandler DOCTORS_HANDLER = new DoctorsHandler();
    private static final PatientsHandler PATIENTS_HANDLER = new PatientsHandler();

    public static void start() {

        performTesting();
    }

    private static void performTesting() {
//        int id = DOCTORS_HANDLER.insertDoctor(new Doctor("Doctor", "Strangelove", "Hero"));
//        System.out.println(id);
//
//        Doctor doctor = DOCTORS_HANDLER.getDoctor(id);
//        System.out.println(doctor);
//
//        Doctor dummy = new Doctor("Update name", "Update surname", "Update title");
//        DOCTORS_HANDLER.updateDoctor(dummy, id);
//        doctor = DOCTORS_HANDLER.getDoctor(id);
//        System.out.println(doctor);
//
//        DOCTORS_HANDLER.deleteDoctor(id);
//        doctor = DOCTORS_HANDLER.getDoctor(id);
//        System.out.println(doctor);
//
//       List<Doctor> doctors = DOCTORS_HANDLER.getDoctors();
//        System.out.println(doctors);
//
//        List<Patient> patients = PATIENTS_HANDLER.getPatientsForDoctor(1);
//        System.out.println(patients);

//        List<Bill> bills = PATIENTS_HANDLER.getBills(2);
//        System.out.println(bills);
    }
    
}
