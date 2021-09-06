create table tipo_financiamento (
	id bigint not null auto_increment,
    tipo varchar(10) not null,
    
    primary key (id)
);

create table mensalidade (
	id bigint not null auto_increment,
    meses bigint not null,
    
    primary key (id)
);

create table viatura (
	id bigint not null auto_increment,
    nome varchar(10) not null,
    valor double not null,
    
    primary key (id)
);