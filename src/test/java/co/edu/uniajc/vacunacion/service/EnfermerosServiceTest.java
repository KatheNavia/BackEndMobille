package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.EnfermeroModel;
import co.edu.uniajc.vacunacion.model.PacienteModel;
import co.edu.uniajc.vacunacion.repository.EnfermerosRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class EnfermerosServiceTest {

    private EnfermeroModel enfermeros;

    @Mock
    private EnfermerosRepository enfermerosRepository;

    @InjectMocks
    private EnfermerosService enfermerosService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(enfermerosService).build();

        enfermeros= new EnfermeroModel();
        enfermeros.setId(1L);
        enfermeros.setTipoDocumento("CC");
        enfermeros.setDocumento(12345678L);
        enfermeros.setNombres("Pepito");
        enfermeros.setApellidos("Perez");
        enfermeros.setTelefono("3053634914");
        enfermeros.setEmail("ato.1994@hotmail.com");
        enfermeros.setCiudad("Cali");
        enfermeros.setUsuario("pepito");
        enfermeros.setUsuario("12345");

    }

    @Test
    void createEnfermeros() {
        when(enfermerosRepository.save(any(EnfermeroModel.class))).thenReturn(enfermeros);
        Assertions.assertNotNull(enfermerosService.createEnfermeros(enfermeros));
    }

    @Test
    void updateEnfermeros() throws Exception{
        when(enfermerosRepository.save(any(EnfermeroModel.class))).thenReturn(enfermeros);

        // Assertions.assertNotNull(enfermerosService.updateEnfermeros(new EnfermeroModel()));

        Assertions.assertNotNull(enfermerosService.updateEnfermeros(enfermeros));
    }

    @Test
    void deleteEnfermeros() {
        enfermerosService.deleteEnfermeros(enfermeros.getId());

        Assertions.assertEquals(Collections.EMPTY_LIST,enfermerosService.findAllEnfermeros());
    }

    @Test
    void findAllEnfermeros() {

        when(enfermerosRepository.findAll()).thenReturn(Collections.singletonList(enfermeros));
        Assertions.assertNotNull(enfermerosService.findAllEnfermeros());
    }

}