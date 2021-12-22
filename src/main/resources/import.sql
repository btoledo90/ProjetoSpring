INSERT INTO tb_sentimentos (name, created_At) VALUES ('Feliz', NOW());
INSERT INTO tb_sentimentos (name, created_At) VALUES ('Triste', NOW());
INSERT INTO tb_sentimentos (name, created_At) VALUES ('Desanimado', NOW());

INSERT INTO tb_exercicios (name, date, descricao) VALUES ('Perna', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 'Exercicio 1');
INSERT INTO tb_exercicios (name, date, descricao) VALUES ('Braço', TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Exercicio 2');
INSERT INTO tb_exercicios (name, date, descricao) VALUES ('Peito 2', TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Exercicio 3');

INSERT INTO tb_sentimento_exercicio (sentimento_id, exercicio_id) VALUES (1, 2);
INSERT INTO tb_sentimento_exercicio (sentimento_id, exercicio_id) VALUES (2, 1);
INSERT INTO tb_sentimento_exercicio (sentimento_id, exercicio_id) VALUES (2, 3);
