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
@Table(name="inventarios")
public class InventarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vi_id")
    private Long id;

    @Column(name = "vi_codigo_vacuna")
    @Size(min = 1, max = 20)
    @NotNull
    private String codigoVacuna;

    @Column(name = "vi_nombre_vacuna")
    @Size(min = 1, max = 50)
    @NotNull
    private String nombreVacuna;

    @Column(name = "vi_cantidad_vacuna")
    @Size(min = 1, max = 5)
    @NotNull
    private Long cantidad_Vacuna;

    @Column(name = "vi_lote")
    @Size(min = 1, max = 10)
    @NotNull
    private String lote;

    @Column(name = "vi_fecha_fabricacion")
    @NotNull
    private Date fechaFabricacion;

    @Column(name = "vi_fecha_vencimiento")
    @NotNull
    private Date fechaVencimiento;

}
