package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.response.ResponseMessage;
import io.udevs.apptaskmedical.entity.Staff;
import io.udevs.apptaskmedical.repository.StaffRepository;
import io.udevs.apptaskmedical.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    final
    StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff create(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff update(Long id, Staff staff) {
        Staff editedStaff = null;
        if (staffRepository.findById(id).isPresent()){
            staff.setId(id);
            editedStaff = staffRepository.save(staff);
        }
        return editedStaff;
    }

    @Override
    public ResponseMessage delete(Long id) {
        Optional<Staff> user = staffRepository.findById(id);
        if (user.isPresent()) {
            staffRepository.delete(user.get());
            return new ResponseMessage("Staff deleted!!!");
        } else {
            return new ResponseMessage("Staff not found");
        }
    }

    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff findById(Long id) {
        return staffRepository.findById(id).orElseThrow();
    }
}
