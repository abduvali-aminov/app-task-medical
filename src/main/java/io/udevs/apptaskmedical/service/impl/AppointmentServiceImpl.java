package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.request.AppointmentDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.*;
import io.udevs.apptaskmedical.enums.Role;
import io.udevs.apptaskmedical.repository.AppointmentRepository;
import io.udevs.apptaskmedical.repository.PatientRepository;
import io.udevs.apptaskmedical.repository.UserRepository;
import io.udevs.apptaskmedical.security.SecurityUtils;
import io.udevs.apptaskmedical.service.AppointmentService;
import io.udevs.apptaskmedical.service.PatientService;
import io.udevs.apptaskmedical.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final StaffService staffService;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, StaffService staffService, PatientRepository patientRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.staffService = staffService;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Appointment create(AppointmentDto appointmentDto) {
        Staff staff = staffService.findById(appointmentDto.getStaffId());
        Patient patient = patientRepository.findById(appointmentDto.getPatientId()).orElseThrow();
        Appointment appointment = new Appointment(null, patient, staff, appointmentDto.getDateTimeOfAppointment());
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long id, AppointmentDto appointmentDto) {
        Appointment editedAppointment = null;
        if (appointmentRepository.existsById(id)){
            Patient patient = patientRepository.findById(appointmentDto.getPatientId()).orElseThrow();
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
        User user =  userRepository.findByUserName(SecurityUtils.getCurrentUserName().orElseThrow());
        if (user.getRole().equals(Role.ADMIN)){
            return appointmentRepository.findAll();
//        }else if (user.getRole().equals(Role.PATIENT)){
        }else{
            Patient patient = patientRepository.findPatientByUser(user);
            return appointmentRepository.findAllByPatient(patient);
        }
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).orElseThrow();
    }
}
