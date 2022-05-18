package com.crud.spring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.spring.dao.DepartamentosDAO;
import com.crud.spring.dto.Departamentos;

/**
 * Esta clase implementa los mñetodos de la interfaz @DepartamentosService
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */
@Service
public class DepartamentosServiceImpl implements DepartamentosService {

	@Autowired
	DepartamentosDAO departamentosDAO;

	@Override
	public List<Departamentos> listarDepartamentos() {
		return departamentosDAO.findAll();
	}

	/** Método para crear un departamento. */
	@Override
	public Departamentos guardarDepartamento(Departamentos departamentos) {
		return departamentosDAO.save(departamentos);
	}

	/** Método para buscar un departamento por ID. */
	@Override
	public Departamentos buscarDepartamentosId(Long codigo) {
		return departamentosDAO.findById(codigo).get();
	}

	/** Método para devolver una lista de departamentos por nombre. */
	@Override
	public List<Departamentos> listarDepartamentoNombre(String nombre) {
		return null;
	}

	/** Método para modificar un departamento */
	@Override
	public Departamentos actualizarDepartamento(Departamentos departamentos) {
		return departamentosDAO.save(departamentos);
	}

	/** Método para eliminar un departamento mediante el código */
	@Override
	public void eliminarDepartamento(Long codigo) {
		departamentosDAO.deleteById(codigo);

	}

}
