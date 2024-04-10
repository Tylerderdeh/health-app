package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.entity.Doctor;
import kz.iitu.healthapp.entity.Role;
import kz.iitu.healthapp.entity.User;
import kz.iitu.healthapp.model.DoctorDTO;
import kz.iitu.healthapp.model.PatientDTO;
import kz.iitu.healthapp.model.UserResponse;
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

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    @Override
    public Doctor getByUserId(Long id) {
        return doctorRepository.findByUserId(id);
    }

}
