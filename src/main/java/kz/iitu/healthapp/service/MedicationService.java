package kz.iitu.healthapp.service;

import kz.iitu.healthapp.entity.Medication;

import java.util.List;

public interface MedicationService {
    Medication getById(Long id);
    List<Medication> getAllMedications();
    Medication createMedication(Medication medication);
    Medication updateMedication(Long id, Medication medication);
    void deleteMedication(Long id);
}
