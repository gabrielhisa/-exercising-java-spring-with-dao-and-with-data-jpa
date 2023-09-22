-- Simple cart - item project to exercise Spring Boot notions

-- Creating test database
CREATE DATABASE IF NOT EXISTS cart;
USE cart;

-- Creating tables
DROP TABLE IF EXISTS Carts;
CREATE TABLE Carts (
	cart_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL,
	cart_size CHAR(1) NOT NULL,
	cart_slots INT NOT NULL,
    item_id INT NOT NULL
);

DROP TABLE IF EXISTS Items;
CREATE TABLE Items (
	item_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Add a foreign key in the Carts table to reference the Items table
ALTER TABLE Carts
ADD CONSTRAINT fk_cart_item
FOREIGN KEY (item_id)
REFERENCES Items(item_id);

-- Inserts for the Items table
INSERT INTO Items (name, price)
VALUES
    ('Item 4', 8.49),
    ('Item 5', 12.99),
    ('Item 6', 19.95),
    ('Item 7', 6.25),
    ('Item 8', 11.50),
    ('Item 9', 15.75),
    ('Item 10', 22.99),
    ('Item 11', 7.99),
    ('Item 12', 13.25),
    ('Item 13', 16.75);

-- Inserts for the Carts table
INSERT INTO Carts (user_id, cart_size, cart_slots, item_id)
VALUES
    (1, 'S', 5, 1), -- Cart 1 with Item 1
    (2, 'M', 10, 2), -- Cart 2 with Item 2
    (3, 'L', 15, 3); -- Cart 3 with Item 3

