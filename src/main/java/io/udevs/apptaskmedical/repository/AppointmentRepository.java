package io.udevs.apptaskmedical.repository;

import io.udevs.apptaskmedical.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
