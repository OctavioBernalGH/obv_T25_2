package com.crud.spring.services;

import java.util.List;

import com.crud.spring.dto.Empleados;

/**
 * Interfaz @EmpleadosService con los métodos.
 * 
 * @author Ixabel Justo
 * @author Josep Oriol López
 * @author David Dalmau
 * @author Octavio Bernal
 *
 */
public interface EmpleadosService {

	/** Devolver una lista de empleados */
	public List<Empleados> listarEmpleados();

	/** Crea un empleado del tipo Empleados */
	public Empleados guardarEmpleado(Empleados empleados);

	/** Buscar un empleado por DNI */
	public Empleados buscarEmpleadoId(String dni);

	/** Lista empleados por nombre de empleado */
	public List<Empleados> listarEmpleadoNombre(String nombre);

	/** Modificar un empleado del tipo Empleados */
	public Empleados actualizarEmpleado(Empleados empleados);

	/** Eliminar un empleado filtrando por el DNI */
	public void eliminarEmpleado(String dni);
}
