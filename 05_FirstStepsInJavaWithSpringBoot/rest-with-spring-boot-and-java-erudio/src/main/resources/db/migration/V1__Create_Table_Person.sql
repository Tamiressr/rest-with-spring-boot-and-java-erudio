CREATE TABLE IF NOT EXISTS tb_person(
    id serial NOT NULL ,
    first_name varchar(80) NOT NULL,
    last_name varchar(80)  NOT NULL,
    address varchar(80) NOT NULL,
    gender varchar(6) NOT NULL,
    PRIMARY KEY (id)
);
