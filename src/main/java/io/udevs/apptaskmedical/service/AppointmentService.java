package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.dto.request.AppointmentDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment create(AppointmentDto appointmentDto);
    Appointment update(Long id, AppointmentDto appointmentDto);
    ResponseMessage delete(Long id);
    List<Appointment> getAll();
    Appointment findById(Long id);
}
