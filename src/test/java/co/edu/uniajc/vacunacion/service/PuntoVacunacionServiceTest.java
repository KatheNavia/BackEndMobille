package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.PuntoVacunacionModel;
import co.edu.uniajc.vacunacion.repository.PuntoVacunacionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class PuntoVacunacionServiceTest {

    private PuntoVacunacionModel puntoVacunacion;

    @Mock
    private PuntoVacunacionRepository puntoVacunacionRepository;

    @InjectMocks
    private PuntoVacunacionService puntoVacunacionService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(puntoVacunacionService).build();

        puntoVacunacion=new PuntoVacunacionModel();
        puntoVacunacion.setId(1L);
        puntoVacunacion.setNombrePv("Estadio");
        puntoVacunacion.setDireccion("Calle 5");
        puntoVacunacion.setTelefono("3053634914");
        puntoVacunacion.setCiudad("Cali");

    }

    @Test
    void createPuntoVacunacion() {
        when(puntoVacunacionRepository.save(any(PuntoVacunacionModel.class))).thenReturn(puntoVacunacion);
        Assertions.assertNotNull(puntoVacunacionService.createPuntoVacunacion(puntoVacunacion));
    }

    @Test
    void updatePuntoVacunacion() {
        when(puntoVacunacionRepository.save(any(PuntoVacunacionModel.class))).thenReturn(puntoVacunacion);
        Assertions.assertNotNull(puntoVacunacionService.updatePuntoVacunacion(puntoVacunacion));
    }

    @Test
    void deletePuntoVacunacion() {
      //  Assertions.assertEquals(Collections.EMPTY_LIST, puntoVacunacionService.getClass());
        puntoVacunacionService.deletePuntoVacunacion(puntoVacunacion.getId());

        Assertions.assertEquals(Collections.EMPTY_LIST,puntoVacunacionService.findAllPuntoVacunacion());
    }

    @Test
    void findAllPuntoVacunacion() {
        when(puntoVacunacionRepository.findAll()).thenReturn(Collections.singletonList(puntoVacunacion));
        Assertions.assertNotNull(puntoVacunacionService.findAllPuntoVacunacion());
    }
}