package kz.iitu.healthapp.service;

import kz.iitu.healthapp.model.CreatePrescriptionRequest;
import kz.iitu.healthapp.model.UpdatePrescriptionRequest;

import java.util.List;

public interface PrescriptionService {
    void createPrescription(List<CreatePrescriptionRequest> request, Long recordId);

    void updatePrescription(Long prescriptionId, UpdatePrescriptionRequest request);
}
