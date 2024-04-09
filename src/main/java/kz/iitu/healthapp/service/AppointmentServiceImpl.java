package kz.iitu.healthapp.service;

import kz.iitu.healthapp.model.CreateAppointmentRequest;
import kz.iitu.healthapp.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public void createAppointment(CreateAppointmentRequest request) {

    }

    @Override
    public void updateAppointmentStatus(Long appointmentId, String newStatus) {

    }
}
