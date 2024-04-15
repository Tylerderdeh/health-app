package kz.iitu.healthapp.model;

import kz.iitu.healthapp.entity.Medication;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreatePrescriptionRequest {
    private Long medicationId;
    private String dosage;
    private String frequency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
