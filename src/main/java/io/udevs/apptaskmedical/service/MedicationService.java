package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.dto.request.MedicationDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Medication;

import java.util.List;

public interface MedicationService {
    Medication create(MedicationDto medicationDto);
    Medication update(Long id, MedicationDto medicationDto);
    ResponseMessage delete(Long id);
    List<Medication> getAll();
    Medication findById(Long id);
}
