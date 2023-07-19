package com.mecanica.microservicios.app.vehiculos.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mecanica.microservicios.app.commons.services.CommonServiceImpl;
import com.mecanica.microservicios.app.vehiculos.models.entity.Vehiculo;
import com.mecanica.microservicios.app.vehiculos.models.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl extends CommonServiceImpl<Vehiculo, IVehiculoRepository> implements IVehiculoService {

	@Override
	@Transactional(readOnly = true)
	public Vehiculo findVehiculoByTecnicoId(Long id) {
		return repository.findVehiculoByTecnicoId(id);
	}


}
