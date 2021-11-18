package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment create(Appointment appointment);
    Appointment update(Long id, Appointment appointment);
    ResponseMessage delete(Long id);
    List<Appointment> getAll();
    Appointment findById(Long id);
}
