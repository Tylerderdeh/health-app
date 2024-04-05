package kz.iitu.healthapp.repository;

import kz.iitu.healthapp.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication,Long> {
}
