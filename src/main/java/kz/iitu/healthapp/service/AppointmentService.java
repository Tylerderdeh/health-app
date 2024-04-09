package kz.iitu.healthapp.service;

import kz.iitu.healthapp.model.CreateAppointmentRequest;

public interface AppointmentService {

    void createAppointment(CreateAppointmentRequest request);

    void updateAppointmentStatus(Long appointmentId, String newStatus);
}
