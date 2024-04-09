package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.service.CrudServiceForDoctor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final CrudServiceForDoctor crudServiceForDoctor;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(crudServiceForDoctor.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(crudServiceForDoctor.getById(id));
    }

}
