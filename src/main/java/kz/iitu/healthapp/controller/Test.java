package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class Test {
    private final AuthenticationService authenticationService;

    @GetMapping("/get")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok(authenticationService.getAll());
    }

}
