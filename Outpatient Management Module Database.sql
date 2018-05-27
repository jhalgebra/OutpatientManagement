USE master
GO
DROP DATABASE OutpatientManagementModule
GO
CREATE DATABASE OutpatientManagementModule
GO
USE OutpatientManagementModule
GO

--Enums
CREATE TABLE PaymentType
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	Name NVARCHAR(100) NOT NULL
)

INSERT INTO PaymentType VALUES
('Credit Card'),
('Cash')

CREATE TABLE PredominantEatingOption
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	Name NVARCHAR(100) NOT NULL
)

INSERT INTO PredominantEatingOption VALUES
('Home Food'),
('Outside')

CREATE TABLE Sex
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	Name NVARCHAR(100) NOT NULL
)

INSERT INTO Sex VALUES
('Male'),
('Female')

CREATE TABLE Medicine
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	Name NVARCHAR(100) NOT NULL
)

INSERT INTO Medicine VALUES
('Andol'),
('Lupocet'),
('Caffetin'),
('Linex'),
('Dimidril'),
('Aqua Maris'),
('Euthyrox')
--ENDOF: Enums-------------------------------------------------------------------------------------

--Helper objects
CREATE TABLE Contact
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	TelephoneWork NVARCHAR(100) NULL, --Mini Registration Form
	TelephoneHome NVARCHAR(100) NULL, --Mini Registration Form
	Mobile NVARCHAR(100) NULL,
	Pager NVARCHAR(100) NULL,
	Fax NVARCHAR(100) NULL,
	Email NVARCHAR(100) NULL
)
--ENDOF: Helper objects----------------------------------------------------------------------------

--Patient details
CREATE TABLE BasicDetails
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	OIB CHAR(11) NULL,
	Name NVARCHAR(100) NOT NULL, --Mini Registration Form
	SexID INT NOT NULL, --Mini Registration Form
	DateOfBirth DATETIME NOT NULL, --Mini Registration Form

	FOREIGN KEY(SexID) REFERENCES Sex(ID)
)

CREATE TABLE ContactDetails
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	PresentAddress NVARCHAR(200) NULL,
	PermanentAddress NVARCHAR(200) NULL,
	ContactID INT NOT NULL, --Mini Registration Form

	FOREIGN KEY(ContactID) REFERENCES Contact(ID)
)

CREATE TABLE ContactOfNextOfKin
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	Name NVARCHAR(100) NOT NULL, --Mini Registration Form
	ContactAddress NVARCHAR(200) NULL,
	ContactID INT NULL,

	FOREIGN KEY(ContactID) REFERENCES Contact(ID)
)

CREATE TABLE PersonalDetails
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	MaritalStatus BIT NULL,
	NumberOfDependents INT NULL, --people in immediate family
	Height FLOAT NULL,
	Weight FLOAT NULL,
	BloodTypeRH NVARCHAR(5) NULL
)

CREATE TABLE ProfessionDetails
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	Occupation NVARCHAR(200) NULL,
	GrossAnnualIncome MONEY NULL
)

CREATE TABLE Lifestyle
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	Vegetarian BIT NULL,
	Smoker BIT NULL,
	ConsumesAlcoholicBeverage BIT NULL,
	UsesStimulants BIT NULL,
	StimulantsUsed NVARCHAR(1000) NULL,
	CoffeeConsumptionPerDay FLOAT NULL,
	TeaConsumptionPerDay FLOAT NULL,
	SoftDrinkConsumptionPerDay FLOAT NULL,
	RegularMeals BIT NULL,
	PredominantEatingOptionID INT NULL,

	FOREIGN KEY(PredominantEatingOptionID) REFERENCES PredominantEatingOption(ID)
)

CREATE TABLE BasicComplaints
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	StatementOfComplaint NVARCHAR(1000) NOT NULL, --Mini Registration Form
	HistoryOfPreviousTreatment NVARCHAR(MAX) NULL,
	PhysicianOrHospitalTreated NVARCHAR(200) NULL
)

CREATE TABLE MedicalComplaints
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	Diabetic BIT NULL,
	Hypertensive BIT NULL,
	CardiacCondition NVARCHAR(1000) NULL,
	RespiratoryCondition NVARCHAR(1000) NULL,
	DigestiveCondition NVARCHAR(1000) NULL,
	OrthopedicCondition NVARCHAR(1000) NULL,
	MuscularCondition NVARCHAR(1000) NULL,
	NeurologicalCondition NVARCHAR(1000) NULL,
	KnownAllergies NVARCHAR(1000) NULL,
	KnownAdverseReactionToSpecificDrugs NVARCHAR(3000) NULL,
	MajorSurgeries NVARCHAR(4000) NULL
)
--ENDOF: Patient details---------------------------------------------------------------------------

--Entities
CREATE TABLE Doctor
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	BasicDetailsID INT NOT NULL,

	FOREIGN KEY(BasicDetailsID) REFERENCES BasicDetails(ID)
)

CREATE TABLE Patient
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	RegistrationDate DATETIME DEFAULT GETDATE() NOT NULL, --Mini Registration Form
	BasicRegistration BIT NOT NULL,
	BasicDetailsID INT NOT NULL,
	ContactDetailsID INT NOT NULL,
	ContactOfNextOfKinID INT NOT NULL,
	PersonalDetailsID INT NULL,
	ProfessionDetailsID INT NULL,
	LifestyleID INT NULL,
	BasicComplaintsID INT NOT NULL,
	MedicalComplaintsID INT NULL,

	FOREIGN KEY(BasicDetailsID) REFERENCES BasicDetails(ID),
	FOREIGN KEY(ContactDetailsID) REFERENCES ContactDetails(ID),
	FOREIGN KEY(ContactOfNextOfKinID) REFERENCES ContactOfNextOfKin(ID),
	FOREIGN KEY(PersonalDetailsID) REFERENCES PersonalDetails(ID),
	FOREIGN KEY(ProfessionDetailsID) REFERENCES ProfessionDetails(ID),
	FOREIGN KEY(LifestyleID) REFERENCES Lifestyle(ID),
	FOREIGN KEY(BasicComplaintsID) REFERENCES BasicComplaints(ID),
	FOREIGN KEY(MedicalComplaintsID) REFERENCES MedicalComplaints(ID),
)

CREATE TABLE Bill
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	DateIssued DATETIME DEFAULT GETDATE() NOT NULL,
	PaymentTypeID INT NOT NULL,
	PatientID INT NOT NULL,
	DoctorID INT NOT NULL,
	Amount MONEY NOT NULL,

	FOREIGN KEY(PaymentTypeID) REFERENCES PaymentType(ID),
	FOREIGN KEY(PatientID) REFERENCES Patient(ID),
	FOREIGN KEY(DoctorID) REFERENCES Doctor(ID)
)

CREATE TABLE Appointment
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	DoctorID INT NOT NULL,
	PatientID INT NOT NULL,

	-- Onaj tko je zatratio pregled (ustanova, doktor, na recepciji)
	Delegate NVARCHAR(150) NOT NULL,
	DateAppointed DATETIME NOT NULL,
	Details NVARCHAR(1000) NULL,

	FOREIGN KEY(PatientID) REFERENCES Patient(ID),
	FOREIGN KEY(DoctorID) REFERENCES Doctor(ID)
)

CREATE TABLE Test
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	PatientID INT NOT NULL,
	DoctorID INT NOT NULL,
	Name NVARCHAR(100) NOT NULL,
	Details NVARCHAR(1000) NULL,
	TestDateTime DATETIME NOT NULL,

	FOREIGN KEY(PatientID) REFERENCES Patient(ID),
	FOREIGN KEY(DoctorID) REFERENCES Doctor(ID)
)
--ENDOF: Entities----------------------------------------------------------------------------------

--Patient.List<Medicine>
CREATE TABLE PatientMedicine
(
	ID INT PRIMARY KEY IDENTITY NOT NULL,
	DateIssued DATETIME DEFAULT GETDATE() NOT NULL,
	Quantity INT NOT NULL,
	MedicineID INT NOT NULL,
	PatientID INT NOT NULL,
	DoctorID INT NOT NULL,

	FOREIGN KEY(MedicineID) REFERENCES Medicine(ID),
	FOREIGN KEY(PatientID) REFERENCES Patient(ID),
	FOREIGN KEY(DoctorID) REFERENCES Doctor(ID)
)
--ENDOF: Patient.List<Medicine>--------------------------------------------------------------------