create database learnybd;
#drop database learnybd;
use learnybd;

create table alunos(
	idAluno int auto_increment primary key,
    nome varchar(50),
    usuario varchar(50),
    senha varchar(50),
    email varchar(100),
    dataNasc date,
    idade INT AS (TIMESTAMPDIFF(YEAR, dataNasc, CURDATE())),
    pontosTotais real(8,2),
    fasesConcluidas int,
    foto varchar(50)
);
insert into alunos(nome, email, usuario, senha, dataNasc, pontosTotais, fasesConcluidas, foto) values
("Joao Marcos", "joao.kirimis@gmail.com", "joao", "123", "2004-03-11", 0, 0, "teste.png");

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
    nomeRegiao varchar(50),
    constraint fk_mundo foreign key(idMundo) references mundos(idMundo)
);
insert into regioes(idMundo, nomeRegiao) values
(1, "Floresta");

create table fases(
	idFase int auto_increment primary key,
    idRegiao int not null,
    tipo varchar(50),
    dificuldade varchar(50),
    constraint fk_regiao foreign key(idRegiao) references regioes(idRegiao)
);
insert into fases(idRegiao, tipo, dificuldade) values
(1, "Visual", "Fácil"),
(1, "Números", "Médio"),
(1, "Ouvir", "Médio"),
(1, "Observacao", "Fácil");

create table fasesConcluidas(
	idFaseConcluida int auto_increment primary key,
    idFase int not null,
    idAluno int not null,
    pontos double(8,2),
    tempoConclusao time,
    porcentagemAcertos real(8,2),
    constraint fk_fase foreign key(idFase) references fases(idFase),
    constraint fk_aluno_fase_concluida foreign key(idAluno) references alunos(idAluno)
);

create table conquistas(
	idConquista int auto_increment primary key,
    nomeConquista varchar(100),
    descConquista varchar(100)
);
insert into conquistas(nomeConquista, descConquista) values
("Iniciando!", "Terminou uma atividade"),
("A todo vapor!", "Terminou quatro atividades"),
("Mundo Concluído!", "Terminou um mundo");

create table alunosXconquistas(
	idAlunoConquista int auto_increment primary key,
    idConquista int not null,
    idAluno int not null,
    constraint fk_conquista foreign key(idConquista) references conquistas(idConquista),
    constraint fk_aluno_conquista foreign key(idAluno) references alunos(idAluno)
);

create table missoes(
	idMissao int auto_increment primary key,
    nomeMissao varchar(100),
    descMissao varchar(200)
);
insert into missoes(nomeMissao, descMissao) values 
("Atividades 1", "Faça 3 fases"),
("Atividades 2", "Faça 5 fases"),
("Observacao", "Faça a fase de observacao"),
("Visual", "Faça a fase visual"),
("Ouvir", "Faça a fase de escuta"),
("Numeros", "Faça a fase de números"),
("Mundo", "Conclua um mundo");

create table missoesDiarias(
	idMissaoDiaria int auto_increment primary key,
    idMissao int not null,
    descMissao varchar(200),
    constraint fk_diaria_missao foreign key(idMissao) references missoes(idMissao)
);
insert into missoesDiarias(idMissao, descMissao) values 
(1, "Faça 3 fases"),
(3, "Faça a fase de observacao"),
(7, "Conclua um mundo");

create table notificacoes(
	idNotificacao int auto_increment primary key,
    idAluno int not null,
    notificacao varchar(100),
    descNotificacao varchar(100),
    constraint fk_aluno_notificacao foreign key(idALuno) references alunos(idALuno)
);

-- Criação do trigger para atualizar o número de fases concluídas
DELIMITER //

CREATE TRIGGER atualiza_num_fases_concluidas
AFTER INSERT ON fasesConcluidas
FOR EACH ROW
BEGIN
    UPDATE alunos
    SET fasesConcluidas = (
        SELECT COUNT(*) 
        FROM fasesConcluidas 
        WHERE idAluno = NEW.idAluno
    )
    WHERE idAluno = NEW.idAluno;
END;
//

DELIMITER ;


-- Criação do trigger para atualizar o número de pontos
DELIMITER //

CREATE TRIGGER atualiza_pontos
AFTER INSERT ON fasesConcluidas
FOR EACH ROW
BEGIN
    UPDATE alunos
    SET pontosTotais = pontosTotais + NEW.pontos
    WHERE idAluno = NEW.idAluno;
END;
//

DELIMITER ;

--  Criação de um evento para pegas as missões da tabela missões e inserir nas missões diárias a cada 24 horas
DELIMITER //

CREATE EVENT inserir_missao_diaria
ON SCHEDULE EVERY 1 DAY
STARTS CURRENT_TIMESTAMP
DO
BEGIN
    DECLARE total_missao INT;
    DECLARE id_missao_1, id_missao_2, id_missao_3 INT;

    -- Limpa a tabela missoesDiarias
    DELETE FROM missoesDiarias;

    -- Conta o total de missões existentes
    SELECT COUNT(*) INTO total_missao FROM missoes;

    -- Gera três números aleatórios distintos entre 1 e o total de missões
    REPEAT
        SET id_missao_1 = FLOOR(RAND() * total_missao) + 1;
        SET id_missao_2 = FLOOR(RAND() * total_missao) + 1;
        SET id_missao_3 = FLOOR(RAND() * total_missao) + 1;
        -- Garante que não sejam selecionadas missões repetidas
    UNTIL id_missao_1 <> id_missao_2 AND id_missao_1 <> id_missao_3 AND id_missao_2 <> id_missao_3 END REPEAT;

    -- Insere as três missões diárias com base nos números gerados
    INSERT INTO missoesDiarias (idMissao, descMissao)
    SELECT idMissao, descMissao FROM missoes WHERE idMissao IN (id_missao_1, id_missao_2, id_missao_3);
END //

DELIMITER ;

-- Query que todos os eventos sejam executados automaticamente --
SET GLOBAL event_scheduler=ON;
-- Ativa o evento criado
ALTER EVENT inserir_missao_diaria ENABLE;