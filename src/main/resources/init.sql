CREATE USER assai WITH PASSWORD 'assai' NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;

CREATE TABLE store
(
    store_id int8 NOT NULL,
    name varchar(100) NOT NULL,
    longitude NUMERIC NOT NULL,
    latitude NUMERIC NOT NULL,
    street varchar(100) NOT NULL,
    city varchar(100) NOT NULL,
    number varchar(100) NOT NULL,
    cnpj varchar(100) NOT NULL,
    CONSTRAINT store_pkey PRIMARY KEY (store_id)
);

CREATE TABLE partner
(
    partner_id int8 NOT NULL,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    cpf varchar(100) NOT NULL,
    password varchar(150) NOT NULL,
    telephone varchar(100) NOT NULL,
    CONSTRAINT partner_pkey PRIMARY KEY (partner_id)
);

CREATE TABLE product_type
(
    product_type_id int8 NOT NULL,
    name varchar(100) NOT NULL,
    price NUMERIC(8,2) NOT NULL,
    prepare_time NUMERIC NOT NULL,
    store_id int8 NOT NULL,
    CONSTRAINT product_type_pkey PRIMARY KEY (product_type_id),
    CONSTRAINT product_type_store_id_fkey FOREIGN KEY (store_id) REFERENCES store(store_id)
);

CREATE TABLE product (
    product_id int8 NOT NULL,
    name varchar(100) NOT NULL,
    product_type_id int8 NOT NULL,
    start_date TIMESTAMP NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (product_id),
    CONSTRAINT product_product_type_id_fkey FOREIGN KEY (product_type_id) REFERENCES product_type(product_type_id)
);

CREATE TABLE client (
    client_id int8 NOT NULL,
    name varchar(100) NOT NULL,
    cpf varchar(100) NOT NULL,
    telephone varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    password varchar(150) NOT NULL,
    CONSTRAINT client_pkey PRIMARY KEY (client_id)
);

CREATE TABLE "order" (
    order_id int8 NOT NULL,
    client_id int8 NOT NULL,
    product_id int8 NOT NULL,
    store_id int8 NOT NULL,
    status varchar(100) NOT NULL,
    CONSTRAINT order_pkey PRIMARY KEY (order_id),
    CONSTRAINT order_client_id_fkey FOREIGN KEY (client_id) REFERENCES client(client_id),
    CONSTRAINT order_product_id_fkey FOREIGN KEY (product_id) REFERENCES product(product_id),
    CONSTRAINT order_store_id_fkey FOREIGN KEY (store_id) REFERENCES store(store_id)
);