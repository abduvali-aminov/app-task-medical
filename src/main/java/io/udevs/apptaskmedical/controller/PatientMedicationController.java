package io.udevs.apptaskmedical.controller;

import io.udevs.apptaskmedical.dto.request.PatientMedicationDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.PatientMedication;
import io.udevs.apptaskmedical.service.PatientMedicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient-medication")
public class PatientMedicationController {

    final PatientMedicationService patientMedicationService;

    public PatientMedicationController(PatientMedicationService patientMedicationService) {
        this.patientMedicationService = patientMedicationService;
    }

    @GetMapping
    public ResponseEntity<List<PatientMedication>> getAll(){
        return ResponseEntity.ok(patientMedicationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientMedication> getById(@PathVariable Long id){
        return ResponseEntity.ok(patientMedicationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PatientMedication> add(@RequestBody PatientMedicationDto patientMedicationDto){
        return ResponseEntity.ok(patientMedicationService.create(patientMedicationDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientMedication> edit(@PathVariable Long id,
                                  @RequestBody PatientMedicationDto patientMedicationDto){
        return ResponseEntity.ok(patientMedicationService.update(id, patientMedicationDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        return ResponseEntity.ok(patientMedicationService.delete(id));
    }
}
