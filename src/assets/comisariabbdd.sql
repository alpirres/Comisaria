CREATE DATABASE IF NOT EXISTS `comisaria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `comisaria`;
CREATE TABLE IF NOT EXISTS `correo` (
  `IDSosp` int(20) unsigned NOT NULL,
  `DirCor` char(30) NOT NULL,
  PRIMARY KEY (`IDSosp`,`DirCor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `direccion` (
  `IDSosp` int(20) unsigned NOT NULL,
  `NomDir` char(40) NOT NULL,
  PRIMARY KEY (`IDSosp`,`NomDir`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `foto` (
  `IDSosp` int(20) unsigned NOT NULL,
  `IDFoto` int(20) unsigned NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `ImgData` blob NOT NULL,
  PRIMARY KEY (`IDSosp`,`IDFoto`)
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
  `Antecedentes` blob DEFAULT NULL,
  `Hechos` blob DEFAULT NULL,
  PRIMARY KEY (`IDSosp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `telefono` (
  `IDSosp` int(20) unsigned NOT NULL,
  `NumTel` varchar(9) NOT NULL,
  PRIMARY KEY (`IDSosp`,`NumTel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `correo`
  ADD CONSTRAINT `correo_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `direccion`
  ADD CONSTRAINT `direccion_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `foto`
  ADD CONSTRAINT `foto_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `matricula`
  ADD CONSTRAINT `matricula_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `telefono`
  ADD CONSTRAINT `telefono_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;