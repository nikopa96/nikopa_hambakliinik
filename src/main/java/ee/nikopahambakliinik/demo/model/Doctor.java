package ee.nikopahambakliinik.demo.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.Getter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor", schema = "nikopa_dental_clinic")
@Getter
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "photo_url")
    private String photoURL;

    @Type(type = "jsonb-node")
    @Column(name = "additional_fields")
    private JsonNode additionalFields;
}
