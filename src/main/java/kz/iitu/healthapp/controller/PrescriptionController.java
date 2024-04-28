package kz.iitu.healthapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @Operation(summary = "Create a new prescription for a medical record", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/create/{recordId}")
    public ResponseEntity<?> createPrescription(@RequestBody List<CreatePrescriptionRequest> createPrescriptionRequest, @PathVariable Long recordId) {
        prescriptionService.createPrescription(createPrescriptionRequest,recordId);
        return ResponseEntity.ok().build();
    }
    @Operation(summary = "Update a prescription", security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/{prescriptionId}/update")
    public ResponseEntity<?> updatePrescription(@PathVariable Long prescriptionId, @RequestBody UpdatePrescriptionRequest updatePrescriptionRequest) {
        prescriptionService.updatePrescription(prescriptionId,updatePrescriptionRequest);
        return ResponseEntity.ok().build();
    }
}
