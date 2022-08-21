/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.main;

import com.as.bl.PatientsHandler;
import com.as.model.Bill;
import com.as.model.Patient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Main {

    /**
     * @param args the command line arguments
     */

    private static final PatientsHandler PATIENTS_HANDLER = new PatientsHandler();

        public static void main(String[] args) {
        try {
            int switcher = readFromFile();
            //int switcher = Integer.parseInt(args[0]);

            List<Patient> patients = PATIENTS_HANDLER.getPatientsForDoctor(1);
               System.out.println(patients);
            switch(switcher) {
                case 1:
                    com.as.console.Main.start();
                    break;
                case 2:
                    com.as.gui.Main.start();
                    break;
                
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        
    }

    private static int readFromFile() {
        try (Scanner s = new Scanner(new File("init.txt"))){
            return s.nextInt();
        } catch (FileNotFoundException ex) {
            System.out.println(new File("init.txt").getAbsolutePath());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 2;
    }
}
