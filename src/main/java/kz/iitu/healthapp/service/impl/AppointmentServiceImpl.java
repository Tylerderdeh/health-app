package kz.iitu.healthapp.service.impl;

import kz.iitu.healthapp.entity.Appointment;
import kz.iitu.healthapp.entity.Doctor;
import kz.iitu.healthapp.entity.Patient;
import kz.iitu.healthapp.model.CreateAppointmentRequest;
import kz.iitu.healthapp.repository.AppointmentRepository;
import kz.iitu.healthapp.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorServiceImpl doctorService;
    private final PatientServiceImpl patientService;

    @Override
    public void createAppointment(CreateAppointmentRequest request, Long patientId, Long doctorId) {
        Doctor doctor = doctorService.getById(doctorId);
        Patient patient = patientService.getById(patientId);
        Appointment appointment = Appointment.builder()
                .appointmentDate(request.getAppointmentDate())
                .purpose(request.getPurpose())
                .status(request.getStatus())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .doctor(doctor)
                .patient(patient)
                .build();

        appointmentRepository.save(appointment);
    }

    @Override
    public void updateAppointmentStatus(Long appointmentId, String newStatus) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElse(new Appointment());
        appointment.setStatus(newStatus);
        appointmentRepository.save(appointment);

    }

    @Override
    public List<Appointment> getAllByDoctor(Long doctorId) {
        Doctor doctor = doctorService.getById(doctorId);
        return appointmentRepository.findAllByDoctor(doctor);
    }

    @Override
    public List<Appointment> getAllByPatient(Long patientId) {
        Patient patient = patientService.getById(patientId);
        return appointmentRepository.findAllByPatient(patient);
    }
}
