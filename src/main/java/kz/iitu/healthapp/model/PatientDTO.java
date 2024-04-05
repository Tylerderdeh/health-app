package kz.iitu.healthapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientDTO {
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer age;
    private String gender;
}
