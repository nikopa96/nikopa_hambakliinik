package ee.nikopahambakliinik.demo.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
@Getter
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
