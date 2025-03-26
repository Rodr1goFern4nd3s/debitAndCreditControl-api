create table categoria (
    id bigint not null auto_increment,
    nome varchar(60) not null,

    primary key (id)
) engine=InnoDB default charset=utf8;

insert into categoria (nome) values ('Lazer');
insert into categoria (nome) values ('Alimentação');
insert into categoria (nome) values ('Supermercado');
insert into categoria (nome) values ('Farmácia');
insert into categoria (nome) values ('Outros');