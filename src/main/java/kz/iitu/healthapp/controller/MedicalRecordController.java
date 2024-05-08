package kz.iitu.healthapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.iitu.healthapp.model.CreateMedicalRecordRequest;
import kz.iitu.healthapp.model.UpdateMedicalRecordRequest;
import kz.iitu.healthapp.service.MedicalRecordService;
import kz.iitu.healthapp.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/medical-record")
@RequiredArgsConstructor
@Tag(name="Назначение пациента", description="Контроллер по управления назначениями")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;
    @Operation(summary = "Get all medical records for a doctor", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("getAllForDoctor/{doctorId}")
    public ResponseEntity<?> getAllForDoctor(@PathVariable Long doctorId){
        return ResponseEntity.ok(medicalRecordService.getAllByDoctor(doctorId));
    }
    @Operation(summary = "Get all medical records for a patient", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("getAllForPatient/{patientId}")
    public ResponseEntity<?> getAllForPatient(@PathVariable Long patientId){
        return ResponseEntity.ok(medicalRecordService.getAllByPatient(patientId));
    }
    @Operation(summary = "Get a medical record by its ID", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("getById/{recordId}")
    public ResponseEntity<?> getById(@PathVariable Long recordId){
        return ResponseEntity.ok(medicalRecordService.getById(recordId));
    }
    @Operation(summary = "Create a new medical record", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/create/{patientId}/{doctorId}")
    public ResponseEntity<?> createMedicalRecord(@PathVariable Long patientId, @PathVariable Long doctorId,@RequestBody CreateMedicalRecordRequest createMedicalRecordRequest) {
        medicalRecordService.createMedicalRecord(patientId,doctorId,createMedicalRecordRequest);
        return ResponseEntity.ok("Medical-record has created!");
    }
    @Operation(summary = "Update a medical record", security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/{recordId}/update")
    public ResponseEntity<?> updateMedicalRecord(@PathVariable Long recordId, @RequestBody UpdateMedicalRecordRequest updateMedicalRecordRequest) {
        medicalRecordService.updateMedicalRecord(recordId,updateMedicalRecordRequest);
        return ResponseEntity.ok("Medical-record has updated!");
    }
}
