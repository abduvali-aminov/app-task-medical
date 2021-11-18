package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient create(Patient patient);
    Patient update(Long id, Patient patient);
    ResponseMessage delete(Long id);
    List<Patient> getAll();
    Patient findById(Long id);
}
