package co.edu.uniajc.vacunacion.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="votes")
public class VoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vo_id_vote")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vo_us_id_user")
    @NotNull
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "vo_ca_id_candidate")
    @NotNull
    private CandidateModel candidate;

}
