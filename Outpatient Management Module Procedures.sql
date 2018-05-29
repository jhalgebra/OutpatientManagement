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
	VALUES             (1,                @BasicDetailsID, @BasicComplaintsID, @ContactDetailsID, @ContactOfNextOfKinID)

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

	SET @ContactOfNextOfKinID = SCOPE_IDENTITY()

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

	DECLARE @BasicDetailsID INT, @ContactDetailsID INT, @ContactOfNextOfKinID INT, @PersonalDetailsID INT,
			@ProfessionDetailsID INT, @LifestyleID INT, @BasicComplaintsID INT, @MedicalComplaintsID INT

	DECLARE @PatientContactID INT, @NextOfKinContactID INT

	SELECT
		@BasicDetailsID = BasicDetailsID,
		@ContactDetailsID = ContactDetailsID,
		@ContactOfNextOfKinID = ContactOfNextOfKinID,
		@PersonalDetailsID = PersonalDetailsID,
		@ProfessionDetailsID = ProfessionDetailsID,
		@LifestyleID = LifestyleID,
		@BasicComplaintsID = BasicComplaintsID,
		@MedicalComplaintsID = MedicalComplaintsID
	FROM Patient
	WHERE ID = @IDPatient

	SELECT @PatientContactID = ContactID FROM ContactDetails WHERE ID = @ContactDetailsID
	SELECT @NextOfKinContactID = ContactID FROM ContactOfNextOfKin WHERE ID = @ContactOfNextOfKinID

	DELETE FROM Patient WHERE ID = @IDPatient

	DELETE FROM BasicDetails WHERE ID = @BasicDetailsID

	DELETE FROM ContactDetails WHERE ID = @ContactDetailsID

	DELETE FROM ContactOfNextOfKin WHERE ID = @ContactOfNextOfKinID

	DELETE FROM PersonalDetails WHERE ID = @PersonalDetailsID

	DELETE FROM ProfessionDetails WHERE ID = @ProfessionDetailsID

	DELETE FROM Lifestyle WHERE ID = @LifestyleID

	DELETE FROM BasicComplaints WHERE ID = @BasicComplaintsID

	DELETE FROM MedicalComplaints WHERE ID = @MedicalComplaintsID

	DELETE FROM Contact WHERE ID IN (@PatientContactID, @NextOfKinContactID)
GO
--ENDOF: RemovePatient-----------------------------------------------------------------------------

CREATE PROC GetPatients
AS
	SELECT
		p.ID,
		p.BasicRegistration, --was the registration full or basic
		--Basic Details (bd)
		bd.Name,
		bd.OIB,
		s.Name AS 'Sex', --Sex
		bd.DateOfBirth,
		--Contact Details (cd)
		cd.PresentAddress,
		cd.PermanentAddress,
		cPatient.TelephoneHome AS 'Patient''s home telephone',
		cPatient.TelephoneWork AS 'Patient''s work telephone',
		cPatient.Mobile AS 'Patient''s mobile',
		cPatient.Pager AS 'Patient''s pager',
		cPatient.Fax AS 'Patient''s fax',
		cPatient.Email AS 'Patient''s email',
		--Contact of Next of Kin (cnk)
		cnk.Name AS 'Name of Next of Kin',
		cnk.ContactAddress,
		cNextOfKin.TelephoneHome,
		cNextOfKin.TelephoneWork,
		cNextOfKin.Mobile,
		cNextOfKin.Pager,
		cNextOfKin.Fax,
		cNextOfKin.Email,
		--Personal Details (pd)
		pd.MaritalStatus AS 'Married',
		pd.NumberOfDependents,
		pd.Height,
		pd.Weight,
		pd.BloodTypeRH,
		--Lifestyle (l)
		l.Vegetarian,
		l.Smoker,
		l.ConsumesAlcoholicBeverage,
		l.UsesStimulants,
		l.StimulantsUsed,
		l.CoffeeConsumptionPerDay,
		l.TeaConsumptionPerDay,
		l.SoftDrinkConsumptionPerDay,
		l.RegularMeals,
		peo.Name, --predominant eating option name
		--Basic Complaints (bc)
		bc.StatementOfComplaint,
		bc.HistoryOfPreviousTreatment,
		bc.PhysicianOrHospitalTreated,
		--Medical Complaints (mc)
		mc.Diabetic,
		mc.Hypertensive,
		mc.CardiacCondition,
		mc.RespiratoryCondition,
		mc.DigestiveCondition,
		mc.OrthopedicCondition,
		mc.MuscularCondition,
		mc.NeurologicalCondition,
		mc.KnownAllergies,
		mc.KnownAdverseReactionToSpecificDrugs,
		mc.MajorSurgeries
	FROM Patient AS p
	LEFT JOIN BasicDetails AS bd ON bd.ID = p.BasicDetailsID
	FULL OUTER JOIN ContactDetails AS cd ON cd.ID = p.ContactDetailsID
	FULL OUTER JOIN ContactOfNextOfKin AS cnk ON cnk.ID = p.ContactOfNextOfKinID
	FULL OUTER JOIN PersonalDetails AS pd ON pd.ID = p.PersonalDetailsID
	FULL OUTER JOIN ProfessionDetails AS profD ON profD.ID = p.ProfessionDetailsID
	FULL OUTER JOIN Lifestyle AS l ON l.ID = p.LifestyleID
	FULL OUTER JOIN BasicComplaints AS bc ON bc.ID = p.BasicComplaintsID
	FULL OUTER JOIN MedicalComplaints AS mc ON mc.ID = p.MedicalComplaintsID
	LEFT JOIN Contact AS cPatient ON cPatient.ID = cd.ContactID
	LEFT JOIN Contact AS cNextOfKin ON cNextOfKin.ID = cnk.ContactID
	LEFT JOIN Sex AS s ON s.ID = bd.SexID
	LEFT JOIN PredominantEatingOption AS peo ON peo.ID = l.PredominantEatingOptionID
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
		b.ID,
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
		a.ID,
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
		t.ID,
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
		pm.ID,
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
	DECLARE @BasicDetailsID INT = (SELECT BasicDetailsID FROM Doctor WHERE ID = @IDDoctor)

	DELETE FROM Doctor WHERE ID = @IDDoctor

	DELETE FROM BasicDetails WHERE ID = @BasicDetailsID
GO
--ENDOF: RemoveDoctor------------------------------------------------------------------------------

CREATE PROC GetDoctors
AS
	SELECT
		d.ID,
		bd.Name,
		bd.OIB,
		bd.DateOfBirth,
		s.Name AS 'Sex'
	FROM Doctor AS d
	INNER JOIN BasicDetails AS bd ON bd.ID = d.BasicDetailsID
	INNER JOIN Sex AS s ON s.ID = bd.SexID
GO
--ENDOF: GetDoctors--------------------------------------------------------------------------------