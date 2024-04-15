package kz.iitu.healthapp.repository;

import kz.iitu.healthapp.entity.Doctor;
import kz.iitu.healthapp.entity.MedicalRecord;
import kz.iitu.healthapp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
    List<MedicalRecord> findAllByDoctor(Doctor doctor);
    List<MedicalRecord> findAllByPatient(Patient patient);
}
