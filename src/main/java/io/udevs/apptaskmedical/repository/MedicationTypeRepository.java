package io.udevs.apptaskmedical.repository;

import io.udevs.apptaskmedical.entity.MedicationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationTypeRepository extends JpaRepository<MedicationType, Long> {
}
