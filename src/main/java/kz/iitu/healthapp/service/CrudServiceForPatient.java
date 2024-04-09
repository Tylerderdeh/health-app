package kz.iitu.healthapp.service;

import kz.iitu.healthapp.entity.Patient;
import kz.iitu.healthapp.model.DoctorDTO;
import kz.iitu.healthapp.model.PatientDTO;

import java.util.List;

public interface CrudServiceForPatient {

    List<PatientDTO> getAll();

    PatientDTO getById(Long id);

    PatientDTO getByUserId(Long id);
}
