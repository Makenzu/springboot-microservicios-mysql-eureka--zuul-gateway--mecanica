package com.mecanica.microservicios.app.tecnicos.services;

import com.mecanica.microservicios.app.tecnicos.models.repository.ITecnicoRepository;
import com.mecanica.microservicios.commons.tecnicos.models.entity.Tecnico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TecnicoServiceImplTest {

    @Mock
    private ITecnicoRepository iTecnicoRepository;
    @InjectMocks
    private TecnicoServiceImpl tecnicoService;

    /**
     * Setup.
     */
    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
        Iterable<Tecnico> iterable = new ArrayList<>();
        when(iTecnicoRepository.findAll()).thenReturn(iterable);
        Iterable<Tecnico> resultado = tecnicoService.findAll();
        Assertions.assertNotNull(resultado);
    }
    
    @Test
    public void findById() {
    	Optional<Tecnico> obj = Optional.ofNullable(new Tecnico());
    	Long id = 1L;
        when(iTecnicoRepository.findById(id)).thenReturn(obj);
        Optional<Tecnico> resultado = tecnicoService.findById(id);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void save(){
        Tecnico tecnico = new Tecnico();
        tecnico.setEmail("email@3it.cl");
        tecnico.setNombre("Nombre");
        when(iTecnicoRepository.save(ArgumentMatchers.any(Tecnico.class))).thenReturn(tecnico);
        Tecnico resultado = tecnicoService.save(tecnico);
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(tecnico,resultado);
    }


}