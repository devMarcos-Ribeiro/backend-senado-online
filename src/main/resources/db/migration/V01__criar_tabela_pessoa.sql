CREATE TABLE pessoa(
    codigo serial PRIMARY KEY,
    nome VARCHAR ( 50 ) NOT NULL,
    email VARCHAR ( 255 ) UNIQUE NOT NULL,
    senha VARCHAR ( 50 ) NOT NULL
);