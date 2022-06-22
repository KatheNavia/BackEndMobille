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
@Table(name="puntovacunacion")

public class PuntoVacunacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pv_id")
    private Long id;

    @Column(name = "pv_nombre")
    @Size(min = 1, max = 20)
    @NotNull
    private String nombrePv;

    @Column(name = "pv_direccion")
    @Size(min = 1, max = 30)
    private String direccion;

    @Column(name = "pv_telefono")
    @Size(min = 1, max = 15)
    @NotNull
    private String telefono;

    @Column(name = "pv_ciudad")
    @Size(min = 1, max = 20)
    @NotNull
    private String ciudad;
}

