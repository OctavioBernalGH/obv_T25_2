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