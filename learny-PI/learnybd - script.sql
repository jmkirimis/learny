create database learnybd;
use learnybd;

create table alunos(
	idAluno int auto_increment primary key,
    nome varchar(50),
    email varchar(100),
    usuario varchar(50),
    senha varchar(50),
    dataNasc date
);
select * from alunos;
select * from alunos where usuario ="jao" and senha ="123";

create table alunosXemails(
	alunosEmailID int not null primary key,
    idAluno int not null,
    email varchar(100)
);
alter table alunosXemails add constraint fk_aluno_email foreign key(idAluno) references alunos(idAluno);

create table alunosXtelefones(
	alunoTelefoneID int not null primary key,
    idAluno int not null,
    telefone varchar(14)
);
alter table alunosXtelefones add constraint fk_aluno_telefone foreign key(idAluno) references alunos(idAluno);

create table mundos(
	idMundo int not null primary key,
    nivel int,
    tema varchar(50),
    qtdFases int
);

create table fases(
	idFase int not null primary key,
    idMundo int not null,
    tipo varchar(50),
    dificuldade varchar(50)
);
alter table fases add constraint fk_mundo foreign key(idMundo) references mundos(idMundo);

create table fasesConcluidas(
	idFaseConcluida int not null primary key,
    idFase int not null,
    idAluno int not null,
    dataConclusao date,
    pontos real(8,2)
);
alter table fasesConcluidas add constraint fk_fase foreign key(idFase) references fases(idFase);
alter table fasesConcluidas add constraint fk_aluno_fase_concluida foreign key(idFase) references alunos(idAluno);

create table conquistas(
	idConquista int not null primary key,
    nomeConquista varchar(100)
);

create table alunosXconquistas(
	idAlunoConquista int not null primary key,
    idConquista int not null,
    idAluno int not null
);





