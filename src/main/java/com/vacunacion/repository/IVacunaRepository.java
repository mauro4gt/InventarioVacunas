package com.vacunacion.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vacunacion.model.Vacuna;


public interface IVacunaRepository extends JpaRepository<Vacuna, Long>{

	Vacuna consultarPorTipoVacuna(String tipoVacuna);
	Vacuna consultarPorFechaVacuna(Date fechaVacunacion);
	Vacuna consultarPorNumeroDosisVacuna(Integer numeroDosis);
}

