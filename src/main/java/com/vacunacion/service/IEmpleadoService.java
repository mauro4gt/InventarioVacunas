package com.vacunacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vacunacion.model.Empleado;
import com.vacunacion.model.Vacuna;


public interface IEmpleadoService {
	
	public List<Empleado> findAll();

	public void save(Empleado cliente);
	
	public Empleado findOne(Long id);
	
	public void delete(Long id);
	
	List<Empleado>consultarPorVacuna(Long idVacuna);

	Void borrarPorCedula (int cedula);
	
	Empleado consultarPorCedula(int cedula);
}
