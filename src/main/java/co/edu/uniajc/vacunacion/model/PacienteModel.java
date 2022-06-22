package co.edu.uniajc.vacunacion.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pacientes")
public class PacienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pcet_id")
    private Long id;

    @Column(name = "pcet_tipo_documento")
    @Size(min = 1, max = 20)
    @NotNull
    private String tipoDocumento;

    @Column(name = "pcet_numero_documento")
    @Size(min = 1, max = 15)
    @NotNull
    private String documento;

    @Column(name = "pcet_nombres")
    @Size(min = 1, max = 50)
    @NotNull
    private String nombres;

    @Column(name = "pcet_apellidos")
    @Size(min = 1, max = 50)
    @NotNull
    private String apellidos;

    @Column(name = "pcet_edad")
    @Size(min = 1, max = 2)
    @NotNull
    private Integer edad;

    @Column(name = "pcet_tipo_sangre")
    @Size(min = 1, max = 20)
    private String tipoSangre;

    @Column(name = "pcet_eps")
    @Size(min = 1, max = 50)
    @NotNull
    private String eps;

    @Column(name = "pcet_telefono")
    @Size(min = 1, max = 20)
    private String telefono;

    @Column(name = "pcet_email")
    @Size(min = 1, max = 30)
    private String email;

    @Column(name = "pcet_ciudad")
    @Size(min = 1, max = 30)
    private String ciudad;

}
