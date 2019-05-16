CREATE DATABASE `comisaria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `comisaria`;
CREATE TABLE IF NOT EXISTS `acompania` (
  `IDPrinc` bigint(20) unsigned NOT NULL,
  `IDSec` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`IDPrinc`,`IDSec`),
  KEY `IDSec` (`IDSec`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `aparece` (
  `idfoto` int(20) unsigned NOT NULL,
  `IDSosp` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`idfoto`,`IDSosp`),
  KEY `IDSosp` (`IDSosp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `correo` (
  `DirCorreo` varchar(40) NOT NULL,
  PRIMARY KEY (`DirCorreo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `direccion` (
  `NomDir` varchar(50) NOT NULL,
  PRIMARY KEY (`NomDir`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `foto` (
  `Descripcion` blob NOT NULL,
  `IDfoto` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `SrcFoto` varchar(50) NOT NULL,
  PRIMARY KEY (`IDfoto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
CREATE TABLE IF NOT EXISTS `matricula` (
  `NumMat` char(10) NOT NULL,
  PRIMARY KEY (`NumMat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `posee` (
  `IDSosp` bigint(20) unsigned NOT NULL,
  `NumMat` char(10) NOT NULL,
  PRIMARY KEY (`IDSosp`,`NumMat`),
  KEY `NumMat` (`NumMat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `sospechoso` (
  `IDSosp` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` char(25) NOT NULL,
  `Apellidos` char(40) NOT NULL,
  `Antecedentes` blob NOT NULL,
  PRIMARY KEY (`IDSosp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
CREATE TABLE IF NOT EXISTS `telefono` (
  `NumTel` int(9) unsigned NOT NULL,
  PRIMARY KEY (`NumTel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `tiene` (
  `NumTel` int(9) unsigned NOT NULL,
  `IDSosp` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`NumTel`,`IDSosp`),
  KEY `IDSosp` (`IDSosp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `usa` (
  `IDSosp` bigint(20) unsigned NOT NULL,
  `dircorreo` varchar(40) NOT NULL,
  PRIMARY KEY (`IDSosp`,`dircorreo`),
  KEY `dircorreo` (`dircorreo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `vive` (
  `NomDir` varchar(50) NOT NULL,
  `IDSosp` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`NomDir`,`IDSosp`),
  KEY `IDSosp` (`IDSosp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `acompania`
  ADD CONSTRAINT `acompania_ibfk_2` FOREIGN KEY (`IDSec`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `acompania_ibfk_1` FOREIGN KEY (`IDPrinc`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `aparece`
  ADD CONSTRAINT `aparece_ibfk_4` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `aparece_ibfk_3` FOREIGN KEY (`idfoto`) REFERENCES `foto` (`IDfoto`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `posee`
  ADD CONSTRAINT `posee_ibfk_2` FOREIGN KEY (`NumMat`) REFERENCES `matricula` (`NumMat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `posee_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `tiene`
  ADD CONSTRAINT `tiene_ibfk_2` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tiene_ibfk_1` FOREIGN KEY (`NumTel`) REFERENCES `telefono` (`NumTel`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `usa`
  ADD CONSTRAINT `usa_ibfk_2` FOREIGN KEY (`dircorreo`) REFERENCES `correo` (`DirCorreo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usa_ibfk_1` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `vive`
  ADD CONSTRAINT `vive_ibfk_2` FOREIGN KEY (`IDSosp`) REFERENCES `sospechoso` (`IDSosp`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vive_ibfk_1` FOREIGN KEY (`NomDir`) REFERENCES `direccion` (`NomDir`) ON DELETE CASCADE ON UPDATE CASCADE;