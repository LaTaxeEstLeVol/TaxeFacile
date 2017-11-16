/*
 * Scripts que serão usados para o ICMS
 */

 /*
  * Script de criação
  */

CREATE DATABASE IF NOT EXISTS TaxeFacile;
Use TaxeFacile;

CREATE TABLE IF NOT EXISTS ICMS (
	idICMS INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	state VARCHAR(18) NOT NULL,
	aliquot DOUBLE NOT NULL,
	initials VARCHAR(2) NOT NULL
);


/*
 * Scripts de inserção no banco de dados para ICMS
 */

INSERT INTO ICMS (state,aliquot,initials) VALUES ("Acre",0.17,"AC");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Alagoas",0.18,"AL");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Amazonas",0.18,"AM");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Amapá",0.18,"AP");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Bahia",0.18,"BA");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Ceará",0.18,"CE");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Distrito Federal",0.18,"DF");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Espírito Santo",0.17,"ES");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Goiás",0.17,"GO");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Maranhão",0.18,"MA");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Mato Grosso",0.17,"MT");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Mato Grosso do Sul",0.17,"MS");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Minas Gerais",0.18,"MG");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Pará",0.17,"PA");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Paraíba",0.18,"PB");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Paraná",0.18,"PR");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Pernambuco",0.18,"PE");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Piauí",0.18,"PI");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Rio Grande do Norte",0.18,"RN");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Rio Grande do Sul",0.18,"RS");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Rio de Janeiro",0.20,"RJ");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Rondônia",0.175,"RO");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Roraima",0.17,"RR");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Santa Catarina",0.17,"SC");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("São Paulo",0.18,"SP");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Sergipe",0.18,"SE");
INSERT INTO ICMS (state,aliquot,initials) VALUES ("Tocantins",0.18,"TO");