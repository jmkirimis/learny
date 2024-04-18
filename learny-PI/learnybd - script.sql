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
insert into alunos(nome, email, usuario, senha, dataNasc) values
("Joao Marcos", "joao.kirimis@gmail.com", "joao", "123", "2004-03-11");
ALTER TABLE alunos ADD COLUMN idade INT AS (TIMESTAMPDIFF(YEAR, dataNasc, CURDATE()));

create table alunoLogado(
	idAluno int auto_increment primary key,
    nome varchar(50),
    email varchar(100),
    usuario varchar(50),
    senha varchar(50),
    dataNasc date,
    idade int
);

create table mundos(
	idMundo int auto_increment primary key,
    nivel int,
    tema varchar(50)
);

insert into mundos(nivel, tema) values
(1, "Natureza");

create table regioes(
	idRegiao int auto_increment primary key,
    idMundo int not null,
    nomeRegiao varchar(50)
);
alter table regioes add constraint fk_mundo foreign key(idMundo) references mundos(idMundo);
insert into regioes(idMundo, nomeRegiao) values
(1, "Floresta");

create table fases(
	idFase int auto_increment primary key,
    idRegiao int not null,
    tipo varchar(50),
    dificuldade varchar(50)
);
alter table fases add constraint fk_regiao foreign key(idRegiao) references regioes(idRegiao);
insert into fases(idRegiao, tipo, dificuldade) values
(1, "Visual", "Fácil");

create table fasesConcluidas(
	idFaseConcluida int auto_increment primary key,
    idFase int not null,
    idAluno int not null,
    pontos real(8,2),
    tempoConclusao time,
    porcentagemAcertos real(8,2)
);
alter table fasesConcluidas add constraint fk_fase foreign key(idFase) references fases(idFase);
alter table fasesConcluidas add constraint fk_aluno_fase_concluida foreign key(idFase) references alunos(idAluno);
select * from fasesConcluidas;

create table conquistas(
	idConquista int auto_increment primary key,
    nomeConquista varchar(100)
);
insert into conquistas(nomeConquista) values
("A todo vapor!");

create table alunosXconquistas(
	idAlunoConquista int auto_increment primary key,
    idConquista int not null,
    idAluno int not null
);
alter table alunosXconquistas add constraint fk_conquista foreign key(idConquista) references conquistas(idConquista);
alter table alunosXconquistas add constraint fk_aluno_conquista foreign key(idAluno) references alunos(idAluno);
insert into alunosXconquistas(idConquista, idAluno) values
(1,1);





