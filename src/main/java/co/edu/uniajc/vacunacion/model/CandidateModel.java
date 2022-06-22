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
@Table(name="candidates")
public class CandidateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ca_id_candidate")
    private Long id;

    @Column(name = "us_name")
    @Size(min = 1, max = 50)
    @NotNull
    private String name;

    @Column(name = "us_lastname")
    @Size(min = 1, max = 50)
    @NotNull
    private String lastname;

    @Column(name = "ca_political_party")
    @Size(min = 1, max = 20)
    @NotNull
    private String politicalParty;

}
