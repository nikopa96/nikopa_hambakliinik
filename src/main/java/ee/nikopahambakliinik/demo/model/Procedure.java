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
@Table(name = "procedure", schema = "nikopa_dental_clinic")
@Getter
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class Procedure {

    @Id
    @Column(name = "procedure_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Type(type = "jsonb-node")
    @Column(name = "additional_fields")
    private JsonNode additionalFields;
}
