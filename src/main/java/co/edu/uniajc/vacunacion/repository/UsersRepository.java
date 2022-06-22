package co.edu.uniajc.vacunacion.repository;

import co.edu.uniajc.vacunacion.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserModel, Long>{

    UserModel findByNumberDocument(String numberDocument);

}
