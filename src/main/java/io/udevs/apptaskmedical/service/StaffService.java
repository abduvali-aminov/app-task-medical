package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Staff;

import java.util.List;

public interface StaffService {
    Staff create(Staff staff);
    Staff update(Long id, Staff staff);
    ResponseMessage delete(Long id);
    List<Staff> getAll();
    Staff findById(Long id);
}
