package com.vacunacion.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacunacion.model.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Long>{
	List<Empleado>consultarPorVacuna(Long idVacuna);
	
	Void borrarPorCedula (int cedula);
	
	Empleado consultarPorCedula(int cedula);
}

