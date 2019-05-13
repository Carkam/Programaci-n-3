-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-03-2019 a las 02:55:31
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nomina`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE `concepto` (
  `concodigo` varchar(10) NOT NULL,
  `connombre` varchar(50) DEFAULT NULL,
  `conefecto` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `concepto`
--

INSERT INTO `concepto` (`concodigo`, `connombre`, `conefecto`) VALUES
('1', 'Sueldo Base', '+'),
('2', 'Bonificación', '+'),
('3', 'Comisiones', '+'),
('4', 'IGSS', '-'),
('5', 'ISR', '-'),
('6', 'Descuentos Judiciales', '-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `depcodigo` varchar(10) NOT NULL,
  `depnombre` varchar(50) DEFAULT NULL,
  `depestatus` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`depcodigo`, `depnombre`, `depestatus`) VALUES
('1', 'Informatica', 1),
('2', 'Contabilidad', 1),
('3', 'Publicidad y Mercadotecnia', 1),
('4', 'Finanzas', 1),
('5', 'Dirección General', 1),
('6', 'Auxiliar Administrativo', 1),
('7', 'Recursos Humanos', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `empcodigo` varchar(10) NOT NULL,
  `empnombre` varchar(50) NOT NULL,
  `sueldo_emp` double(10,2) DEFAULT NULL,
  `depcodigo` varchar(10) NOT NULL,
  `codigo_puesto` varchar(10) NOT NULL,
  `empestatus` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`empcodigo`, `empnombre`, `sueldo_emp`, `depcodigo`, `codigo_puesto`, `empestatus`) VALUES
('1', 'Carlos Laib', 15000.00, '1', '1', 1),
('2', 'Jose Lopez', 5000.00, '1', '1', 1),
('3', 'Fernando Argueta', 6000.00, '2', '2', 1),
('4', 'Bryan Aguirre', 7500.00, '2', '2', 1),
('5', 'Bryan Mazariegoz', 7000.00, '4', '9', 1),
('6', 'Alexis Urias', 6500.00, '6', '6', 1),
('7', 'Ricardo Perez', 7500.00, '3', '5', 1),
('8', 'Sergio Orozco', 8000.00, '7', '8', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nominadetalles`
--

CREATE TABLE `nominadetalles` (
  `nomicodigo` varchar(10) NOT NULL,
  `empcodigo` varchar(10) NOT NULL,
  `concodigo` varchar(10) NOT NULL,
  `nomidtotal` double(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nominadetalles`
--

INSERT INTO `nominadetalles` (`nomicodigo`, `empcodigo`, `concodigo`, `nomidtotal`) VALUES
('1', '1', '1', 15000.00),
('1', '1', '2', 500.00),
('1', '1', '3', 500.00),
('1', '1', '4', 724.50),
('1', '1', '5', 1500.00),
('1', '2', '1', 5000.00),
('1', '2', '4', 241.50),
('1', '2', '5', 150.00),
('1', '3', '1', 6000.00),
('1', '3', '2', 250.00),
('1', '3', '4', 289.80),
('1', '3', '5', 300.00),
('1', '3', '6', 1000.00),
('1', '5', '1', 7000.00),
('1', '5', '4', 338.10),
('1', '5', '5', 350.00),
('1', '6', '1', 6500.00),
('1', '6', '3', 1000.00),
('1', '6', '4', 313.95),
('1', '6', '5', 325.00),
('1', '6', '6', 1200.00),
('1', '8', '1', 8000.00),
('1', '8', '4', 386.40),
('1', '8', '5', 400.00),
('2', '2', '1', 5000.00),
('2', '2', '2', 300.00),
('2', '2', '4', 241.50),
('2', '2', '5', 150.00),
('2', '2', '6', 300.00),
('2', '4', '1', 7500.00),
('2', '4', '2', 250.00),
('2', '4', '3', 250.00),
('2', '4', '4', 362.25),
('2', '4', '5', 375.00),
('2', '4', '6', 500.00),
('2', '7', '1', 7500.00),
('2', '7', '2', 250.00),
('2', '7', '3', 250.00),
('2', '7', '4', 362.25),
('2', '7', '5', 375.00),
('3', '1', '1', 15000.00),
('3', '2', '1', 5000.00),
('3', '3', '1', 6000.00),
('3', '4', '1', 7500.00),
('3', '5', '1', 7000.00),
('3', '6', '1', 6500.00),
('3', '7', '1', 7500.00),
('3', '8', '1', 8000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nominaencabezado`
--

CREATE TABLE `nominaencabezado` (
  `nomicodigo` varchar(10) NOT NULL,
  `fecha_inicial_nomina` date DEFAULT NULL,
  `fecha_final_nomina` date DEFAULT NULL,
  `nomimonto` double(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nominaencabezado`
--

INSERT INTO `nominaencabezado` (`nomicodigo`, `fecha_inicial_nomina`, `fecha_final_nomina`, `nomimonto`) VALUES
('1', '2019-03-01', '2019-03-02', 42230.75),
('2', '2019-03-03', '2019-03-31', 18634.00),
('3', '2019-04-01', '2019-04-30', 62500.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puestos`
--

CREATE TABLE `puestos` (
  `codigo_puesto` varchar(10) NOT NULL,
  `depnombre` varchar(50) DEFAULT NULL,
  `depestatus` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `puestos`
--

INSERT INTO `puestos` (`codigo_puesto`, `depnombre`, `depestatus`) VALUES
('1', 'Programador', 1),
('2', 'Secretaria', 1),
('3', 'Director Ejecutivo', 1),
('4', 'Gerente', 1),
('5', 'Jefe de Marketing', 1),
('6', 'Conserge', 1),
('7', 'Director Comercial', 1),
('8', 'Director de Recursos Humanos', 1),
('9', 'Director Financiero', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `codigo_usuario` varchar(10) NOT NULL,
  `nombre_usuario` varchar(10) DEFAULT NULL,
  `clave_usuario` varchar(10) DEFAULT NULL,
  `estado_usuario` tinyint(1) DEFAULT NULL,
  `empcodigo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`codigo_usuario`, `nombre_usuario`, `clave_usuario`, `estado_usuario`, `empcodigo`) VALUES
('1', 'kami', '1', 1, '1'),
('2', 'chipa', '123', 1, '2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `concepto`
--
ALTER TABLE `concepto`
  ADD PRIMARY KEY (`concodigo`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`depcodigo`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`empcodigo`),
  ADD KEY `FK_departamentosempleados` (`depcodigo`),
  ADD KEY `FK_puestosempleados` (`codigo_puesto`);

--
-- Indices de la tabla `nominadetalles`
--
ALTER TABLE `nominadetalles`
  ADD PRIMARY KEY (`nomicodigo`,`empcodigo`,`concodigo`),
  ADD KEY `FK_empleadosnominadetalle` (`empcodigo`),
  ADD KEY `FK_conceptonominadetalle` (`concodigo`);

--
-- Indices de la tabla `nominaencabezado`
--
ALTER TABLE `nominaencabezado`
  ADD PRIMARY KEY (`nomicodigo`);

--
-- Indices de la tabla `puestos`
--
ALTER TABLE `puestos`
  ADD PRIMARY KEY (`codigo_puesto`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`codigo_usuario`),
  ADD KEY `FK_empleadosusuarios` (`empcodigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `FK_departamentosempleados` FOREIGN KEY (`depcodigo`) REFERENCES `departamentos` (`depcodigo`),
  ADD CONSTRAINT `FK_puestosempleados` FOREIGN KEY (`codigo_puesto`) REFERENCES `puestos` (`codigo_puesto`);

--
-- Filtros para la tabla `nominadetalles`
--
ALTER TABLE `nominadetalles`
  ADD CONSTRAINT `FK_conceptonominadetalle` FOREIGN KEY (`concodigo`) REFERENCES `concepto` (`concodigo`),
  ADD CONSTRAINT `FK_empleadosnominadetalle` FOREIGN KEY (`empcodigo`) REFERENCES `empleados` (`empcodigo`),
  ADD CONSTRAINT `FK_nominaencabezadonominadetalle` FOREIGN KEY (`nomicodigo`) REFERENCES `nominaencabezado` (`nomicodigo`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK_empleadosusuarios` FOREIGN KEY (`empcodigo`) REFERENCES `empleados` (`empcodigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
