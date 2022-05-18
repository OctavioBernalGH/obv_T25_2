package com.crud.spring.services;

/** Se importa el DTO correspondiente */

import java.util.List;
import com.crud.spring.dto.Departamentos;

/**
 * Interfaz con métodos definidos
 * 
 * @author Ixabel Justo
 * @author Josep Oriol López
 * @author David Dalmau
 * @author Octavio Bernal
 *
 */
public interface DepartamentosService {

	/** Devolver una lista de departamentos */
	public List<Departamentos> listarDepartamentos();

	/** Crea un departamento del tipo Departamentos */
	public Departamentos guardarDepartamento(Departamentos departamentos);

	/** Buscar un departamento por codigo */
	public Departamentos buscarDepartamentosId(Long codigo);

	/** Lista departamentos por nombre de departamento */
	public List<Departamentos> listarDepartamentoNombre(String nombre);

	/** Modificar un departamento del tipo Departamentos */
	public Departamentos actualizarDepartamento(Departamentos departamentos);

	/** Eliminar un departamento por codigo */
	public void eliminarDepartamento(Long codigo);
}
