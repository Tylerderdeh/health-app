package kz.iitu.healthapp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateAppointmentRequest {
    private LocalDateTime appointmentDate;
    private String purpose;
    private String status;
}
