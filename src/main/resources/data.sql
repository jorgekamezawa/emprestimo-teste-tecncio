DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes (
  cnpj VARCHAR(250) PRIMARY KEY,
  pontuacao_analise_credito INT DEFAULT NULL
);

DROP TABLE IF EXISTS perguntas;
CREATE TABLE perguntas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  descricao_pergunta VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS respostas;
CREATE TABLE respostas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  descricao_resposta VARCHAR(250) NOT NULL,
  pontuacao INT DEFAULT NULL,
  pergunta_id INT DEFAULT NULL
);

ALTER TABLE respostas add constraint FK4l5x5l5vrpcfi2n0q58m1o0vn foreign key (pergunta_id) references perguntas;

INSERT INTO CLIENTES (cnpj, pontuacao_analise_credito) VALUES
  ('10001889000128', 0);

INSERT INTO PERGUNTAS (descricao_pergunta) VALUES
    ('Como você considera o momento atual da sua empresa?'),
    ('Como foi o comportamento financeiro da sua empresa nos últimos 3 meses?'),
    ('O motivo do empréstimo consiste em pagar dívidas?');

INSERT INTO RESPOSTAS (descricao_resposta, pontuacao, pergunta_id) VALUES
  ('Demanda de produção em crescimento', 2, 1),
  ('Retornando atividades pós pandemia (dificuldades em manter o pagamento de fornecedores)', -3, 1),
  ('Em crescimento, quero investir em máquinas', 3, 1),
  ('Com dificuldades em vendas', -1, 1),
  ('Faturamento em crescimento (aumentou mês a mês)', 3, 2),
  ('As dificuldades levaram as dívidas cobrirem a receita', -3, 2),
  ('Estabilidade ou crescimento no faturamento/despesas', 0, 2),
  ('Receita instável (dificuldades em manter clientes fixos)', -1, 2),
  ('É um investimento para o crescimento da empresa (ex: material, contratação e etc.)', 0, 3),
  ('Tive algumas dificuldades e agora preciso quitar dívidas para continuar com a operação', -1, 3);
