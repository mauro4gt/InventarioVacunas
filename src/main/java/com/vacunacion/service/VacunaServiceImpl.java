package com.vacunacion.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vacunacion.model.Empleado;
import com.vacunacion.model.Vacuna;
import com.vacunacion.repository.IEmpleadoRepository;
import com.vacunacion.repository.IVacunaRepository;

@Service
public class VacunaServiceImpl implements IVacunaService{

	@Autowired
	private IVacunaRepository vacunaDao;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Vacuna> findAll() {
		// TODO Auto-generated method stub
		return vacunaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Vacuna vacuna) {
		// TODO Auto-generated method stub
		vacunaDao.save(vacuna);
	}

	@Override
	@Transactional(readOnly = true)
	public Vacuna findOne(Long id) {
		// TODO Auto-generated method stub
		return vacunaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		vacunaDao.deleteById(id);
	}

	@Override
	public Vacuna consultarPorTipoVacuna(String tipoVacuna) {
		// TODO Auto-generated method stub
		Vacuna vacuna=vacunaDao.consultarPorTipoVacuna(tipoVacuna);
		
		return vacuna;
	}

	@Override	
	public Vacuna consultarPorFechaVacuna(Date fechaVacunacion) {
		// TODO Auto-generated method stub
		Vacuna vacuna=vacunaDao.consultarPorFechaVacuna(fechaVacunacion);
		return vacuna;
	}

	@Override
	public Vacuna consultarPorNumeroDosisVacuna(Integer numeroDosis) {
		// TODO Auto-generated method stub
		Vacuna vacuna=vacunaDao.consultarPorNumeroDosisVacuna(numeroDosis);
		return vacuna;
	}


}
