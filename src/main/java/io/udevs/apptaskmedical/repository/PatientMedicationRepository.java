package io.udevs.apptaskmedical.repository;

import io.udevs.apptaskmedical.entity.PatientMedication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientMedicationRepository extends JpaRepository<PatientMedication, Long> {
}
