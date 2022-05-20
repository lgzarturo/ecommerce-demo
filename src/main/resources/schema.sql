create table categories (
    category_id int primary key auto_increment,
    description varchar(46) not null,
    status int default 0
);

create table products (
    product_id int primary key auto_increment,
    category_id int not null,
    name varchar(45) not null,
    bar_code varchar(150) default '',
    price decimal(16, 2) default 0.0,
    stock int default 0,
    status int default
);

create table clients (
    id int primary key auto_increment,
    name varchar(40) not null,
    last_name varchar(100) not null,
    phone decimal null,
    direction varchar(80) not null,
    email varchar(70) unique
);

create table shopping (
    shopping_id int primary key auto_increment,
    client_id int not null,
    date date not null,
    payment_mode varchar(1) not null,
    comment varchar(300) default '',
    status int default 0
);

create table shopping_products (
    id int primary key auto_increment,
    shopping_id int not null,
    product_id int not null,
    total decimal(16, 2),
    status int default 0
);

alter table products add foreign key (category_id) references categories(category_id);
alter table shopping add foreign key (client_id) references shopping(id);
alter table shopping_products add foreign key (shopping_id) references shopping(shopping_id);
alter table shopping_products add foreign key (product_id) references products(product_id);
