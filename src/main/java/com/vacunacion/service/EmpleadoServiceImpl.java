package com.vacunacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunacion.model.Empleado;
import com.vacunacion.model.Vacuna;
import com.vacunacion.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoRepository empleadoRepo;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return empleadoRepo.findAll();
	}

	@Override
	@Transactional
	public void save(Empleado empleado) {
		// TODO Auto-generated method stub
		empleadoRepo.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findOne(Long id) {
		// TODO Auto-generated method stub
		return empleadoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		empleadoRepo.deleteById(id);
	}

	@Override
	public List<Empleado> consultarPorVacuna(Long idVacuna) {
		List<Empleado> empleados=new ArrayList<>();
		empleados=empleadoRepo.consultarPorVacuna(idVacuna);
		return empleados;
	}
/*
	@Override
	public Void borrarPorCedula(int cedula) {
		// TODO Auto-generated method stub
		empleadoRepo.borrarPorCedula(cedula);
		return null;
	}
*/

	@Override
	public Empleado consultarPorCedula(int cedula) {
		// TODO Auto-generated method stub
		Empleado empleados=null;
		empleados=empleadoRepo.consultarPorCedula(cedula);
		return empleados;
	
	}

	@Override
	public Void borrarPorCedula(int cedula) {
		// TODO Auto-generated method stub
		empleadoRepo.borrarPorCedula(cedula);
		return null;
	}

		
		
}
