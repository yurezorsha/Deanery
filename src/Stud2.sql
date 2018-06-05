drop  database if exists t ; 
create database t;

CREATE TABLE `t`.`group` (
  `id_group` INT NOT NULL COMMENT '',
  `Name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id_group`)  COMMENT '');
  
  INSERT INTO `t`.`group` (`id_group`, `Name`) VALUES ('1', 'It-3');
INSERT INTO `t`.`group` (`id_group`, `Name`) VALUES ('2', 'It-4');
  
  CREATE TABLE `t`.`stud` (
  `id_stud` INT NOT NULL COMMENT '',
  `FirstName` VARCHAR(45) NULL COMMENT '',
  `SurName` VARCHAR(45) NULL COMMENT '',
  `Patronymic` VARCHAR(45) NULL COMMENT '',
  `Group` INT NULL COMMENT '',
  PRIMARY KEY (`id_stud`)  COMMENT '',
  CONSTRAINT `gk`
    FOREIGN KEY (`Group`)
    REFERENCES `t`.`group` (`id_group`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `t`.`stud` (`id_stud`, `FirstName`, `SurName`, `Patronymic`, `Group`) VALUES (10100, 'Anton','Martynov','Lvovich' , 2);
INSERT INTO `t`.`stud` (`id_stud`, `FirstName`, `SurName`, `Patronymic`, `Group`) VALUES (10101, 'Pavel','Marchuk','Petrovich' , 1);
INSERT INTO `t`.`stud` (`id_stud`, `FirstName`, `SurName`, `Patronymic`, `Group`) VALUES (10102, 'Aleksandr','Titenko','Yaroslavovich' , 1);

CREATE TABLE `t`.`teacher` (
  `id_teach` INT NOT NULL COMMENT '',
  `FirstName` VARCHAR(45) NULL COMMENT '',
  `SurName` VARCHAR(45) NULL COMMENT '',
  `Patronymic` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id_teach`)  COMMENT '');
  
  INSERT INTO `t`.`teacher` (`id_teach`, `FirstName`,`SurName`,`Patronymic`) VALUES (1, 'Aleksandr','Dmitriev','Petrovich');
INSERT INTO `t`.`teacher` (`id_teach`, `FirstName`,`SurName`,`Patronymic`) VALUES (2, 'Michail','Baziuk','Sergeevich');


CREATE TABLE `t`.`subject` (
  `id_subj` INT NOT NULL COMMENT '',
  `Name` VARCHAR(45) NULL COMMENT '',
  `Teacher` INT NULL COMMENT '',
  PRIMARY KEY (`id_subj`)  COMMENT '',
  CONSTRAINT `sk`
    FOREIGN KEY (`Teacher`)
    REFERENCES `t`.`teacher` (`id_teach`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `t`.`subject` (`id_subj`, `Name`, `Teacher`) VALUES (1, 'Hight Mathematics' , 1);
INSERT INTO `t`.`subject` (`id_subj`, `Name`, `Teacher`) VALUES (2, 'Operating Systems' , 2);

CREATE TABLE `t`.`mark` (
  `id_mark` INT NOT NULL COMMENT '',
  `Mark` INT NULL COMMENT '',
  `Date` date NULL COMMENT '',
  `Student` INT NULL COMMENT '',
  `Subject` INT NULL COMMENT '',
  
  PRIMARY KEY (`id_mark`)  COMMENT '',
  CONSTRAINT `mkst`
    FOREIGN KEY (`Student`)
    REFERENCES `t`.`stud` (`id_stud`)
    ,
      CONSTRAINT `mksub`
    FOREIGN KEY (`Subject`)
    REFERENCES `t`.`subject` (`id_subj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `t`.`mark` (`id_mark`, `Mark`,`Date`, `Student`,`Subject`) VALUES (1, 9 ,curdate(),10100,1);
INSERT INTO `t`.`mark` (`id_mark`, `Mark`,`Date`, `Student`,`Subject`) VALUES (2, 8 ,curdate(),10101,1);


  