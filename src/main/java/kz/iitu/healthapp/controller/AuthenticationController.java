package kz.iitu.healthapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.iitu.healthapp.dto.AuthenticationRequest;
import kz.iitu.healthapp.dto.AuthenticationResponse;
import kz.iitu.healthapp.dto.RegisterRequest;
import kz.iitu.healthapp.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name="Авторизация", description="Контроллер по авторизации")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationServiceImpl;
    @Operation(summary = "Register a new user", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationServiceImpl.register(request));
    }
    @Operation(summary = "Authenticate a user", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationServiceImpl.authenticate(request));
    }

}
