package kz.iitu.healthapp.service;

import kz.iitu.healthapp.model.CreateMedicalRecordRequest;
import kz.iitu.healthapp.model.UpdateMedicalRecordRequest;

public interface MedicalRecordService {

    void createMedicalRecord(CreateMedicalRecordRequest request);

    void updateMedicalRecord(Long recordId, UpdateMedicalRecordRequest request);
}
