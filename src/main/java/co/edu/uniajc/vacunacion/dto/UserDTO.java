package co.edu.uniajc.vacunacion.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String token;
    private String numberDocument;
    private String name;
    private String lastName;

}
