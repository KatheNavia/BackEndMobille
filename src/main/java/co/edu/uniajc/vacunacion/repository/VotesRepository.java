package co.edu.uniajc.vacunacion.repository;

import co.edu.uniajc.vacunacion.model.VoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotesRepository extends JpaRepository<VoteModel, Long>{

}
