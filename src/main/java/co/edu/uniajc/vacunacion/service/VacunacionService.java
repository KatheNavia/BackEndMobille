package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.*;
import co.edu.uniajc.vacunacion.repository.InventarioRepository;
import co.edu.uniajc.vacunacion.repository.VacunacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacunacionService {

    private final VacunacionRepository vacunacionRepository;
    private final InventarioRepository inventarioRepository;

    private VacunacionModel vacunacion;

    @Autowired
    public VacunacionService(VacunacionRepository vacunacionRepository, InventarioRepository inventarioRepository){
        this.vacunacionRepository = vacunacionRepository;
        this.inventarioRepository = inventarioRepository;
    }

    public VacunacionModel createVacunacion(VacunacionModel vacunacionModel) throws Exception {
        try {

            this.vacunacion = this.vacunacionRepository.save(vacunacionModel);

            InventarioModel inventario = vacunacionModel.getVacuna();

            if (inventario.getCantidad_Vacuna() <= 0) {
                throw new Exception("Vacunas insuficiente");
            }

            inventario.setCantidad_Vacuna(inventario.getCantidad_Vacuna()-1);
            this.inventarioRepository.save(inventario);

        }catch (Exception e){

            Exception exception = e;

            if (vacunacionModel == null) {
                exception = new Exception("Vacunación no puede ser nulo");
            } else if (vacunacionModel.getEnfermero() == null) {
                exception = new Exception("Enfermero no puede ser nulo");
            } else if (vacunacionModel.getPaciente() == null) {
                exception = new Exception("Paciente no puede ser nulo");
            } else if (vacunacionModel.getVacuna() == null) {
                exception = new Exception("Vacuna no puede ser nulo");
            } else if (vacunacionModel.getIps() == null) {
                exception = new Exception("Ips no puede ser nulo");
            }

            throw exception;
        }
        return this.vacunacion;
    }

    public VacunacionModel updateVacunacion(VacunacionModel vacunacionModel) throws Exception {
        try {

            this.vacunacion = this.vacunacionRepository.save(vacunacionModel);

        }catch (Exception e){

            Exception exception = e;

            if (vacunacionModel == null) {
                exception = new Exception("Vacunación no puede ser nulo");
            } else if (vacunacionModel.getEnfermero() == null) {
                exception = new Exception("Enfermero no puede ser nulo");
            } else if (vacunacionModel.getPaciente() == null) {
                exception = new Exception("Paciente no puede ser nulo");
            } else if (vacunacionModel.getVacuna() == null) {
                exception = new Exception("Vacuna no puede ser nulo");
            } else if (vacunacionModel.getIps() == null) {
                exception = new Exception("Ips no puede ser nulo");
            }

            throw exception;
        }
        return this.vacunacion;
    }

    public void deleteVacunacion(Long id) {
        this.vacunacionRepository.deleteById(id);
    }

    public List<VacunacionModel> findAllVacunacion() {
        return this.vacunacionRepository.findAll();
    }

}
