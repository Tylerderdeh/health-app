package kz.iitu.healthapp.service;

import kz.iitu.healthapp.entity.Doctor;
import kz.iitu.healthapp.model.DoctorDTO;

import javax.print.Doc;
import java.util.List;

public interface CrudServiceForDoctor {
    List<Doctor> getAll();

    Doctor getById(Long id);

    Doctor getByUserId(Long id);

}
