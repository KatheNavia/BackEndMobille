package co.edu.uniajc.vacunacion.repository;

import co.edu.uniajc.vacunacion.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatesRepository extends JpaRepository<CandidateModel, Long>{

}
