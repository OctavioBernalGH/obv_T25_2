package com.crud.spring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.spring.dao.EmpleadosDAO;
import com.crud.spring.dto.Empleados;

/**
 * Esta clase implementa los méstodos de la interfaz @EmpleadosService
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */
@Service
public class EmpleadosServiceImpl implements EmpleadosService {

	/** Listar empleados */
	@Autowired
	EmpleadosDAO empleadosDAO;

	@Override
	public List<Empleados> listarEmpleados() {
		return empleadosDAO.findAll();
	}

	/** Método de crear un empleado */
	@Override
	public Empleados guardarEmpleado(Empleados empleados) {
		return empleadosDAO.save(empleados);
	}

	/** Método para buscar un empleado por el DNI */
	@Override
	public Empleados buscarEmpleadoId(String dni) {
		return empleadosDAO.getById(dni);
	}

	/** Método para listar empleados por nombre */
	@Override
	public List<Empleados> listarEmpleadoNombre(String nombre) {
		return null;
	}

	/** Método para actualizar empleados */
	@Override
	public Empleados actualizarEmpleado(Empleados empleados) {
		return empleadosDAO.save(empleados);
	}

	/** Método para eliminar un empleado por el DNI */
	@Override
	public void eliminarEmpleado(String dni) {
		empleadosDAO.deleteById(dni);

	}

}
