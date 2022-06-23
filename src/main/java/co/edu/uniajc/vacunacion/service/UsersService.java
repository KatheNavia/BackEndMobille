package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.dto.UserDTO;
import co.edu.uniajc.vacunacion.model.UserModel;
import co.edu.uniajc.vacunacion.repository.UsersRepository;
import co.edu.uniajc.vacunacion.security.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public UserModel createUser(UserModel userModel) {
        return this.usersRepository.save(userModel);
    }

    public UserModel updateUser(UserModel userModel) {
        return this.usersRepository.save(userModel);
    }

    public void deleteUsers(Long id) {
        this.usersRepository.deleteById(id);
    }

    public List<UserModel> findAllUsers() {
        return this.usersRepository.findAll();
    }

    public UserModel findByNumberDocument(String numberDocument){
        return usersRepository.findByNumberDocument(numberDocument);
    }

    public UserDTO login(String numberDocument, String password){
        UserModel userModel = usersRepository.findByNumberDocument(numberDocument);
        UserDTO userDTO = null;
        if(userModel != null) {
            if (userModel.getPassword().equals(password)){
                userDTO = new UserDTO();

                userDTO.setId(userModel.getId());
                userDTO.setToken(JWTToken.getToken(numberDocument));
                userDTO.setNumberDocument(userModel.getNumberDocument());
                userDTO.setName(userModel.getName());
                userDTO.setLastName(userModel.getLastname());

            }
        }

        return userDTO;
    }

}
