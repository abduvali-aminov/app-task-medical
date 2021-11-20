package io.udevs.apptaskmedical.repository;

import io.udevs.apptaskmedical.entity.Patient;
import io.udevs.apptaskmedical.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientByUser(User user);
}
