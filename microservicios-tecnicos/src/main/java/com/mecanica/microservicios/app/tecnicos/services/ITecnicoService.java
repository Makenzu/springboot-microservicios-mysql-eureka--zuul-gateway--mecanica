package com.mecanica.microservicios.app.tecnicos.services;

import java.util.List;

import com.mecanica.microservicios.app.commons.services.ICommonService;
import com.mecanica.microservicios.commons.tecnicos.models.entity.Tecnico;

public interface ITecnicoService extends ICommonService<Tecnico> {

	public List<Tecnico> findByNameOrLastname(String texto);
}
