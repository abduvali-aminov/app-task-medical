package io.udevs.apptaskmedical.controller;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.MedicationType;
import io.udevs.apptaskmedical.service.MedicationTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medication-type")
public class MedicationTypeController {

    private final
    MedicationTypeService medicationTypeService;

    public MedicationTypeController(MedicationTypeService medicationTypeService) {
        this.medicationTypeService = medicationTypeService;
    }

    @GetMapping
    public ResponseEntity<List<MedicationType>> getAll(){
        return ResponseEntity.ok(medicationTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationType> getById(@PathVariable Long id){
        return ResponseEntity.ok(medicationTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MedicationType> add(@RequestBody MedicationType medicationType){
        return ResponseEntity.ok(medicationTypeService.create(medicationType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationType> edit(@PathVariable Long id,
                                  @RequestBody MedicationType medicationType){
        return ResponseEntity.ok(medicationTypeService.update(id, medicationType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        return ResponseEntity.ok(medicationTypeService.delete(id));
    }
}
