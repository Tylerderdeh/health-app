package kz.iitu.healthapp.util;

import kz.iitu.healthapp.entity.Doctor;
import kz.iitu.healthapp.entity.Patient;
import kz.iitu.healthapp.model.DoctorDTO;
import kz.iitu.healthapp.model.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Mapper {

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
}
