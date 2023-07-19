package com.mecanica.microservicios.app.vehiculos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mecanica.microservicios.app.commons.controllers.CommonController;
import com.mecanica.microservicios.app.vehiculos.models.entity.Vehiculo;
import com.mecanica.microservicios.app.vehiculos.services.IVehiculoService;
import com.mecanica.microservicios.commons.tecnicos.models.entity.Tecnico;

@RestController
public class VehiculoController extends CommonController<Vehiculo, IVehiculoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Vehiculo vehiculo, @PathVariable Long id){
		Optional<Vehiculo> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Vehiculo vehiculoDb = o.get();
		vehiculoDb.setPatente(vehiculo.getPatente());
		vehiculoDb.setModelo(vehiculo.getModelo());
		vehiculoDb.setMarca(vehiculo.getMarca());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(vehiculoDb));
	}
	
	@PutMapping("/{id}/asignar-tecnicos")
	public ResponseEntity<?> asignarTecnicos(@RequestBody List<Tecnico> tecnicos, @PathVariable Long id){
		Optional<Vehiculo> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Vehiculo vehiculoDb = o.get();
		
		tecnicos.forEach(a -> {
			vehiculoDb.addTecnicos(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(vehiculoDb));
	}
	
	@PutMapping("/{id}/eliminar-tecnico")
	public ResponseEntity<?> eliminarTecnicos(@RequestBody Tecnico tecnico, @PathVariable Long id){
		Optional<Vehiculo> o = this.service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Vehiculo vehiculoDb = o.get();
		
		vehiculoDb.removeTecnicos(tecnico);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(vehiculoDb));
	}
	
	@GetMapping("/tecnico/{id}")
	public ResponseEntity<?> buscarPorTecnicoId(@PathVariable Long id){
		Vehiculo vehiculo = service.findVehiculoByTecnicoId(id);
		
		return ResponseEntity.ok(vehiculo);
	}
}
