package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.dto.EnfermeroDTO;
import co.edu.uniajc.vacunacion.model.EnfermeroModel;
import co.edu.uniajc.vacunacion.repository.EnfermerosRepository;
import co.edu.uniajc.vacunacion.repository.LoginRepository;
import co.edu.uniajc.vacunacion.security.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public EnfermeroDTO findUserAndPassword(String usuario, String contrasena){
        EnfermeroModel modelo = this.loginRepository.findUserAndPassword(usuario, contrasena);
        EnfermeroDTO enfermero = new EnfermeroDTO();

        enfermero.setToken(JWTToken.getToken(usuario));

        enfermero.setTipoDocumento(modelo.getTipoDocumento());
        enfermero.setDocumento(modelo.getDocumento());
        enfermero.setNombres(modelo.getNombres());
        enfermero.setApellidos(modelo.getApellidos());
        enfermero.setTelefono(modelo.getTelefono());
        enfermero.setEmail(modelo.getEmail());
        enfermero.setCiudad(modelo.getCiudad());
        enfermero.setUsuario(modelo.getUsuario());

        return enfermero;
    }
}
