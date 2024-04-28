-- Create _user table
CREATE TABLE IF NOT EXISTS _user (
                       id BIGSERIAL PRIMARY KEY,
                       created_at TIMESTAMP(6),
                       email VARCHAR(255),
                       password VARCHAR(255),
                       role VARCHAR(255) CHECK (role IN ('DOCTOR', 'PATIENT', 'ADMIN')),
                       updated_at TIMESTAMP(6),
                       username VARCHAR(255)
);

-- Create doctor table
CREATE TABLE IF NOT EXISTS doctor (
                        id BIGSERIAL PRIMARY KEY,
                        created_at TIMESTAMP(6),
                        first_name VARCHAR(255),
                        last_name VARCHAR(255),
                        middle_name VARCHAR(255),
                        specialization VARCHAR(255),
                        updated_at TIMESTAMP(6),
                        user_id BIGINT,
                        CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES _user(id)
);

-- Create medication table
CREATE TABLE IF NOT EXISTS medication (
                            id BIGSERIAL PRIMARY KEY,
                            created_at TIMESTAMP(6),
                            description TEXT,
                            updated_at TIMESTAMP(6),
                            name VARCHAR(100) NOT NULL
);

-- Create patient table
CREATE TABLE IF NOT EXISTS patient (
                         id BIGSERIAL PRIMARY KEY,
                         age INTEGER,
                         created_at TIMESTAMP(6),
                         first_name VARCHAR(255),
                         gender VARCHAR(255),
                         last_name VARCHAR(255),
                         middle_name VARCHAR(255),
                         updated_at TIMESTAMP(6),
                         user_id BIGINT,
                         CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES _user(id)
);

-- Create appointment table
CREATE TABLE IF NOT EXISTS appointment (
                             id BIGSERIAL PRIMARY KEY,
                             appointment_date TIMESTAMP(6),
                             created_at TIMESTAMP(6),
                             purpose TEXT,
                             status VARCHAR(20),
                             updated_at TIMESTAMP(6),
                             doctor_id BIGINT,
                             patient_id BIGINT,
                             CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(id),
                             CONSTRAINT fk_patient_id FOREIGN KEY (patient_id) REFERENCES patient(id)
);

-- Create medical_record table
CREATE TABLE IF NOT EXISTS medical_record (
                                record_id SERIAL PRIMARY KEY,
                                created_at TIMESTAMP(6),
                                diagnosis TEXT,
                                prescription TEXT,
                                record_date TIMESTAMP(6),
                                updated_at TIMESTAMP(6),
                                doctor_id BIGINT,
                                patient_id BIGINT,
                                CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(id),
                                CONSTRAINT fk_patient_id FOREIGN KEY (patient_id) REFERENCES patient(id)
);

-- Create prescription table
CREATE TABLE IF NOT EXISTS prescription (
                              prescription_id SERIAL PRIMARY KEY,
                              created_at TIMESTAMP(6),
                              dosage VARCHAR(50),
                              end_date TIMESTAMP(6),
                              frequency VARCHAR(50),
                              start_date TIMESTAMP(6),
                              updated_at TIMESTAMP(6),
                              record_id INTEGER,
                              medication_id BIGINT,
                              CONSTRAINT fk_record_id FOREIGN KEY (record_id) REFERENCES medical_record(record_id),
                              CONSTRAINT fk_medication_id FOREIGN KEY (medication_id) REFERENCES medication(id)
);