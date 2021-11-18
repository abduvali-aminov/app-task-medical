package io.udevs.apptaskmedical.controller;

import io.udevs.apptaskmedical.entity.MedicationType;
import io.udevs.apptaskmedical.service.MedicationTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medication-type")
public class MedicationTypeController {

    final
    MedicationTypeService medicationTypeService;

    public MedicationTypeController(MedicationTypeService medicationTypeService) {
        this.medicationTypeService = medicationTypeService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(medicationTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(medicationTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody MedicationType medicationType){
        return ResponseEntity.ok(medicationTypeService.create(medicationType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,
                                  @RequestBody MedicationType medicationType){
        return ResponseEntity.ok(medicationTypeService.update(id, medicationType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(medicationTypeService.delete(id));
    }
}
