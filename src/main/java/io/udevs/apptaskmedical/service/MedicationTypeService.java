package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.MedicationType;

import java.util.List;

public interface MedicationTypeService {
    MedicationType create(MedicationType medicationType);
    MedicationType update(Long id, MedicationType medicationType);
    ResponseMessage delete(Long id);
    List<MedicationType> getAll();
    MedicationType findById(Long id);
}
