package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.PacienteModel;
import co.edu.uniajc.vacunacion.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientesService {

    private final PacientesRepository pacientesRepository;

    private PacienteModel pacienteModel;

    @Autowired
    public PacientesService(PacientesRepository pacientesRepository){
        this.pacientesRepository = pacientesRepository;
    }

    public PacienteModel createPacientes(PacienteModel pacientesModel) throws Exception {
        try {
            isNumeric(pacientesModel.getDocumento());
           this.pacienteModel = this.pacientesRepository.save(pacientesModel);
        }catch (Exception e){
            throw new Exception("salio un error paila "+e.getMessage());
        }
        return this.pacienteModel;
    }

    public PacienteModel updatePacientes(PacienteModel pacientesModel)throws Exception {
        //return this.pacientesRepository.save(pacientesModel);
        try {
            this.pacienteModel = this.pacientesRepository.save(pacientesModel);

        } catch (Exception e) {
            Exception exception = e;
            if (null == pacientesModel) exception = new Exception("Paciente no puede ser nulo");
            throw exception;
        }
        return this.pacienteModel;
    }

    public void deletePacientes(Long id) {
        this.pacientesRepository.deleteById(id);
    }

    public List<PacienteModel> findAllPacientes() {
        return this.pacientesRepository.findAll();
    }

    public PacienteModel findByDocumento(String documento){
        return pacientesRepository.findByDocumento(documento);
    }

    private static boolean isNumeric(String cadena) throws Exception{
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            throw new Exception(nfe.getMessage());
        }
    }
}
