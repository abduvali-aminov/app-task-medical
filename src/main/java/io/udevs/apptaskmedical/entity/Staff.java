package io.udevs.apptaskmedical.entity;

import io.udevs.apptaskmedical.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Staff extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender genderMfu;

    @Column(nullable = false)
    private String qualifications;

    @OneToOne
    private User user;
}
