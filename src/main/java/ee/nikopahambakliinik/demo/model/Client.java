package ee.nikopahambakliinik.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client", schema = "nikopa_dental_clinic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @NotNull
    @Column(name = "visit_id")
    private Long visitId;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "surname")
    private String surname;

    @NotEmpty
    @Size(max = 50)
    @Pattern(regexp = "^[+]*[(]?[+]?[0-9]*[)]?[-\\s\\d]*$")
    @Column(name = "telephone")
    private String telephone;

    @NotEmpty
    @Size(max = 255)
    @Pattern(regexp = "^([a-z0-9_\\-.]+)@([a-z0-9_\\-.]+)\\.([a-z]{2,5})$")
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Size(max = 5)
    @Column(name = "connection_type")
    private String connectionType;
}
