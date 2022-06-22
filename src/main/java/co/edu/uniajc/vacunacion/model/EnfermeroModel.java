package co.edu.uniajc.vacunacion.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enfermeros")
public class EnfermeroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "efmr_id")
    private Long id;

    @Column(name = "efmr_tipo_documento")
    @Size(min = 1, max = 20)
    @NotNull
    private String tipoDocumento;

    @Column(name = "efmr_numero_documento")
    @Size(min = 1, max = 15)
    @NotNull
    private Long documento;

    @Column(name = "efmr_nombres")
    @Size(min = 1, max = 50)
    @NotNull
    private String nombres;

    @Column(name = "efmr_apellidos")
    @Size(min = 1, max = 50)
    @NotNull
    private String apellidos;

    @Column(name = "efmr_telefono")
    @Size(min = 1, max = 20)
    private String telefono;

    @Column(name = "efmr_email")
    @Size(min = 1, max = 30)
    private String email;

    @Column(name = "efmr_ciudad")
    @Size(min = 1, max = 30)
    private String ciudad;

    @Column(name = "efmr_usuario")
    @Size(min = 1, max = 20)
    @NotNull
    private String usuario;

    @Column(name = "efmr_contrasena")
    @Size(min = 1, max = 20)
    @NotNull
    private String contrasena;

}


