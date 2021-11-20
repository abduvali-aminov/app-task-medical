package io.udevs.apptaskmedical.repository;

import io.udevs.apptaskmedical.entity.Appointment;
import io.udevs.apptaskmedical.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByPatient(Patient patient);
}
