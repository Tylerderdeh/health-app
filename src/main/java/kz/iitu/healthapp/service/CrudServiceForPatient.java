package kz.iitu.healthapp.service;

import kz.iitu.healthapp.model.PatientDTO;

import java.util.List;

public interface CrudServiceForPatient {

    List<PatientDTO> getAll();
}
