-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema manage_book_market
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema manage_book_market
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `manage_book_market` DEFAULT CHARACTER SET utf8 ;
USE `manage_book_market` ;

-- -----------------------------------------------------
-- Table `manage_book_market`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `manage_book_market`.`USER` (
  `idUSER` INT NOT NULL AUTO_INCREMENT,
  `PhoneNumber` VARCHAR(10) NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`idUSER`),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE,
  UNIQUE INDEX `PhoneNumber_UNIQUE` (`PhoneNumber` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `manage_book_market`.`CATEGORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `manage_book_market`.`CATEGORY` (
  `idCATEGORY` INT NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(45) NULL,
  PRIMARY KEY (`idBOOK_CATEGORY`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `manage_book_market`.`BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `manage_book_market`.`BOOK` (
  `idBOOK` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(255) NULL,
  `ReleaseTime` YEAR NULL,
  `Description` TEXT NULL,
  `Author` VARCHAR(45) NULL,
  `Price` VARCHAR(45) NULL,
  `PhotoLink` TEXT NULL,
  `CATEGORY_idBOOK_CATEGORY` INT NOT NULL,
  PRIMARY KEY (`idBOOK`),
  INDEX `fk_BOOK_CATEGORY1_idx` (`CATEGORY_idBOOK_CATEGORY` ASC) VISIBLE,
  CONSTRAINT `fk_BOOK_CATEGORY1`
    FOREIGN KEY (`CATEGORY_idBOOK_CATEGORY`)
    REFERENCES `manage_book_market`.`CATEGORY` (`idBOOK_CATEGORY`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `manage_book_market`.`POST_BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `manage_book_market`.`POST_BOOK` (
  `IDPostBook` INT NOT NULL AUTO_INCREMENT,
  `BOOK_idBOOK` INT NOT NULL,
  `USER_idUSER` INT NOT NULL,
  `PostDate` TIMESTAMP(6) NULL,
  PRIMARY KEY (`IDPostBook`),
  INDEX `fk_POST_BOOK_BOOK1_idx` (`BOOK_idBOOK` ASC) VISIBLE,
  INDEX `fk_POST_BOOK_USER1_idx` (`USER_idUSER` ASC) VISIBLE,
  CONSTRAINT `fk_POST_BOOK_BOOK1`
    FOREIGN KEY (`BOOK_idBOOK`)
    REFERENCES `manage_book_market`.`BOOK` (`idBOOK`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_POST_BOOK_USER1`
    FOREIGN KEY (`USER_idUSER`)
    REFERENCES `manage_book_market`.`USER` (`idUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `manage_book_market`.`FAVOURITE_BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `manage_book_market`.`FAVOURITE_BOOK` (
  `IDFavourite` INT NOT NULL AUTO_INCREMENT,
  `USER_idUSER` INT NOT NULL,
  `BOOK_idBOOK` INT NOT NULL,
  `FavoriteDate` TIMESTAMP(6) NULL,
  INDEX `fk_FAVOURITE_BOOK_USER1_idx` (`USER_idUSER` ASC) VISIBLE,
  INDEX `fk_FAVOURITE_BOOK_BOOK1_idx` (`BOOK_idBOOK` ASC) VISIBLE,
  PRIMARY KEY (`IDFavourite`),
  CONSTRAINT `fk_FAVOURITE_BOOK_USER1`
    FOREIGN KEY (`USER_idUSER`)
    REFERENCES `manage_book_market`.`USER` (`idUSER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FAVOURITE_BOOK_BOOK1`
    FOREIGN KEY (`BOOK_idBOOK`)
    REFERENCES `manage_book_market`.`BOOK` (`idBOOK`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
CREATE TABLE IF NOT EXISTS `manage_book_market`.`FAVOURITE_BOOK` (   `IDFavourite` INT NOT NULL AUTO_INCREMENT,   `USER_idUSER` INT NOT NULL,   `BOOK_idBOOK` INT NOT NULL,   `FavoriteDate` TIMESTAMP(6) NULL DEFAULT CURRENT_TIMESTAMP,   INDEX `fk_FAVOURITE_BOOK_USER1_idx` (`USER_idUSER` ASC) VISIBLE,   INDEX `fk_FAVOURITE_BOOK_BOOK1_idx` (`BOOK_idBOOK` ASC) VISIBLE,   PRIMARY KEY (`IDFavourite`),   CONSTRAINT `fk_FAVOURITE_BOOK_USER1`     FOREIGN KEY (`USER_idUSER`)     REFERENCES `manage_book_market`.`USER` (`idUSER`)     ON DELETE NO ACTION     ON UPDATE NO ACTION,   CONSTRAINT `fk_FAVOURITE_BOOK_BOOK1`     FOREIGN KEY (`BOOK_idBOOK`)     REFERENCES `manage_book_market`.`BOOK` (`idBOOK`)     ON DELETE NO ACTION     ON UPDATE NO ACTION) ENGINE = InnoDB
