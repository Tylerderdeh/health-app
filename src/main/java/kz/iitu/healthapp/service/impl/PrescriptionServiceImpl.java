package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.model.CreatePrescriptionRequest;
import kz.iitu.healthapp.model.UpdatePrescriptionRequest;
import kz.iitu.healthapp.repository.PrescriptionRepository;
import kz.iitu.healthapp.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Override
    public void createPrescription(CreatePrescriptionRequest request) {

    }

    @Override
    public void updatePrescription(Long prescriptionId, UpdatePrescriptionRequest request) {

    }
}
