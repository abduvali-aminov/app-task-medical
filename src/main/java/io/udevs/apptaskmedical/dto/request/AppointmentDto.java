package io.udevs.apptaskmedical.dto.request;

import lombok.Data;

import java.util.Date;


@Data
public class AppointmentDto {
    private Long patientId;
    private Long staffId;
    private Date dateTimeOfAppointment;
}
