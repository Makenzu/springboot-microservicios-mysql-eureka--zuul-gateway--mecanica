package com.mecanica.microservicios.app.vehiculos.services;

import com.mecanica.microservicios.app.commons.services.ICommonService;
import com.mecanica.microservicios.app.vehiculos.models.entity.Vehiculo;

public interface IVehiculoService extends ICommonService<Vehiculo> {

	public Vehiculo findVehiculoByTecnicoId(Long id);
}
