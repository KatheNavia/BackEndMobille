package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.dto.EnfermeroDTO;
import co.edu.uniajc.vacunacion.model.EnfermeroModel;
import co.edu.uniajc.vacunacion.repository.EnfermerosRepository;
import co.edu.uniajc.vacunacion.security.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfermerosService {

    private final EnfermerosRepository enfermerosRepository;

    private EnfermeroModel enfermeroModel;

    @Autowired
    public EnfermerosService(EnfermerosRepository enfermerosRepository){
        this.enfermerosRepository = enfermerosRepository;
    }

    public EnfermeroModel createEnfermeros(EnfermeroModel enfermerosModel) {
        return this.enfermerosRepository.save(enfermerosModel);
    }

    public EnfermeroModel updateEnfermeros(EnfermeroModel enfermerosModel)throws Exception {
        //return this.enfermerosRepository.save(enfermerosModel);
        try{
            this.enfermeroModel=this.enfermerosRepository.save(enfermerosModel);
        }catch (Exception e){
            Exception exception = e;
            if (null == enfermerosModel) exception = new Exception("Paciente no puede ser nulo");
            throw exception;
        }
        return this.enfermeroModel;
    }

    public void deleteEnfermeros(Long id) {
        this.enfermerosRepository.deleteById(id);
    }

    public List<EnfermeroModel> findAllEnfermeros() {
        return this.enfermerosRepository.findAll();
    }

}
