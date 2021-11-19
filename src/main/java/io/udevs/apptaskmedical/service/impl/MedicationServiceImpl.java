package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.request.MedicationDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Medication;
import io.udevs.apptaskmedical.entity.MedicationType;
import io.udevs.apptaskmedical.repository.MedicationRepository;
import io.udevs.apptaskmedical.service.MedicationService;
import io.udevs.apptaskmedical.service.MedicationTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    private final
    MedicationRepository medicationRepository;

    private final
    MedicationTypeService medicationTypeService;

    public MedicationServiceImpl(MedicationRepository medicationRepository, MedicationTypeService medicationTypeService) {
        this.medicationRepository = medicationRepository;
        this.medicationTypeService = medicationTypeService;
    }

    @Override
    public Medication create(MedicationDto medicationDto) {
        MedicationType medicationType = medicationTypeService.findById(medicationDto.getMedicationTypeId());
        Medication medication = new Medication(null, medicationType, medicationDto.getUnitCost(), medicationDto.getName(), medicationDto.getDescription());
        return medicationRepository.save(medication);
    }

    @Override
    public Medication update(Long id, MedicationDto medicationDto) {
        Medication editedMedication = null;
        if (medicationRepository.existsById(id)){
            MedicationType medicationType = medicationTypeService.findById(medicationDto.getMedicationTypeId());
            Medication medication = new Medication(id, medicationType, medicationDto.getUnitCost(), medicationDto.getName(), medicationDto.getDescription());
            editedMedication =  medicationRepository.save(medication);
        }
        return editedMedication;
    }

    @Override
    public ResponseMessage delete(Long id) {
        if (medicationRepository.findById(id).isPresent()){
            medicationRepository.deleteById(id);
            return new ResponseMessage("Medication deleted!!!");
        }else{
            return new ResponseMessage("Medication not found");
        }
    }

    @Override
    public List<Medication> getAll() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication findById(Long id) {
        return medicationRepository.findById(id).orElseThrow();
    }
}
