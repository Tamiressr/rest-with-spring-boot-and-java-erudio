CREATE TABLE IF NOT EXISTS tb_book(
    id serial NOT NULL ,
    nome varchar(80) NOT NULL,
    data_lancamento varchar(80)  NOT NULL,
    autor varchar(80) NOT NULL,
    quantidade_de_paginas varchar(6) NOT NULL,
    genero varchar(50),
    PRIMARY KEY (id)
);
