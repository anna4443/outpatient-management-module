use "master"
GO

drop database "OutPatientManagementModuleForVirgoHosiptals"
GO

create database "OutPatientManagementModuleForVirgoHosiptals"
GO

use "OutPatientManagementModuleForVirgoHosiptals"
GO

-- CREATING TABLES

create table BasicDetails
(
	IDBasicDetails int primary key identity not null,
	OutpatientID nvarchar(11) null,
	Name nvarchar(100) not null,
	SexID int not null,
	DateOfBirth DateTime not null,
	CONSTRAINT FK_BasicDetails_Sex FOREIGN KEY(SexID) REFERENCES Sex(IDSex)
)
GO

create table Sex
(
	IDSex int primary key identity not null,
	Name nvarchar(20) not null
)
GO

create table Contact
(
	IDContact int primary key identity not null,
	Mobile nvarchar(50) not null,
	Pager nvarchar(50),
	Fax nvarchar(50),
	Email nvarchar(50),
	TelephoneWork nvarchar(50),
	TelephoneHome nvarchar(50) not null
)
GO

create table ContactDetails
(
	IDContactDetails int primary key identity not null,
	ContactID int not null,
	PresentAddress nvarchar(100) null,
	PermanentAddress nvarchar(100) null,
	CONSTRAINT FK_ContactDetails_Contact FOREIGN KEY(ContactID) REFERENCES Contact(IDContact)
)
GO

create table ContactNextOfKin
(
	IDContactNextOfKin int primary key identity not null,
	Name nvarchar(50) not null,
	ContactAddress nvarchar(100) null,
	ContactID int null,
	CONSTRAINT FK_ContactNextOfKin_Contact FOREIGN KEY(ContactID) REFERENCES Contact(IDContact)
)
GO

create table PersonalDetails
(
	IDPersonalDetails int primary key identity not null, 
	MaritalStatus bit null,
	NumberOfDependents int null,
	Height float null,
	Weight float null,
	BloodTypeRH nvarchar(10) null
)
GO

create table ProfessionDetails
(
	IDProfessionDetails int primary key identity not null,
	Occupation nvarchar(100) null,
	GrossAnnualIncome money null
)
GO

create table Medicine
(
	IDMedicine int primary key identity not null,
	Name nvarchar(100) not null
)
GO

create table PerdominantEating
(
	IDPerdominantEating int primary key identity not null,
	Name nvarchar(100) not null
)
GO

create table LifeStyle
(
	IDLifeStyle int primary key identity not null,
	Vegetarian bit null,
	Smoker bit null,
	ConsumeAlcoholicBeverage bit null,
	UseStimulants bit null,
	UsedStimulants nvarchar(500) null,
	ConsumptionOfCoffeePerDay float null,
	ConsumptionOfTeaPerDay float null, 
	ConsumptionOfSoftDrinksPerDay float null,
	HaveRegularMeals bit null,
	PerdominantEatingID int null,
	CONSTRAINT FK_LifeStyle_PerdominantEating FOREIGN KEY(PerdominantEatingID) REFERENCES PerdominantEating(IDPerdominantEating)
)
GO

create table BasicComplaints
(
	IDBasicComplaints int primary key identity not null,
	StatementOfComplaint nvarchar(max) not null,
	HistoryOfPreviousTreatment nvarchar(max) null,
	PhysicanOrHospitalTrated nvarchar(100) null
)
GO

create table ImportantMedicalComplaints
(
	IDImportantMedicalComplaints int primary key identity not null,
	Diabetic bit null,
	Hypertensive bit null,
	CardiacCondition nvarchar(max) null,
	RespiratoryCondition nvarchar(max) null,
	DigestiveCondition nvarchar(max) null,
	OrthopedicCondition nvarchar(max) null,
	MuscularCondition nvarchar(max) null,
	NeurologicalCondition nvarchar(max) null,
	KnownAllergies nvarchar(max) null, 
	KnownAdverseReactionToSpecificDrugs nvarchar(max) null,
	MajorSurgeriesHistory nvarchar(max) null
)
GO

create table PaymentType 
(
	IDPaymentType int primary key identity not null,
	Name nvarchar(100) not null
)
GO

create table Doctor 
(
	IDDoctor int primary key identity not null,
	BasicDetailsID int not null,
	CONSTRAINT FK_Doctor_BasicDetails FOREIGN KEY(BasicDetailsID) REFERENCES BasicDetails(IDBasicDetails)
)
GO

create table Patient
(
	IDPatient int primary key identity not null,
	RegistrationDate DATETIME DEFAULT GETDATE() not null,
	BasicDetailsID int not null,
	ContactDetailsID int not null,
	ContactNextOfKinID int not null,
	PersonalDetailsID int null,
	ProfessionDetailsID int null,
	LifeStyleID int null,
	BasicComplaintsID int not null,
	ImportantMedicalComplaintsID int null,

	CONSTRAINT FK_Patient_BasicDetails FOREIGN KEY(BasicDetailsID) REFERENCES BasicDetails(IDBasicDetails),
	CONSTRAINT FK_Patient_ContactDetails FOREIGN KEY(ContactDetailsID) REFERENCES ContactDetails(IDContactDetails),
	CONSTRAINT FK_Patient_ContactNextOfKin FOREIGN KEY(ContactNextOfKinID) REFERENCES ContactNextOfKin(IDContactNextOfKin),
	CONSTRAINT FK_Patient_PersonalDetails FOREIGN KEY(PersonalDetailsID) REFERENCES PersonalDetails(IDPersonalDetails),
	CONSTRAINT FK_Patient_ProfessionDetails FOREIGN KEY(ProfessionDetailsID) REFERENCES ProfessionDetails(IDProfessionDetails),
	CONSTRAINT FK_Patient_LifeStyle FOREIGN KEY(LifeStyleID) REFERENCES LifeStyle(IDLifeStyle),
	CONSTRAINT FK_Patient_BasicComplaints FOREIGN KEY(BasicComplaintsID) REFERENCES BasicComplaints(IDBasicComplaints),
	CONSTRAINT FK_Patient_ImportantMedicalComplaints FOREIGN KEY(ImportantMedicalComplaintsID) REFERENCES ImportantMedicalComplaints(IDImportantMedicalComplaints)
)
GO

create table Bill
(
	IDBill int primary key identity not null,
	DateIssuing DATETIME DEFAULT GETDATE() not null,
	PaymentTypeID int not null,
	PatientID int not null,
	Amount money not null,

	CONSTRAINT FK_Bill_PaymentType FOREIGN KEY(PaymentTypeID) REFERENCES PaymentType(IDPaymentType),
	CONSTRAINT FK_Bill_Patient FOREIGN KEY(PatientID) REFERENCES Patient(IDPatient)
)
GO

create table Appointment
(
	IDAppointment int primary key identity not null,
	DoctorID int not null,
	PatientID int not null,
	Representative nvarchar(100) not null,
	DateAppointed DATETIME DEFAULT GETDATE() not null,
	Details nvarchar(max) null,
	SecondOpinion bit not null,

	CONSTRAINT FK_Appointment_Doctor FOREIGN KEY(DoctorID) REFERENCES Doctor(IDDoctor),
	CONSTRAINT FK_Appointment_Patient FOREIGN KEY(PatientID) REFERENCES Patient(IDPatient)
)
GO

create table Test 
(
	IDTest int primary key identity not null,
	Name nvarchar(100) not null,
	PatientID int not null,
	DoctorID int not null,
	TestDateTime DATETIME not null,
	Details nvarchar(max) null,

	CONSTRAINT FK_Test_Doctor FOREIGN KEY(DoctorID) REFERENCES Doctor(IDDoctor),
	CONSTRAINT FK_Test_Patient FOREIGN KEY(PatientID) REFERENCES Patient(IDPatient)
)
GO

create table PatientMedicine
(
	IDPatientMedicine int primary key identity not null,
	DateIssued DATETIME DEFAULT GETDATE() not null,
	Quantity float not null,
	MedicineID int not null,
	PatientID int not null,
	DoctorID int not null,

	CONSTRAINT FK_PatientMedicine_Medicine FOREIGN KEY(MedicineID) REFERENCES Medicine(IDMedicine),
	CONSTRAINT FK_PatientMedicine_Patient FOREIGN KEY(PatientID) REFERENCES Patient(IDPatient),
	CONSTRAINT FK_PatientMedicine_Doctor FOREIGN KEY(DoctorID) REFERENCES Doctor(IDDoctor)
)
GO

-- INSERTING INTO TABLES
insert into Sex
values ('Male'),
	   ('Female')
GO

insert into Medicine
values ('Lupocet'),
	   ('Cardipirin'),
	   ('Iruzid'),
	   ('Neofen'),
	   ('Andol'),
	   ('Caffetin')
GO

insert into PaymentType
values ('Credit card'),
	   ('Cash')
GO

insert into PerdominantEating
values ('Home food'),
       ('Outside')
GO

-- creating,inserting, dropping procedures
drop proc InsertPatientInMiniRegistrationForm
GO

drop proc InsertPatientInComprehensiveRegistrationForm
GO

drop proc GetPatients
GO

drop proc AccessToPatient
GO

drop proc DeletePatient
GO

drop proc GetSex
GO

drop proc GetPredominatingEating
GO

drop proc EditAppointment
GO

drop proc UpdateAppointment
GO

drop proc DeleteAppointment
GO

drop proc GetAppointments
GO

drop proc EditDoctor
GO

drop proc DeleteDoctor
GO

drop proc GetDoctors
GO

drop proc GetMedicine
GO

drop proc EditTest
GO

drop proc DeleteTest
GO

drop proc GetTests
GO

drop proc EditPatientMedicine
GO

drop proc DeletePatientMedicine
GO

drop proc GetPatientMedicine
GO

drop proc EditBill
GO

drop proc DeleteBill
GO

drop proc GetBills 
GO

create proc InsertPatientInMiniRegistrationForm
@Name nvarchar(100),
@SexID int,
@DateOfBirth DATETIME,
@StatementOfComplaint nvarchar(max),
@Mobile nvarchar(50),
@TelephoneHome nvarchar(50),
@NameNextOfKin nvarchar(50),
@RegistrationDate DATETIME OUTPUT
AS

declare @BasicDetailsID int
declare @BasicComplaintsID int
declare @ContactID int
declare @ContactDetailsID int
declare @ContactNextOfKinID int

insert into BasicDetails(Name, SexID, DateOfBirth)
values (@Name, @SexID, @DateOfBirth)

set @BasicDetailsID = SCOPE_IDENTITY()

insert into BasicComplaints(StatementOfComplaint)
values (@StatementOfComplaint)

set @BasicComplaintsID = SCOPE_IDENTITY()

insert into Contact(Mobile, TelephoneHome)
values (@Mobile, @TelephoneHome)

set @ContactID = SCOPE_IDENTITY()

insert into ContactDetails(ContactID)
values (@ContactID)

set @ContactDetailsID = SCOPE_IDENTITY()

insert into ContactNextOfKin(Name)
values (@NameNextOfKin)

set @ContactNextOfKinID = SCOPE_IDENTITY()

insert into Patient(BasicDetailsID, BasicComplaintsID, ContactDetailsID, ContactNextOfKinID)
values (@BasicDetailsID, @BasicComplaintsID, @ContactDetailsID, @ContactNextOfKinID)

SET @RegistrationDate = GETDATE()

GO

declare @insertedDate datetime 
exec InsertPatientInMiniRegistrationForm 'Klara', 2,'19971021', 'Not complaining', '333-3112', '2222113311', 'Mirna', @insertedDate output
GO

declare @insertDate datetime
exec InsertPatientInMiniRegistrationForm 'Borna', 1,'19981113', 'Complaining', '0956662211', '5553322', 'Joža', @insertDate output
exec InsertPatientInMiniRegistrationForm 'Ana',2,'19980122', 'Complaining', '0986347200', '2220066', 'Paula', @insertDate output
exec InsertPatientInMiniRegistrationForm 'Lea',2,'20001224', 'Not conplaining', '0912355765', '3342215', 'Ivona', @insertDate output
GO

create proc InsertPatientInComprehensiveRegistrationForm
@OutpatientID nvarchar(11),
@Name nvarchar(100),
@SexID int,
@DateOfBirth DATETIME,
@PresentAddress nvarchar(100),
@PermanentAddress nvarchar(100),
@TelephoneWork nvarchar(50),
@TelephoneHome nvarchar(50),
@Mobile nvarchar(50),
@Pager nvarchar(50),
@Fax nvarchar(50),
@Email nvarchar(50),
@NameOfNextOfKin nvarchar(50),
@NextOfKinContactAddress nvarchar(100),
@NextOfKinTelephoneWork nvarchar(50),
@NextOfKinTelephoneHome nvarchar(50),
@NextOfKinMobile nvarchar(50),
@NextOfKinPager nvarchar(50),
@NextOfKinFax nvarchar(50),
@NextOfKinEmail nvarchar(50),
@MaritalStatus bit, 
@NumberOfDependents int,
@Height float,
@Weight float,
@BloodTypeRH nvarchar(10),
@Occupation nvarchar(100),
@GrossAnnualIncome money,
@Vegetarian bit,
@Smoker bit, 
@ConsumeAlcoholicBeverage bit, 
@UseStimulants bit,
@UsedStimulants nvarchar(50),
@ConsumptionOfCoffeePerDay float,
@ConsumptionOfTeaPerDay float,
@ConsumptionOfSoftDrinksPerDay float,
@HaveRegularMeals bit,
@PerdominantEatingID int,
@StatementOfComplaint nvarchar(max),
@HistoryOfPreviousTretment nvarchar(max),
@PhysicanOrHospitalTreated nvarchar(100),
@Diabetic bit, 
@Hypertensive bit,
@CardiacCondition nvarchar(max),
@RespiratoryCondition nvarchar(max),
@DigestiveCondition nvarchar(max),
@OrthopedicCondition nvarchar(max),
@MuscularCondition nvarchar(max),
@NeurlogicalCondition nvarchar(max),
@KnownAllergies nvarchar(max),
@KnownAdverseReactionToSpecificDrugs nvarchar(max),
@MajorSurgeriesHistory nvarchar(max),
@RegistrationDate DATETIME OUTPUT

AS

declare @BasicDetailsID int
declare @ContactID int
declare @ContactDetailsID int
declare @ContactOfNextOfKinID int
declare @PersonalDetailsID int
declare @ProfessionDetailsID int
declare @LifestyleID int
declare @BasicComplaintsID int
declare @ImportantMedicalComplaintsID int
declare @NextContactID int

insert into BasicDetails(OutpatientID, Name, SexID, DateOfBirth)
values (@OutpatientID, @Name, @SexID, @DateOfBirth)

set @BasicDetailsID = SCOPE_IDENTITY()

insert into Contact(Mobile, Pager, Fax, Email, TelephoneWork, TelephoneHome)
values (@Mobile, @Pager, @Fax, @Email, @TelephoneWork, @TelephoneHome)

set @ContactID = SCOPE_IDENTITY()

insert into ContactDetails(ContactID, PresentAddress, PermanentAddress)
values (@ContactID, @PresentAddress, @PermanentAddress)

set @ContactDetailsID = SCOPE_IDENTITY()

insert into Contact(Mobile, Pager, Fax, Email, TelephoneWork, TelephoneHome)
values (@NextOfKinMobile, @NextOfKinPager, @NextOfKinFax, @NextOfKinFax, @NextOfKinTelephoneWork, @NextOfKinTelephoneHome)

set @NextContactID = SCOPE_IDENTITY()

insert into ContactNextOfKin(Name, ContactAddress, ContactID)
values (@NameOfNextOfKin, @NextOfKinContactAddress,@NextContactID)

set @ContactOfNextOfKinID = SCOPE_IDENTITY()

insert into PersonalDetails(MaritalStatus, NumberOfDependents, Height, Weight, BloodTypeRH)
values (@MaritalStatus, @NumberOfDependents, @Height, @Weight, @BloodTypeRH)

set @PersonalDetailsID = SCOPE_IDENTITY()

insert into ProfessionDetails(Occupation, GrossAnnualIncome)
values (@Occupation, @GrossAnnualIncome)

set @ProfessionDetailsID = SCOPE_IDENTITY()

insert into LifeStyle(Vegetarian, Smoker, ConsumeAlcoholicBeverage, UseStimulants, UsedStimulants, ConsumptionOfCoffeePerDay, ConsumptionOfTeaPerDay, ConsumptionOfSoftDrinksPerDay, HaveRegularMeals, PerdominantEatingID)
values (@Vegetarian, @Smoker, @ConsumeAlcoholicBeverage, @UseStimulants, @UsedStimulants, @ConsumptionOfCoffeePerDay, @ConsumptionOfTeaPerDay, @ConsumptionOfSoftDrinksPerDay, @HaveRegularMeals, @PerdominantEatingID) 

set @LifestyleID = SCOPE_IDENTITY()

insert into BasicComplaints(StatementOfComplaint, HistoryOfPreviousTreatment, PhysicanOrHospitalTrated)
values (@StatementOfComplaint, @HistoryOfPreviousTretment, @PhysicanOrHospitalTreated)

set @BasicComplaintsID = SCOPE_IDENTITY()

insert into ImportantMedicalComplaints(Diabetic, Hypertensive, CardiacCondition, RespiratoryCondition, DigestiveCondition, OrthopedicCondition, MuscularCondition, NeurologicalCondition, KnownAllergies, KnownAdverseReactionToSpecificDrugs, MajorSurgeriesHistory)
values (@Diabetic, @Hypertensive, @CardiacCondition, @RespiratoryCondition, @DigestiveCondition, @OrthopedicCondition, @MuscularCondition, @NeurlogicalCondition, @KnownAllergies, @KnownAdverseReactionToSpecificDrugs, @MajorSurgeriesHistory)

set @ImportantMedicalComplaintsID = SCOPE_IDENTITY()

insert into Patient(BasicDetailsID, ContactDetailsID, ContactNextOfKinID, PersonalDetailsID, ProfessionDetailsID, LifeStyleID, BasicComplaintsID, ImportantMedicalComplaintsID)
values (@BasicDetailsID, @ContactDetailsID, @ContactOfNextOfKinID, @PersonalDetailsID, @ProfessionDetailsID, @LifestyleID, @BasicComplaintsID, @ImportantMedicalComplaintsID)

set @RegistrationDate = GETDATE()
GO

declare @RegDate datetime
exec InsertPatientInComprehensiveRegistrationForm '01010101010','Domagoj', 1, '19881021', 'Domobranska 2', 'Ilica 200', '2938138', '645454', '0984531357','200','3231657', 'domagoj@mail.com', 'Marko', 'Horvaæanska 3', '5431321', '1335468', '0975522455', '223', '6545377', 'marko@mail.com', 0, 4, 188.3, 86.7, 'A+', 'System engineer', 23421, 0,0,0,0,'No', 0.3, 1.5,0.3, 1, 1, 'No complaining', 'No history of previous treatment', 'No', 0,0, 'Good', 'Good', 'Good', 'Good', 'Good', 'Good', 'No', 'No', 'No major surgeries history', @RegDate output 
GO

declare @ReDate datetime
exec InsertPatientInComprehensiveRegistrationForm '01010101101','Filip', 1, '19970516', 'Veslaèka 2', 'Veslaèka 2', '6136541', '1213524', '0996651245','122','5421124', 'filip@mail.com', 'Domagoj', 'Odranska 3', '5412151', '3131234', '0995331356', '111', '5555555', 'domagoj@mail.com', 1, 3, 180.3, 80.2, 'B+', 'Chef', 1233, 0,0,0,0,'No', 0.3, 1.5,0.3, 1, 1, 'No complaining', 'No history of previous treatment', 'No', 0,0, 'Good', 'Good', 'Good', 'Good', 'Good', 'Good', 'No', 'No', 'No major surgeries history', @ReDate output 
exec InsertPatientInComprehensiveRegistrationForm '01010101111','Ivana', 2, '19931223', 'Horvaæanska 3', 'Horvaæanska 3', '7736531', '4513545', '0916651333','100','2211133', 'ivana@mail.com', 'Marija', 'Trakošæanska 2', '7712123', '4531221', '0985131223', '100', '1111111', 'marija@mail.com', 0, 4, 175.3, 74.5, 'B+', 'Manager', 3435, 0,1,1,0,'No', 0.5, 2.5,0.5, 1, 2, 'Complaining', 'No history of previous treatment', 'No', 0,0, 'Bad', 'Bad', 'Good', 'Good', 'Good', 'Bad', 'Allergic to argan oil', 'No', 'No major surgeries history', @ReDate output
exec InsertPatientInComprehensiveRegistrationForm '01010101000','Josip', 1, '19961024', 'Ilica 5', 'Ilica 5', '6144487', '5412459', '0985454210','333','6463213', 'josip@mail.com', 'Ivan', 'Ozaljska 2', '4654557', '4541221', '0995222485', '444', '7474747', 'ivan@mail.com', 0, 4, 182.3, 81.3, '0+', 'Programmer', 4556, 0,0,0,0,'No', 0.3, 1.5,0.3, 1, 1, 'No complaining', 'No history of previous treatment', 'No', 0,0, 'Good', 'Good', 'Good', 'Good', 'Good', 'Good', 'No', 'No', 'No major surgeries history', @ReDate output  
GO

declare @RDate datetime
exec InsertPatientInComprehensiveRegistrationForm '123456789','Mirko', 1, '19970516', 'Veslaèka 2', 'Veslaèka 2', '6136541', '1213524', '0996651245','122','5421124', 'filip@mail.com', 'Domagoj', 'Odranska 3', '5412151', '3131234', '0995331356', '111', '5555555', 'domagoj@mail.com', 1, 3, 180.3, 80.2, 'B+', 'Chef', 1233, 0,0,0,0,'No', 0.3, 1.5,0.3, 1, 1, 'No complaining', 'No history of previous treatment', 'No', 0,0, 'Good', 'Good', 'Good', 'Good', 'Good', 'Good', 'No', 'No', 'No major surgeries history', @RDate output 
GO

create proc GetPredominatingEating
AS
select * from PerdominantEating
GO


create proc GetPatients 
AS 
select 
p.IDPatient, p.RegistrationDate, 
bd.Name as 'Patient''s name', bd.OutpatientID, bd.DateOfBirth, 
s.Name as 'Sex',
cd.PermanentAddress, cd.PresentAddress, 
cP.TelephoneHome as 'Patient''s telephone home', cP.TelephoneWork as 'Patient''s telephone work', cp.Mobile as 'Patient''s mobile', cP.Pager as 'Patient''s pager', cP.Fax as 'Patient''s fax', cp.Email as 'Patient''s email',
cnok.Name as 'Next of kin''s name', cnok.ContactAddress as 'Next of kin''s contact address', 
cn.TelephoneHome as 'Next of kin''s telephone home', cn.TelephoneWork as 'Next of kin''s telephone work', cn.Mobile as 'Next of kin''s mobile', cn.Pager as 'Next of kin''s pager', cn.Fax as 'Next of kin''s fax', cn.Email as 'Next of kin''s email',
pd.MaritalStatus, pd.NumberOfDependents, pd.Height, pd.Weight, pd.BloodTypeRH,
pfd.Occupation, pfd.GrossAnnualIncome,
l.Vegetarian, l.Smoker, l.ConsumeAlcoholicBeverage, l.UseStimulants, l.UsedStimulants, l.ConsumptionOfCoffeePerDay, l.ConsumptionOfTeaPerDay, l.ConsumptionOfSoftDrinksPerDay, l.HaveRegularMeals,
bc.StatementOfComplaint, bc.HistoryOfPreviousTreatment, bc.PhysicanOrHospitalTrated,
imc.Diabetic, imc.Hypertensive, imc.CardiacCondition, imc.RespiratoryCondition, imc.DigestiveCondition, imc.OrthopedicCondition, imc.MuscularCondition, imc.NeurologicalCondition, imc.KnownAllergies, imc.KnownAdverseReactionToSpecificDrugs, imc.MajorSurgeriesHistory
from Patient as p

LEFT JOIN BasicDetails AS bd 
ON p.BasicDetailsID = bd.IDBasicDetails

LEFT JOIN ContactDetails AS cd
ON cd.IDContactDetails = p.ContactDetailsID

LEFT JOIN ContactNextOfKin AS cnok
ON cnok.IDContactNextOfKin = p.ContactNextOfKinID

LEFT JOIN PersonalDetails AS pd
ON pd.IDPersonalDetails = p.PersonalDetailsID

LEFT JOIN ProfessionDetails AS pfd 
ON pfd.IDProfessionDetails = p.ProfessionDetailsID

LEFT JOIN LifeStyle AS l
ON l.IDLifeStyle = p.LifeStyleID

LEFT JOIN BasicComplaints AS bc 
ON bc.IDBasicComplaints = p.BasicComplaintsID

LEFT JOIN ImportantMedicalComplaints AS imc
ON imc.IDImportantMedicalComplaints = p.ImportantMedicalComplaintsID

LEFT JOIN Sex AS s
ON s.IDSex = bd.SexID

LEFT JOIN Contact AS cP
ON cP.IDContact = cd.ContactID

LEFT JOIN Contact AS cn
ON cn.IDContact = cnok.ContactID

LEFT JOIN PerdominantEating AS pe 
ON l.PerdominantEatingID = pe.IDPerdominantEating
GO

exec GetPatients
SELECT * FROM Patient
GO



create proc DeletePatient

@PatientAjdi int

AS

-- deleting foregin key of patient
delete from Appointment where PatientID = @PatientAjdi
delete from Bill where PatientID = @PatientAjdi
delete from PatientMedicine where PatientID = @PatientAjdi
delete from Test where PatientID = @PatientAjdi
delete from PatientMedicine where PatientID = @PatientAjdi

-- deleting patient
-- declare all foreign keys 
declare @BasicDetailsID int
declare @ContactOfPatientID int
declare @NextOfKinContactID int
declare @ContactDetailsID int
declare @ContactNextOfKinID int
declare @PersonalDetailsID int
declare @ProfessionDetailsID int
declare @LifeStyleID int
declare @BasicComplaintsID int
declare @ImportantMedicalComplaintsID int

-- make sure all foreign keys belong to the table patient, except ContactOfPatientID and NextOfKinContactID which belong in another two tables
select 
BasicDetailsID = @BasicDetailsID,
ContactDetailsID = @ContactDetailsID,
ContactNextOfKinID = @ContactNextOfKinID,
PersonalDetailsID = @PersonalDetailsID,
ProfessionDetailsID = @ProfessionDetailsID,
LifeStyleID = @LifeStyleID,
BasicComplaintsID = @BasicComplaintsID,
ImportantMedicalComplaintsID = @ImportantMedicalComplaintsID
from Patient
where IDPatient = @PatientAjdi

select @ContactOfPatientID = ContactID from ContactDetails where IDContactDetails = @ContactDetailsID
select @NextOfKinContactID = ContactID from ContactNextOfKin where IDContactNextOfKin = @ContactNextOfKinID

-- deleting
delete from Patient where IDPatient = @PatientAjdi
delete from BasicDetails where IDBasicDetails = @BasicDetailsID
delete from Contact where IDContact IN (@ContactOfPatientID, @NextOfKinContactID)
delete from ContactDetails where IDContactDetails = @ContactDetailsID
delete from ContactNextOfKin where IDContactNextOfKin = @ContactNextOfKinID
delete from PersonalDetails where IDPersonalDetails = @PersonalDetailsID
delete from ProfessionDetails where IDProfessionDetails = @ProfessionDetailsID
delete from LifeStyle where IDLifeStyle = @LifeStyleID
delete from BasicComplaints where IDBasicComplaints = @BasicComplaintsID
delete from ImportantMedicalComplaints where IDImportantMedicalComplaints = @ImportantMedicalComplaintsID

GO


create proc GetSex 
AS
select * 
from Sex
GO

exec GetSex 
GO

create proc EditAppointment
@DoctorID int,
@PatientID int,
@Representative nvarchar(100),
@DateAppointed datetime,
@Details nvarchar(max),
@SecondOpinion bit,
@EditedID int output 

AS

insert into Appointment (DoctorID, PatientID, Representative, DateAppointed, Details, SecondOpinion)
values (@DoctorID, @PatientID, @Representative, @DateAppointed, @Details, @SecondOpinion)

set @EditedID = SCOPE_IDENTITY()
GO

declare @edit int
exec EditAppointment 1,5,'Receptionist','20201220','no comment',1, @edit output
exec EditAppointment 2,7,'Receptionist','20201220','no comment',1, @edit output
exec EditAppointment 2,9,'Receptionist','20201220','no comment',1, @edit output
exec EditAppointment 1,3,'Receptionist','20201220','no comment',1, @edit output
exec EditAppointment 3,4,'Receptionist','20201220','no comment',1, @edit output
exec EditAppointment 1,11,'Receptionist','20201220','no comment',1, @edit output
GO

create proc UpdateAppointment
@AjdiAppointment int,
@DoctorID int,
@PatientID int,
@Representative nvarchar(100),
@DateAppointed datetime,
@Details nvarchar(max),
@SecondOpinion bit

AS

update Appointment
set DoctorID = @DoctorID,
	PatientID = @PatientID,
	Representative = @Representative,
	DateAppointed = @DateAppointed, 
	Details = @Details,
	SecondOpinion = @SecondOpinion
 
 where IDAppointment = @AjdiAppointment
 GO


 create proc DeleteAppointment
 @AjdiAp int

 AS

 delete from Appointment
 where IDAppointment = @AjdiAp
 GO


 create proc GetAppointments
 @AjdiP int 

 AS 

 select a.IDAppointment, d.IDDoctor as 'Doctor''s id', a.Representative, a.DateAppointed, a.Details, a.SecondOpinion
 from Appointment as a

 INNER JOIN Doctor as d
 ON a.DoctorID = d.IDDoctor

 INNER JOIN BasicDetails as bd
 ON bd.IDBasicDetails = d.BasicDetailsID

 where a.PatientID = @AjdiP
GO



create proc EditDoctor
@OIB nvarchar(11),
@Name nvarchar(100),
@SexID int,
@DOB datetime 

AS 

declare @BasicsID int

insert into BasicDetails(OutpatientID, Name, SexID, DateOfBirth)
values (@OIB, @Name, @SexID, @DOB)

set @BasicsID = SCOPE_IDENTITY()

insert into Doctor(BasicDetailsID)
values (@BasicsID)
GO

exec EditDoctor '23456789', 'Luka', 1, '19871022'
exec EditDoctor '84523667', 'Ivan', 1, '19851112'
exec EditDoctor '15454212', 'Marija', 2, '19901222'
GO

create proc DeleteDoctor
@AjdiDoctor int

AS 

declare @Basic int = (select BasicDetailsID from Doctor where IDDoctor = @AjdiDoctor)

delete from Doctor
where IDDoctor = @AjdiDoctor

delete from BasicDetails
where IDBasicDetails = @Basic
GO


create proc GetDoctors

AS

select d.IDDoctor, bd.Name, s.Name as 'Doctor''s gender', OutpatientID, bd.DateOfBirth
from Doctor as d

INNER JOIN BasicDetails as bd
ON d.BasicDetailsID = bd.IDBasicDetails

INNER JOIN Sex as s
ON bd.SexID = s.IDSex
GO


create proc GetMedicine
AS 
select *
from Medicine
GO1
SELECT * FROM PatientMedicine


create proc EditTest 
@Name nvarchar(100),
@PatientID int,
@DoctorID int, 
@TestDateTime datetime,
@Details nvarchar(max)

AS 

insert into Test(Name, PatientID, DoctorID, TestDateTime, Details)
values (@Name, @PatientID, @DoctorID, @TestDateTime, @Details)
GO



create proc DeleteTest

@TestAjdi int

AS

delete from Test
where IDTest = @TestAjdi
GO


create proc GetTests

@AjdiPatient int

AS

select t.IDTest, t.Name, t.DoctorID, bd.Name as 'Doctors''s name', t.TestDateTime, t.Details
from Test as t

INNER JOIN Doctor as d
ON t.DoctorID = d.IDDoctor

INNER JOIN BasicDetails as bd
ON d.BasicDetailsID = bd.IDBasicDetails

where t.PatientID = @AjdiPatient
GO



create proc EditPatientMedicine
@Quantity float,
@MedicineAjdi int,
@PatientAjdi int,
@DoctorAjdi int,
@DateIssued datetime output 

AS

insert into PatientMedicine(Quantity, MedicineID, PatientID, DoctorID)
values (@Quantity, @MedicineAjdi, @PatientAjdi, @DoctorAjdi)

set @DateIssued = GETDATE()
GO



create proc DeletePatientMedicine
@PatientMedicineAjdi int

AS 

delete from PatientMedicine
where IDPatientMedicine = @PatientMedicineAjdi
GO



create proc GetPatientMedicine
@AjdiP int 

AS

select pm.IDPatientMedicine, pm.DoctorID, bd.Name as 'Doctor''s name', m.Name, pm.Quantity, pm.DateIssued
from PatientMedicine pm

INNER JOIN Medicine as m
ON pm.MedicineID = m.IDMedicine

INNER JOIN Doctor as d
ON pm.DoctorID = d.IDDoctor

INNER JOIN BasicDetails as bd
ON d.BasicDetailsID = bd.IDBasicDetails

where pm.PatientID = @AjdiP
GO



create proc EditBill
@PejmentTajpAjdi int, 
@PejšntAjdi int, 
@Amount money,
@DejtIšuing datetime output

AS 

insert into Bill(PaymentTypeID, PatientID, Amount)
values (@PejmentTajpAjdi, @PejšntAjdi, @Amount)

set @DejtIšuing = SCOPE_IDENTITY()
GO
 
 declare @d datetime
 exec EditBill 2, 3, 234.55, @d output
 GO

create proc DeleteBill

@AjdiBill int

AS 

delete from Bill
where IDBill = @AjdiBill
GO



create proc GetBills

@AjdiPejšent int

AS 

select b.IDBill, b.DateIssuing, pt.Name, b.Amount
from Bill as b

INNER JOIN PaymentType as pt
ON b.PaymentTypeID = pt.IDPaymentType

where b.PatientID = @AjdiPejšent
GO

exec GetPatients
GO

select * from BasicDetails
GO

select * from Patient
GO

SELECT * FROM Appointment
exec GetAppointments 5











declare @insertedDate datetime
--declare @id int = (select MAX(IDPatient) from patient)
--exec DeletePatient @id
SELECT * FROM Patient
exec InsertPatientInMiniRegistrationForm 'Troll', 2,'19971021', 'Not complaining', '333-3112', '2222113311', 'Mirna', @insertedDate output
DECLARE @insertedID INT = SCOPE_IDENTITY()
exec EditAppointment 1,@insertedDate,'Hoki','20201220','no comment',1, @insertedDate output

exec GetPatients
SELECT * FROM Appointment
GO

create proc GetPaymentType 
AS
select * from PaymentType
GO
SELECT * FROM Doctor
SELECT * FROM BasicDetails WHERE IDBasicDetails = 10
select * from Appointment
GO
EXEC GetAppointments 5
select * from Bill
GO
EXEC GetBills 1

select * from Bill
GO

exec GetBills 2

select * from Patient
GO

exec GetBills 6
GO