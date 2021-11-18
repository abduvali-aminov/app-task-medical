package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.dto.request.PatientMedicationDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.PatientMedication;

import java.util.List;

public interface PatientMedicationService {
    PatientMedication create(PatientMedicationDto patientMedicationDto);
    PatientMedication update(Long id, PatientMedicationDto patientMedicationDto);
    ResponseMessage delete(Long id);
    List<PatientMedication> getAll();
    PatientMedication findById(Long id);
}
