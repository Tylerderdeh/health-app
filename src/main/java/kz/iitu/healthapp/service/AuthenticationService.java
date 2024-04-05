package kz.iitu.healthapp.service;

import kz.iitu.healthapp.dto.AuthenticationRequest;
import kz.iitu.healthapp.dto.AuthenticationResponse;
import kz.iitu.healthapp.dto.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
