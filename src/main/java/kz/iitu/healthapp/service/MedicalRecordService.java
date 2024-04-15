package kz.iitu.healthapp.service;

import kz.iitu.healthapp.entity.MedicalRecord;
import kz.iitu.healthapp.model.CreateMedicalRecordRequest;
import kz.iitu.healthapp.model.UpdateMedicalRecordRequest;

import java.util.List;

public interface MedicalRecordService {

    void createMedicalRecord(Long patientId, Long doctorId, CreateMedicalRecordRequest request);

    void updateMedicalRecord(Long recordId, UpdateMedicalRecordRequest request);
    List<MedicalRecord> getAllByDoctor(Long doctorId);

    List<MedicalRecord> getAllByPatient(Long patientId);
}
