package io.udevs.apptaskmedical.repository;

import io.udevs.apptaskmedical.entity.Patient;
import io.udevs.apptaskmedical.entity.PatientMedication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientMedicationRepository extends JpaRepository<PatientMedication, Long> {
    List<PatientMedication> findAllByPatient(Patient patient);
}
