package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.service.CrudServiceForDoctor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final CrudServiceForDoctor crudServiceForDoctor;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(crudServiceForDoctor.getAll());
    }
}
