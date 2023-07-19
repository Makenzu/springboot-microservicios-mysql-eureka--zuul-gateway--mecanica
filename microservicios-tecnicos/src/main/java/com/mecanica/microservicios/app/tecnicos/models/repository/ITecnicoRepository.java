package com.mecanica.microservicios.app.tecnicos.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mecanica.microservicios.commons.tecnicos.models.entity.Tecnico;

public interface ITecnicoRepository extends CrudRepository<Tecnico, Long> {

	@Query("select a from Tecnico a where a.nombre like %?1% or a.apellido like %?1%")
	public List<Tecnico> findByNameOrLastname(String texto);
}
