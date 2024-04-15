package kz.iitu.healthapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateMedicalRecordRequest {
    private String diagnosis;
    private String prescription;
}
