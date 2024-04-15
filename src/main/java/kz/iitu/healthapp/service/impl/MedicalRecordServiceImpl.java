package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.entity.Doctor;
import kz.iitu.healthapp.entity.MedicalRecord;
import kz.iitu.healthapp.entity.Patient;
import kz.iitu.healthapp.model.CreateMedicalRecordRequest;
import kz.iitu.healthapp.model.UpdateMedicalRecordRequest;
import kz.iitu.healthapp.repository.MedicalRecordRepository;
import kz.iitu.healthapp.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final DoctorServiceImpl doctorService;
    private final PatientServiceImpl patientService;

    @Override
    public void createMedicalRecord(Long patientId, Long doctorId,CreateMedicalRecordRequest request) {
        Patient patient = patientService.getById(patientId);
        Doctor doctor = doctorService.getById(doctorId);
        MedicalRecord medicalRecord = MedicalRecord.builder()
                .createdAt(LocalDateTime.now())
                .diagnosis(request.getDiagnosis())
                .prescription(request.getPrescription())
                .recordDate(request.getRecordDate())
                .patient(patient)
                .doctor(doctor)
                .updatedAt(LocalDateTime.now())
                .build();
        medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public void updateMedicalRecord(Long recordId, UpdateMedicalRecordRequest request) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId)
                .orElse(new MedicalRecord());
        medicalRecord.setUpdatedAt(LocalDateTime.now());
        medicalRecord.setDiagnosis(request.getDiagnosis());
        medicalRecord.setPrescription(request.getPrescription());
        medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public MedicalRecord getById(Long recordId) {
        return medicalRecordRepository.findById(recordId).orElse(new MedicalRecord());
    }

    @Override
    public List<MedicalRecord> getAllByDoctor(Long doctorId) {
        Doctor doctor = doctorService.getById(doctorId);
        return medicalRecordRepository.findAllByDoctor(doctor);
    }

    @Override
    public List<MedicalRecord> getAllByPatient(Long patientId) {
        Patient patient = patientService.getById(patientId);
        return medicalRecordRepository.findAllByPatient(patient);
    }
}
