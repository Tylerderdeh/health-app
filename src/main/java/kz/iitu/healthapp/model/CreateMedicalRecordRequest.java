package kz.iitu.healthapp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateMedicalRecordRequest {
    private LocalDateTime recordDate;
    private String diagnosis;
    private String prescription;
}
