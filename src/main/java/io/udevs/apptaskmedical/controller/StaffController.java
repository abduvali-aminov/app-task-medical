package io.udevs.apptaskmedical.controller;

import io.udevs.apptaskmedical.entity.Staff;
import io.udevs.apptaskmedical.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    final
    StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(staffService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(staffService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Staff staff){
        return ResponseEntity.ok(staffService.create(staff));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,
                                  @RequestBody Staff staff){
        return ResponseEntity.ok(staffService.update(id, staff));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(staffService.delete(id));
    }
}
