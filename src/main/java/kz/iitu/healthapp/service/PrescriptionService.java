package kz.iitu.healthapp.service;

import kz.iitu.healthapp.model.CreatePrescriptionRequest;
import kz.iitu.healthapp.model.UpdatePrescriptionRequest;

public interface PrescriptionService {
    void createPrescription(CreatePrescriptionRequest request);

    void updatePrescription(Long prescriptionId, UpdatePrescriptionRequest request);
}
