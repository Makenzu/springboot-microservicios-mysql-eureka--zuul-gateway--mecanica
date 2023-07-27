package com.mecanica.microservicios.app.tecnicos.controllers;

import com.mecanica.microservicios.app.tecnicos.services.TecnicoServiceImpl;
import com.mecanica.microservicios.commons.tecnicos.models.entity.Tecnico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TecnicoControllerTest {

    @Mock
    private TecnicoServiceImpl tecnicoService;
    @InjectMocks
    private TecnicoController tecnicoController;
    /**
     * Setup.
     */
    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ver() {
    	Optional<Tecnico> obj = Optional.ofNullable(new Tecnico());
    	Long id = 1L;
    	Mockito.when(tecnicoService.findById(id)).thenReturn(obj);
    	ResponseEntity<?> responseEntity = tecnicoController.ver(id);
    	Assertions.assertNotNull(responseEntity);
    	Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    	Assertions.assertNotNull(responseEntity.getBody());
    }
    
    @Test
    public void listar() {
        Iterable<Tecnico> iterable = new ArrayList<>();
        Mockito.when(tecnicoService.findAll()).thenReturn(iterable);
        ResponseEntity<?> responseEntity = tecnicoController.listar();
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
    }

    @Test
    public void editar() {
        Tecnico tecnicoNuevo = new Tecnico();
        tecnicoNuevo.setNombre("Nombre nuevo");

        Tecnico tecnicoBaseDatos = new Tecnico();
        tecnicoBaseDatos.setNombre("Nombre Anterior");

        Mockito.when(tecnicoService.findById(ArgumentMatchers.anyLong()))
            .thenReturn(Optional.ofNullable(tecnicoBaseDatos));
        Mockito.when(tecnicoService.save(ArgumentMatchers.any(Tecnico.class)))
                .thenReturn(tecnicoNuevo);
        ResponseEntity<?> responseEntity = tecnicoController.editar(tecnicoNuevo, 1L);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
    }


}