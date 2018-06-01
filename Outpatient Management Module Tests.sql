USE OutpatientManagementModule
GO

DECLARE @insertedID INT, @patientID INT, @doctorID INT, @insertedDate DATETIME, @insertedString NVARCHAR(500)
EXEC InsertPatientWithBasicDetails 'Zvonimir', 2, '19670419', 'Complaining', '3841312', '3841513', 'Luka', @patientID OUTPUT, @insertedDate OUTPUT, @insertedString OUTPUT
EXEC InsertDoctor '12345678909', 'Slavko', 1, '19620613', @doctorID OUTPUT

EXEC InsertBill 1, @patientID, 123, @insertedID OUTPUT, @insertedDate OUTPUT
EXEC GetBills @patientID

EXEC RemoveBill @insertedID
EXEC GetBills @patientID

EXEC InsertTest @patientID, @doctorID, 'Vaginal exam', 'Seems like there isn'' anything there...', '20171212', @insertedID OUTPUT
EXEC GetTests @patientID

EXEC RemoveTest @insertedID
EXEC GetTests @patientID

EXEC InsertAppointment @doctorID, @patientID, 'Doctor', '20170307', 'Exam', @insertedID OUTPUT
EXEC GetAppointments @patientID

DECLARE @now DATETIME = GETDATE()
EXEC UpdateAppointment @insertedID, 'Dr. House', @now, 'Stuff'
EXEC GetAppointments @patientID

EXEC GetPatientsForDoctor @doctorID

EXEC RemoveAppointment @insertedID
EXEC GetAppointments @patientID

EXEC InsertPatientMedicine 3, 2, @patientID, @doctorID, @insertedID OUTPUT, @insertedDate OUTPUT
EXEC GetPatientMedicine @patientID

EXEC RemovePatientMedicine @insertedID
EXEC GetPatientMedicine @patientID

EXEC InsertPatientWithFullDetails '00000000001', 'Marko', 1, '19971212', 'Ulica Hasana Kikiæa 14', 'Ilica 212', '3841123', '3841543', '0911231231', '123', '3841555', 'marko@mail.hr', 'Stjepan', 'Srednjaci 10', '3841842', '3841294', '0916543213', '543', '3841999', 'stipe@gmail.com', 1, 3, 187.4, 84, '0+', 'Stuff', 23402, 0, 0, 0, 0, 'None', 3, 0, 0, 0, 1, 'Many pain', 'All over the country', 'Bolnica', 0, 0, 'Shit', 'Good', 'OK', 'OK', 'Masa je mama', 'Killer', 'None', 'Alergic to coconut', 'Tonsils taken out', @insertedID OUTPUT, @insertedDate OUTPUT, @insertedString OUTPUT
EXEC InsertPatientWithBasicDetails 'Marko', 2, '19970419', 'Complaining', '3841312', '3841513', 'Luka', @insertedID OUTPUT, @insertedDate OUTPUT, @insertedString OUTPUT

--Zvonimir, Marko, Marko (2.)

EXEC RemovePatient @insertedID

--Zvonimir, Marko
EXEC GetPatients

DECLARE @ID INT = (SELECT MIN(ID) FROM Patient)
EXEC RemovePatient @ID
EXEC InsertPatientWithBasicDetails 'Vedran', 2, '19970419', 'Complaining', '3841312', '3841513', 'Miroslav', @insertedID OUTPUT, @insertedDate OUTPUT, @insertedString OUTPUT

--Marko, Vedran
EXEC GetPatients

EXEC RemovePatient @insertedID

--Marko
EXEC GetPatients
SET @ID = (SELECT MIN(ID) FROM Patient)
EXEC RemovePatient @ID
EXEC GetPatients

EXEC GetDoctors
EXEC RemoveDoctor @doctorID
EXEC GetDoctors