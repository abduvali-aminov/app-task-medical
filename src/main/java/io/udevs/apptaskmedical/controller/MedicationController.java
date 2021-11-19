package io.udevs.apptaskmedical.controller;

import io.udevs.apptaskmedical.dto.request.MedicationDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Medication;
import io.udevs.apptaskmedical.service.MedicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medication")
public class MedicationController {

    private final
    MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping
    public ResponseEntity<List<Medication>> getAll(){
        return ResponseEntity.ok(medicationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getById(@PathVariable Long id){
        return ResponseEntity.ok(medicationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Medication> add(@RequestBody MedicationDto medicationDto){
        return ResponseEntity.ok(medicationService.create(medicationDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medication> edit(@PathVariable Long id,
                                  @RequestBody MedicationDto medicationDto){
        return ResponseEntity.ok(medicationService.update(id, medicationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        return ResponseEntity.ok(medicationService.delete(id));
    }
}
