package co.edu.uniajc.vacunacion.repository;

import co.edu.uniajc.vacunacion.model.PuntoVacunacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface PuntoVacunacionRepository extends JpaRepository<PuntoVacunacionModel, Long> {
}

