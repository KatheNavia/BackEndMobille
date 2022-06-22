package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.InventarioModel;
import co.edu.uniajc.vacunacion.repository.InventarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventarioServiceTest {

    private InventarioModel inventario;

    @Mock
    private InventarioRepository inventarioRepository;

    @InjectMocks
    private InventarioService inventarioService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(inventarioService).build();

        inventario=new InventarioModel();

        inventario.setId(1L);
        inventario.setCodigoVacuna("V001");
        inventario.setNombreVacuna("Sinovac");
        inventario.setCantidad_Vacuna(5L);
        inventario.setLote("L001");
        inventario.setFechaFabricacion(Date.valueOf("2021-01-01"));
        inventario.setFechaVencimiento(Date.valueOf("2021-01-01"));
    }

    @Test
    void createInventario() {
        when(inventarioRepository.save(any(InventarioModel.class))).thenReturn(inventario);
        Assertions.assertNotNull(inventarioService.createInventario(inventario));
    }

    @Test
    void updateInventario() {
        when(inventarioRepository.save(any(InventarioModel.class))).thenReturn(inventario);

        Assertions.assertNotNull(inventarioService.updateInventario(inventario));
    }

    @Test
    void deleteInventario() {
        inventarioService.deleteInventario(inventario.getId());

        Assertions.assertEquals(Collections.EMPTY_LIST,inventarioService.findAllInventario());
    }

    @Test
    void findAllInventario() {
        when(inventarioRepository.findAll()).thenReturn(Collections.singletonList(inventario));
        Assertions.assertNotNull(inventarioService.findAllInventario());
    }
}