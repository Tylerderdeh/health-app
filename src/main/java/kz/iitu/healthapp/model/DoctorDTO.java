package kz.iitu.healthapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorDTO {
    private String firstName;
    private String lastName;
    private String middleName;
    private String specialization;
}
