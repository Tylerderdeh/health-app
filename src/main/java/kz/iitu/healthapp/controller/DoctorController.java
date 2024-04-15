package kz.iitu.healthapp.controller;

import kz.iitu.healthapp.entity.Role;
import kz.iitu.healthapp.entity.User;
import kz.iitu.healthapp.model.DoctorDTO;
import kz.iitu.healthapp.model.PatientDTO;
import kz.iitu.healthapp.model.UserResponse;
import kz.iitu.healthapp.service.CrudServiceForDoctor;
import kz.iitu.healthapp.service.CrudServiceForPatient;
import kz.iitu.healthapp.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final CrudServiceForDoctor crudServiceForDoctor;
    private final Mapper mapper;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(crudServiceForDoctor.getAll()
                .stream()
                .map(mapper::mapDoctorToDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.mapDoctorToDTO(crudServiceForDoctor.getById(id)));
    }

}
