package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.entity.MedicalRecord;
import kz.iitu.healthapp.entity.Medication;
import kz.iitu.healthapp.entity.Prescription;
import kz.iitu.healthapp.model.CreatePrescriptionRequest;
import kz.iitu.healthapp.model.UpdatePrescriptionRequest;
import kz.iitu.healthapp.repository.MedicationRepository;
import kz.iitu.healthapp.repository.PrescriptionRepository;
import kz.iitu.healthapp.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final MedicalRecordServiceImpl medicalRecordService;
    private final MedicationRepository medicationRepository;
    @Override
    public void createPrescription(List<CreatePrescriptionRequest> requests, Long recordId) {
        MedicalRecord medicalRecord = medicalRecordService.getById(recordId);
        requests.forEach(request -> {
            Medication medication = medicationRepository.findById(request.getMedicationId())
                    .orElse(new Medication());
            Prescription prescription = buildPrescriptionFromRequest(request, medicalRecord, medication);
            prescriptionRepository.save(prescription);
        });
    }

    @Override
    public void updatePrescription(Long prescriptionId, UpdatePrescriptionRequest request) {
        Optional<Prescription> optionalPrescription = prescriptionRepository.findById(prescriptionId);
        optionalPrescription.ifPresentOrElse(prescription -> {
            prescription.setDosage(request.getDosage());
            prescription.setFrequency(request.getFrequency());
            prescription.setStartDate(request.getStartDate());
            prescription.setEndDate(request.getEndDate());
            prescription.setUpdatedAt(LocalDateTime.now());
            prescriptionRepository.save(prescription);
        },
                () -> {
                    throw new NoSuchElementException("Prescription with ID " + prescriptionId + " not found");
                }
        );
    }

    private Prescription buildPrescriptionFromRequest(CreatePrescriptionRequest request, MedicalRecord medicalRecord, Medication medication) {
        return Prescription.builder()
                .medicalRecord(medicalRecord)
                .medication(medication)
                .dosage(request.getDosage())
                .frequency(request.getFrequency())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
