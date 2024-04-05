package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.config.JwtService;
import kz.iitu.healthapp.dto.AuthenticationRequest;
import kz.iitu.healthapp.dto.AuthenticationResponse;
import kz.iitu.healthapp.dto.RegisterRequest;
import kz.iitu.healthapp.entity.Doctor;
import kz.iitu.healthapp.entity.Patient;
import kz.iitu.healthapp.entity.User;
import kz.iitu.healthapp.repository.DoctorRepository;
import kz.iitu.healthapp.repository.PatientRepository;
import kz.iitu.healthapp.repository.UserRepository;
import kz.iitu.healthapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepository.save(user);

        if ("PATIENT".equals(request.getRole().name())) {
            var patient = Patient.builder()
                    .user(user)
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .middleName(request.getMiddleName())
                    .age(request.getAge())
                    .gender(request.getGender())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            patientRepository.save(patient);
        } else if ("DOCTOR".equals(request.getRole().name())) {
            var doctor = Doctor.builder()
                    .user(user)
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .middleName(request.getMiddleName())
                    .specialization(request.getSpecialization())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            doctorRepository.save(doctor);
        }

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
