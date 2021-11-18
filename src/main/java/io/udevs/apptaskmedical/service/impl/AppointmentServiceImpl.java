package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Appointment;
import io.udevs.apptaskmedical.repository.AppointmentRepository;
import io.udevs.apptaskmedical.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    final
    AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        return null;
    }

    @Override
    public ResponseMessage delete(Long id) {
        return null;
    }

    @Override
    public List<Appointment> getAll() {
        return null;
    }

    @Override
    public Appointment findById(Long id) {
        return null;
    }
}
