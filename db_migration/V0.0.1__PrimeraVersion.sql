-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SONY
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SONY
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SONY` DEFAULT CHARACTER SET utf8 ;
USE `SONY` ;

-- -----------------------------------------------------
-- Table `SONY`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`Producto` ;

CREATE TABLE IF NOT EXISTS `SONY`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `precio` FLOAT NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `idMarca` INT NOT NULL,
  `idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_Producto_Marca1_idx` (`idMarca` ASC),
  INDEX `fk_Producto_Categoria1_idx` (`idCategoria` ASC),
  CONSTRAINT `fk_Producto_Marca1`
    FOREIGN KEY (`idMarca`)
    REFERENCES `SONY`.`Marca` (`idMarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `SONY`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`Proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`Proveedor` ;

CREATE TABLE IF NOT EXISTS `SONY`.`Proveedor` (
  `proveedor` VARCHAR(45) NOT NULL,
  `idProveedor` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`Marca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`Marca` ;

CREATE TABLE IF NOT EXISTS `SONY`.`Marca` (
  `idMarca` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMarca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `SONY`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`Producto` ;

CREATE TABLE IF NOT EXISTS `SONY`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `precio` FLOAT NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `idMarca` INT NOT NULL,
  `idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_Producto_Marca1_idx` (`idMarca` ASC),
  INDEX `fk_Producto_Categoria1_idx` (`idCategoria` ASC),
  CONSTRAINT `fk_Producto_Marca1`
    FOREIGN KEY (`idMarca`)
    REFERENCES `SONY`.`Marca` (`idMarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `SONY`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`Vendedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`Vendedor` ;

CREATE TABLE IF NOT EXISTS `SONY`.`Vendedor` (
  `idVendedores` INT NOT NULL AUTO_INCREMENT,
  `vendedor` VARCHAR(100) NOT NULL,
  `comision` FLOAT NOT NULL,
  PRIMARY KEY (`idVendedores`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`Local`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`Local` ;

CREATE TABLE IF NOT EXISTS `SONY`.`Local` (
  `idLocales` INT NOT NULL AUTO_INCREMENT,
  `local` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idLocales`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`ProductosPorLocal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`ProductosPorLocal` ;

CREATE TABLE IF NOT EXISTS `SONY`.`ProductosPorLocal` (
  `idLocales` INT NOT NULL,
  `idProducto` INT NOT NULL,
  `stock` INT NULL,
  `stockMinimo` INT NULL,
  `stockMaximo` INT NULL,
  PRIMARY KEY (`idLocales`, `idProducto`),
  INDEX `fk_Locales_has_Producto_Producto1_idx` (`idProducto` ASC),
  INDEX `fk_Locales_has_Producto_Locales1_idx` (`idLocales` ASC),
  CONSTRAINT `fk_Locales_has_Producto_Locales1`
    FOREIGN KEY (`idLocales`)
    REFERENCES `SONY`.`Local` (`idLocales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locales_has_Producto_Producto1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `SONY`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `SONY`.`Cliente` (
  `username` VARCHAR(100) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `razonSocial` VARCHAR(100) NOT NULL,
  `idClientes` INT NOT NULL AUTO_INCREMENT,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  PRIMARY KEY (`idClientes`));


-- -----------------------------------------------------
-- Table `SONY`.`VentaDetalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`VentaDetalle` ;

CREATE TABLE IF NOT EXISTS `SONY`.`VentaDetalle` (
  `idProducto` INT NOT NULL,
  `cantidad` INT NULL,
  `comision` FLOAT NULL,
  `importeComision` FLOAT NULL,
  `precio` FLOAT NULL,
  `idVenta` INT NOT NULL,
  PRIMARY KEY (`idProducto`, `idVenta`),
  INDEX `fk_Vendedores_has_Producto_Producto1_idx` (`idProducto` ASC),
  CONSTRAINT `fk_Vendedores_has_Producto_Producto1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `SONY`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`ProductoProveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`ProductoProveedor` ;

CREATE TABLE IF NOT EXISTS `SONY`.`ProductoProveedor` (
  `idProducto` INT NOT NULL,
  `idProveedor` INT NOT NULL,
  PRIMARY KEY (`idProducto`, `idProveedor`),
  INDEX `fk_Producto_has_Provedores_Provedores1_idx` (`idProveedor` ASC),
  INDEX `fk_Producto_has_Provedores_Producto1_idx` (`idProducto` ASC),
  CONSTRAINT `fk_Producto_has_Provedores_Producto1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `SONY`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Provedores_Provedores1`
    FOREIGN KEY (`idProveedor`)
    REFERENCES `SONY`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SONY`.`Venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SONY`.`Venta` ;

CREATE TABLE IF NOT EXISTS `SONY`.`Venta` (
  `idVenta` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NULL,
  `idVendedor` INT NULL,
  `idCliente` INT NULL,
  `idLocal` INT NULL,
  PRIMARY KEY (`idVenta`),
  INDEX `fk_Ventas_Locales1_idx` (`idLocal` ASC),
  INDEX `fk_Ventas_Clientes1_idx` (`idCliente` ASC),
  INDEX `fk_Ventas_Vendedores1_idx` (`idVendedor` ASC),
  CONSTRAINT `fk_Ventas_Locales1`
    FOREIGN KEY (`idLocal`)
    REFERENCES `SONY`.`Local` (`idLocales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ventas_Clientes1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `SONY`.`Cliente` (`idClientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ventas_Vendedores1`
    FOREIGN KEY (`idVendedor`)
    REFERENCES `SONY`.`Vendedor` (`idVendedores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

