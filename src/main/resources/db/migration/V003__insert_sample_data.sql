insert into tipo_financiamento(tipo) values('Interno');
insert into tipo_financiamento(tipo) values('Externo');

insert into mensalidade(meses) values(12);
insert into mensalidade(meses) values(24);
insert into mensalidade(meses) values(36);
insert into mensalidade(meses) values(48);
insert into mensalidade(meses) values(60);

insert into mensalidade_tipo_financiamento(tipo_financiamento_id, mensalidade_id) values(1, 1);
insert into mensalidade_tipo_financiamento(tipo_financiamento_id, mensalidade_id) values(1, 2);
insert into mensalidade_tipo_financiamento(tipo_financiamento_id, mensalidade_id) values(1, 3);
insert into mensalidade_tipo_financiamento(tipo_financiamento_id, mensalidade_id) values(1, 4);
insert into mensalidade_tipo_financiamento(tipo_financiamento_id, mensalidade_id) values(2, 1);
insert into mensalidade_tipo_financiamento(tipo_financiamento_id, mensalidade_id) values(2, 2);
insert into mensalidade_tipo_financiamento(tipo_financiamento_id, mensalidade_id) values(2, 3);
insert into mensalidade_tipo_financiamento(tipo_financiamento_id, mensalidade_id) values(2, 4);
insert into mensalidade_tipo_financiamento(tipo_financiamento_id, mensalidade_id) values(2, 5);

insert into viatura(nome, valor) values('A', 10000.5);
insert into viatura(nome, valor) values('B', 20000.75);
insert into viatura(nome, valor) values('C', 25000.25);

commit;