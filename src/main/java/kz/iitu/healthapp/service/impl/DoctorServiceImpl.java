package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.model.DoctorDTO;
import kz.iitu.healthapp.repository.DoctorRepository;
import kz.iitu.healthapp.service.CrudServiceForDoctor;
import kz.iitu.healthapp.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements CrudServiceForDoctor {

    private final DoctorRepository doctorRepository;
    private final Mapper mapper;

    @Override
    public List<DoctorDTO> getAll() {
        return doctorRepository.findAll()
                .stream()
                .map(mapper::mapDoctorToDTO)
                .collect(Collectors.toList());
    }
}
