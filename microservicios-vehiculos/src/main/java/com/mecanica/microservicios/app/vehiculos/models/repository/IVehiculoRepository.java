package com.mecanica.microservicios.app.vehiculos.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mecanica.microservicios.app.vehiculos.models.entity.Vehiculo;

public interface IVehiculoRepository extends CrudRepository<Vehiculo, Long> {

	@Query("select v from Vehiculo v join fetch v.tecnicos a where a.id =?1")
	public Vehiculo findVehiculoByTecnicoId(Long id);
}
