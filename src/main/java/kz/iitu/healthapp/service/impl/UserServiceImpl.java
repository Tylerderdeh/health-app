package kz.iitu.healthapp.service.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.iitu.healthapp.entity.Role;
import kz.iitu.healthapp.entity.User;
import kz.iitu.healthapp.model.DoctorDTO;
import kz.iitu.healthapp.model.PatientDTO;
import kz.iitu.healthapp.model.UserResponse;
import kz.iitu.healthapp.repository.UserRepository;
import kz.iitu.healthapp.service.UserService;
import kz.iitu.healthapp.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DoctorServiceImpl doctorService;
    private final PatientServiceImpl patientService;
    private final Mapper mapper;

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return mapToUserResponse(user);
    }


    public UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(userResponse.getEmail());
        if (user.getRole() == Role.DOCTOR) {
            DoctorDTO doctor = mapper.mapDoctorToDTO(doctorService.getByUserId(user.getId()));
            userResponse.setFirstName(doctor.getFirstName());
            userResponse.setLastName(doctor.getLastName());
            userResponse.setMiddleName(doctor.getMiddleName());
        } else if (user.getRole() == Role.PATIENT) {
            PatientDTO patient = patientService.getByUserId(user.getId());
            userResponse.setFirstName(patient.getFirstName());
            userResponse.setLastName(patient.getLastName());
            userResponse.setMiddleName(patient.getMiddleName());
        }
        return userResponse;
    }
}
