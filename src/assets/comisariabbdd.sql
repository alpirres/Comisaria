DROP DATABASE `comisaria`;
CREATE DATABASE `comisaria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `comisaria`;

CREATE TABLE IF NOT EXISTS `correo` (
  `IDSosp` int(20) unsigned NOT NULL,
  `dircorreo` char(30) NOT NULL,
  PRIMARY KEY (`IDSosp`,`dircorreo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `direccion` (
  `IDSosp` int(20) unsigned NOT NULL,
  `NomDir` char(40) NOT NULL,
  PRIMARY KEY (`IDSosp`,`NumTel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `matricula` (
  `IDSosp` int(20) unsigned NOT NULL,
  `NumMat` char(7) NOT NULL,
  PRIMARY KEY (`IDSosp`,`NumMat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `sospechoso` (
  `IDSosp` int(20) unsigned NOT NULL,
  `Nombre` char(25) NOT NULL,
  `Apellidos` char(40) NOT NULL,
  `Antecedentes` blob NOT NULL,
  PRIMARY KEY (`IDSosp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `telefono` (
  `IDSosp` int(20) unsigned NOT NULL,
  `NumTel` int(10) NOT NULL,
  PRIMARY KEY (`IDSosp`,`NumTel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `correo`
  ADD CONSTRAINT `correo_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `direccion`
  ADD CONSTRAINT `direccion_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `matricula`
  ADD CONSTRAINT `matricula_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `telefono`
  ADD CONSTRAINT `telefono_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;
