package co.edu.uniajc.vacunacion.repository;

import co.edu.uniajc.vacunacion.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository extends JpaRepository<PacienteModel, Long> {

    PacienteModel findByDocumento(String documento);
}
