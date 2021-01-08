CREATE TABLE pauta (
    codigo serial PRIMARY KEY,
    nome VARCHAR ( 50 ) NOT NULL,
    descricao VARCHAR ( 200 ) NOT NULL,
    status VARCHAR ( 20 ) NOT NULL,
    codigo_pessoa INT NOT NULL,
    FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
);