package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.PatientMedication;
import io.udevs.apptaskmedical.repository.PatientMedicationRepository;
import io.udevs.apptaskmedical.service.PatientMedicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientMedicationServiceImpl implements PatientMedicationService {

    final
    PatientMedicationRepository patientMedicationRepository;

    public PatientMedicationServiceImpl(PatientMedicationRepository patientMedicationRepository) {
        this.patientMedicationRepository = patientMedicationRepository;
    }

    @Override
    public PatientMedication create(PatientMedication patientMedication) {
        return null;
    }

    @Override
    public PatientMedication update(Long id, PatientMedication patientMedication) {
        return null;
    }

    @Override
    public ResponseMessage delete(Long id) {
        return null;
    }

    @Override
    public List<PatientMedication> getAll() {
        return null;
    }

    @Override
    public PatientMedication findById(Long id) {
        return null;
    }
}
