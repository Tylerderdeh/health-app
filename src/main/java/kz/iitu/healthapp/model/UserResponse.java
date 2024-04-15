package kz.iitu.healthapp.model;

import kz.iitu.healthapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String email;
    private Role role;
    private String firstName;
    private String lastName;
    private String middleName;
}