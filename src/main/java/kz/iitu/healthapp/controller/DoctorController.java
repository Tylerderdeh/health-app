package kz.iitu.healthapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="Управление докторами", description="Контроллер по управлению докторами")
public class DoctorController {

    private final CrudServiceForDoctor crudServiceForDoctor;
    private final Mapper mapper;
    @Operation(summary = "Get all doctor info", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(crudServiceForDoctor.getAll()
                .stream()
                .map(mapper::mapDoctorToDTO)
                .collect(Collectors.toList()));
    }
    @Operation(summary = "Get doctor info by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.mapDoctorToDTO(crudServiceForDoctor.getById(id)));
    }

}
