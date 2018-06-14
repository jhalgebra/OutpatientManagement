USE OutpatientManagementModule
GO

DECLARE @insertedInt INT, @insertedDate DATETIME, @insertedString NVARCHAR(500)

-------------
-- Doctors --
-------------

EXEC InsertDoctor '12312312312', 'Slaven', 1, '19630701', @insertedInt
EXEC InsertDoctor '75389343923', 'Branimir', 1, '19720212', @insertedInt
EXEC InsertDoctor '53428759238', 'Jerko', 1, '19830923', @insertedInt
EXEC InsertDoctor '38473827589', 'Mirjana', 2, '19661225', @insertedInt
EXEC InsertDoctor '91249172472', 'Krunoslava', 2, '19861103', @insertedInt
EXEC InsertDoctor '41387482748', 'Sara', 2, '19820412', @insertedInt

--------------
-- Patients --
--------------

EXEC InsertPatientWithFullDetails '24975492304', 'Mirko', 1, '19740312', 'Ilica 212', 'Ilica 212', '3841123', '3841987', '0912138423', '123', '3841555', 'mirko@mail.hr', 'Slavko', 'Braæe Domany 6', '3841915', '3840213', '0981239423', '543', '3840111', 'slavko@hotmail.com', 1, 3, 183.2, 70, 'A+', 'Useless', 23142, 0, 0, 1, 1, 'Marijuana', 3, 0, 0, 1, 2, 'Complaining about this ''n that', 'No history :)', 'Iza ugla', 0, 1, 'Nice', 'Nice', 'OK', 'OK', 'OK', 'Bad', 'None', 'Alergic to coconut oil', 'Tonsils removed', @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientWithFullDetails '51292492304', 'Ante', 1, '19610312', 'Ilica 212', 'Ilica 212', '3841123', '3841987', '0912138423', '123', '3841555', 'mirko@mail.hr', 'Slavko', 'Braæe Domany 6', '3841915', '3840213', '0981239423', '543', '3840111', 'slavko@hotmail.com', 1, 3, 183.2, 70, 'A+', 'Useless', 23142, 0, 0, 1, 1, 'Marijuana', 3, 0, 0, 1, 2, 'Complaining about this ''n that', 'No history :)', 'Iza ugla', 0, 1, 'Nice', 'Nice', 'OK', 'OK', 'OK', 'Bad', 'None', 'Alergic to coconut oil', 'Tonsils removed', @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientWithFullDetails '27893492304', 'Stjepan', 1, '19870312', 'Ilica 212', 'Ilica 212', '3841123', '3841987', '0912138423', '123', '3841555', 'mirko@mail.hr', 'Slavko', 'Braæe Domany 6', '3841915', '3840213', '0981239423', '543', '3840111', 'slavko@hotmail.com', 1, 3, 183.2, 70, 'A+', 'Useless', 23142, 0, 0, 1, 1, 'Marijuana', 3, 0, 0, 1, 2, 'Complaining about this ''n that', 'No history :)', 'Iza ugla', 0, 1, 'Nice', 'Nice', 'OK', 'OK', 'OK', 'Bad', 'None', 'Alergic to coconut oil', 'Tonsils removed', @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientWithFullDetails '99975492304', 'Mirjana', 2, '19950312', 'Ilica 212', 'Ilica 212', '3841123', '3841987', '0912138423', '123', '3841555', 'mirko@mail.hr', 'Slavko', 'Braæe Domany 6', '3841915', '3840213', '0981239423', '543', '3840111', 'slavko@hotmail.com', 1, 3, 183.2, 70, 'A+', 'Useless', 23142, 0, 0, 1, 1, 'Marijuana', 3, 0, 0, 1, 2, 'Complaining about this ''n that', 'No history :)', 'Iza ugla', 0, 1, 'Nice', 'Nice', 'OK', 'OK', 'OK', 'Bad', 'None', 'Alergic to coconut oil', 'Tonsils removed', @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientWithFullDetails '13275492304', 'Vatroslav', 1, '19850312', 'Ilica 212', 'Ilica 212', '3841123', '3841987', '0912138423', '123', '3841555', 'mirko@mail.hr', 'Slavko', 'Braæe Domany 6', '3841915', '3840213', '0981239423', '543', '3840111', 'slavko@hotmail.com', 1, 3, 183.2, 70, 'A+', 'Useless', 23142, 0, 0, 1, 1, 'Marijuana', 3, 0, 0, 1, 2, 'Complaining about this ''n that', 'No history :)', 'Iza ugla', 0, 1, 'Nice', 'Nice', 'OK', 'OK', 'OK', 'Bad', 'None', 'Alergic to coconut oil', 'Tonsils removed', @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientWithFullDetails '65475492304', 'Anita', 2, '19780312', 'Ilica 212', 'Ilica 212', '3841123', '3841987', '0912138423', '123', '3841555', 'mirko@mail.hr', 'Slavko', 'Braæe Domany 6', '3841915', '3840213', '0981239423', '543', '3840111', 'slavko@hotmail.com', 1, 3, 183.2, 70, 'A+', 'Useless', 23142, 0, 0, 1, 1, 'Marijuana', 3, 0, 0, 1, 2, 'Complaining about this ''n that', 'No history :)', 'Iza ugla', 0, 1, 'Nice', 'Nice', 'OK', 'OK', 'OK', 'Bad', 'None', 'Alergic to coconut oil', 'Tonsils removed', @insertedInt OUTPUT, @insertedDate OUTPUT

EXEC InsertPatientWithBasicDetails 'Ana', 2, '19971212', 'Complaining', '3841293', '3840212', 'Leon', @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientWithBasicDetails 'Marta', 2, '19970925', 'Complaining', '3841293', '3840212', 'Leon', @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientWithBasicDetails 'Ivan', 1, '19970103', 'Complaining', '3841293', '3840212', 'Leon', @insertedInt OUTPUT, @insertedDate OUTPUT
	
IF(DB_ID('#Temp') IS NULL)
	DROP TABLE #Temp

SELECT * INTO #Temp FROM Patient

DECLARE @ID INT, @Counter INT = 0

WHILE EXISTS (SELECT * FROM #Temp)
BEGIN
	SELECT TOP 1 @ID = ID FROM #Temp
	
	UPDATE Patient SET
		RegistrationDate = DATEADD(DAY, @Counter, RegistrationDate)
	WHERE ID = @ID

	SET @Counter = @Counter - 1

	DELETE #Temp WHERE ID = @ID
END

-----------
-- Bills --
-----------

EXEC InsertBill 2, 6, 238, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 1, 5, 412, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 2, 1, 783, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 1, 2, 322, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 1, 4, 116, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 2, 5, 564, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 1, 6, 412, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 1, 3, 116, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 2, 2, 783, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 2, 4, 564, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertBill 1, 5, 815, @insertedInt OUTPUT, @insertedDate OUTPUT

------------------
-- Appointments --
------------------

DECLARE @i INT = 0
DECLARE @patientID INT, @doctorID INT, @dateAdd INT, @date DATETIME, @secondOpinion BIT

WHILE(@i < 100)
BEGIN
	EXEC RNG 1, 6, @patientID OUTPUT
	EXEC RNG 1, 6, @doctorID OUTPUT
	EXEC RNG -10, 10, @dateAdd OUTPUT
	SET @date = DATEADD(DAY, @dateAdd, GETDATE())

	IF(@i % 3 = 0)
		SET @secondOpinion = 1
	ELSE
		SET @secondOpinion = 0

	EXEC InsertAppointment @doctorID, @patientID, 'Doctor', @date, 'Exam', @secondOpinion, @insertedInt OUTPUT

	SET @i = @i + 1
END

-----------
-- Tests --
-----------

EXEC InsertTest 1, 3, 'Lung Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT
EXEC InsertTest 6, 2, 'Vaginal Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT
EXEC InsertTest 4, 4, 'Kidney Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT
EXEC InsertTest 2, 5, 'Heart Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT
EXEC InsertTest 3, 1, 'Lung Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT
EXEC InsertTest 4, 6, 'Leg Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT
EXEC InsertTest 1, 4, 'Lung Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT
EXEC InsertTest 2, 3, 'Kidney Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT
EXEC InsertTest 3, 2, 'Lung Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT
EXEC InsertTest 5, 1, 'Full Body Exam', 'Very tough and complicated procedure', '20181011', @insertedInt OUTPUT

---------------------
-- PatientMedicine --
---------------------

EXEC InsertPatientMedicine 3, 1, 1, 3, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientMedicine 5, 4, 3, 2, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientMedicine 2, 5, 4, 4, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientMedicine 5, 6, 2, 2, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientMedicine 3, 1, 6, 1, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientMedicine 1, 3, 5, 5, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientMedicine 5, 7, 2, 2, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientMedicine 3, 2, 1, 3, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientMedicine 1, 3, 3, 6, @insertedInt OUTPUT, @insertedDate OUTPUT
EXEC InsertPatientMedicine 3, 4, 5, 1, @insertedInt OUTPUT, @insertedDate OUTPUT