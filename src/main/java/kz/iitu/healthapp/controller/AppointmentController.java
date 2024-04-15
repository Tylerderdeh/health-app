package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.model.CreateAppointmentRequest;
import kz.iitu.healthapp.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("getAll/{doctorId}")
    public ResponseEntity<?> getAll(@PathVariable Long doctorId){
        return ResponseEntity.ok(appointmentService.getAllByDoctor(doctorId));
    }

    @PostMapping("/create/{patientId}/{doctorId}")
    public ResponseEntity<?> createAppointment(@RequestBody CreateAppointmentRequest createAppointmentRequest,@PathVariable Long patientId, @PathVariable Long doctorId) {
        appointmentService.createAppointment(createAppointmentRequest,patientId,doctorId);
        return ResponseEntity.ok("Appointment has created");
    }

    @PutMapping("/{appointmentId}/update-status")
    public ResponseEntity<?> updateAppointmentStatus(@PathVariable Long appointmentId, @RequestParam String newStatus) {
        appointmentService.updateAppointmentStatus(appointmentId, newStatus);
        return ResponseEntity.ok("Appointment has updated");
    }
}
