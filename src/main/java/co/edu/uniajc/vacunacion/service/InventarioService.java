package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.InventarioModel;
import co.edu.uniajc.vacunacion.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository InventarioRepository;

    @Autowired
    public InventarioService(InventarioRepository inventarioRepository){
        this.InventarioRepository = inventarioRepository;
    }

    public InventarioModel createInventario(InventarioModel inventarioModel) {
        return this.InventarioRepository.save(inventarioModel);
    }

    public InventarioModel updateInventario(InventarioModel inventarioModel) {
        return this.InventarioRepository.save(inventarioModel);
    }

    public void deleteInventario(Long id) {
        this.InventarioRepository.deleteById(id);
    }

    public List<InventarioModel> findAllInventario() {
        return this.InventarioRepository.findAll();
    }

}
