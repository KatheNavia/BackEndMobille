package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.PacienteModel;
import co.edu.uniajc.vacunacion.repository.PacientesRepository;
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
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


class PacientesServiceTest {

    private PacienteModel paciente;

    @Mock
    private PacientesRepository pacientesRepository;

    @InjectMocks
    private PacientesService pacientesService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(pacientesService).build();

        paciente = new PacienteModel();
        paciente.setId(1L);
        paciente.setTipoDocumento("CC");
        paciente.setDocumento("123456");
        paciente.setNombres("PEPITO");
        paciente.setApellidos("PEREZ");
        paciente.setEdad(40);
        paciente.setTipoSangre("O+");
        paciente.setEps("SURA");
        paciente.setTelefono("3053634914");
        paciente.setEmail("pepito@gmail.com");
        paciente.setCiudad("Cali");
    }

    @Test
    void createPacientes() throws Exception {
        when(pacientesRepository.save(any(PacienteModel.class))).thenReturn(paciente);
        //Assertions.assertNotNull(pacientesService.createPacientes(new PacienteModel()));
        Assertions.assertNotNull(pacientesService.createPacientes(paciente));
    }

    @Test
    void updatePacientes() throws Exception {
        when(pacientesRepository.save(any(PacienteModel.class))).thenReturn(paciente);

        Assertions.assertNotNull(pacientesService.updatePacientes(paciente));
    }

    @Test
    void deletePacientes() throws Exception{

       // Assertions.assertNull(pacientesService.deletePacientes(paciente.getId()));

        //Assertions.assertNotNull(pacientesService.createPacientes(paciente));

        pacientesService.deletePacientes(paciente.getId());

        Assertions.assertEquals(Collections.EMPTY_LIST,pacientesService.findAllPacientes());

        //verify(pacientesRepository,times(1).deletePacientes(paciente.getId()));

    }

    @Test
    void findAllPacientes() {
        when(pacientesRepository.findAll()).thenReturn(Collections.singletonList(paciente));
        Assertions.assertNotNull(pacientesService.findAllPacientes());
    }

    @Test
    void findByDocumento() throws Exception{
         when(pacientesRepository.findByDocumento(paciente.getDocumento())).thenReturn(paciente);
        Assertions.assertNotNull(pacientesService.findByDocumento(paciente.getDocumento()));
    }
}