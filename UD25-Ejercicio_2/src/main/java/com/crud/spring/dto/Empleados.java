package com.crud.spring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase @Empleados se utiliza para mappear
 * las columnas con los atributos de clase.
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */

/** Definimos que la clase representa una entidad */
@Entity
@Table(name = "empleados")

public class Empleados {

	/** La columna ID es del tipo autoincremental */
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	 */

	/** Se mapea la columna con el atributo correspondiente */
	@Id
	@Column(name = "dni")
	private String dni;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	/**
	 * Se define una relación de muchos a uno mediante la anotación
	 * 
	 * @ManyToOne utilizando la columna "empleado_dni" como referencia de esta
	 *            tabla.
	 */
	@ManyToOne
	@JoinColumn(name = "empleado_dni")
	private Departamentos departamentos;

	/** Constructor por defecto */
	public Empleados() {
	}

	/**
	 * Constructor con todos los atributos.
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param departamentos
	 */
	public Empleados(String dni, String nombre, String apellidos, Departamentos departamentos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamentos = departamentos;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the departamentos
	 */
	public Departamentos getDepartamentos() {
		return departamentos;
	}

	/**
	 * @param departamentos the departamentos to set
	 */
	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

}
