package com.crud.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.spring.dto.Empleados;
/**
 * Clase @EmpleadosDAO
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */
public interface EmpleadosDAO extends JpaRepository<Empleados, String>{

}
