CREATE DATABASE  price_db;
USE price_db;



CREATE TABLE price_product (
  id int NOT NULL AUTO_INCREMENT,
  provider varchar(100),
  code_product int(20),
  name_product varchar(100),
  unit varchar(10),
  price float,
  date_update_price varchar(25),
  PRIMARY KEY (id)
);

