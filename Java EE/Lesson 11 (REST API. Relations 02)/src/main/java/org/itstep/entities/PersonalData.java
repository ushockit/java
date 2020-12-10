package org.itstep.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users_data")
@Data
public class PersonalData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birth;

    @OneToOne(mappedBy = "personalData")
    private User user;
}
