package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.MedicationType;
import io.udevs.apptaskmedical.repository.MedicationTypeRepository;
import io.udevs.apptaskmedical.service.MedicationTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationTypeServiceImpl implements MedicationTypeService {

    private final
    MedicationTypeRepository medicationTypeRepository;

    public MedicationTypeServiceImpl(MedicationTypeRepository medicationTypeRepository) {
        this.medicationTypeRepository = medicationTypeRepository;
    }

    @Override
    public MedicationType create(MedicationType medicationType) {
        return medicationTypeRepository.save(medicationType);
    }

    @Override
    public MedicationType update(Long id, MedicationType medicationType) {
        MedicationType editedMedicationType = null;
        if (medicationTypeRepository.existsById(id)){
            medicationType.setId(id);
            editedMedicationType = medicationTypeRepository.save(medicationType);
        }
        return editedMedicationType;
    }

    @Override
    public ResponseMessage delete(Long id) {
        if (medicationTypeRepository.existsById(id)){
            medicationTypeRepository.deleteById(id);
            return new ResponseMessage("Medication type deleted!!!");
        }else{
            return new ResponseMessage("Medication type not found");
        }
    }

    @Override
    public List<MedicationType> getAll() {
        return medicationTypeRepository.findAll();
    }

    @Override
    public MedicationType findById(Long id) {
        return medicationTypeRepository.findById(id).orElseThrow();
    }
}
