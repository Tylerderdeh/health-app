package kz.iitu.healthapp.service.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.iitu.healthapp.entity.User;
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
        return users.stream().map(mapper::mapToUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return mapper.mapToUserResponse(user);
    }
}
