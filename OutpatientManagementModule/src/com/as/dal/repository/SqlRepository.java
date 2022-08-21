package com.as.dal.repository;

import com.as.dal.sql.DataSourceSingleton;
import com.as.model.*;

import javax.sql.DataSource;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class SqlRepository implements IRepository {

    private static final String GET_PATIENTS = "{CALL GetPatients}";
    private static final String INSERT_PATIENT_COMPREHENSIVE = "{CALL InsertPatientInComprehensiveRegistrationForm (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String INSERT_PATIENT_BASIC = "{CALL InsertPatientInMiniRegistrationForm (?,?,?,?,?,?,?,?)}";
    private static final String INSERT_DOCTOR = "{ CALL insertDoctor (?,?,?,?) }";
    private static final String UPDATE_DOCTOR = "{ CALL updateDoctor (?,?,?,?) }";
    private static final String DELETE_DOCTOR = "{ CALL deleteDoctor (?) }";
    private static final String GET_DOCTOR = "{ CALL getDoctor (?) }";
    private static final String GET_DOCTORS = "{ CALL getDoctors }";
    private static final String GET_SEX = "{ CALL GetSex }";
    private static final String GET_PREDOMINATINGEATING = "{CALL GetPredominatingEating}";
    private static final String GET_PATIENTS_FOR_DOCTOR = "{ CALL getPatientsForDoctor (?) }";
    private static final String GET_APPOINTMENTS = "{CALL GetAppointments (?)}";
    private static final String INSERT_APPOINTMENT = "{CALL EditAppointment (?,?,?,?,?,?,?)}";
    private static final String GET_PAYMENTTYPE = "{CALL GetPaymentType}";
    private static final String INSERT_BILL = "{CALL EditBill (?,?,?,?)}";
    private static final String GET_BILLS = "{CALL GetBills(?)}";
    private static final String GET_MEDICINE = "{CALL GetPatientMedicine(?)}";
    private static final String INSERT_MEDICINE = "{CALL GetPatientMedicine (?,?,?,?,?)}";
    private static final String GET_MEDICINE_BASIC = "{CALL GetMedicine}";
//    @Override
//    public int insertDoctor(Doctor doctor) {
//        DataSource dataSource = DataSourceSingleton.getInstance();
//        try(Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(INSERT_DOCTOR)) {
//            stmt.setString(1, doctor.getName());
//            stmt.setString(2, doctor.getSurname());
//            stmt.setString(3, doctor.getTitle());
//            stmt.registerOutParameter(4, Types.INTEGER);
//
//            stmt.executeUpdate();
//            return stmt.getInt(4);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//    @Override
//    public void updateDoctor(Doctor dummy, int idDoctor) {
//        DataSource dataSource = DataSourceSingleton.getInstance();
//        try(Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(UPDATE_DOCTOR)) {
//            stmt.setString(1, dummy.getName());
//            stmt.setString(2, dummy.getSurname());
//            stmt.setString(3, dummy.getTitle());
//            stmt.setInt(4, idDoctor);
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void deleteDoctor(int idDoctor) {
//        DataSource dataSource = DataSourceSingleton.getInstance();
//        try(Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(DELETE_DOCTOR)) {
//            stmt.setInt(1, idDoctor);
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Doctor getDoctor(int idDoctor) {
//        DataSource dataSource = DataSourceSingleton.getInstance();
//        try (Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(GET_DOCTOR)){
//                stmt.setInt(1, idDoctor);
//            try(ResultSet resultSet = stmt.executeQuery()) {
//                if (resultSet.next()) {
//                    return new Doctor(
//                                resultSet.getInt("IDDoctor"),
//                                resultSet.getString("Name"),
//                                resultSet.getString("Surname"),
//                                resultSet.getString("Title"));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Doctor> getDoctors() {
//        List<Doctor> doctors = new ArrayList<>();
//        DataSource dataSource = DataSourceSingleton.getInstance();
//        try (Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(GET_DOCTORS);
//                ResultSet resultSet = stmt.executeQuery()){
//                    while (resultSet.next()) {
//                        doctors.add(
//                                new Doctor(
//                                    resultSet.getInt("IDDoctor"),
//                                    resultSet.getString("Name"),
//                                    resultSet.getString("Surname"),
//                                    resultSet.getString("Title")));
//                    }
//            return doctors;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return doctors;
//    }
//
//    @Override
//    public List<Patient> getPatientsForDoctor(int idDoctor) {
//        List<Patient> patients = new ArrayList<>();
//        DataSource dataSource = DataSourceSingleton.getInstance();
//        try(Connection con = dataSource.getConnection();
//                CallableStatement stmt = con.prepareCall(GET_PATIENTS_FOR_DOCTOR)) {
//            stmt.setInt(1, idDoctor);
//           try(ResultSet resultSet = stmt.executeQuery()) {
//                while (resultSet.next()) {
//                    patients.add(
//                            new Patient(
//                                resultSet.getInt("IDPatient"),
//                                resultSet.getString("Name"),
//                                resultSet.getString("Surname"),
//                                resultSet.getString("Diagnosis")));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return patients;
//    }

    @Override
    public void insertPatient(Patient p) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(INSERT_PATIENT_BASIC);
        ) {
            stmt.setString(1, p.getName());
            stmt.setInt(2, p.getSexID());
            stmt.setDate(3, new Date(p.getDateOfBirth().getTime()));
            stmt.setString(4, p.getStatementOfComplaint());
            stmt.setString(5, p.getMobile());
            stmt.setString(6, p.getTelephoneHome());
            stmt.setString(7, p.getNameOfNextOfKin());
            stmt.registerOutParameter(8, Types.DATE);

            stmt.executeUpdate();

            System.out.println(stmt.getDate(8));
            //return stmt.getInt(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPatientFullDetails(Patient p) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(INSERT_PATIENT_COMPREHENSIVE);
        ) {
            stmt.setString(1, p.getOutpatientID());
            stmt.setString(2, p.getName());
            stmt.setInt(3, p.getSexID());
            stmt.setDate(4, new Date(p.getDateOfBirth().getTime()));
            stmt.setString(5, p.getPresentAddress());
            stmt.setString(6, p.getPermanentAddress());
            stmt.setString(7, p.getTelephoneWork());
            stmt.setString(8, p.getTelephoneHome());
            stmt.setString(9, p.getMobile());
            stmt.setString(10, p.getPager());
            stmt.setString(11, p.getFax());
            stmt.setString(12, p.getEmail());
            stmt.setString(13, p.getNameOfNextOfKin());
            stmt.setString(14, p.getNextOfKinContactAddress());
            stmt.setString(15, p.getNextOfKinTelephoneWork());
            stmt.setString(16, p.getNextOfKinTelephoneHome());
            stmt.setString(17, p.getNextOfKinMobile());
            stmt.setString(18, p.getNextOfKinPager());
            stmt.setString(19, p.getNextOfKinFax());
            stmt.setString(20, p.getNextOfKinEmail());
            stmt.setBoolean(21, p.getMaritalStatus());
            stmt.setInt(22, p.getNumberOfDependents());
            stmt.setFloat(23, p.getHeight());
            stmt.setFloat(24, p.getWeight());
            stmt.setString(25, p.getBloodTypeRH());
            stmt.setString(26, p.getOccupation());
            stmt.setDouble(27, p.getGrossAnnualIncome());
            stmt.setBoolean(28, p.getVegetarian());
            stmt.setBoolean(29, p.getSmoker());
            stmt.setBoolean(30, p.getConsumeAlcoholicBeverage());
            stmt.setBoolean(31, p.getUseStimulants());
            stmt.setString(32, p.getUsedStimulants());
            stmt.setFloat(33, p.getConsumptionOfCoffeePerDay());
            stmt.setFloat(34, p.getConsumptionOfTeaPerDay());
            stmt.setFloat(35, p.getConsumptionOfSoftDrinksPerDay());
            stmt.setBoolean(36, p.getHaveRegularMeals());
            stmt.setInt(37, p.getPredominatingEatingID());
            stmt.setString(38, p.getStatementOfComplaint());
            stmt.setString(39, p.getHistoryOfPreviousTreatment());
            stmt.setString(40, p.getPhysicianOrHospitalTreated());
            stmt.setBoolean(41, p.getDiabetic());
            stmt.setBoolean(42, p.getHypertensive());
            stmt.setString(43, p.getCardiacCondition());
            stmt.setString(44, p.getRespiratoryCondition());
            stmt.setString(45, p.getDigestiveCondition());
            stmt.setString(46, p.getOrthopedicCondition());
            stmt.setString(47, p.getMuscularCondition());
            stmt.setString(48, p.getNeurologicalCondition());
            stmt.setString(49, p.getKnownAllergies());
            stmt.setString(50, p.getKnownAdverseReactionToSpecificDrugs());
            stmt.setString(51, p.getMajorSurgeriesHistory());
            stmt.registerOutParameter(52, Types.DATE);

            stmt.executeUpdate();
            Date registrationDate = stmt.getDate(52);
            System.out.println(registrationDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<Integer, String> getSex() {
        Map<Integer, String> sexList = new HashMap<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GET_SEX);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                sexList.put(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sexList;
    }

    @Override
    public Map<Integer, String> getPredominatingEating() {
        Map<Integer, String> predominatingEatingList = new HashMap<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GET_PREDOMINATINGEATING);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                predominatingEatingList.put(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return predominatingEatingList;
    }

    @Override
    public void insertAppointment(Appointment a) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(INSERT_APPOINTMENT);
        ) {

            stmt.setInt(1, a.getDoctorID());
            stmt.setInt(2, a.getPatientID());
            stmt.setString(3, a.getRepresentative());
            stmt.setDate(4, new Date(a.getDate().getTime()));
            stmt.setString(5, a.getDetails());
            stmt.setBoolean(6, a.isSecondOpinion());
            stmt.registerOutParameter(7, Types.INTEGER);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Appointment> getAppointments(int patientID) {
        List<Appointment> appointmentList = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GET_APPOINTMENTS)) {
            stmt.setInt(1, patientID);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Appointment a = new Appointment();
                a.setId(resultSet.getInt(1));
                a.setDoctorID(resultSet.getInt(2));
                a.setRepresentative(resultSet.getString(3));
                a.setDate(resultSet.getDate(4));
                a.setDetails(resultSet.getString(5));
                a.setSecondOpinion(resultSet.getBoolean(6));

                appointmentList.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointmentList;
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> patientList = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GET_PATIENTS);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                Patient p = new Patient();
                p.setId(resultSet.getInt(1));
                p.setRegistrationDate(resultSet.getDate(2));
                p.setName(resultSet.getString(3));
                p.setOutpatientID(resultSet.getString(4));
                p.setDateOfBirth(resultSet.getDate(5));
                p.setSex(resultSet.getString(6));
                p.setPermanentAddress(resultSet.getString(7));
                p.setPresentAddress(resultSet.getString(8));
                p.setTelephoneHome(resultSet.getString(9));
                p.setTelephoneWork(resultSet.getString(10));
                p.setMobile(resultSet.getString(11));
                p.setPager(resultSet.getString(12));
                p.setFax(resultSet.getString(13));
                p.setEmail(resultSet.getString(14));
                p.setNameOfNextOfKin(resultSet.getString(15));
                p.setNextOfKinContactAddress(resultSet.getString(16));
                p.setNextOfKinTelephoneHome(resultSet.getString(17));
                p.setNextOfKinTelephoneWork(resultSet.getString(18));
                p.setNextOfKinMobile(resultSet.getString(19));
                p.setNextOfKinPager(resultSet.getString(20));
                p.setNextOfKinFax(resultSet.getString(21));
                p.setNextOfKinEmail(resultSet.getString(22));
                p.setMaritalStatus(resultSet.getBoolean(23));
                p.setNumberOfDependents(resultSet.getInt(24));
                p.setHeight(resultSet.getFloat(25));
                p.setWeight(resultSet.getFloat(26));
                p.setBloodTypeRH(resultSet.getString(27));
                p.setOccupation(resultSet.getString(28));
                p.setGrossAnnualIncome(resultSet.getDouble(29));
                p.setVegetarian(resultSet.getBoolean(30));
                p.setSmoker(resultSet.getBoolean(31));
                p.setConsumeAlcoholicBeverage(resultSet.getBoolean(32));
                p.setUseStimulants(resultSet.getBoolean(33));
                p.setUsedStimulants(resultSet.getString(34));
                p.setConsumptionOfCoffeePerDay(resultSet.getFloat(35));
                p.setConsumptionOfTeaPerDay(resultSet.getFloat(36));
                p.setConsumptionOfSoftDrinksPerDay(resultSet.getFloat(37));
                p.setHaveRegularMeals(resultSet.getBoolean(38));
                p.setStatementOfComplaint(resultSet.getString(39));
                p.setHistoryOfPreviousTreatment(resultSet.getString(40));
                p.setPhysicianOrHospitalTreated(resultSet.getString(41));
                p.setDiabetic(resultSet.getBoolean(42));
                p.setHypertensive(resultSet.getBoolean(43));
                p.setCardiacCondition(resultSet.getString(44));
                p.setRespiratoryCondition(resultSet.getString(45));
                p.setDigestiveCondition(resultSet.getString(46));
                p.setOrthopedicCondition(resultSet.getString(47));
                p.setMuscularCondition(resultSet.getString(48));
                p.setNeurologicalCondition(resultSet.getString(49));
                p.setKnownAllergies(resultSet.getString(50));
                p.setKnownAdverseReactionToSpecificDrugs(resultSet.getString(51));
                p.setMajorSurgeriesHistory(resultSet.getString(52));

                p.setAppointmentList(getAppointments(p.getId()));
                //p.setBillList(getBills(p.getId()));
                p.setMedicines(getMedicineForPatient(p.getId()));

                patientList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientList;
    }

    @Override
    public List<Patient> getPatientsForDoctor(int doctorID) {
        List<Patient> patients = getPatients();

        for (int i = patients.size() - 1; i >= 0; i--) {
            Patient patient = patients.get(i);

            List<Appointment> appointments = patient.getAppointmentList();

            if (appointments.stream().noneMatch(appointment -> appointment.getDoctorID() == doctorID)) {
                patients.remove(i);
            }
        }

        return patients;
    }

    @Override
    public List<Doctor> getDoctors() {
        List<Doctor> doctorList = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GET_DOCTORS);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                Doctor d = new Doctor();
                d.setId(resultSet.getInt(1));
                d.setName(resultSet.getString(2));
                d.setSex(resultSet.getString(3));
                d.setOib(resultSet.getString(4));
                d.setDate(resultSet.getDate(5));
                doctorList.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public Map<Integer, String> getPaymentType() {
        Map<Integer, String> paymentTypes = new HashMap<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GET_PAYMENTTYPE);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                paymentTypes.put(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentTypes;
    }

    @Override
    public void insertBill(Bill b) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(INSERT_BILL);
        ) {
            stmt.setInt(1, b.getPaymentTypeID());
            stmt.setInt(2, b.getPatientId());
            stmt.setDouble(3, b.getAmount());
            stmt.setDate(4, new Date(b.getDateIssuing().getTime()));

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   @Override
    public List<Bill> getBills(int patientID) {
        List<Bill> billList = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GET_BILLS);
        ) {
            stmt.setInt(1, patientID);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Bill b = new Bill();

                b.setId(stmt.getInt(1));
                b.setDateIssuing(stmt.getDate(2));
                b.setPaymentType(stmt.getString(3));
                b.setAmount(stmt.getDouble(4));

                billList.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return billList;

    }

    @Override
    public java.util.Date insertMedicine(Medicine m, int patientID, int doctorID) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(INSERT_MEDICINE);
        ) {
            stmt.setFloat(1, m.getQuantity());
                stmt.setInt(2, m.getId());
                stmt.setInt(3, patientID);
            stmt.setInt(4, doctorID);
            stmt.registerOutParameter(5, Types.DATE);

            stmt.executeUpdate();

            return stmt.getDate(5);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Medicine> getMedicineForPatient(int patientID) {

        List<Medicine> medicineList = new ArrayList<>();

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GET_MEDICINE)) {
            stmt.setInt(1, patientID);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Medicine m = new Medicine();

                m.setId(stmt.getInt(1));
                m.setName(stmt.getString(4));
                m.setQuantity(stmt.getInt(5));
                m.setDateIssued(stmt.getDate(6));
                medicineList.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineList;
    }

    @Override
    public Map<Integer, String> getMedicine() {
        Map<Integer, String> medicineList = new HashMap<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
             CallableStatement stmt = con.prepareCall(GET_MEDICINE_BASIC);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                medicineList.put(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicineList;
    }


}
