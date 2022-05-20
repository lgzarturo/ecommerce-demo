insert into categories(description, status) values ( 'category1', 1 );

insert into products(category_id, name, bar_code, price, stock, status) values ( 1, 'product1', 'abc1', 1.0, 1, 1);
insert into products(category_id, name, bar_code, price, stock, status) values ( 1, 'product2', 'abc2', 2.0, 2, 1);
insert into products(category_id, name, bar_code, price, stock, status) values ( 1, 'product3', 'abc3', 3.0, 3, 1);
insert into products(category_id, name, bar_code, price, stock, status) values ( 1, 'product4', 'abc4', 4.0, 4, 0);

insert into clients(name, last_name, phone, direction, email) values ( 'client1', 'last_name', '1212', 'address', 'a@gmail.com' );
insert into clients(name, last_name, phone, direction, email) values ( 'client2', 'last_name2', '7272', 'address', 'b@gmail.com' );

insert into shopping(client_id, date, payment_mode, comment, status) values ( 1, '2020-01-01', 'C', 'Comment1', 1);
insert into shopping(client_id, date, payment_mode, comment, status) values ( 1, '2020-01-01', 'C', 'Comment1', 2);

insert into shopping_products(shopping_id, product_id, total, status) values ( 1, 1, 1.0, 1 );
insert into shopping_products(shopping_id, product_id, total, status) values ( 1, 2, 1.0, 1 );
insert into shopping_products(shopping_id, product_id, total, status) values ( 1, 3, 1.0, 1 );
insert into shopping_products(shopping_id, product_id, total, status) values ( 2, 1, 1.0, 1 );
insert into shopping_products(shopping_id, product_id, total, status) values ( 2, 2, 1.0, 0 );
