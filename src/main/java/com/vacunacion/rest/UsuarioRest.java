package com.vacunacion.rest;

import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vacunacion.model.Empleado;
import com.vacunacion.model.Vacuna;
import com.vacunacion.service.IEmpleadoService;
import com.vacunacion.service.IVacunaService;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioRest {

	@Autowired
	private IEmpleadoService serviceEmpleado;
	
	@Autowired
	private IVacunaService serviceVacuna;	

	@GetMapping(value = "/listarDatosEmpleado", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	ResponseEntity<List<Empleado>> listarDatosEmpleado(){
		var listaEmpleado = serviceEmpleado.findAll();
		return ResponseEntity.ok(listaEmpleado);
	}
	
	@GetMapping(value = "/listarDatosEmpleado/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	ResponseEntity <?> listarDatosEmpleadoId(@PathVariable("id") Long id){
		var listaEmpleadoId = serviceEmpleado.findOne(id);
		return ResponseEntity.ok(listaEmpleadoId);
	}
	
	@GetMapping(value = "/listarDatosVacuna", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	ResponseEntity<List<Vacuna>> listarDatosVacuna(){
		var listaVacuna = serviceVacuna.findAll();
		return ResponseEntity.ok(listaVacuna);
	}
	
	@GetMapping(value = "/listarDatosVacuna/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	ResponseEntity <?> listarDatosVacunaId(@PathVariable("id") Long id){
		var listaVacunaId = serviceVacuna.findOne(id);
		return ResponseEntity.ok(listaVacunaId);
	}	
	
	@PostMapping("/consultarEmpleadosPorTipoVacuna")
	ResponseEntity <List<Empleado>> listarEmpleadoTipoVacuna (@RequestParam String tipoVacuna ){
		Vacuna vacuna= serviceVacuna.consultarPorTipoVacuna(tipoVacuna);
		

		if(vacuna==null)
		{
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
		List<Empleado> listaEmpleado = new ArrayList<Empleado>(); 
		listaEmpleado = serviceEmpleado.consultarPorVacuna(vacuna.getId());
		return new ResponseEntity<>(listaEmpleado,HttpStatus.OK);
	}



	
	@PostMapping("/consultarEmpleadosPorFechaVacuna")
	ResponseEntity <List<Empleado>> listarEmpleadoFechaVacuna (@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaVacunacion){
		Vacuna vacuna= serviceVacuna.consultarPorFechaVacuna(fechaVacunacion);
		

		if(vacuna==null)
		{
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
		List<Empleado> listaEmpleado = new ArrayList<Empleado>(); 
		listaEmpleado = serviceEmpleado.consultarPorVacuna(vacuna.getId());
		return new ResponseEntity<>(listaEmpleado,HttpStatus.OK);
	}
	
	@PostMapping("/consultarEmpleadosPorNumeroDosisVacuna")
	ResponseEntity <List<Empleado>> listarEmpleadoNumeroDosis (@RequestParam Integer numeroDosis){
		Vacuna vacuna= serviceVacuna.consultarPorNumeroDosisVacuna(numeroDosis);
		

		if(vacuna==null)
		{
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
		List<Empleado> listaEmpleado = new ArrayList<Empleado>(); 
		listaEmpleado = serviceEmpleado.consultarPorVacuna(vacuna.getId());
		return new ResponseEntity<>(listaEmpleado,HttpStatus.OK);
	}
	
		
	@PostMapping("/guardarVacuna")
	ResponseEntity <List<Vacuna>> guardarVacuna (@RequestParam String tipoVacuna,@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaVacunacion, @RequestParam Integer numeroDosis) {
		Vacuna vacuna = new Vacuna();
		vacuna.setTipoVacuna(tipoVacuna);
		vacuna.setFechaVacunacion(fechaVacunacion);
		vacuna.setNumeroDosis(numeroDosis);		
		serviceVacuna.save(vacuna);		
		List<Vacuna> mostrarVacuna = new ArrayList<Vacuna>();
		mostrarVacuna = serviceVacuna.findAll();
		return new ResponseEntity<>(mostrarVacuna,HttpStatus.OK);
 
	}

	@PostMapping("/guardarEmpleado")
	ResponseEntity <List<Empleado>> guardarEmpleado (@RequestParam int cedula,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String correo,
			@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaNacimiento, @RequestParam String direccionDomicilio,@RequestParam int telefonoMovil,@RequestParam String estadoVacuna){
		
		Empleado empleado = new Empleado();
		empleado.setCedula(cedula);
		empleado.setNombre(nombre);
		empleado.setApellido(apellido);
		empleado.setCorreo(correo);
		empleado.setFechaNacimiento(fechaNacimiento);
		empleado.setDireccionDomicilio(direccionDomicilio);
		empleado.setTelefonoMovil(telefonoMovil);
		empleado.setEstadoVacuna(estadoVacuna);
		
		serviceEmpleado.save(empleado);
		List<Empleado> mostrarEmpleado = new ArrayList<Empleado>();
		mostrarEmpleado = serviceEmpleado.findAll();
		return new ResponseEntity<>(mostrarEmpleado,HttpStatus.OK);
		
		
	}
	
	@PostMapping("/guardarEmpleadoYVacuna")
	ResponseEntity <List<Empleado>> guardarEmpleadoYVacuna (@RequestParam int cedula,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String correo,
			@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaNacimiento, @RequestParam String direccionDomicilio,@RequestParam int telefonoMovil,@RequestParam String estadoVacuna,
			@RequestParam String tipoVacuna,@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaVacunacion, @RequestParam Integer numeroDosis) {
		Vacuna vacuna = new Vacuna();
		vacuna.setTipoVacuna(tipoVacuna);
		vacuna.setFechaVacunacion(fechaVacunacion);
		vacuna.setNumeroDosis(numeroDosis);		
		serviceVacuna.save(vacuna);		
		
		Empleado empleado = new Empleado();
		empleado.setCedula(cedula);
		empleado.setNombre(nombre);
		empleado.setApellido(apellido);
		empleado.setCorreo(correo);
		empleado.setFechaNacimiento(fechaNacimiento);
		empleado.setDireccionDomicilio(direccionDomicilio);
		empleado.setTelefonoMovil(telefonoMovil);
		empleado.setEstadoVacuna(estadoVacuna);
		empleado.setVacuna(vacuna);
		serviceEmpleado.save(empleado);
		List<Empleado> mostrarEmpleado = new ArrayList<Empleado>();
		mostrarEmpleado = serviceEmpleado.findAll();
		return new ResponseEntity<>(mostrarEmpleado,HttpStatus.OK);
	}	
	
	@PostMapping("/eliminarEmpleadoPorCedula")
	ResponseEntity <List<Empleado>> guardarVacuna (@RequestParam int cedula) {
		Empleado empleado  = serviceEmpleado.consultarPorCedula(cedula);
		serviceEmpleado.delete(empleado.getId());
		serviceVacuna.delete(empleado.getVacuna().getId());
		var listaEmpleado = serviceEmpleado.findAll();
		return ResponseEntity.ok(listaEmpleado);
	}
		
	@PostMapping("/editarEmpleadoYVacuna")
	ResponseEntity <List<Empleado>> editarEmpleadoValores (@RequestParam int cedula,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String correo,
			@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaNacimiento, @RequestParam String direccionDomicilio,@RequestParam int telefonoMovil,@RequestParam String estadoVacuna,
			@RequestParam String tipoVacuna,@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaVacunacion, @RequestParam Integer numeroDosis) {		
		
		Empleado empleado  = serviceEmpleado.consultarPorCedula(cedula);
		Vacuna vacuna = serviceVacuna.findOne(empleado.getVacuna().getId());
		
		if(cedula != empleado.getCedula())
			empleado.setCedula(cedula);
		if(nombre != empleado.getNombre())
			empleado.setNombre(nombre);
		if(apellido != empleado.getApellido())
			empleado.setApellido(apellido);
		if(correo != empleado.getCorreo())
			empleado.setCorreo(correo);
		if(fechaNacimiento != empleado.getFechaNacimiento())
			empleado.setFechaNacimiento(fechaNacimiento);
		if(direccionDomicilio != empleado.getDireccionDomicilio())
			empleado.setDireccionDomicilio(direccionDomicilio);
		if(telefonoMovil != empleado.getTelefonoMovil())
			empleado.setTelefonoMovil(telefonoMovil);
		if(estadoVacuna != empleado.getEstadoVacuna())
			empleado.setEstadoVacuna(estadoVacuna);
		
		if(tipoVacuna != vacuna.getTipoVacuna())
			vacuna.setTipoVacuna(tipoVacuna);
		if(fechaVacunacion != vacuna.getFechaVacunacion())
			vacuna.setFechaVacunacion(fechaVacunacion);
		if(numeroDosis != vacuna.getNumeroDosis())
			vacuna.setNumeroDosis(numeroDosis);
			
		
		empleado.setVacuna(vacuna);
		
		serviceEmpleado.save(empleado);
	
		
		List<Empleado> mostrarEmpleado = new ArrayList<Empleado>();
		mostrarEmpleado = serviceEmpleado.findAll();
		return new ResponseEntity<>(mostrarEmpleado,HttpStatus.OK);
		

	}

	
}
