create table mensalidade_tipo_financiamento (
	id bigint not null auto_increment,
    tipo_financiamento_id bigint not null,
    mensalidade_id bigint not null,
    
    primary key (id, tipo_financiamento_id, mensalidade_id),
    foreign key (tipo_financiamento_id) references tipo_financiamento(id), 
    foreign key (mensalidade_id) references mensalidade(id)
);