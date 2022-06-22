package co.edu.uniajc.vacunacion.repository;

import co.edu.uniajc.vacunacion.model.EnfermeroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<EnfermeroModel, Long>{

    @Query(nativeQuery = true,value = "select efmr_id, efmr_tipo_documento, efmr_numero_documento, efmr_nombres, efmr_apellidos, efmr_telefono, efmr_email, efmr_ciudad, efmr_usuario, efmr_contrasena from enfermeros where efmr_usuario = :usuario and efmr_contrasena = :contrasena")
    EnfermeroModel findUserAndPassword(@Param(value = "usuario") String usuario, @Param(value = "contrasena") String contrasena);

}
