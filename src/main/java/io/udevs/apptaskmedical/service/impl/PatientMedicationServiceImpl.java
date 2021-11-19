package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.request.PatientMedicationDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Medication;
import io.udevs.apptaskmedical.entity.Patient;
import io.udevs.apptaskmedical.entity.PatientMedication;
import io.udevs.apptaskmedical.repository.PatientMedicationRepository;
import io.udevs.apptaskmedical.service.MedicationService;
import io.udevs.apptaskmedical.service.PatientMedicationService;
import io.udevs.apptaskmedical.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientMedicationServiceImpl implements PatientMedicationService {

    private final PatientMedicationRepository patientMedicationRepository;
    private final MedicationService medicationService;
    private final PatientService patientService;

    public PatientMedicationServiceImpl(PatientMedicationRepository patientMedicationRepository, MedicationService medicationService, PatientService patientService) {
        this.patientMedicationRepository = patientMedicationRepository;
        this.medicationService = medicationService;
        this.patientService = patientService;
    }

    @Override
    public PatientMedication create(PatientMedicationDto patientMedicationDto) {
        Medication medication = medicationService.findById(patientMedicationDto.getMedicationId());
        Patient patient = patientService.findById(patientMedicationDto.getPatientId());
        PatientMedication patientMedication = new PatientMedication(null, medication, patient,
                patientMedicationDto.getDateTimeAdministered(), patientMedicationDto.getDosage(),
                patientMedicationDto.getComments());
        return patientMedicationRepository.save(patientMedication);
    }

    @Override
    public PatientMedication update(Long id, PatientMedicationDto patientMedicationDto) {
        PatientMedication editedPatientMedication = null;
        if (patientMedicationRepository.existsById(id)){
            Medication medication = medicationService.findById(patientMedicationDto.getMedicationId());
            Patient patient = patientService.findById(patientMedicationDto.getPatientId());
            PatientMedication patientMedication = new PatientMedication(id, medication, patient,
                    patientMedicationDto.getDateTimeAdministered(), patientMedicationDto.getDosage(),
                    patientMedicationDto.getComments());
            editedPatientMedication = patientMedicationRepository.save(patientMedication);
        }
        return editedPatientMedication;
    }

    @Override
    public ResponseMessage delete(Long id) {
        if (patientMedicationRepository.existsById(id)){
            patientMedicationRepository.deleteById(id);
            return new ResponseMessage("Patient-Medication deleted!!!");
        }else{
            return new ResponseMessage("Patient-Medication not found");
        }
    }

    @Override
    public List<PatientMedication> getAll() {
        return patientMedicationRepository.findAll();
    }

    @Override
    public PatientMedication findById(Long id) {
        return patientMedicationRepository.findById(id).orElseThrow();
    }
}
