package kz.iitu.healthapp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UpdatePrescriptionRequest {
    private String dosage;
    private String frequency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
