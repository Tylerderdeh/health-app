package kz.iitu.healthapp.repository;

import kz.iitu.healthapp.entity.Appointment;
import kz.iitu.healthapp.entity.Doctor;
import kz.iitu.healthapp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findAllByDoctor(Doctor doctor);
    List<Appointment> findAllByPatient(Patient patient);
}
