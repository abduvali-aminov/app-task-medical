package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.PatientMedication;

import java.util.List;

public interface PatientMedicationService {
    PatientMedication create(PatientMedication patientMedication);
    PatientMedication update(Long id, PatientMedication patientMedication);
    ResponseMessage delete(Long id);
    List<PatientMedication> getAll();
    PatientMedication findById(Long id);
}
