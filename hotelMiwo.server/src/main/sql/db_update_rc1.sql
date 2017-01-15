create schema mydb;

use mydb;

create table ANWENDER (
	id INT NOT NULL AUTO_INCREMENT,
  benutzername VARCHAR(3) NOT NULL UNIQUE,
  passwort VARCHAR(255) NOT NULL,
  email VARCHAR(20) NOT NULL,
	vorname VARCHAR(20) default NULL,
  nachname VARCHAR(20) default NULL,
  job_beschreibung VARCHAR(50) default NULL,
  PRIMARY KEY (id)
);

create table ROLLE (
	id INT NOT NULL AUTO_INCREMENT,
  rolle VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

create table ANWENDER_ROLLE (
	id INT NOT NULL AUTO_INCREMENT,
  benutzername VARCHAR(3) NOT NULL UNIQUE,
  rolle_id VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);