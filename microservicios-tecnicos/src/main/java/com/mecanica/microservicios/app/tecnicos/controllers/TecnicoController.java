package com.mecanica.microservicios.app.tecnicos.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mecanica.microservicios.app.commons.controllers.CommonController;
import com.mecanica.microservicios.app.tecnicos.services.ITecnicoService;
import com.mecanica.microservicios.commons.tecnicos.models.entity.Tecnico;

@RestController
public class TecnicoController extends CommonController<Tecnico, ITecnicoService> {

	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable Long id){
		Optional<Tecnico> o = service.findById(id);
		if (o.isEmpty() || o.get().getFoto() == null) {
			return ResponseEntity.notFound().build();
		}
		Resource imagen = new ByteArrayResource(o.get().getFoto()); 
		
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(imagen);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid 
									@RequestBody Tecnico tecnico, 
									BindingResult result, 
									@PathVariable Long id){
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
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

	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> crearConFoto(@Valid 
										  Tecnico tecnico, 
										  BindingResult result,
										  @RequestParam MultipartFile archivo) throws IOException {
		if (!archivo.isEmpty()) {
			tecnico.setFoto(archivo.getBytes());
		}
		return super.crear(tecnico, result);
	}

	@PutMapping("/editar-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid 
										   Tecnico tecnico, 
										   BindingResult result, 
										   @PathVariable Long id, 
										   @RequestParam MultipartFile archivo) throws IOException{
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Tecnico> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Tecnico tecnicoDb = o.get();
		tecnicoDb.setNombre(tecnico.getNombre());
		tecnicoDb.setApellido(tecnico.getApellido());
		tecnicoDb.setEmail(tecnico.getEmail());
		if (!archivo.isEmpty()) {
			tecnicoDb.setFoto(archivo.getBytes());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tecnicoDb));
	}
	
}
