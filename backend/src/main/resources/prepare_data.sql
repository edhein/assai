GRANT ALL PRIVILEGES ON product_type TO assai;
GRANT ALL PRIVILEGES ON store TO assai;
GRANT ALL PRIVILEGES ON client TO assai;
GRANT ALL PRIVILEGES ON order TO assai;
GRANT ALL PRIVILEGES ON partner TO assai;

insert into partner
(name, email, cpf, password, telephone)
values ('testinho', 'testinho@teste.com', '999.999.999-99', 'senha', '99 99999-9999');

insert into store
(name, longitude, latitude, street, city, number, cnpj)
values ('testinho store', 9999.99, 9999.99, 'rua teste', 'teste city', '999', '99.999.999/0009-99');

insert into product_type
(name, price, prepare_time, store_id)
values ('frango de teste', 99.99, 10800, 1);

insert into product
(name, product_type_id, start_date)
values ('frango de teste', 1, NOW());

insert into product
(name, product_type_id, start_date)
values ('frango de teste com pedido', 1, NOW());

insert into client
(name, cpf, telephone, email, password)
values ('fulano', '999.999.999-99', '99 99999-9999', 'fulano@teste.com', 'senha');

insert into "order"
(client_id, product_id, store_id, status)
values (1, 2, 1, 'NEW');