package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.model.DoctorDTO;
import kz.iitu.healthapp.model.PatientDTO;
import kz.iitu.healthapp.repository.PatientRepository;
import kz.iitu.healthapp.service.CrudServiceForPatient;
import kz.iitu.healthapp.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements CrudServiceForPatient {

    private final PatientRepository patientRepository;
    private final Mapper mapper;
    @Override
    public List<PatientDTO> getAll() {
        return patientRepository.findAll()
                .stream()
                .map(mapper::mapPatientToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getById(Long id) {
        return mapper.mapPatientToDTO(patientRepository.findById(id).orElseThrow());
    }
}
