package io.udevs.apptaskmedical.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PatientMedicationDto {
    private Long medicationId;
    private Long patientId;
    private Date dateTimeAdministered;
    private BigDecimal dosage;
    private String comments;
}
