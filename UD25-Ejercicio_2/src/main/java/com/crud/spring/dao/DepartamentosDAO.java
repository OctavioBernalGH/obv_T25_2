package com.crud.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.spring.dto.Departamentos;

/**
 * Clase @DepartamentosDAO
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */
public interface DepartamentosDAO extends JpaRepository<Departamentos, Long>{

}
