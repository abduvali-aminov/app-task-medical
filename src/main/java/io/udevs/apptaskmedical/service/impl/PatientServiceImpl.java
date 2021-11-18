package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Patient;
import io.udevs.apptaskmedical.repository.PatientRepository;
import io.udevs.apptaskmedical.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    final
    PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Long id, Patient patient) {
        Patient editedPatient = null;
        if (patientRepository.existsById(id)){
            patient.setId(id);
            editedPatient = patientRepository.save(patient);
        }
        return editedPatient;
    }

    @Override
    public ResponseMessage delete(Long id) {
        if (patientRepository.findById(id).isPresent()){
            return new ResponseMessage("Patient deleted!!!");
        }else{
            return new ResponseMessage("Patient not found");
        }
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }
}
