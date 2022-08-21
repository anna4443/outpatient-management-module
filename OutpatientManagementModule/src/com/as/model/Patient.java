/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as.model;

import java.util.Date;
import java.util.List;


public class Patient {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String outpatientID;
    private String name;
    private int sexID;
    private String sex;
    private Date dateOfBirth;
    private String statementOfComplaint;
    private String mobile;
    private String telephoneHome;
    private String nameOfNextOfKin;
    private Date registrationDate;
    private String presentAddress;
    private String permanentAddress;
    private String telephoneWork;
    private String pager;
    private String fax;
    private String email;
    private String nextOfKinContactAddress;
    private String nextOfKinTelephoneWork;
    private String nextOfKinTelephoneHome;
    private String nextOfKinMobile;
    private String nextOfKinPager;
    private String nextOfKinFax;
    private String nextOfKinEmail;
    private Boolean maritalStatus;
    private Integer numberOfDependents;
    private Float height;
    private Float weight;
    private String bloodTypeRH;
    private String occupation;
    private Double grossAnnualIncome;
    private Boolean vegetarian;
    private Boolean smoker;
    private Boolean consumeAlcoholicBeverage;
    private Boolean useStimulants;
    private String usedStimulants;
    private Float consumptionOfCoffeePerDay;
    private Float consumptionOfTeaPerDay;
    private Float consumptionOfSoftDrinksPerDay;
    private Boolean haveRegularMeals;
    private Integer predominatingEatingID;
    private String historyOfPreviousTreatment;
    private String physicianOrHospitalTreated;
    private Boolean diabetic;
    private Boolean hypertensive;
    private String cardiacCondition;
    private String respiratoryCondition;
    private String digestiveCondition;
    private String orthopedicCondition;
    private String muscularCondition;
    private String neurologicalCondition;
    private String knownAllergies;
    private String knownAdverseReactionToSpecificDrugs;
    private String majorSurgeriesHistory;
    private List<Appointment> appointmentList;

private  List<Bill> billList;

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    private List<Medicine> medicines;

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public Integer getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(Integer numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getBloodTypeRH() {
        return bloodTypeRH;
    }

    public void setBloodTypeRH(String bloodTypeRH) {
        this.bloodTypeRH = bloodTypeRH;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getGrossAnnualIncome() {
        return grossAnnualIncome;
    }

    public void setGrossAnnualIncome(Double grossAnnualIncome) {
        this.grossAnnualIncome = grossAnnualIncome;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getSmoker() {
        return smoker;
    }

    public void setSmoker(Boolean smoker) {
        this.smoker = smoker;
    }

    public Boolean getConsumeAlcoholicBeverage() {
        return consumeAlcoholicBeverage;
    }

    public void setConsumeAlcoholicBeverage(Boolean consumeAlcoholicBeverage) {
        this.consumeAlcoholicBeverage = consumeAlcoholicBeverage;
    }

    public Boolean getUseStimulants() {
        return useStimulants;
    }

    public void setUseStimulants(Boolean useStimulants) {
        this.useStimulants = useStimulants;
    }


    public String getUsedStimulants() {
        return usedStimulants;
    }

    public void setUsedStimulants(String usedStimulants) {
        this.usedStimulants = usedStimulants;
    }

    public Float getConsumptionOfCoffeePerDay() {
        return consumptionOfCoffeePerDay;
    }

    public void setConsumptionOfCoffeePerDay(Float consumptionOfCoffeePerDay) {
        this.consumptionOfCoffeePerDay = consumptionOfCoffeePerDay;
    }

    public Float getConsumptionOfTeaPerDay() {
        return consumptionOfTeaPerDay;
    }

    public void setConsumptionOfTeaPerDay(Float consumptionOfTeaPerDay) {
        this.consumptionOfTeaPerDay = consumptionOfTeaPerDay;
    }

    public Float getConsumptionOfSoftDrinksPerDay() {
        return consumptionOfSoftDrinksPerDay;
    }

    public void setConsumptionOfSoftDrinksPerDay(Float consumptionOfSoftDrinksPerDay) {
        this.consumptionOfSoftDrinksPerDay = consumptionOfSoftDrinksPerDay;
    }

    public Boolean getHaveRegularMeals() {
        return haveRegularMeals;
    }

    public void setHaveRegularMeals(Boolean haveRegularMeals) {
        this.haveRegularMeals = haveRegularMeals;
    }

    public Integer getPredominatingEatingID() {
        return predominatingEatingID;
    }

    public void setPredominatingEatingID(Integer predominatingEatingID) {
        this.predominatingEatingID = predominatingEatingID;
    }

    public String getHistoryOfPreviousTreatment() {
        return historyOfPreviousTreatment;
    }

    public void setHistoryOfPreviousTreatment(String historyOfPreviousTreatment) {
        this.historyOfPreviousTreatment = historyOfPreviousTreatment;
    }

    public String getPhysicianOrHospitalTreated() {
        return physicianOrHospitalTreated;
    }

    public void setPhysicianOrHospitalTreated(String physicianOrHospitalTreated) {
        this.physicianOrHospitalTreated = physicianOrHospitalTreated;
    }

    public Boolean getDiabetic() {
        return diabetic;
    }

    public void setDiabetic(Boolean diabetic) {
        this.diabetic = diabetic;
    }

    public Boolean getHypertensive() {
        return hypertensive;
    }

    public void setHypertensive(Boolean hypertensive) {
        this.hypertensive = hypertensive;
    }

    public String getCardiacCondition() {
        return cardiacCondition;
    }

    public void setCardiacCondition(String cardiacCondition) {
        this.cardiacCondition = cardiacCondition;
    }

    public String getRespiratoryCondition() {
        return respiratoryCondition;
    }

    public void setRespiratoryCondition(String respiratoryCondition) {
        this.respiratoryCondition = respiratoryCondition;
    }

    public String getDigestiveCondition() {
        return digestiveCondition;
    }

    public void setDigestiveCondition(String digestiveCondition) {
        this.digestiveCondition = digestiveCondition;
    }

    public String getOrthopedicCondition() {
        return orthopedicCondition;
    }

    public void setOrthopedicCondition(String orthopedicCondition) {
        this.orthopedicCondition = orthopedicCondition;
    }

    public String getMuscularCondition() {
        return muscularCondition;
    }

    public void setMuscularCondition(String muscularCondition) {
        this.muscularCondition = muscularCondition;
    }

    public String getNeurologicalCondition() {
        return neurologicalCondition;
    }

    public void setNeurologicalCondition(String neurologicalCondition) {
        this.neurologicalCondition = neurologicalCondition;
    }

    public String getKnownAllergies() {
        return knownAllergies;
    }

    public void setKnownAllergies(String knownAllergies) {
        this.knownAllergies = knownAllergies;
    }

    public String getKnownAdverseReactionToSpecificDrugs() {
        return knownAdverseReactionToSpecificDrugs;
    }

    public void setKnownAdverseReactionToSpecificDrugs(String knownAdverseReactionToSpecificDrugs) {
        this.knownAdverseReactionToSpecificDrugs = knownAdverseReactionToSpecificDrugs;
    }

    public String getMajorSurgeriesHistory() {
        return majorSurgeriesHistory;
    }

    public void setMajorSurgeriesHistory(String majorSurgeriesHistory) {
        this.majorSurgeriesHistory = majorSurgeriesHistory;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNextOfKinContactAddress() {
        return nextOfKinContactAddress;
    }

    public void setNextOfKinContactAddress(String nextOfKinContactAddress) {
        this.nextOfKinContactAddress = nextOfKinContactAddress;
    }

    public String getNextOfKinTelephoneWork() {
        return nextOfKinTelephoneWork;
    }

    public void setNextOfKinTelephoneWork(String nextOfKinTelephoneWork) {
        this.nextOfKinTelephoneWork = nextOfKinTelephoneWork;
    }

    public String getNextOfKinTelephoneHome() {
        return nextOfKinTelephoneHome;
    }

    public void setNextOfKinTelephoneHome(String nextOfKinTelephoneHome) {
        this.nextOfKinTelephoneHome = nextOfKinTelephoneHome;
    }

    public String getNextOfKinMobile() {
        return nextOfKinMobile;
    }

    public void setNextOfKinMobile(String nextOfKinMobile) {
        this.nextOfKinMobile = nextOfKinMobile;
    }

    public String getNextOfKinPager() {
        return nextOfKinPager;
    }

    public void setNextOfKinPager(String nextOfKinPager) {
        this.nextOfKinPager = nextOfKinPager;
    }

    public String getNextOfKinFax() {
        return nextOfKinFax;
    }

    public void setNextOfKinFax(String nextOfKinFax) {
        this.nextOfKinFax = nextOfKinFax;
    }

    public String getNextOfKinEmail() {
        return nextOfKinEmail;
    }

    public void setNextOfKinEmail(String nextOfKinEmail) {
        this.nextOfKinEmail = nextOfKinEmail;
    }

    public Boolean getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }


    public Patient() {
    }


    public String getTelephoneWork() {
        return telephoneWork;
    }

    public void setTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getOutpatientID() {
        return outpatientID;
    }

    public void setOutpatientID(String outpatientID) {
        this.outpatientID = outpatientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSexID() {
        return sexID;
    }

    public void setSexID(int sexID) {
        this.sexID = sexID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStatementOfComplaint() {
        return statementOfComplaint;
    }

    public void setStatementOfComplaint(String statementOfComplaint) {
        this.statementOfComplaint = statementOfComplaint;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephoneHome() {
        return telephoneHome;
    }

    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }

    public String getNameOfNextOfKin() {
        return nameOfNextOfKin;
    }

    public void setNameOfNextOfKin(String nameOfNextOfKin) {
        this.nameOfNextOfKin = nameOfNextOfKin;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String string) {
        sex = string;

    }
}
