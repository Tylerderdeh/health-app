package kz.iitu.healthapp.repository;

import kz.iitu.healthapp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
