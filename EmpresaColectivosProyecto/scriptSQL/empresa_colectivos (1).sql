-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2024 a las 23:28:13
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresa_colectivos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colectivo`
--

CREATE TABLE `colectivo` (
  `idColectivo` int(11) NOT NULL,
  `matricula` varchar(20) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `asientosOcupados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `colectivo`
--

INSERT INTO `colectivo` (`idColectivo`, `matricula`, `marca`, `modelo`, `capacidad`, `estado`, `asientosOcupados`) VALUES
(1, '11', 'Volvo', '4', 50, 1, 13),
(2, '13', 'Mercedes', 'X12', 45, 1, 5),
(3, 'abc123', 'Chevrolet', 'a2', 50, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colectivoruta`
--

CREATE TABLE `colectivoruta` (
  `idColectivoRuta` int(11) NOT NULL,
  `idColectivo` int(11) NOT NULL,
  `idRuta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `colectivoruta`
--

INSERT INTO `colectivoruta` (`idColectivoRuta`, `idColectivo`, `idRuta`) VALUES
(5, 1, 2),
(7, 2, 2),
(9, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `idHorario` int(11) NOT NULL,
  `idRuta` int(11) NOT NULL,
  `horaSalida` time NOT NULL,
  `horaLlegada` time NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`idHorario`, `idRuta`, `horaSalida`, `horaLlegada`, `estado`) VALUES
(1, 1, '06:00:00', '18:10:00', 1),
(2, 2, '10:30:00', '14:30:00', 1),
(7, 1, '12:00:00', '23:00:00', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasaje`
--

CREATE TABLE `pasaje` (
  `idPasaje` int(11) NOT NULL,
  `idPasajero` int(11) NOT NULL,
  `idColectivo` int(11) NOT NULL,
  `idRuta` int(11) NOT NULL,
  `fechaViaje` date NOT NULL,
  `horaViaje` time NOT NULL,
  `asiento` int(10) NOT NULL,
  `precio` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasaje`
--

INSERT INTO `pasaje` (`idPasaje`, `idPasajero`, `idColectivo`, `idRuta`, `fechaViaje`, `horaViaje`, `asiento`, `precio`) VALUES
(16, 1, 2, 2, '2024-06-11', '04:00:00', 5, 400),
(17, 1, 1, 2, '2024-06-06', '04:00:00', 2, 400),
(18, 1, 1, 2, '2024-06-12', '04:00:00', 3, 400),
(19, 1, 1, 2, '2024-06-11', '04:00:00', 4, 400),
(20, 1, 1, 2, '2024-06-13', '04:00:00', 5, 400),
(21, 1, 1, 2, '2024-06-04', '04:00:00', 6, 400),
(22, 1, 1, 2, '2024-06-05', '04:00:00', 7, 400),
(23, 1, 1, 2, '2024-06-01', '04:00:00', 8, 400),
(24, 1, 1, 2, '2024-06-24', '04:00:00', 9, 400),
(25, 1, 1, 2, '2024-06-12', '04:00:00', 10, 400),
(26, 1, 1, 2, '2024-06-11', '04:00:00', 11, 400),
(27, 1, 1, 2, '2024-06-10', '04:00:00', 12, 400),
(28, 2, 1, 2, '2024-06-07', '04:00:00', 13, 400),
(29, 2, 3, 1, '2024-06-06', '12:00:00', 1, 1200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `idPasajero` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` int(20) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` int(20) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajeros`
--

INSERT INTO `pasajeros` (`idPasajero`, `nombre`, `apellido`, `dni`, `correo`, `telefono`, `estado`) VALUES
(1, 'Agustina', 'Gonzalez', 111, 'abc@gmail.com', 135, 1),
(2, 'Viviana', 'Estrada', 222, 'erd@gmail.com', 246, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ruta`
--

CREATE TABLE `ruta` (
  `idRuta` int(11) NOT NULL,
  `origen` varchar(50) NOT NULL,
  `destino` varchar(50) NOT NULL,
  `duracionEstimada` time NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ruta`
--

INSERT INTO `ruta` (`idRuta`, `origen`, `destino`, `duracionEstimada`, `estado`) VALUES
(1, 'Buenos Aires', 'San Luis, capital', '12:00:00', 1),
(2, 'Misiones', 'Corrientes', '04:00:00', 1),
(7, 'asd', 'asd', '04:50:00', 0),
(8, 'asd', 'asd', '04:30:00', 0),
(9, 'asd', 'asd', '04:30:00', 0),
(10, 'asd', 'qewqd', '12:12:00', 0),
(11, 'asd', 'asd', '12:30:00', 0),
(12, 'aa', 'aa', '12:12:00', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `colectivo`
--
ALTER TABLE `colectivo`
  ADD PRIMARY KEY (`idColectivo`);

--
-- Indices de la tabla `colectivoruta`
--
ALTER TABLE `colectivoruta`
  ADD PRIMARY KEY (`idColectivoRuta`),
  ADD UNIQUE KEY `idColectivo` (`idColectivo`),
  ADD KEY `idRuta` (`idRuta`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`idHorario`),
  ADD KEY `idRuta` (`idRuta`);

--
-- Indices de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD PRIMARY KEY (`idPasaje`),
  ADD KEY `idPasajero` (`idPasajero`),
  ADD KEY `idColectivo` (`idColectivo`),
  ADD KEY `idruta` (`idRuta`);

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`idPasajero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `ruta`
--
ALTER TABLE `ruta`
  ADD PRIMARY KEY (`idRuta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `colectivo`
--
ALTER TABLE `colectivo`
  MODIFY `idColectivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `colectivoruta`
--
ALTER TABLE `colectivoruta`
  MODIFY `idColectivoRuta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `idHorario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  MODIFY `idPasaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `idPasajero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ruta`
--
ALTER TABLE `ruta`
  MODIFY `idRuta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `colectivoruta`
--
ALTER TABLE `colectivoruta`
  ADD CONSTRAINT `colectivoruta_ibfk_1` FOREIGN KEY (`idColectivo`) REFERENCES `colectivo` (`idColectivo`),
  ADD CONSTRAINT `colectivoruta_ibfk_2` FOREIGN KEY (`idRuta`) REFERENCES `ruta` (`idRuta`);

--
-- Filtros para la tabla `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`idRuta`) REFERENCES `ruta` (`idRuta`);

--
-- Filtros para la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD CONSTRAINT `pasaje_ibfk_1` FOREIGN KEY (`idPasajero`) REFERENCES `pasajeros` (`idPasajero`),
  ADD CONSTRAINT `pasaje_ibfk_2` FOREIGN KEY (`idColectivo`) REFERENCES `colectivo` (`idColectivo`),
  ADD CONSTRAINT `pasaje_ibfk_3` FOREIGN KEY (`idruta`) REFERENCES `ruta` (`idRuta`),
  ADD CONSTRAINT `pasaje_ibfk_4` FOREIGN KEY (`idRuta`) REFERENCES `ruta` (`idRuta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
