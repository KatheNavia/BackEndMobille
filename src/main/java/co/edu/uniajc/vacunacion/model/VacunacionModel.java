package co.edu.uniajc.vacunacion.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vacunacion")
public class VacunacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "va_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "va_id_paciente")
    @NotNull
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "va_id_enfermero")
    @NotNull
    private EnfermeroModel enfermero;

    @ManyToOne
    @JoinColumn(name = "va_id_vacuna")
    @NotNull
    private InventarioModel vacuna;

    @ManyToOne
    @JoinColumn(name = "va_id_ips_vacunadora")
    @NotNull
    private PuntoVacunacionModel ips;

    @Column(name = "va_cantidad_dosis")
    @Size(min = 1, max = 15)
    @NotNull
    private Long dosis;

    @Column(name = "va_fecha_aplicacion")
    @NotNull
    private Date fechaAplicacion;

}
