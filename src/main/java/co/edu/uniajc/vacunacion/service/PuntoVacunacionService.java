package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.PuntoVacunacionModel;
import co.edu.uniajc.vacunacion.repository.PuntoVacunacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoVacunacionService {

    private final PuntoVacunacionRepository  puntoVacunacionRepository;

    @Autowired
    public PuntoVacunacionService(PuntoVacunacionRepository puntoVacunacionRepository){
        this.puntoVacunacionRepository = puntoVacunacionRepository;
    }

    public PuntoVacunacionModel createPuntoVacunacion (PuntoVacunacionModel puntoVacunacionModel) {
        return this.puntoVacunacionRepository.save(puntoVacunacionModel);
    }

    public PuntoVacunacionModel updatePuntoVacunacion (PuntoVacunacionModel puntoVacunacionModel) {
        return this.puntoVacunacionRepository.save(puntoVacunacionModel);
    }

    public void deletePuntoVacunacion(Long id) {
        this.puntoVacunacionRepository.deleteById(id);
    }

    public List<PuntoVacunacionModel> findAllPuntoVacunacion() {
        return this.puntoVacunacionRepository.findAll();
    }


}