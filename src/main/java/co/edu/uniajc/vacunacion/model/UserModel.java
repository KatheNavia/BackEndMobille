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
@Table(name="users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id_user")
    private Long id;

    @Column(name = "us_number_document")
    @Size(min = 1, max = 50)
    @NotNull
    private String numberDocument;

    @Column(name = "us_name")
    @Size(min = 1, max = 50)
    @NotNull
    private String name;

    @Column(name = "us_lastname")
    @Size(min = 1, max = 50)
    @NotNull
    private String lastname;

    @Column(name = "us_password")
    @Size(min = 1, max = 20)
    @NotNull
    private String password;

}
