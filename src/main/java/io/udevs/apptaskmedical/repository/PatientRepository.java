package io.udevs.apptaskmedical.repository;

import io.udevs.apptaskmedical.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
