package com.mecanica.microservicios.app.tecnicos.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mecanica.microservicios.app.commons.controllers.CommonController;
import com.mecanica.microservicios.app.tecnicos.services.ITecnicoService;
import com.mecanica.microservicios.commons.tecnicos.models.entity.Tecnico;

@RestController
public class TecnicoController extends CommonController<Tecnico, ITecnicoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Tecnico tecnico, @PathVariable Long id){
		Optional<Tecnico> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Tecnico tecnicoDb = o.get();
		tecnicoDb.setNombre(tecnico.getNombre());
		tecnicoDb.setApellido(tecnico.getApellido());
		tecnicoDb.setEmail(tecnico.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tecnicoDb));
	}
	
	@GetMapping("/filtrar/{texto}")
	public ResponseEntity<?> filtrar(@PathVariable String texto){
		return ResponseEntity.ok(service.findByNameOrLastname(texto));
	}

}
