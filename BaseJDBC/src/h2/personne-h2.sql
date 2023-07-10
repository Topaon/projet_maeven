
DROP TABLE if exists personne;

CREATE TABLE personne(
    id INTEGER auto_increment ,
	prenom VARCHAR(64),
	nom VARCHAR(64),
	PRIMARY KEY(id));                   
                   
INSERT INTO personne (prenom, nom) VALUES ('Simon' , 'Granier');
INSERT INTO personne (prenom, nom) VALUES ('Mathieu' , 'Prosic');
INSERT INTO personne (prenom, nom) VALUES ('Antoine' , 'Clément');

SELECT * from personne;