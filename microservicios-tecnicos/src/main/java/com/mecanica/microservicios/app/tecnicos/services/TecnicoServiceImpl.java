package com.mecanica.microservicios.app.tecnicos.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mecanica.microservicios.app.commons.services.CommonServiceImpl;
import com.mecanica.microservicios.app.tecnicos.models.repository.ITecnicoRepository;
import com.mecanica.microservicios.commons.tecnicos.models.entity.Tecnico;

@Service
public class TecnicoServiceImpl extends CommonServiceImpl<Tecnico, ITecnicoRepository> implements ITecnicoService {

	@Override
	@Transactional(readOnly = true)
	public List<Tecnico> findByNameOrLastname(String texto) {
		return repository.findByNameOrLastname(texto);
	}


}
