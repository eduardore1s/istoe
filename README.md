# istoe
Sistema de Julgamento de Fatos - IstoE


#Banco de dados

banco rodando: localhost:3306/istoe_jf

CREATE TABLE `istoe_jf`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idusuario`));

CREATE TABLE `istoe_jf`.`aluno` (
  `idaluno` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `login` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `curso` VARCHAR(45) NULL,
  PRIMARY KEY (`idaluno`));

CREATE TABLE `istoe_jf`.`professor` (
  `idprofessor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `login` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`idprofessor`));





#Requests

##Adicionar Professor

POST http://localhost:8080/api/professores
{
	"nome": "Rommel",
	"login": "rommel",
	"senha": "1234",
	"email": "rommel@gmail.com"
}

##Buscar Professor

GET http://localhost:8080/api/professores?login=rommel

##Adicionar Aluno:

POST http://localhost:8080/api/alunos

{
	"nome": "Eduardo Reis",
	"login": "edsilveira.reis",
	"senha": "023",
	"curso": "Sistemas de informação",
	"email": "edsilveira.reis@gmail.com"
}

##Buscar Aluno:

GET http://localhost:8080/api/alunos?login=edsilveira.reis

##Login:

GET http://localhost:8080/api/login?login=edsilveira.reis&senha=023

##Adicionar Turma:

POST http://localhost:8080/api/turmas

{
	"disciplina": "Projeto de Sistemas de Informação",
	"curso": "Sistemas de informação",
	"unidade": "Barreiro",
	"idProfessor": 2
}


##Buscar Turma especifica

GET http://localhost:8080/api/turmas/{idTurma}






