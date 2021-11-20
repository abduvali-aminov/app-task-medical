package io.udevs.apptaskmedical.repository;

import io.udevs.apptaskmedical.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
