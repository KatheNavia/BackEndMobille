package co.edu.uniajc.vacunacion.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnfermeroDTO {

    private String token;
    private String tipoDocumento;
    private Long documento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private String ciudad;
    private String usuario;

}
