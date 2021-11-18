package io.udevs.apptaskmedical.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MedicationDto {
    private Long medicationTypeId;
    private BigDecimal unitCost;
    private String name;
    private String description;
}
