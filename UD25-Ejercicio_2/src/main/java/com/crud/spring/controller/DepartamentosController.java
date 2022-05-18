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
import com.crud.spring.dto.Departamentos;
import com.crud.spring.services.DepartamentosServiceImpl;

/**
 * Clase @DepartamentosController. Mappea las funcionalidades con las rutas de
 * la api.
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */
@RestController
@RequestMapping("/api")
public class DepartamentosController {

	/** Se crea una instancia del tipo @DepartamentosServiceImpl */
	@Autowired
	DepartamentosServiceImpl departamentosServiceImpl;

	/** Método para listar departamentos */
	@GetMapping("/departamentos")
	public List<Departamentos> listarDepartamentos() {
		return departamentosServiceImpl.listarDepartamentos();
	}

	/** Método para listar departamentos por nombre */
	@GetMapping("/departamentos/nombre/{nombre}")
	public List<Departamentos> listarDepartamentoNombre(@PathVariable(name = "nombre") String nombre) {
		return null;
	}

	/** Método para crear un nuevo departamento */
	@PostMapping("/departamentos")
	public Departamentos guardarDepartamentos(@RequestBody Departamentos departamentos) {
		return departamentosServiceImpl.guardarDepartamento(departamentos);
	}

	/** Método para buscar un departamento por codigo */
	@GetMapping("/departamentos/{id}")
	public Departamentos buscarDepartamentosId(@PathVariable(name = "codigo") Long codigo) {
		return departamentosServiceImpl.buscarDepartamentosId(codigo);

	}

	/** Método para eliminar un departamento */
	@PutMapping("/departamentos/{id}")
	public Departamentos actualizarDepartamento(@PathVariable(name = "codigo") Long codigo,
			@RequestBody Departamentos departamentos) {
		/** Se definen instancias del tipo Departamentos */
		Departamentos departamento_a_actualizar = new Departamentos();
		Departamentos actualizado = new Departamentos();
		/** Se filtra el departamento a actualizar por código */
		departamento_a_actualizar = departamentosServiceImpl.buscarDepartamentosId(codigo);
		/** Se actualizan los valores */
		departamento_a_actualizar.setNombre(departamentos.getNombre());
		departamento_a_actualizar.setPresupuesto(departamentos.getPresupuesto());
		departamento_a_actualizar.setCodigo(departamentos.getCodigo());

		actualizado = departamentosServiceImpl.actualizarDepartamento(departamento_a_actualizar);

		return actualizado;
	}

	/** Método para eliminar un departamento */
	@DeleteMapping("/departamentos/{id}")
	public void eliminarDepartamento(@PathVariable(name = "codigo") Long codigo) {
		departamentosServiceImpl.eliminarDepartamento(codigo);
		System.out.println("Departamento eliminado con exito.");
	}
}
