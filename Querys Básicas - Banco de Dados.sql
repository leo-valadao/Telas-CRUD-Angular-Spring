-- Consulta de Todos os Dados:
SELECT * FROM UserCredentials;
SELECT * FROM Customer;
SELECT * FROM Product;
SELECT * FROM Sale;
SELECT * FROM ShoppingCart;

-- Inserção de Credenciais de Usuários:
INSERT INTO UserCredentials (Username, Email, Password, Role) VALUES ('ADMIN', 'ADMIN', 'ADMIN', 'ADMIN');
INSERT INTO UserCredentials (Username, Email, Password, Role) VALUES ('USER', 'USER', 'USER', 'USER');

-- Inserção de Clientes:
INSERT INTO Customer (Name, Email, BirthDate) VALUES ('Leonardo', 'Leonardo@gmail.com', '1997-04-03');
INSERT INTO Customer (Name, Email, BirthDate) VALUES ('Divino', 'Divino@gmail.com', '1996-07-21');

-- Inserção de Produtos:
INSERT INTO Product (Name, Price, Description) VALUES ('Product 1', 100.00, 'Description of Product 1');
INSERT INTO Product (Name, Price, Description) VALUES ('Product 2', 20.00, 'Description of Product 2');
INSERT INTO Product (Name, Price, Description) VALUES ('Product 3', 0.33, 'Description of Product 3');

-- Inserção de Vendas:
INSERT INTO Sale (FK_Customer_ID) VALUES (1);
INSERT INTO Sale (FK_Customer_ID) VALUES (2);

-- Inserção de Carrinho de Compras:
INSERT INTO ShoppingCart (FK_Product_ID, FK_Sale_ID, Quantity) VALUES (1, 2, 10);
INSERT INTO ShoppingCart (FK_Product_ID, FK_Sale_ID, Quantity) VALUES (3, 1, 25);