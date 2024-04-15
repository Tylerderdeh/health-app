package kz.iitu.healthapp.controller;

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
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @GetMapping("getAllForDoctor/{doctorId}")
    public ResponseEntity<?> getAllForDoctor(@PathVariable Long doctorId){
        return ResponseEntity.ok(medicalRecordService.getAllByDoctor(doctorId));
    }
    @GetMapping("getAllForPatient/{patientId}")
    public ResponseEntity<?> getAllForPatient(@PathVariable Long patientId){
        return ResponseEntity.ok(medicalRecordService.getAllByPatient(patientId));
    }

    @GetMapping("getById/{recordId}")
    public ResponseEntity<?> getById(@PathVariable Long recordId){
        return ResponseEntity.ok(medicalRecordService.getById(recordId));
    }

    @PostMapping("/create/{patientId}/{doctorId}")
    public ResponseEntity<?> createMedicalRecord(@PathVariable Long patientId, @PathVariable Long doctorId,@RequestBody CreateMedicalRecordRequest createMedicalRecordRequest) {
        medicalRecordService.createMedicalRecord(patientId,doctorId,createMedicalRecordRequest);
        return ResponseEntity.ok("Medical-record has created!");
    }

    @PutMapping("/{recordId}/update")
    public ResponseEntity<?> updateMedicalRecord(@PathVariable Long recordId, @RequestBody UpdateMedicalRecordRequest updateMedicalRecordRequest) {
        medicalRecordService.updateMedicalRecord(recordId,updateMedicalRecordRequest);
        return ResponseEntity.ok("Medical-record has updated!");
    }
}
