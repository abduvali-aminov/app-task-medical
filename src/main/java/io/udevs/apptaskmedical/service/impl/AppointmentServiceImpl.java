package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.request.AppointmentDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.*;
import io.udevs.apptaskmedical.repository.AppointmentRepository;
import io.udevs.apptaskmedical.service.AppointmentService;
import io.udevs.apptaskmedical.service.PatientService;
import io.udevs.apptaskmedical.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    final AppointmentRepository appointmentRepository;
    final StaffService staffService;
    final PatientService patientService;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, StaffService staffService, PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.staffService = staffService;
        this.patientService = patientService;
    }

    @Override
    public Appointment create(AppointmentDto appointmentDto) {
        Staff staff = staffService.findById(appointmentDto.getStaffId());
        Patient patient = patientService.findById(appointmentDto.getPatientId());
        Appointment appointment = new Appointment(null, patient, staff, appointmentDto.getDateTimeOfAppointment());
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long id, AppointmentDto appointmentDto) {
        Appointment editedAppointment = null;
        if (appointmentRepository.existsById(id)){
            Patient patient = patientService.findById(appointmentDto.getPatientId());
            Staff staff = staffService.findById(appointmentDto.getStaffId());
            Appointment appointment = new Appointment(id, patient, staff, appointmentDto.getDateTimeOfAppointment());
            editedAppointment =  appointmentRepository.save(appointment);
        }
        return editedAppointment;
    }

    @Override
    public ResponseMessage delete(Long id) {
        if (appointmentRepository.existsById(id)){
            appointmentRepository.deleteById(id);
            return new ResponseMessage("Appointment deleted!!!");
        }else{
            return new ResponseMessage("Appointment not found");
        }
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).orElseThrow();
    }
}
