package kz.iitu.healthapp.util;

import kz.iitu.healthapp.entity.Doctor;
import kz.iitu.healthapp.entity.Patient;
import kz.iitu.healthapp.entity.Role;
import kz.iitu.healthapp.entity.User;
import kz.iitu.healthapp.model.DoctorDTO;
import kz.iitu.healthapp.model.PatientDTO;
import kz.iitu.healthapp.model.UserResponse;
import kz.iitu.healthapp.service.CrudServiceForDoctor;
import kz.iitu.healthapp.service.CrudServiceForPatient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapper {
    private final CrudServiceForDoctor doctorService;
    private final CrudServiceForPatient patientService;

    public DoctorDTO mapDoctorToDTO(Doctor doctor) {
        return DoctorDTO.builder()
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .middleName(doctor.getMiddleName())
                .specialization(doctor.getSpecialization())
                .build();
    }
    public PatientDTO mapPatientToDTO(Patient patient) {
        return PatientDTO.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .middleName(patient.getMiddleName())
                .age(patient.getAge())
                .gender(patient.getGender())
                .build();
    }


    public UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(userResponse.getUsername());
        userResponse.setEmail(userResponse.getEmail());
        if (user.getRole() == Role.DOCTOR) {
            DoctorDTO doctor = doctorService.getByUserId(user.getId());
            userResponse.setFirstName(doctor.getFirstName());
            userResponse.setLastName(doctor.getLastName());
            userResponse.setMiddleName(doctor.getMiddleName());
            userResponse.setSpecialization(doctor.getSpecialization());
        } else if (user.getRole() == Role.PATIENT) {
            PatientDTO patient = patientService.getByUserId(user.getId());
            userResponse.setFirstName(patient.getFirstName());
            userResponse.setLastName(patient.getLastName());
            userResponse.setMiddleName(patient.getMiddleName());
            userResponse.setAge(patient.getAge());
            userResponse.setGender(patient.getGender());
        }
        return userResponse;
    }
}
