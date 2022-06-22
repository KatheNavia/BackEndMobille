package co.edu.uniajc.vacunacion.repository;

import co.edu.uniajc.vacunacion.model.VacunacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunacionRepository extends JpaRepository<VacunacionModel, Long> {

}
