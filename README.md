<table>
 <tr>
    <td width="100px"><img src="https://github.com/OctavioBernalGH/BTC_Reus2022_UD16/blob/main/dou_logo.png" alt="Team DOU"/></td>
  <td width="1000px"> <h2> Spring + JPA + H2 + Maven Ejercicio 2 Unidad 25 </h2> </td>
  
 </tr>
</table>

[![Java](https://img.shields.io/badge/Java-FrontEnd-informational)]()
[![JBuilder](https://img.shields.io/badge/JBuilder-View-critical)]()
[![JUnit 5](https://img.shields.io/badge/JUnit%205-Testing-success)]()
[![GitHub](https://img.shields.io/badge/GitHub-Repository-lightgrey)]()
[![SQL](https://img.shields.io/badge/SQL-DataBase-yellowgreen)]()
[![Spring](https://img.shields.io/badge/Spring-infrastructure-brightgreen)]()
[![Maven](https://img.shields.io/badge/Maven-ProjectStructure-blueviolet)]()

Este ejercicio ha sido realizado por los miembros del equipo 1. Dicho equipo esta formado por:

  [- Ixabel Justo Etxeberria](https://github.com/Kay-Nicte)<br>
  [- J.Oriol López Bosch](https://github.com/mednologic)<br>
  [- Octavio Bernal](https://github.com/OctavioBernalGH)<br>
  [- David Dalmau](https://github.com/DavidDalmauDieguez)

<p align="justify">Se crea un proyecto Maven utilizando la tecnología spring, se definen como componentes los spring services, la base de datos H2 y JPA. Se crea la estructura de proyecto en capas definiendo los paquetes de controllers, dao, dto y services. Para proseguir se crean las entidades 'almacenes' y 'cajas' con una relación de uno a muchos (one to many). Se definen las columnas y mediante anotaciones se mapea con los atributos de la entidad.</p>

<p align="justify">Antes de proceder con la creación de paquetes y estructuras se definirán los parámetros de acceso a la base de datos H2, para ello se añaden las siguiente línas en el fichero 'application.propierties' ubicado en 'src/main/resources/.</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/103035621/169650442-7c57e6ec-69cd-42de-a819-2d1a3c47fee4.png">
</p>

<p align="justify">A vez este definido el application.propierties se procederá a la creación de la estructura de proyecto, en este caso queda tal que así:</p>

<p align="center">
    <img src="https://user-images.githubusercontent.com/103035621/169650398-a6a9164f-31a8-494a-b6c3-e12d9d036ef1.png">
</p>

Para proseguir se crearán dos entidades, la entidad empleados y la entidad departamentos, para ello se crearán dos clases en el paquete DTO. El código de la clase empleados será el mostrado a continuación:

```java
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

```

Es muy importante a la hora de crear el código verificar las anotaciones necesarias para la aplicación. En este caso se utilizan las anotaciones "entity" y "table" para decir al programa que esta clase representa una entidad y que está asociada a la tabla 'x'. También se utiliza la anotación "Column" para realizar el mapeo entre columna/atributo. El siguiente código a visualziar es el de la entidad "departamentos".

```java
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

```

A diferencia de la otra clase en esta se utiliza la etiqueta "JsonIgnore" para eliminar la recursividad. En esta entidad vendrá la etiqueta "OneToMany" puesto que la 'N' está en el lado de empleados.

El siguiente paso será crear el DAO. Para ello hay que dirigirse al paquete DAO y crear dos interfaces, una llamada EmpleadosDAO y la otra DepartamentosDAO:

```java
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
```

Ambas interfaces heredan la clase JpaRepository para poder utilizar los métodos predefinidos en JPA para el acceso a la base de datos y las sentencias propias de Jpa. En el siguiente fragmento de código se podrá observar el mismo funcionamiento:

```java
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
```

Una vez finalizada la capa DAO se tendrán que crear dos interfaces más en la capa Services, dichas interfaces definirán la cabecera de los métodos que se utilizarán a lo largo del programa. A continuación se muestra el código de la interfaz 'EmpleadosService'.

```java
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
```

Para acabar el tema de las interfaces se realizará el mismo procedimiento en la interfaz 'DepartamentosService'.

```java
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

```

Como se podrá observar en todo el código es muy importante el uso de comentarios puesto que cada ejercicio realizado es una 'plantilla' en caso de necesidad. Es un buen hábito.

Continuando con el programa, lo siguiente será implementar las interfaces creadas en las clases 'EmpleadosServiceImpl' y 'DepartamentosServiceImpl'.

```java
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
		return empleadosDAO.findById(dni).get();
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

``` 

En ambas clases se utilizan los métodos de las interfaces de forma obligatoria. Muy importante el uso de la anotación @Service en ambas clases puesto que sin esta anotación la aplicación no funcionará, dicha anotación es utilizada para construir una clase de Servicio que habitualmente se conecta a varios repositorios.

```java
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

```

Una vez este finalizado el DTO, DAO y service se procederá a desarrollar la capa Controllers. En este paquete se ubicarán los controladores de Empleados y Departamentos, para ello se crean dos clases.

```java
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
	public Empleados buscarEmpleadoId(@PathVariable (name = "id") String dni) {
		return empleadosServiceImpl.buscarEmpleadoId(dni);
	}

	/** Método para buscar un empleado por DNI y modificar el empleado */
	@PutMapping("/empleados/{id}")
	public Empleados actualizarEmpleado(@PathVariable(name = "id") String dni, @RequestBody Empleados empleados) {
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
	public void eliminarEmpleado(@PathVariable(name = "id") String dni) {
		empleadosServiceImpl.eliminarEmpleado(dni);
	}
}

```

Como se podrá observar en el siguiente fragmento de código, se da uso a la anotación @RestController para indicar al aplicativo Spring que esta clase es un controllador del tipo rest, y también la anotación @RequestMapping("/api") para indicarle que las funcionalidades colgarán de la ruta del servidor:puerto/api/funcionalides. 

En el siguiente fragmento de código se desarrolla el controlador de Departamentos:

```java
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
	public Departamentos buscarDepartamentosId(@PathVariable(name = "id") Long codigo) {
		return departamentosServiceImpl.buscarDepartamentosId(codigo);

	}

	/** Método para eliminar un departamento */
	@PutMapping("/departamentos/{id}")
	public Departamentos actualizarDepartamento(@PathVariable(name = "id") Long codigo,
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
	public void eliminarDepartamento(@PathVariable(name = "id") Long codigo) {
		departamentosServiceImpl.eliminarDepartamento(codigo);
		System.out.println("Departamento eliminado con exito.");
	}
}

```

Ahora que está el aplicativo Java terminado se procederá a crear el Script con las creación de tablas y con inserts para verificar su correcto funcionamiento con la herramienta postman. Para ello se añadirá el siguiente código en el fichero data.sql ubicado en la carpeta src:

```sql
DROP table IF EXISTS `empleados`;
DROP table IF EXISTS `departamentos`;

CREATE TABLE `departamentos` (
  `codigo` int,
  `nombre` nvarchar(100) NOT NULL,
  `presupuesto` int NOT NULL,
  PRIMARY KEY (`codigo`)
);

CREATE TABLE `empleados` (
  `dni` varchar(8),
  `nombre` nvarchar(100) NOT NULL,
  `apellidos` nvarchar(255) NOT NULL,
  `empleado_dni` int,
  PRIMARY KEY (`dni`),
  CONSTRAINT `fk_empleados` FOREIGN KEY (`empleado_dni`) REFERENCES `departamentos`(`codigo`)
);

insert into  `departamentos` (codigo, nombre, presupuesto) VALUES (1, 'Ciencias', 150000);
insert into  `departamentos` (codigo, nombre, presupuesto) VALUES (2, 'Arte', 5454544);
insert into  `departamentos` (codigo, nombre, presupuesto) VALUES (3, 'Tecnología', 41282245);
insert into  `departamentos` (codigo, nombre, presupuesto) VALUES (4, 'Informática', 1417522);
insert into  `departamentos` (codigo, nombre, presupuesto) VALUES (5, 'Gimnasia', 428570);

insert into `empleados` (dni, nombre, apellidos, empleado_dni) VALUES ('00000x', 'paco', 'peres', 1);
insert into `empleados` (dni, nombre, apellidos, empleado_dni) VALUES ('11111z', 'pacomer', 'peresoso', 2);
insert into `empleados` (dni, nombre, apellidos, empleado_dni) VALUES ('22222s', 'paquita', 'peresosa', 3);
insert into `empleados` (dni, nombre, apellidos, empleado_dni) VALUES ('33333a', 'paquito', 'pereson', 4);
insert into `empleados` (dni, nombre, apellidos, empleado_dni) VALUES ('44444b', 'paca', 'peresona', 5);
```
