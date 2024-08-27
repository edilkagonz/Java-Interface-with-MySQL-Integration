use mysql; 
show databases;
CREATE DATABASE store;

USE store;


CREATE TABLE product
(
   productNo varchar(10) NOT NULL UNIQUE,
   productName varchar(15) NOT NULL,
   productDescription varchar(100) NOT NULL,
   productBrand varchar(15) NOT NULL,
   productImage varchar(30),
   quantity int,
   cost float,
   price float
);

select * from product;
SET SQL_SAFE_UPDATES = 0;
  DELETE FROM product WHERE productNo='J23A12-P';


-- Insert or create a new product
INSERT INTO store.product (productNo, productName, productDescription, productBrand, productImage, quantity, cost, price) 
     VALUES ('J23A12-P', 'Blue Classic', '100 Standard size card sleeves', 'Dragon Shield', 'DragonShieldBlueClassic.jpg', 25, 8.95, 14.99);

-- Select all products from DB
SELECT * FROM store.product;	

-- Select an specific product 
SELECT * FROM store.product WHERE productNo = 'J23A12-P';

-- Update a product
UPDATE store.product SET productName='Blue Classic', productDescription='100 Standard size card sleeves', productBrand='Dragon Shield', productImage='DragonShieldBlueClassic.jpg', quantity=30, cost=9.95, price=15.99 WHERE productNo = 'J23A12-P';
