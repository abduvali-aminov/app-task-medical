package io.udevs.apptaskmedical.controller;

import io.udevs.apptaskmedical.entity.Patient;
import io.udevs.apptaskmedical.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    final
    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(patientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.create(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,
                                  @RequestBody Patient patient){
        return ResponseEntity.ok(patientService.update(id, patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(patientService.delete(id));
    }
}
