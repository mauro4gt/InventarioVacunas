package com.vacunacion.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vacunacion.model.Vacuna;


public interface IVacunaService {
	
	public List<Vacuna> findAll();

	public void save(Vacuna cliente);
	
	public Vacuna findOne(Long id);
	
	public void delete(Long id);

	Vacuna consultarPorTipoVacuna(String tipoVacuna);	
	Vacuna consultarPorFechaVacuna(Date fechaVacunacion);
	Vacuna consultarPorNumeroDosisVacuna(Integer numeroDosis);
	
}
