package com.crud.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.spring.dto.Empleados;
import com.crud.spring.services.EmpleadosServiceImpl;

/**
 * Clase @EmpleadosController. Mappea las funcionalidades con las rutas de la
 * api.
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */
@RestController
@RequestMapping("/api")
public class EmpleadosController {

	/** Se crea una instancia del tipo @EmpleadosServiceImpl */
	@Autowired
	EmpleadosServiceImpl empleadosServiceImpl;

	/** Método para listar todos los empleados */
	@GetMapping("/empleados")
	public List<Empleados> listarEmpleados() {
		return empleadosServiceImpl.listarEmpleados();
	}

	/** Método para para listar empleados por nombre */
	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleados> listarEmpleadoNombre(@PathVariable(name = "nombre") String nombre) {
		return null;
	}

	/**
	 * Método para crear un empleado solicitando la introducción de datos en el body
	 * mediante la anotación @RequestBody
	 * 
	 * @param empleados
	 * @return
	 */
	@PostMapping("/empleados")
	public Empleados guardarEmpleado(@RequestBody Empleados empleados) {
		return empleadosServiceImpl.guardarEmpleado(empleados);
	}

	/** Método para buscar un empleado por DNI */
	@GetMapping("/empleados/{id}")
	public Empleados buscarEmpleadoId(@PathVariable (name = "dni") String dni) {
		return empleadosServiceImpl.buscarEmpleadoId(dni);
	}

	/** Método para buscar un empleado por DNI y modificar el empleado */
	@PutMapping("/empleados/{id}")
	public Empleados actualizarEmpleado(@PathVariable(name = "dni") String dni, @RequestBody Empleados empleados) {
		/** Se crean instancias de empleado */
		Empleados empleados_a_actualizar = new Empleados();
		Empleados empleados_ya_actualizados = new Empleados();
		/** Se busca el empleado por DNI para recuperar todos sus datos */
		empleados_a_actualizar = empleadosServiceImpl.buscarEmpleadoId(dni);
		/** Seteamos los nuevos valores en las columnas correspondientes */
		empleados_a_actualizar.setNombre(empleados.getNombre());
		empleados_a_actualizar.setApellidos(empleados.getApellidos());
		empleados_a_actualizar.setDni(empleados.getDni());
		empleados_a_actualizar.setDepartamentos(empleados.getDepartamentos());
		/** Se vuelca la información en una instancia de la clase */
		empleados_ya_actualizados = empleadosServiceImpl.actualizarEmpleado(empleados_a_actualizar);
		/** Se devuelve el nuevo empleado */
		return empleados_ya_actualizados;
	}

	/** Método para eliminar el empleado mediante el DNI */
	@DeleteMapping("/empleados/{id}")
	public void eliminarEmpleado(@PathVariable(name = "dni") String dni) {
		empleadosServiceImpl.eliminarEmpleado(dni);
	}
}
