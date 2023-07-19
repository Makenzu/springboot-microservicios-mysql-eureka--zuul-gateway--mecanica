package com.mecanica.microservicios.app.vehiculos.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mecanica.microservicios.commons.tecnicos.models.entity.Tecnico;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String patente;
	private String modelo;
	private String marca;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Tecnico> tecnicos;
	
	@PrePersist
	public void prePersistDate() {
		this.createAt = new Date();
	}
	
	// Inicializamos tecnicos
	public Vehiculo() {
		this.tecnicos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}
	
	public void addTecnicos(Tecnico tecnico) {
		this.tecnicos.add(tecnico);
	}
	
	public void removeTecnicos(Tecnico tecnico) {
		this.tecnicos.remove(tecnico);
	}

}
