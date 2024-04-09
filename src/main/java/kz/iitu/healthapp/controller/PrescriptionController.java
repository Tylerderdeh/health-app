package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.model.CreatePrescriptionRequest;
import kz.iitu.healthapp.model.UpdatePrescriptionRequest;
import kz.iitu.healthapp.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/prescription")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @PostMapping("/create")
    public ResponseEntity<?> createPrescription(@RequestBody CreatePrescriptionRequest createPrescriptionRequest) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{prescriptionId}/update")
    public ResponseEntity<?> updatePrescription(@PathVariable Long prescriptionId, @RequestBody UpdatePrescriptionRequest updatePrescriptionRequest) {
        return ResponseEntity.ok().build();
    }
}
