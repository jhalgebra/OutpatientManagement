USE OutpatientManagementModule
GO

DELETE FROM Doctor
DBCC CHECKIDENT('Doctor', RESEED, 0)

DELETE FROM Patient
DBCC CHECKIDENT('Patient', RESEED, 0)

DELETE FROM Bill
DBCC CHECKIDENT('Bill', RESEED, 0)

DELETE FROM Appointment
DBCC CHECKIDENT('Appointment', RESEED, 0)

DELETE FROM Test
DBCC CHECKIDENT('Test', RESEED, 0)

DELETE FROM PatientMedicine
DBCC CHECKIDENT('PatientMedicine', RESEED, 0)

DELETE FROM BasicDetails
DBCC CHECKIDENT('BasicDetails', RESEED, 0)

DELETE FROM ContactDetails
DBCC CHECKIDENT('ContactDetails', RESEED, 0)

DELETE FROM ContactOfNextOfKin
DBCC CHECKIDENT('ContactOfNextOfKin', RESEED, 0)

DELETE FROM Contact
DBCC CHECKIDENT('Contact', RESEED, 0)

DELETE FROM PersonalDetails
DBCC CHECKIDENT('PersonalDetails', RESEED, 0)

DELETE FROM ProfessionDetails
DBCC CHECKIDENT('ProfessionDetails', RESEED, 0)

DELETE FROM Lifestyle
DBCC CHECKIDENT('Lifestyle', RESEED, 0)

DELETE FROM BasicComplaints
DBCC CHECKIDENT('BasicComplaints', RESEED, 0)

DELETE FROM MedicalComplaints
DBCC CHECKIDENT('MedicalComplaints', RESEED, 0)