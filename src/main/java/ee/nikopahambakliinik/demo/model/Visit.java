package ee.nikopahambakliinik.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "visit", schema = "nikopa_dental_clinic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit {

    @Id
    @Column(name = "visit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "procedure_id")
    private Procedure procedure;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "date", insertable = false)
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date date;

    @NotNull
    @Temporal(TemporalType.TIME)
    @Column(name = "time", insertable = false)
    @JsonFormat(pattern = "HH:mm")
    private Date time;

    @NotNull
    @Pattern(regexp = "^[0-2]?\\d[:]\\d\\d\\s[-]\\s[0-2]?\\d[:]\\d\\d*$")
    @Column(name = "interval")
    private String interval;

    @NotNull
    @Column(name = "is_active")
    private Boolean isActive;

    @NotNull
    @Column(name = "is_booked")
    private Boolean isBooked;
}
