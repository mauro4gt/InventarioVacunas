package com.vacunacion.model;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@NamedQueries({
    @NamedQuery(name = "Empleado.consultarPorVacuna", query = "SELECT e FROM Empleado e where vacuna.id = :idVacuna"),
    @NamedQuery(name = "Empleado.consultarPorCedula", query = "SELECT a FROM Empleado a where cedula = :cedula"),
    @NamedQuery(name = "Empleado.borrarPorCedula", query = "DELETE FROM Empleado e where cedula = :cedula")

})

@Entity
@Table (name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	//@Pattern(regexp="^[0-9]{10}",message="length must be 10")  
	private int cedula;
	
	//@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String nombre;
	
	//@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String apellido;
	
	//@Column(name = "correo", nullable=false, length=60)
	//@Email(message = "El valor debe ser un correo válido!")
	private String correo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd ")
	@JsonFormat(pattern = "yyyy-MM-dd ", timezone = "GMT+8")
	private Date fechaNacimiento;
	
	private String direccionDomicilio;
	
	private int telefonoMovil;
	
	private String estadoVacuna;
	
	
	@OneToOne
	@JoinColumn (name="id_vacuna")
	private Vacuna vacuna;
	
	
	
	public Empleado() {
	}



	public Empleado(Long id, int cedula, String nombre, String apellido, String correo, Date fechaNacimiento,
			String direccionDomicilio, int telefonoMovil, String estadoVacuna, Vacuna vacuna) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionDomicilio = direccionDomicilio;
		this.telefonoMovil = telefonoMovil;
		this.estadoVacuna = estadoVacuna;
		this.vacuna = vacuna;
	}
	
	public Empleado(Long id, int cedula, String nombre, String apellido, String correo, Date fechaNacimiento,
			String direccionDomicilio, int telefonoMovil, String estadoVacuna) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionDomicilio = direccionDomicilio;
		this.telefonoMovil = telefonoMovil;
		this.estadoVacuna = estadoVacuna;
		
	}

	public Empleado(Long id, int cedula, String nombre, String apellido, String correo) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}
	
	public Empleado(Date fechaNacimiento, String direccionDomicilio, int telefonoMovil, String estadoVacuna, Vacuna vacuna) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.direccionDomicilio = direccionDomicilio;
		this.telefonoMovil = telefonoMovil;
		this.estadoVacuna = estadoVacuna;
		this.vacuna = vacuna;
	}
	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getCedula() {
		return cedula;
	}



	public void setCedula(int cedula) {
		this.cedula = cedula;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getDireccionDomicilio() {
		return direccionDomicilio;
	}



	public void setDireccionDomicilio(String direccionDomicilio) {
		this.direccionDomicilio = direccionDomicilio;
	}



	public int getTelefonoMovil() {
		return telefonoMovil;
	}



	public void setTelefonoMovil(int telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}



	public String getEstadoVacuna() {
		return estadoVacuna;
	}



	public void setEstadoVacuna(String estadoVacuna) {
		this.estadoVacuna = estadoVacuna;
	}



	public Vacuna getVacuna() {
		return vacuna;
	}



	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}
	
	
	
}
