package ee.nikopahambakliinik.demo.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "procedure")
@Getter
public class Procedure {

    @Id
    @Column(name = "procedure_id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
