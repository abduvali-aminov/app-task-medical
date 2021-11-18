package io.udevs.apptaskmedical.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "patients_medication")
public class PatientMedication extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Medication medication;

    @ManyToOne(optional = false)
    private Patient patient;

    @Column(nullable = false)
    private Date dateTimeAdministered;

    @Column(nullable = false)
    private BigDecimal dosage;

    private String comments;

//    private String otherDetails;
}
