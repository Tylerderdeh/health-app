package kz.iitu.healthapp.service;

import kz.iitu.healthapp.entity.Appointment;
import kz.iitu.healthapp.model.CreateAppointmentRequest;

import java.util.List;

public interface AppointmentService {

    void createAppointment(CreateAppointmentRequest request, Long patientId, Long doctorId);

    void updateAppointmentStatus(Long appointmentId, String newStatus);

    Appointment getById(Long appointmentId);
    List<Appointment> getAllByDoctor(Long doctorId);
    List<Appointment> getAllByPatient(Long patientId);
}
