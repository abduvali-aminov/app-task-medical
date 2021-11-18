package io.udevs.apptaskmedical.controller;

import io.udevs.apptaskmedical.dto.request.AppointmentDto;
import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Appointment;
import io.udevs.apptaskmedical.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAll(){
        return ResponseEntity.ok(appointmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable Long id){
        return ResponseEntity.ok(appointmentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Appointment> add(@RequestBody AppointmentDto appointmentDto){
        return ResponseEntity.ok(appointmentService.create(appointmentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> edit(@PathVariable Long id,
                                  @RequestBody AppointmentDto appointmentDto){
        return ResponseEntity.ok(appointmentService.update(id, appointmentDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        return ResponseEntity.ok(appointmentService.delete(id));
    }
}
