IF(DB_ID('OutpatientManagementModule') IS NULL)
	RAISERROR('Make sure that the OutpatientManagementModule database exists before running this script', 20, -1) WITH LOG

USE OutpatientManagementModule
GO

DROP PROC InsertPatientWithBasicDetails
DROP PROC InsertPatientWithFullDetails
DROP PROC RemovePatient
DROP PROC GetPatients
DROP PROC InsertBill
DROP PROC RemoveBill
DROP PROC GetBills
DROP PROC InsertAppointment
DROP PROC RemoveAppointment
DROP PROC GetAppointments
DROP PROC InsertTest
DROP PROC RemoveTest
DROP PROC GetTests
DROP PROC InsertPatientMedicine
DROP PROC RemovePatientMedicine
DROP PROC GetPatientMedicine
DROP PROC InsertDoctor
DROP PROC RemoveDoctor
DROP PROC GetDoctors

GO

-------------
-- Patient --
-------------

CREATE PROC InsertPatientWithBasicDetails
	--Basic Details
	@Name NVARCHAR(100),
	@SexID INT,
	@DateOfBirth DATETIME,
	--Basic Complaints
	@StatementOfComplaint NVARCHAR(1000),
	--Contact Details -> Contact
	@TelephoneWork NVARCHAR(100),
	@TelephoneHome NVARCHAR(100),
	--Contact of Next of Kin
	@NameOfNextOfKin NVARCHAR(100),
	--Patient
	@InsertedID INT OUTPUT
AS --InsertPatientWithBasicDetails
	DECLARE @BasicDetailsID INT, @BasicComplaintsID INT,
			@ContactDetailsID INT, @ContactOfNextOfKinID INT

	DECLARE @ContactID INT

	--Basic Details
	INSERT INTO BasicDetails(Name, SexID, DateOfBirth)
	VALUES(@Name, @SexID, @DateOfBirth)

	SET @BasicDetailsID = SCOPE_IDENTITY()

	--Basic Complaints
	INSERT INTO BasicComplaints(StatementOfComplaint)
	VALUES(@StatementOfComplaint)

	SET @BasicComplaintsID = SCOPE_IDENTITY()

	--Contact Details
	INSERT INTO Contact(TelephoneHome, TelephoneWork)
	VALUES(@TelephoneHome, @TelephoneWork)

	SET @ContactID = SCOPE_IDENTITY()

	INSERT INTO ContactDetails(ContactID)
	VALUES(@ContactID)

	SET @ContactDetailsID = SCOPE_IDENTITY()

	--Contact of Next of Kin
	INSERT INTO ContactOfNextOfKin(Name)
	VALUES(@NameOfNextOfKin)

	SET @ContactOfNextOfKinID = SCOPE_IDENTITY()

	--Patient
	INSERT INTO Patient(BasicRegistration, BasicDetailsID, BasicComplaintsID, ContactDetailsID, ContactOfNextOfKinID)
	VALUES (1, @BasicDetailsID, @BasicComplaintsID, @ContactDetailsID, @ContactOfNextOfKinID)

	SET @InsertedID = SCOPE_IDENTITY()
GO 
--ENDOF: InsertPatientWithBasicDetails-------------------------------------------------------------

CREATE PROC InsertPatientWithFullDetails
	--Basic Details
	@OIB CHAR(11),
	@Name NVARCHAR(100),
	@SexID INT,
	@DateOfBirth DATETIME,
	--Contact Details
	@PresentAddress NVARCHAR(200),
	@PermanentAddress NVARCHAR(200),
	@TelephoneWork NVARCHAR(100),
	@TelephoneHome NVARCHAR(100),
	@Mobile NVARCHAR(100),
	@Pager NVARCHAR(100),
	@Fax NVARCHAR(100),
	@Email NVARCHAR(100),
	--Contact of Next of Kin
	@NextOfKinName NVARCHAR(100),
	@NextOfKinContactAddress NVARCHAR(200),
	@NextOfKinTelephoneWork NVARCHAR(100),
	@NextOfKinTelephoneHome NVARCHAR(100),
	@NextOfKinMobile NVARCHAR(100),
	@NextOfKinPager NVARCHAR(100),
	@NextOfKinFax NVARCHAR(100),
	@NextOfKinEmail NVARCHAR(100),
	--Personal Details
	@MaritalStatus BIT,
	@NumberOfDependents INT,
	@Height FLOAT,
	@Weight FLOAT,
	@BloodTypeRH NVARCHAR(5),
	--Profession Details
	@Occupation NVARCHAR(200),
	@GrossAnnualIncome MONEY,
	--Lifestyle
	@Vegetarian BIT,
	@Smoker BIT,
	@ConsumesAlcoholicBeverage BIT,
	@UsesStimulants BIT,
	@StimulantsUsed NVARCHAR(1000),
	@CoffeeConsumptionPerDay FLOAT,
	@TeaConsumptionPerDay FLOAT,
	@SoftDrinkConsumptionPerDay FLOAT,
	@RegularMeals BIT,
	@PredominantEatingOptionID INT,
	--Basic Complaints
	@StatementOfComplaint NVARCHAR(1000),
	@HistoryOfPreviousTreatment NVARCHAR(MAX),
	@PhysicianOrHospitalTreated NVARCHAR(200),
	--Medical Complaints
	@Diabetic BIT,
	@Hypertensive BIT,
	@CardiacCondition NVARCHAR(1000),
	@RespiratoryCondition NVARCHAR(1000),
	@DigestiveCondition NVARCHAR(1000),
	@OrthopedicCondition NVARCHAR(1000),
	@MuscularCondition NVARCHAR(1000),
	@NeurologicalCondition NVARCHAR(1000),
	@KnownAllergies NVARCHAR(1000),
	@KnownAdverseReactionToSpecificDrugs NVARCHAR(3000),
	@MajorSurgeries NVARCHAR(4000),
	--Patient
	@InsertedID INT OUTPUT
AS --InsertPatientWithFullDetails
	DECLARE @BasicDetailsID INT, @ContactDetailsID INT, @ContactOfNextOfKinID INT, @PersonalDetailsID INT,
			@ProfessionDetailsID INT, @LifestyleID INT, @BasicComplaintsID INT, @MedicalComplaintsID INT

	DECLARE @ContactID INT, @NextOfKinContactID INT

	--Basic Details
	INSERT INTO BasicDetails(OIB, Name, SexID, DateOfBirth)
	VALUES (@OIB, @Name, @SexID, @DateOfBirth)

	SET @BasicDetailsID = SCOPE_IDENTITY()

	--Contact Details
	INSERT INTO Contact(TelephoneWork, TelephoneHome, Mobile, Pager, Fax, Email)
	VALUES(@TelephoneWork, @TelephoneHome, @Mobile, @Pager, @Fax, @Email)

	SET @ContactID = SCOPE_IDENTITY()

	INSERT INTO ContactDetails(PresentAddress, PermanentAddress, ContactID)
	VALUES(@PresentAddress, @PermanentAddress, @ContactID)

	SET @ContactDetailsID = SCOPE_IDENTITY()

	--Contact of Next of Kin
	INSERT INTO Contact(TelephoneWork, TelephoneHome, Mobile, Pager, Fax, Email)
	VALUES(@NextOfKinTelephoneWork, @NextOfKinTelephoneHome, @NextOfKinMobile,
		   @NextOfKinPager, @NextOfKinFax, @NextOfKinEmail)

	SET @NextOfKinContactID = SCOPE_IDENTITY()

	INSERT INTO ContactOfNextOfKin(Name, ContactAddress, ContactID)
	VALUES(@NextOfKinName, @NextOfKinContactAddress, @NextOfKinContactID)

	--Personal Details
	INSERT INTO PersonalDetails(MaritalStatus, NumberOfDependents, Height, Weight, BloodTypeRH)
	VALUES(@MaritalStatus, @NumberOfDependents, @Height, @Weight, @BloodTypeRH)

	SET @PersonalDetailsID = SCOPE_IDENTITY()

	--Profession Details
	INSERT INTO ProfessionDetails(Occupation, GrossAnnualIncome)
	VALUES(@Occupation, @GrossAnnualIncome)

	SET @ProfessionDetailsID = SCOPE_IDENTITY()

	--Lifestyle
	INSERT INTO Lifestyle(Vegetarian, Smoker, ConsumesAlcoholicBeverage, UsesStimulants, StimulantsUsed,
	CoffeeConsumptionPerDay, TeaConsumptionPerDay, SoftDrinkConsumptionPerDay, RegularMeals, PredominantEatingOptionID)
	VALUES(@Vegetarian, @Smoker, @ConsumesAlcoholicBeverage, @UsesStimulants, @StimulantsUsed, @CoffeeConsumptionPerDay,
	@TeaConsumptionPerDay, @SoftDrinkConsumptionPerDay, @RegularMeals, @PredominantEatingOptionID)

	SET @LifestyleID = SCOPE_IDENTITY()

	--Basic Complaints
	INSERT INTO BasicComplaints(StatementOfComplaint, HistoryOfPreviousTreatment, PhysicianOrHospitalTreated)
	VALUES(@StatementOfComplaint, @HistoryOfPreviousTreatment, @PhysicianOrHospitalTreated)

	SET @BasicComplaintsID = SCOPE_IDENTITY()

	--Medical Complaints
	INSERT INTO MedicalComplaints(Diabetic, Hypertensive, CardiacCondition, RespiratoryCondition, DigestiveCondition,
	OrthopedicCondition, MuscularCondition, NeurologicalCondition, KnownAllergies, KnownAdverseReactionToSpecificDrugs, MajorSurgeries)
	VALUES(@Diabetic, @Hypertensive, @CardiacCondition, @RespiratoryCondition, @DigestiveCondition, @OrthopedicCondition,
	@MuscularCondition, @NeurologicalCondition, @KnownAllergies, @KnownAdverseReactionToSpecificDrugs, @MajorSurgeries)

	SET @MedicalComplaintsID = SCOPE_IDENTITY()

	/*
		DECLARE @BasicDetailsID INT, @ContactDetailsID INT, @ContactOfNextOfKinID INT, @PersonalDetailsID INT,
			@ProfessionDetailsID INT, @LifestyleID INT, @BasicComplaintsID INT, @MedicalComplaintsID INT
	*/

	--Patient
	INSERT INTO Patient(BasicRegistration, BasicDetailsID, ContactDetailsID, ContactOfNextOfKinID, PersonalDetailsID,
	ProfessionDetailsID, LifestyleID, BasicComplaintsID, MedicalComplaintsID)
	VALUES(0, @BasicDetailsID, @ContactDetailsID, @ContactOfNextOfKinID, @PersonalDetailsID, @ProfessionDetailsID,
	@LifestyleID, @BasicComplaintsID, @MedicalComplaintsID)

	SET @InsertedID = SCOPE_IDENTITY()
GO
--ENDOF: InsertPatientWithFullDetails--------------------------------------------------------------

CREATE PROC RemovePatient
	@IDPatient INT
AS
	DELETE FROM Bill WHERE PatientID = @IDPatient
	DELETE FROM Appointment WHERE PatientID = @IDPatient
	DELETE FROM Test WHERE PatientID = @IDPatient
	DELETE FROM PatientMedicine WHERE PatientID = @IDPatient

	DELETE FROM Contact WHERE ID IN
	(
		SELECT ContactID FROM ContactDetails WHERE ID IN
		(
			SELECT ContactDetailsID FROM Patient WHERE ID = @IDPatient
		)

		UNION ALL

		SELECT ContactID FROM ContactOfNextOfKin WHERE ID IN
		(
			SELECT ContactOfNextOfKinID FROM Patient WHERE ID = @IDPatient
		)
	)

	DELETE FROM BasicDetails WHERE ID IN
	( SELECT BasicDetailsID FROM Patient WHERE ID = @IDPatient )

	DELETE FROM ContactDetails WHERE ID IN
	( SELECT ContactDetailsID FROM Patient WHERE ID = @IDPatient )

	DELETE FROM ContactOfNextOfKin WHERE ID IN
	( SELECT ContactOfNextOfKinID FROM Patient WHERE ID = @IDPatient )

	DELETE FROM PersonalDetails WHERE ID IN
	( SELECT PersonalDetailsID FROM Patient WHERE ID = @IDPatient )

	DELETE FROM ProfessionDetails WHERE ID IN
	( SELECT ProfessionDetailsID FROM Patient WHERE ID = @IDPatient )

	DELETE FROM Lifestyle WHERE ID IN
	( SELECT LifestyleID FROM Patient WHERE ID = @IDPatient )

	DELETE FROM BasicComplaints WHERE ID IN
	( SELECT BasicComplaintsID FROM Patient WHERE ID = @IDPatient )

	DELETE FROM MedicalComplaints WHERE ID IN
	( SELECT MedicalComplaintsID FROM Patient WHERE ID = @IDPatient )

	DELETE FROM Patient WHERE ID = @IDPatient
GO
--ENDOF: RemovePatient-----------------------------------------------------------------------------

CREATE PROC GetPatients
AS
	SELECT * FROM Patient AS p
	INNER JOIN BasicDetails AS bd ON bd.ID = p.BasicDetailsID
	INNER JOIN ContactDetails AS cd ON cd.ID = p.ContactDetailsID
	INNER JOIN ContactOfNextOfKin AS cnk ON cnk.ID = p.ContactOfNextOfKinID
	INNER JOIN PersonalDetails AS pd ON pd.ID = p.PersonalDetailsID
	INNER JOIN ProfessionDetails AS profD ON profD.ID = p.ProfessionDetailsID
	INNER JOIN Lifestyle AS l ON l.ID = p.LifestyleID
	INNER JOIN BasicComplaints AS bc ON bc.ID = p.BasicComplaintsID
	INNER JOIN MedicalComplaints AS mc ON mc.ID = p.MedicalComplaintsID
GO
--ENDOF: GetPatients-------------------------------------------------------------------------------

-------------------
-- Patient.Bills --
-------------------

CREATE PROC InsertBill
	@PaymentTypeID INT,
	@PatientID INT,
	@DoctorID INT,
	@Amount MONEY,
	@InsertedID INT OUTPUT
AS
	INSERT INTO BILL(PaymentTypeID, PatientID, DoctorID, Amount)
	VALUES(@PaymentTypeID, @PatientID, @DoctorID, @Amount)

	SET @InsertedID = SCOPE_IDENTITY()
GO
--ENDOF: InsertBill--------------------------------------------------------------------------------

CREATE PROC RemoveBill
	@IDBill INT
AS
	DELETE FROM Bill WHERE ID = @IDBill
GO
--ENDOF: RemoveBill--------------------------------------------------------------------------------

CREATE PROC GetBills
	@IDPatient INT
AS
	SELECT
		b.Amount,
		b.DateIssued,
		pt.Name, --payment type
		bd.Name --doctor's name
	FROM Bill AS b
	INNER JOIN Doctor AS d ON d.ID = b.DoctorID
	INNER JOIN BasicDetails AS bd ON bd.ID = d.BasicDetailsID
	INNER JOIN PaymentType AS pt ON pt.ID = b.PaymentTypeID
	WHERE b.PatientID = @IDPatient
GO
--ENDOF: GetBills----------------------------------------------------------------------------------

--------------------------
-- Patient.Appointments --
--------------------------

CREATE PROC InsertAppointment
	@DoctorID INT,
	@PatientID INT,
	@Delegate NVARCHAR(150),
	@DateAppointed DATETIME,
	@Details NVARCHAR(1000),
	@InsertedID INT OUTPUT
AS
	INSERT INTO Appointment(DoctorID, PatientID, Delegate, DateAppointed, Details)
	VALUES(@DoctorID, @PatientID, @Delegate, @DateAppointed, @Details)

	SET @InsertedID = SCOPE_IDENTITY()
GO
--ENDOF: InsertAppointment-------------------------------------------------------------------------

CREATE PROC RemoveAppointment
	@IDAppointment INT
AS
	DELETE FROM Appointment WHERE ID = @IDAppointment
GO
--ENDOF: RemoveAppointment-------------------------------------------------------------------------

CREATE PROC GetAppointments
	@IDPatient INT
AS
	SELECT
		a.Delegate, --who set up the appointment
		a.DateAppointed,
		a.Details,
		bd.Name --doctor's name
	FROM Appointment AS a
	INNER JOIN Doctor AS d ON d.ID = a.DoctorID
	INNER JOIN BasicDetails AS bd ON bd.ID = d.BasicDetailsID
	WHERE a.PatientID = @IDPatient
GO
--ENDOF: GetAppointments---------------------------------------------------------------------------

-------------------
-- Patient.Tests --
-------------------

CREATE PROC InsertTest
	@PatientID INT,
	@DoctorID INT,
	@Name NVARCHAR(100),
	@Details NVARCHAR(1000),
	@TestDateTime DATETIME,
	@InsertedID INT OUTPUT
AS
	INSERT INTO Test(PatientID, DoctorID, Name, Details, TestDateTime)
	VALUES(@PatientID, @DoctorID, @Name, @Details, @TestDateTime)

	SET @InsertedID = SCOPE_IDENTITY()
GO
--ENDOF: InsertTest--------------------------------------------------------------------------------

CREATE PROC RemoveTest
	@IDTest INT
AS
	DELETE FROM Test WHERE ID = @IDTest
GO
--ENDOF: RemoveTest--------------------------------------------------------------------------------

CREATE PROC GetTests
	@IDPatient INT
AS
	SELECT
		t.Name,
		bd.Name, --doctor's name
		t.TestDateTime,
		t.Details
	FROM Test AS t
	INNER JOIN Doctor AS d ON d.ID = t.DoctorID
	INNER JOIN BasicDetails AS bd ON bd.ID = d.BasicDetailsID
	WHERE t.PatientID = @IDPatient
GO
--ENDOF: GetTests----------------------------------------------------------------------------------

----------------------
-- Patient.Medicine --
----------------------

CREATE PROC InsertPatientMedicine
	@Quantity INT,
	@MedicineID INT,
	@PatientID INT,
	@DoctorID INT,
	@InsertedID INT OUTPUT
AS
	INSERT INTO PatientMedicine(Quantity, MedicineID, PatientID, DoctorID)
	VALUES(@Quantity, @MedicineID, @PatientID, @DoctorID)

	SET @InsertedID = SCOPE_IDENTITY()
GO
--ENDOF: InsertPatientMedicine---------------------------------------------------------------------

CREATE PROC RemovePatientMedicine
	@IDPatientMedicine INT
AS
	DELETE FROM PatientMedicine WHERE ID = @IDPatientMedicine
GO
--ENDOF: RemovePatientMedicine---------------------------------------------------------------------

CREATE PROC GetPatientMedicine
	@IDPatient INT
AS
	SELECT
		m.Name,
		pm.Quantity,
		pm.DateIssued,
		bd.Name --doctor's name
	FROM PatientMedicine AS pm
	INNER JOIN Medicine AS m ON m.ID = pm.MedicineID
	INNER JOIN Doctor AS d ON d.ID = pm.DoctorID
	INNER JOIN BasicDetails AS bd ON bd.ID = d.BasicDetailsID
	WHERE pm.PatientID = @IDPatient
GO
--ENDOF: GetPatientMedicine------------------------------------------------------------------------

------------
-- Doctor --
------------

CREATE PROC InsertDoctor
	@OIB CHAR(11),
	@Name NVARCHAR(100),
	@SexID INT,
	@DateOfBirth DATETIME,
	@InsertedID INT OUTPUT
AS
	DECLARE @BasicDetailsID INT

	INSERT INTO BasicDetails(OIB, Name, SexID, DateOfBirth)
	VALUES(@OIB, @Name, @SexID, @DateOfBirth)

	SET @BasicDetailsID = SCOPE_IDENTITY()

	INSERT INTO Doctor(BasicDetailsID)
	VALUES(@BasicDetailsID)

	SET @InsertedID = SCOPE_IDENTITY()
GO
--ENDOF: InsertDoctor------------------------------------------------------------------------------

CREATE PROC RemoveDoctor
	@IDDoctor INT
AS
	DELETE FROM BasicDetails WHERE ID IN
	( SELECT BasicDetailsID FROM Doctor WHERE ID = @IDDoctor )

	DELETE FROM Doctor WHERE ID = @IDDoctor
GO
--ENDOF: RemoveDoctor------------------------------------------------------------------------------

CREATE PROC GetDoctors
AS
	SELECT * FROM Doctor AS d
	INNER JOIN BasicDetails AS bd ON bd.ID = d.BasicDetailsID
GO
--ENDOF: GetDoctors--------------------------------------------------------------------------------