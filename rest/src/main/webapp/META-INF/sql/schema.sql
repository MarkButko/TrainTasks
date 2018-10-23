CREATE table users (
    ID INT NOT NULL AUTO_INCREMENT,
    VARCHAR(30) first_name NOT NUll,
    VARCHAR(30) last_name NOT NUll,
    PRIAMRY KEY(ID)
);

CREATE TABLE car (
    ID INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    license_type char(1) not null,
    weight int not null,
    constraint fk_customer_id foreign key (customer_id) references customer(id)
);

