package kz.iitu.healthapp.dto;

import kz.iitu.healthapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientInfoDTO extends UserInfo{
    private String username;
    private String email;
    private Role role;
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer age;
    private String gender;
}
