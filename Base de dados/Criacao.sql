-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ConfiguraFacil
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ConfiguraFacil
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ConfiguraFacil` DEFAULT CHARACTER SET utf8 ;
USE `ConfiguraFacil` ;

-- -----------------------------------------------------
-- Table `ConfiguraFacil`.`Peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ConfiguraFacil`.`Peca` (
  `Quantidade` INT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Tipo` INT NULL,
  `Custo` FLOAT NULL,
  PRIMARY KEY (`Nome`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ConfiguraFacil`.`Pacote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ConfiguraFacil`.`Pacote` (
  `Nome` VARCHAR(45) NOT NULL,
  `Desconto` FLOAT NULL,
  PRIMARY KEY (`Nome`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ConfiguraFacil`.`Utilizador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ConfiguraFacil`.`Utilizador` (
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Tipo` INT NULL,
  `Nome` VARCHAR(45) NULL,
  PRIMARY KEY (`Email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ConfiguraFacil`.`Modelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ConfiguraFacil`.`Modelo` (
  `Nome` VARCHAR(45) NOT NULL,
  `CustoBase` FLOAT NULL,
  PRIMARY KEY (`Nome`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ConfiguraFacil`.`Carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ConfiguraFacil`.`Carro` (
  `id` VARCHAR(45) NOT NULL,
  `Estado` INT NULL,
  `Data` DATE NULL,
  `Preco` FLOAT NULL,
  `Modelo_Nome` VARCHAR(45) NOT NULL,
  `Utilizador_Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Carro_Modelo1_idx` (`Modelo_Nome` ASC) VISIBLE,
  INDEX `fk_Carro_Utilizador1_idx` (`Utilizador_Email` ASC) VISIBLE,
  CONSTRAINT `fk_Carro_Modelo1`
    FOREIGN KEY (`Modelo_Nome`)
    REFERENCES `ConfiguraFacil`.`Modelo` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Carro_Utilizador1`
    FOREIGN KEY (`Utilizador_Email`)
    REFERENCES `ConfiguraFacil`.`Utilizador` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ConfiguraFacil`.`Pacote_Modelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ConfiguraFacil`.`Pacote_Modelo` (
  `Modelo_Nome` VARCHAR(45) NOT NULL,
  `Pacote_Nome` VARCHAR(45) NOT NULL,
  INDEX `fk_Pacote_Modelo_Modelo1_idx` (`Modelo_Nome` ASC) VISIBLE,
  INDEX `fk_Pacote_Modelo_Pacote1_idx` (`Pacote_Nome` ASC) VISIBLE,
  CONSTRAINT `fk_Pacote_Modelo_Modelo1`
    FOREIGN KEY (`Modelo_Nome`)
    REFERENCES `ConfiguraFacil`.`Modelo` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pacote_Modelo_Pacote1`
    FOREIGN KEY (`Pacote_Nome`)
    REFERENCES `ConfiguraFacil`.`Pacote` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ConfiguraFacil`.`Peca_Carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ConfiguraFacil`.`Peca_Carro` (
  `Carro_id` VARCHAR(45) NOT NULL,
  `Colocada` TINYINT NULL,
  `Peca_Nome` VARCHAR(45) NOT NULL,
  INDEX `fk_Peca_Carro_Carro1_idx` (`Carro_id` ASC) VISIBLE,
  INDEX `fk_Peca_Carro_Peca1_idx` (`Peca_Nome` ASC) VISIBLE,
  CONSTRAINT `fk_Peca_Carro_Carro1`
    FOREIGN KEY (`Carro_id`)
    REFERENCES `ConfiguraFacil`.`Carro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peca_Carro_Peca1`
    FOREIGN KEY (`Peca_Nome`)
    REFERENCES `ConfiguraFacil`.`Peca` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ConfiguraFacil`.`Peca_Pacote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ConfiguraFacil`.`Peca_Pacote` (
  `Pacote_Nome` VARCHAR(45) NOT NULL,
  `Peca_Nome` VARCHAR(45) NOT NULL,
  INDEX `fk_Peca_Pacote_Pacote1_idx` (`Pacote_Nome` ASC) VISIBLE,
  INDEX `fk_Peca_Pacote_Peca1_idx` (`Peca_Nome` ASC) VISIBLE,
  CONSTRAINT `fk_Peca_Pacote_Pacote1`
    FOREIGN KEY (`Pacote_Nome`)
    REFERENCES `ConfiguraFacil`.`Pacote` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peca_Pacote_Peca1`
    FOREIGN KEY (`Peca_Nome`)
    REFERENCES `ConfiguraFacil`.`Peca` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ConfiguraFacil`.`Peca_Peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ConfiguraFacil`.`Peca_Peca` (
  `Tipo` TINYINT NOT NULL,
  `idPeca1` VARCHAR(45) NOT NULL,
  `idPeca2` VARCHAR(45) NOT NULL,
  INDEX `fk_Peca_Peca_Peca1_idx` (`idPeca1` ASC) VISIBLE,
  INDEX `fk_Peca_Peca_Peca2_idx` (`idPeca2` ASC) VISIBLE,
  CONSTRAINT `fk_Peca_Peca_Peca1`
    FOREIGN KEY (`idPeca1`)
    REFERENCES `ConfiguraFacil`.`Peca` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peca_Peca_Peca2`
    FOREIGN KEY (`idPeca2`)
    REFERENCES `ConfiguraFacil`.`Peca` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
