
# istoe
Sistema de Julgamento de Fatos - IstoE


# Banco de dados

Criar schema no banco de dados, com o nome "istoe"

# Requests

## US0

### > Cadastrar professor

POST http://localhost:8080/api/professores
{
	"nome": "Lesandro",
	"login": "lesandro",
	"senha": "1234",
	"email": "lesandro@gmail.com"
}

### > Buscar Professor

GET http://localhost:8080/api/professores?login=lesandro


### > Login

GET http://localhost:8080/api/login?login=lesandro&senha=1234



## US1

### > Cadastrar Aluno

POST http://localhost:8080/api/alunos

{
	"nome": "Eduardo Reis",
	"login": "edsilveira.reis",
	"senha": "023",
	"curso": "Sistemas de informação",
	"email": "edsilveira.reis@gmail.com"
}

### > Buscar Aluno:

GET http://localhost:8080/api/alunos?login=edsilveira.reis



## US2

### > Cadastrar Turma:

POST http://localhost:8080/api/turmas

{
	"disciplina": "Projeto de Sistemas de Informação",
	"curso": "Sistemas de informação",
	"unidade": "Barreiro",
	"idProfessor": 1
}


### > Buscar Turma especifica

GET http://localhost:8080/api/turmas/{idTurma}


### > Buscar Alunos do curso

GET http://localhost:8080/api/alunos?curso=Sistemas de informação

### > Adicionar aluno à turma

POST http://localhost:8080/api/turmas/{idTurma}/alunos

{
	"idAluno": 53
}


## US3

### > Cadastrar JF:

POST http://localhost:8080/api/jfs

{
	"idTurma": 1,
	"status": "CRIACAO",
	"tamMaxEquipes": 10,
	"tempoMaxExibicaoFato": 5
}

### > Cadastrar Fato:

POST http://localhost:8080/api/fatos

{
	"idJf": 1,
	"ordem": 2,
	"conteudo": "Quantos padroes GRASP existem?",
	"topicoDisciplina": "Padrao de projeto",
	"resposta": "V"
}

### > Definir status JF:

PATCH http://localhost:8080/api/jfs/{idJf}

{
	"status": "PREPARACAO"
}

### > Buscar JFs da Turma:

GET http://localhost:8080/api/jfs?idTurma=1

## US4





