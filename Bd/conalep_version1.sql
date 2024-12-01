-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema conalep
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema conalep
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `conalep` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema biblionet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblionet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblionet` ;
USE `conalep` ;

-- -----------------------------------------------------
-- Table `conalep`.`alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conalep`.`alumno` (
  `id_alumno` INT NOT NULL AUTO_INCREMENT,
  `nombreAlumno` VARCHAR(30) NOT NULL,
  `apeliidoAlumno` VARCHAR(65) NOT NULL,
  `direccionAlumno` VARCHAR(30) NOT NULL,
  `telefonoAlumno` VARCHAR(10) NOT NULL,
  `edadAlumno` INT NOT NULL,
  PRIMARY KEY (`id_alumno`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `conalep`.`devoluciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conalep`.`devoluciones` (
  `id_devolucion` INT NOT NULL AUTO_INCREMENT,
  `id_prestamo` INT NOT NULL,
  `cantidadDevuelta` INT NOT NULL,
  PRIMARY KEY (`id_devolucion`),
  INDEX `id_prestamo` (`id_prestamo` ASC) VISIBLE,
  CONSTRAINT `devoluciones_ibfk_1`
    FOREIGN KEY (`id_prestamo`)
    REFERENCES `biblionet`.`prestamo` (`id_prestamo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `conalep`.`encargado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conalep`.`encargado` (
  `id_encargado` INT NOT NULL AUTO_INCREMENT,
  `nombreEncargado` VARCHAR(30) NOT NULL,
  `apellido` VARCHAR(65) NOT NULL,
  `direccion` VARCHAR(30) NOT NULL,
  `telefono` VARCHAR(20) NULL DEFAULT NULL,
  `edad` INT NOT NULL,
  PRIMARY KEY (`id_encargado`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `conalep`.`libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conalep`.`libro` (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `nombreLibro` VARCHAR(50) NOT NULL,
  `categoriaLibro` VARCHAR(30) NOT NULL,
  `editorial` VARCHAR(30) NOT NULL,
  `autor` VARCHAR(25) NOT NULL,
  `numeroPagina` INT NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`id_libro`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `conalep`.`inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conalep`.`inventario` (
  `id_inventario` INT NOT NULL AUTO_INCREMENT,
  `stock` INT NOT NULL,
  `cantidadDisponible` INT NOT NULL,
  `id_libro` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_inventario`),
  INDEX `id_libro` (`id_libro` ASC) VISIBLE,
  CONSTRAINT `fk_libro_id`
    FOREIGN KEY (`id_libro`)
    REFERENCES `conalep`.`libro` (`id_libro`)
    ON DELETE CASCADE,
  CONSTRAINT `id_libro`
    FOREIGN KEY (`id_libro`)
    REFERENCES `conalep`.`libro` (`id_libro`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `conalep`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conalep`.`prestamo` (
  `id_prestamo` INT NOT NULL AUTO_INCREMENT,
  `fecha_prestamo` DATE NOT NULL,
  `fecha_devolucion` DATE NOT NULL,
  `id_libro` INT NOT NULL,
  `id_alumno` INT NOT NULL,
  PRIMARY KEY (`id_prestamo`),
  INDEX `fk_id_libro` (`id_libro` ASC) VISIBLE,
  INDEX `fk_id_alumno` (`id_alumno` ASC) INVISIBLE,
  CONSTRAINT `fk_id_alumno`
    FOREIGN KEY (`id_alumno`)
    REFERENCES `conalep`.`alumno` (`id_alumno`),
  CONSTRAINT `fk_id_libro`
    FOREIGN KEY (`id_libro`)
    REFERENCES `conalep`.`libro` (`id_libro`))
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `conalep`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conalep`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombreUsuario` VARCHAR(40) NOT NULL,
  `contrasena` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `biblionet` ;
USE `conalep`;

DELIMITER $$
USE `conalep`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `conalep`.`loan_delete_update_inventory`
AFTER DELETE ON `conalep`.`prestamo`
FOR EACH ROW
BEGIN
    DECLARE devoluciones_cantidadTotalDevuelta INT;

    -- Obtener la cantidad total devuelta para el préstamo eliminado
    SELECT COALESCE(SUM(cantidadDevuelta), 0) INTO devoluciones_cantidadTotalDevuelta
    FROM devoluciones
    WHERE id_prestamo = OLD.id_prestamo;

    -- Actualizar la cantidad disponible en el inventario
    UPDATE inventario
    SET cantidadDisponible = cantidadDisponible + devoluciones_cantidadTotalDevuelta
    WHERE id_libro = OLD.id_libro;

    -- Actualizar la cantidad en la entidad libro
    UPDATE libro
    SET cantidad = cantidad + devoluciones_cantidadTotalDevuelta
    WHERE id_libro = OLD.id_libro;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
