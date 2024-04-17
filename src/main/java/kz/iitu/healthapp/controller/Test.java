package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Deprecated
public class Test {
    private final AuthenticationServiceImpl authenticationServiceImpl;

    @GetMapping("/get")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok(authenticationServiceImpl.getAll());
    }

}
