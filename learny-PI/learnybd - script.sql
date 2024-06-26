create database learnybd;
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
    foto varchar(100),
    medalha varchar(100),
    ranque varchar(50)
);

create table mundos(
	idMundo int auto_increment primary key,
    nivel int,
    tema varchar(50)
);

insert into mundos(nivel, tema) values
(1, "Mundo Natural");

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
(1, "Visual", "Medio"),
(1, "Numeros", "Medio"),
(1, "Ouvir", "Medio"),
(1, "Observacao", "Facil");

create table fasesConcluidas(
	idFaseConcluida int auto_increment primary key,
    idFase int not null,
    idAluno int not null,
    pontos double(8,2),
    tempoConclusao time,
    porcentagemAcertos real(8,2),
    dataConclusao date,
    constraint fk_fase foreign key(idFase) references fases(idFase),
    constraint fk_aluno_fase_concluida foreign key(idAluno) references alunos(idAluno)
);

create table conquistas(
	idConquista int auto_increment primary key,
    nomeConquista varchar(100),
    descConquista varchar(100),
    iconMedalha varchar(50)
);
insert into conquistas(nomeConquista, descConquista, iconMedalha) values
("Iniciando!", "Terminou uma atividade", "icon-medalha-verde.png"),
("A todo vapor!", "Terminou quatro atividades", "icon-medalha-vermelha.png"),
("Mundo Concluido!", "Terminou um mundo", "icon-medalha-azul.png");

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
    descMissao varchar(200),
    iconMissao varchar(100)
);
insert into missoes(nomeMissao, descMissao, iconMissao) values 
("Atividades 1", "Conclua 3 fases", "icon-diaria-fases.png"),
("Atividades 2", "Conclua 5 fases", "icon-diaria-fases.png"),
("Observacao", "Conclua a fase observacao", "icon-diaria-observacao.png"),
("Visual", "Conclua a fase visual", "icon-diaria-visualizar.png"),
("Ouvir", "Conclua a fase de escuta", "icon-diaria-escuta.png"),
("Numeros", "Conclua a fase de numeros", "icon-diaria-numeros.png"),
("Mundo", "Conclua um mundo", "icon-diaria-mundo.png");

create table missoesDiarias(
	idMissaoDiaria int auto_increment primary key,
    idMissao int not null,
    idAluno int not null,
    dataInsercao date,
    CONSTRAINT fk_diaria_aluno FOREIGN KEY(idAluno) REFERENCES alunos(idAluno),
    constraint fk_diaria_missao foreign key(idMissao) references missoes(idMissao)
);

create table notificacoes(
	idNotificacao int auto_increment primary key,
    idAluno int not null,
    notificacao varchar(100),
    descNotificacao varchar(100),
    iconNotificacao varchar(100),
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

-- Criação de um evento para pegas as missões da tabela missões e inserir nas missões diárias a cada 24 horas para todos os alunos
DELIMITER //

CREATE EVENT inserir_missao_diaria_por_aluno
ON SCHEDULE EVERY 1 DAY
STARTS CURRENT_TIMESTAMP
DO
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE total_missao INT;
    DECLARE id_missao_1, id_missao_2, id_missao_3 INT;
    DECLARE aluno_id INT;

    -- Cursor para iterar por todos os alunos
    DECLARE aluno_cursor CURSOR FOR SELECT idAluno FROM alunos;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Conta o total de missões existentes
    SELECT COUNT(*) INTO total_missao FROM missoes;

    -- Limpa as missões do dia anterior que não foram concluídas
    DELETE FROM missoesDiarias WHERE dataInsercao < CURDATE();

    OPEN aluno_cursor;
    
    read_loop: LOOP
        FETCH aluno_cursor INTO aluno_id;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Gera três números aleatórios distintos entre 1 e o total de missões
        REPEAT
            SET id_missao_1 = FLOOR(RAND() * total_missao) + 1;
            SET id_missao_2 = FLOOR(RAND() * total_missao) + 1;
            SET id_missao_3 = FLOOR(RAND() * total_missao) + 1;
        UNTIL id_missao_1 <> id_missao_2 AND id_missao_1 <> id_missao_3 AND id_missao_2 <> id_missao_3 END REPEAT;

        -- Insere as três missões diárias para o aluno atual
        INSERT INTO missoesDiarias (idAluno, idMissao, dataInsercao)
        VALUES (aluno_id, id_missao_1, NOW()), (aluno_id, id_missao_2, NOW()), (aluno_id, id_missao_3, NOW());
    END LOOP;

    CLOSE aluno_cursor;
END //

DELIMITER ;

SET GLOBAL event_scheduler = ON;
-- Ativa o evento criado
ALTER EVENT inserir_missao_diaria_por_aluno ENABLE;

-- Trigger que atribui missões diárias automaticamente quando um novo aluno é cadastrado
DELIMITER //

CREATE TRIGGER atribuir_missao_novo_aluno
AFTER INSERT ON alunos
FOR EACH ROW
BEGIN
    DECLARE total_missao INT;
    DECLARE id_missao_1, id_missao_2, id_missao_3 INT;

    -- Conta o total de missões existentes
    SELECT COUNT(*) INTO total_missao FROM missoes;

    -- Gera três números aleatórios distintos entre 1 e o total de missões
    REPEAT
        SET id_missao_1 = FLOOR(RAND() * total_missao) + 1;
        SET id_missao_2 = FLOOR(RAND() * total_missao) + 1;
        SET id_missao_3 = FLOOR(RAND() * total_missao) + 1;
    UNTIL id_missao_1 <> id_missao_2 AND id_missao_1 <> id_missao_3 AND id_missao_2 <> id_missao_3 END REPEAT;

    -- Insere as três missões diárias para o novo aluno
    INSERT INTO missoesDiarias (idAluno, idMissao, dataInsercao)
    VALUES (NEW.idAluno, id_missao_1, NOW()), (NEW.idAluno, id_missao_2, NOW()), (NEW.idAluno, id_missao_3, NOW());
END //

DELIMITER ;