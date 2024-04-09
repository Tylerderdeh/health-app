package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.model.CreateAppointmentRequest;
import kz.iitu.healthapp.model.UpdateStatusRequest;
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

    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(@RequestBody CreateAppointmentRequest createAppointmentRequest) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{appointmentId}/update-status")
    public ResponseEntity<?> updateAppointmentStatus(@PathVariable Long appointmentId, @RequestBody UpdateStatusRequest updateStatusRequest) {
        return ResponseEntity.ok().build();
    }
}
