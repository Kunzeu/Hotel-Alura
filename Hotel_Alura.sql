DROP DATABASE IF EXISTS HOTEL_ALURA;
CREATE DATABASE IF NOT EXISTS HOTEL_ALURA;
USE HOTEL_ALURA;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotel_alura
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel_alura
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel_alura` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hotel_alura` ;


-- -----------------------------------------------------
-- Table `hotel_alura`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_alura`.`reservas` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FECHA_ENTRADA` DATE NOT NULL,
  `FECHA_SALIDA` DATE NOT NULL,
  `VALOR` BIGINT NOT NULL,
  `FORMA_PAGO` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `hotel_alura`.`huespedes`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `hotel_alura`.`huespedes` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NULL DEFAULT NULL,
  `APELLIDO` VARCHAR(45) NULL DEFAULT NULL,
  `FECHA_NACIMIENTO` DATE NOT NULL,
  `NACIONALIDAD` VARCHAR(25) NULL DEFAULT NULL,
  `TELEFONO` VARCHAR(25) NULL DEFAULT NULL,
  `ID_RESERVA` INT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (ID_RESERVA) REFERENCES reservas (ID) ON DELETE CASCADE ON UPDATE CASCADE)
  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;




CREATE TABLE IF NOT EXISTS USUARIOS(
	ID INT NOT NULL AUTO_INCREMENT,
    USUARIO VARCHAR(150) UNIQUE NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    
    PRIMARY KEY(ID)
);

SET FOREIGN_KEY_CHECKS=0;
