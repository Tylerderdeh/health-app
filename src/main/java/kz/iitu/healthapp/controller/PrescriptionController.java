package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.model.CreatePrescriptionRequest;
import kz.iitu.healthapp.model.UpdatePrescriptionRequest;
import kz.iitu.healthapp.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/prescription")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @PostMapping("/create/{recordId}")
    public ResponseEntity<?> createPrescription(@RequestBody List<CreatePrescriptionRequest> createPrescriptionRequest, @PathVariable Long recordId) {
        prescriptionService.createPrescription(createPrescriptionRequest,recordId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{prescriptionId}/update")
    public ResponseEntity<?> updatePrescription(@PathVariable Long prescriptionId, @RequestBody UpdatePrescriptionRequest updatePrescriptionRequest) {
        return ResponseEntity.ok().build();
    }
}
