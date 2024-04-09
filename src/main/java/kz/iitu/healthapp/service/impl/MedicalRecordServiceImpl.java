package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.model.CreateMedicalRecordRequest;
import kz.iitu.healthapp.model.UpdateMedicalRecordRequest;
import kz.iitu.healthapp.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Override
    public void createMedicalRecord(CreateMedicalRecordRequest request) {

    }

    @Override
    public void updateMedicalRecord(Long recordId, UpdateMedicalRecordRequest request) {

    }
}
