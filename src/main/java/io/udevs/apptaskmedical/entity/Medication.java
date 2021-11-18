package io.udevs.apptaskmedical.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "medications")
public class Medication extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private MedicationType medicationType;

    @Column(nullable = false)
    private BigDecimal unitCost;

    @Column(nullable = false)
    private String name;

    private String description;

//    private String otherDetails;
}
