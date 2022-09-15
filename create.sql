create table customer (id  bigserial not null, birthdate date, email varchar(255) not null, name varchar(255) not null, primary key (id));
create table product (id  bigserial not null, description varchar(255), name varchar(255) not null, price float8 not null, primary key (id));
create table sale (id  bigserial not null, fk_customer_id int8, primary key (id));
create table shoppingcart (id  bigserial not null, quantity int4 not null, fk_product_id int8, fk_sale_id int8, primary key (id));
create table usercredentials (id  bigserial not null, email varchar(255) not null, password varchar(255) not null, role varchar(255) not null, username varchar(255) not null, primary key (id));
alter table usercredentials add constraint UK_bmtj36vmg1f6tv9jwl914ywcw unique (email);
alter table usercredentials add constraint UK_eukgsh8bdk7srcstvx7mgu0dl unique (password);
alter table usercredentials add constraint UK_clc13cg879eiymrue27wht4h2 unique (username);
alter table sale add constraint FKlkhgonycu36th259vsk5hvv7j foreign key (fk_customer_id) references customer;
alter table shoppingcart add constraint FK8b5traobohcljnogdqr6dwpwj foreign key (fk_product_id) references product;
alter table shoppingcart add constraint FKdmn4x53jng3vnrxqswfen3xe6 foreign key (fk_sale_id) references sale;
