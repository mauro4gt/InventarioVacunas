package com.vacunacion.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.util.Date;


import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@NamedQueries({
    @NamedQuery(name = "Vacuna.consultarPorTipoVacuna", query = "SELECT v FROM Vacuna v WHERE v.tipoVacuna = :tipoVacuna"),
    @NamedQuery(name = "Vacuna.consultarPorFechaVacuna", query = "SELECT v FROM Vacuna v WHERE v.fechaVacunacion = :fechaVacunacion"),
    @NamedQuery(name = "Vacuna.consultarPorNumeroDosisVacuna", query = "SELECT v FROM Vacuna v WHERE v.numeroDosis = :numeroDosis")
})



@Entity
@Table (name = "VACUNA")
public class Vacuna {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	private String tipoVacuna;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fechaVacunacion;

	private int numeroDosis;
	
	public Vacuna() {
	}

	public Vacuna(Long id, String tipoVacuna, Date fechaVacunacion, int numeroDosis) {
		super();
		this.id = id;
		this.tipoVacuna = tipoVacuna;
		this.fechaVacunacion = fechaVacunacion;
		this.numeroDosis = numeroDosis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoVacuna() {
		return tipoVacuna;
	}

	public void setTipoVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}

	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public int getNumeroDosis() {
		return numeroDosis;
	}

	public void setNumeroDosis(int numeroDosis) {
		this.numeroDosis = numeroDosis;
	}
	
	
	
}
