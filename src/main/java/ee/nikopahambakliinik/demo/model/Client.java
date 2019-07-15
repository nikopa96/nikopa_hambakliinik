package ee.nikopahambakliinik.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "client")
@Setter
@Getter
public class Client implements Serializable {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clientId;

    @NotNull
    @Column(name = "visit_id")
    private Long visitId;

    @NotNull
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 255)
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Size(max = 60)
    @Pattern(regexp = "^[+]*[(]?[+]?[0-9]*[)]?[-\\s\\d]*$")
    @Column(name = "telephone")
    private String telephone;

    @NotNull
    @Size(max = 255)
    @Pattern(regexp = "^([a-z0-9_\\-.]+)@([a-z0-9_\\-.]+)\\.([a-z]{2,5})$")
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(max = 5)
    @Column(name = "connection_type")
    private String connectionType;

}
