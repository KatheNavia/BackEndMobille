package co.edu.uniajc.vacunacion.repository;

import co.edu.uniajc.vacunacion.model.InventarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioModel, Long>{

}
