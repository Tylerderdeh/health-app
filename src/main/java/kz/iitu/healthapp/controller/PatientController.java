package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.service.CrudServiceForPatient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final CrudServiceForPatient crudServiceForPatient;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(crudServiceForPatient.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(crudServiceForPatient.getPatientDTOById(id));
    }

}
