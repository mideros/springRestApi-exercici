/*	DROP TABLE IF EXISTS `PAINTING`;
	DROP TABLE IF EXISTS `SHOP` ;
	DROP TABLE IF EXISTS `AUTHOR` ;
	DROP SCHEMA IF EXISTS `whitecollardb`;

	CREATE SCHEMA IF NOT EXISTS `WHITECOLLARDB` DEFAULT CHARACTER SET utf8 ;
	USE `WHITECOLLARDB` ;	*/

CREATE TABLE  `SHOP` (
`ID_SHOP` INT NOT NULL AUTO_INCREMENT,
  `NAME_SHOP` VARCHAR(255) NOT NULL,
  `MAX_CAPACITY_SHOP` INT NOT NULL,
  PRIMARY KEY (`ID_SHOP`),
  UNIQUE INDEX `ID_SHOP_UNIQUE` (`ID_SHOP` ASC));


CREATE TABLE  `AUTHOR` (
  `ID_AUTHOR` INT NOT NULL AUTO_INCREMENT,
  `NAME_AUTHOR` VARCHAR(45) NOT NULL,
  `ANONYMOUS_AUTHOR` TINYINT NOT NULL,
  PRIMARY KEY (`ID_AUTHOR`),
  UNIQUE INDEX `ID_AUTHOR_UNIQUE` (`ID_AUTHOR` ASC));


CREATE TABLE  `PAINTING` (
  `ID_PAINTING` INT NOT NULL AUTO_INCREMENT,
  `NAME_PAINTING` VARCHAR(255) NOT NULL,
  `PRICE_PAINTING` DECIMAL(10,2) NOT NULL,
  `ENTRY_DATE_PAINTING` DATETIME DEFAULT NULL,
  `AUTHOR_ID` INT NOT NULL,
  `SHOP_ID` INT NOT NULL,
  PRIMARY KEY (`ID_PAINTING`),
  CONSTRAINT `FK_PAINTING_AUTHOR`
    FOREIGN KEY (`AUTHOR_ID`)
    REFERENCES `AUTHOR` (`ID_AUTHOR`),
  CONSTRAINT `FK_PAINTING_SHOP1`
    FOREIGN KEY (`SHOP_ID`)
    REFERENCES `SHOP` (`ID_SHOP`));