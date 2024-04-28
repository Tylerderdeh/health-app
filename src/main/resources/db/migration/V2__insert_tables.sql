-- Insert data into _user table
-- password: password1
INSERT INTO _user (created_at, email, password, role, updated_at, username)
VALUES
    ('2024-04-28 00:00:00', '29224@iitu.edu.kz', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyOTIyNEBpaXR1LmVkdS5reiIsImlhdCI6MTcxNDMxMjczMiwiZXhwIjoxNzE0MzE0MTcyfQ.hDIrzcjqLFs7pDe0dGO7X6AuRP_3iWFTQxt1P_Dpj_g', 'DOCTOR', '2024-04-28 00:00:00', 'user1'),
    ('2024-04-28 00:00:00', 'zhanibek@gmail.com', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyOTIyNEBpaXR1LmVkdS5reiIsImlhdCI6MTcxNDMxMjczMiwiZXhwIjoxNzE0MzE0MTcyfQ.hDIrzcjqLFs7pDe0dGO7X6AuRP_3iWFTQxt1P_Dpj_g', 'PATIENT', '2024-04-28 00:00:00', 'user2');

-- Insert data into doctor table
INSERT INTO doctor (created_at, first_name, last_name, middle_name, specialization, updated_at, user_id)
VALUES
    ('2024-04-28 00:00:00', 'John', 'Doe', 'Smith', 'Cardiology', '2024-04-28 00:00:00', 1);

-- Insert data into medication table
INSERT INTO medication (created_at, description, updated_at, name)
VALUES
    ('2024-04-28 00:00:00', 'Description 1', '2024-04-28 00:00:00', 'Medication 1'),
    ('2024-04-28 00:00:00', 'Description 2', '2024-04-28 00:00:00', 'Medication 2');

-- Insert data into patient table
INSERT INTO patient (age, created_at, first_name, gender, last_name, middle_name, updated_at, user_id)
VALUES
    (30, '2024-04-28 00:00:00', 'Alice', 'Female', 'Johnson', 'Marie', '2024-04-28 00:00:00', 2);

-- Insert data into appointment table
INSERT INTO appointment (appointment_date, created_at, purpose, status, updated_at, doctor_id, patient_id)
VALUES
    ('2024-04-29 10:00:00', '2024-04-28 00:00:00', 'Regular checkup', 'Confirmed', '2024-04-28 00:00:00', 1, 1);

-- Insert data into medical_record table
INSERT INTO medical_record (created_at, diagnosis, prescription, record_date, updated_at, doctor_id, patient_id)
VALUES
    ('2024-04-28 00:00:00', 'Diagnosis 1', 'Prescription 1', '2024-04-28 00:00:00', '2024-04-28 00:00:00', 1, 1);

-- Insert data into prescription table
INSERT INTO prescription (created_at, dosage, end_date, frequency, start_date, updated_at, record_id, medication_id)
VALUES
    ('2024-04-28 00:00:00', 'Dosage 1', '2024-05-01 00:00:00', 'Once daily', '2024-04-28 00:00:00', '2024-04-28 00:00:00', 1, 1),
    ('2024-04-28 00:00:00', 'Dosage 2', '2024-05-01 00:00:00', 'Two times daily', '2024-04-28 00:00:00', '2024-04-28 00:00:00', 1, 2);
