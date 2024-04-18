package kz.iitu.healthapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import kz.iitu.healthapp.entity.Medication;
import kz.iitu.healthapp.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/medical-record")
@RequiredArgsConstructor
public class MedicationController {

    private final MedicationService medicationService;

    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicationById(@PathVariable Long id) {
        Medication medication = medicationService.getById(id);
        return ResponseEntity.ok().body(medication);
    }
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/all")
    public ResponseEntity<?> getAllMedications() {
        List<Medication> medications = medicationService.getAllMedications();
        return ResponseEntity.ok().body(medications);
    }
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/create")
    public ResponseEntity<?> createMedication(@RequestBody Medication medication) {
        Medication createdMedication = medicationService.createMedication(medication);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedication);
    }
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateMedication(@PathVariable Long id, @RequestBody Medication medication) {
        Medication updatedMedication = medicationService.updateMedication(id, medication);
        return ResponseEntity.ok().body(updatedMedication);
    }
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteMedication(@PathVariable Long id) {
        medicationService.deleteMedication(id);
        return ResponseEntity.noContent().build();
    }
}
