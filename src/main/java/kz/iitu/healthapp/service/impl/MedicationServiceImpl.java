package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.entity.Medication;
import kz.iitu.healthapp.repository.MedicationRepository;
import kz.iitu.healthapp.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;

    @Override
    public Medication getById(Long id) {
        return medicationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Medication not found with ID: " + id));
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication createMedication(Medication medication) {
        medication.setCreatedAt(LocalDateTime.now());
        medication.setUpdatedAt(LocalDateTime.now());
        return medicationRepository.save(medication);
    }

    @Override
    public Medication updateMedication(Long id, Medication updatedMedication) {
        Medication medication = getById(id);
        medication.setName(updatedMedication.getName());
        medication.setDescription(updatedMedication.getDescription());
        medication.setUpdatedAt(LocalDateTime.now());
        return medicationRepository.save(medication);
    }

    @Override
    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }
}
