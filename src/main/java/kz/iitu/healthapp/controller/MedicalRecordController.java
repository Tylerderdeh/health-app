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

    @PostMapping("/create")
    public ResponseEntity<?> createMedicalRecord(@RequestBody CreateMedicalRecordRequest createMedicalRecordRequest) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{recordId}/update")
    public ResponseEntity<?> updateMedicalRecord(@PathVariable Long recordId, @RequestBody UpdateMedicalRecordRequest updateMedicalRecordRequest) {
        return ResponseEntity.ok().build();
    }
}
