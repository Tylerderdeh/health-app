package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.service.CrudServiceForDoctor;
import kz.iitu.healthapp.service.CrudServiceForPatient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final CrudServiceForPatient crudServiceForPatient;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(crudServiceForPatient.getAll());
    }
}
