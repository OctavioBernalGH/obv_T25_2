package com.crud.spring.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Clase @Departamentos se utiliza para mappear
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
@Table(name = "departamentos")

public class Departamentos {

	/** Se mapea la columna con el atributo correspondiente */
	@Id
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "presupuesto")
	private int presupuesto;

	/**
	 * Se establece relación de uno a muchos mediante la anotación OneToMany y se
	 * define la columna codigo como referencia de esta tabla hacia la otra tabla
	 * utilizando un campo identificador de "esta". Se recupera una lista de
	 * empleados.
	 */
	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Empleados> empleados;

	/** Constructor por defecto */
	public Departamentos() {
	}

	/**
	 * Constructor de clase con todos los atributos.
	 * 
	 * @param codigo
	 * @param nombre
	 * @param presupuesto
	 * @param empleados
	 */
	public Departamentos(Long codigo, String nombre, int presupuesto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	 * @return the presupuesto
	 */
	public int getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(List<Empleados> empleados) {
		this.empleados = empleados;
	}

	/** Mediante el JsonIgnore se evita la recursividad en la base de datos */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Empleados")
	public List<Empleados> getEmpleado() {
		return empleados;
	}

}
