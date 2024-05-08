package kz.iitu.healthapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.iitu.healthapp.service.CrudServiceForPatient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/patient")
@RequiredArgsConstructor
@Tag(name="Управление пациентами", description="Контроллер по управлению пациентами")
public class PatientController {

    private final CrudServiceForPatient crudServiceForPatient;

    @Operation(summary = "Get all patient info", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(crudServiceForPatient.getAll());
    }

    @Operation(summary = "Get patient info by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(crudServiceForPatient.getPatientDTOById(id));
    }

}
