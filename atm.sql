-- MySQL Script generated by MySQL Workbench
-- Sun Mar 17 19:50:41 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema atm
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema atm
-- -----------------------------------------------------
CREATE DATABASE `atm` DEFAULT CHARACTER SET utf8 ;
USE `atm` ;

-- -----------------------------------------------------
-- Table `atm`.`tipo_identificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`tipo_identificacion` ;

CREATE TABLE IF NOT EXISTS `atm`.`tipo_identificacion` (
  `id_identificacion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_identificacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`usuario` ;

CREATE TABLE IF NOT EXISTS `atm`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `identificacion` VARCHAR(15) NULL,
  `tipo_identificacion` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `celular` VARCHAR(10) NULL,
  `email` VARCHAR(45) NULL,
  `fec_creacion` DATETIME NULL,
  `fec_actualiza` DATETIME NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `identificacion_UNIQUE` (`identificacion` ASC),
  INDEX `fk_usuario_identificacion_idx` (`tipo_identificacion` ASC),
  CONSTRAINT `fk_usuario_identificacion`
    FOREIGN KEY (`tipo_identificacion`)
    REFERENCES `atm`.`tipo_identificacion` (`id_identificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`banco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`banco` ;

CREATE TABLE IF NOT EXISTS `atm`.`banco` (
  `id_banco` INT NOT NULL AUTO_INCREMENT,
  `nit` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(10) NULL,
  PRIMARY KEY (`id_banco`),
  UNIQUE INDEX `nit_UNIQUE` (`nit` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`cajero`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`cajero` ;

CREATE TABLE IF NOT EXISTS `atm`.`cajero` (
  `id_cajero` INT NOT NULL AUTO_INCREMENT,
  `id_banco` INT NOT NULL,
  `saldo` DECIMAL(12,2) NOT NULL,
  `ubicacion` VARCHAR(45) NULL,
  `ind_servicio` INT NOT NULL,
  PRIMARY KEY (`id_cajero`),
  INDEX `fk_cajero_banco1_idx` (`id_banco` ASC),
  CONSTRAINT `fk_cajero_banco1`
    FOREIGN KEY (`id_banco`)
    REFERENCES `atm`.`banco` (`id_banco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`transaccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`transaccion` ;

CREATE TABLE IF NOT EXISTS `atm`.`transaccion` (
  `id_transaccion` INT NOT NULL AUTO_INCREMENT,
  `id_cajero` INT NOT NULL,
  `fec_creación` DATETIME NOT NULL,
  `ind_estado` INT NOT NULL,
  `valor` DECIMAL(12,2) NULL,
  PRIMARY KEY (`id_transaccion`),
  INDEX `fk_transaccion_cajero1_idx` (`id_cajero` ASC),
  CONSTRAINT `fk_transaccion_cajero1`
    FOREIGN KEY (`id_cajero`)
    REFERENCES `atm`.`cajero` (`id_cajero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`producto` ;

CREATE TABLE IF NOT EXISTS `atm`.`producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`estado` ;

CREATE TABLE IF NOT EXISTS `atm`.`estado` (
  `id_estado` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_estado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`cuenta` ;

CREATE TABLE IF NOT EXISTS `atm`.`cuenta` (
  `id_cuenta` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NOT NULL,
  `id_banco` INT NOT NULL,
  `id_producto` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  `id_estado` INT NOT NULL,
  `saldo` DECIMAL(12,2) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cuenta`),
  INDEX `fk_cuenta_usuario1_idx` (`id_usuario` ASC),
  INDEX `fk_cuenta_producto1_idx` (`id_producto` ASC),
  INDEX `fk_cuenta_estado1_idx` (`id_estado` ASC),
  INDEX `fk_cuenta_banco1_idx` (`id_banco` ASC),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC),
  CONSTRAINT `fk_cuenta_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `atm`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cuenta_producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `atm`.`producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cuenta_estado1`
    FOREIGN KEY (`id_estado`)
    REFERENCES `atm`.`estado` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cuenta_banco1`
    FOREIGN KEY (`id_banco`)
    REFERENCES `atm`.`banco` (`id_banco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`tarjeta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`tarjeta` ;

CREATE TABLE IF NOT EXISTS `atm`.`tarjeta` (
  `id_tarjeta` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NOT NULL,
  `id_cuenta` INT NOT NULL,
  `id_estado` INT NOT NULL,
  `validthru` DATE NOT NULL,
  `ind_block` INT NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `fec_creacion` DATETIME NULL,
  PRIMARY KEY (`id_tarjeta`),
  INDEX `fk_tarjeta_cuenta1_idx` (`id_cuenta` ASC),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC),
  INDEX `fk_tarjeta_estado1_idx` (`id_estado` ASC),
  CONSTRAINT `fk_tarjeta_cuenta1`
    FOREIGN KEY (`id_cuenta`)
    REFERENCES `atm`.`cuenta` (`id_cuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarjeta_estado1`
    FOREIGN KEY (`id_estado`)
    REFERENCES `atm`.`estado` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`movimiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`movimiento` ;

CREATE TABLE IF NOT EXISTS `atm`.`movimiento` (
  `id_movimiento` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_movimiento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `atm`.`detalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `atm`.`detalle` ;

CREATE TABLE IF NOT EXISTS `atm`.`detalle` (
  `id_detalle` INT NOT NULL AUTO_INCREMENT,
  `id_transaccion` INT NOT NULL,
  `id_movimiento` INT NOT NULL,
  `id_cuenta` INT NOT NULL,
  `id_tarjeta` INT NULL,
  `monto` DECIMAL(12,2) NULL,
  PRIMARY KEY (`id_detalle`, `id_transaccion`),
  INDEX `fk_detalle_transaccion1_idx` (`id_transaccion` ASC),
  INDEX `fk_detalle_movimiento1_idx` (`id_movimiento` ASC),
  INDEX `fk_detalle_tarjeta1_idx` (`id_tarjeta` ASC),
  INDEX `fk_detalle_cuenta1_idx` (`id_cuenta` ASC),
  CONSTRAINT `fk_detalle_transaccion1`
    FOREIGN KEY (`id_transaccion`)
    REFERENCES `atm`.`transaccion` (`id_transaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_movimiento1`
    FOREIGN KEY (`id_movimiento`)
    REFERENCES `atm`.`movimiento` (`id_movimiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_tarjeta1`
    FOREIGN KEY (`id_tarjeta`)
    REFERENCES `atm`.`tarjeta` (`id_tarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_cuenta1`
    FOREIGN KEY (`id_cuenta`)
    REFERENCES `atm`.`cuenta` (`id_cuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
