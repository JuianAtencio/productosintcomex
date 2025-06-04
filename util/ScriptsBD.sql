-- Database: productos

DROP DATABASE IF EXISTS productos;

CREATE DATABASE productos
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'es-CO'
    LC_CTYPE = 'es-CO'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE productos
    IS 'Base de Datos de Productos y Categorias';



-- Script DDL para PostgreSQL

-- Tabla: Categories
CREATE TABLE Categories (
    CategoryID SERIAL PRIMARY KEY,
    CategoryName VARCHAR(100) NOT NULL UNIQUE,
    Description TEXT,
    Picture VARCHAR(255)
);

-- Tabla: Suppliers
CREATE TABLE Suppliers (
    SupplierID SERIAL PRIMARY KEY,
    CompanyName VARCHAR(100) NOT NULL,
    ContactName VARCHAR(100),
    ContactTitle VARCHAR(50),
    Address VARCHAR(255),
    City VARCHAR(50),
    Region VARCHAR(50),
    PostalCode VARCHAR(20),
    Country VARCHAR(50),
    Phone VARCHAR(30),
    Fax VARCHAR(30),
    HomePage TEXT
);

-- Tabla: Products
CREATE TABLE Products (
    ProductID SERIAL PRIMARY KEY,
    ProductName VARCHAR(100) NOT NULL,
    SupplierID INTEGER,
    CategoryID INTEGER,
    QuantityPerUnit VARCHAR(50),
    UnitPrice NUMERIC(10, 2),
    UnitsInStock SMALLINT,
    UnitsOnOrder SMALLINT,
    ReorderLevel SMALLINT,
    Discontinued BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_products_supplier FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID),
    CONSTRAINT fk_products_category FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

-- Tabla: Employees (MODIFICADA)
CREATE TABLE Employees (
    EmployeeID SERIAL PRIMARY KEY,
    LastName VARCHAR(50) NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
    Title VARCHAR(50),
    TitleOfCourtesy VARCHAR(30),
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR(255),
    City VARCHAR(50),
    Region VARCHAR(50),
    PostalCode VARCHAR(20),
    Country VARCHAR(50),
    HomePhone VARCHAR(30),
    Extension VARCHAR(10),
    Photo VARCHAR(255),
    Notes TEXT,
    ReportsTo VARCHAR(150) -- Nombre de la persona a la que reporta
);

-- Tabla: Customers
CREATE TABLE Customers (
    CustomerID VARCHAR(10) PRIMARY KEY,
    CompanyName VARCHAR(100) NOT NULL,
    ContactName VARCHAR(100),
    ContactTitle VARCHAR(50),
    Address VARCHAR(255),
    City VARCHAR(50),
    Region VARCHAR(50),
    PostalCode VARCHAR(20),
    Country VARCHAR(50),
    Phone VARCHAR(30),
    Fax VARCHAR(30)
);

-- Tabla: Shippers
CREATE TABLE Shippers (
    ShipperID SERIAL PRIMARY KEY,
    CompanyName VARCHAR(100) NOT NULL,
    Phone VARCHAR(30)
);

-- Tabla: Orders
CREATE TABLE Orders (
    OrderID SERIAL PRIMARY KEY,
    CustomerID VARCHAR(10),
    EmployeeID INTEGER,
    OrderDate TIMESTAMP,
    RequiredDate TIMESTAMP,
    ShippedDate TIMESTAMP,
    ShipVia INTEGER,
    Freight NUMERIC(10, 2) DEFAULT 0.00,
    ShipName VARCHAR(100),
    ShipAddress VARCHAR(255),
    ShipCity VARCHAR(50),
    ShipRegion VARCHAR(50),
    ShipPostalCode VARCHAR(20),
    ShipCountry VARCHAR(50),
    CONSTRAINT fk_orders_customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    CONSTRAINT fk_orders_employee FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
    CONSTRAINT fk_orders_shipper FOREIGN KEY (ShipVia) REFERENCES Shippers(ShipperID)
);

-- Tabla: Order_Details
CREATE TABLE Order_Details (
    OrderID INTEGER NOT NULL,
    ProductID INTEGER NOT NULL,
    UnitPrice NUMERIC(10, 2) NOT NULL,
    Quantity SMALLINT NOT NULL,
    Discount NUMERIC(4, 2) DEFAULT 0.00,
    CONSTRAINT pk_order_details PRIMARY KEY (OrderID, ProductID),
    CONSTRAINT fk_orderdetails_order FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    CONSTRAINT fk_orderdetails_product FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- ÍNDICES (se omite el índice para Employees.ReportsTo si ya no es FK)
CREATE INDEX idx_products_supplier_id ON Products(SupplierID);
CREATE INDEX idx_products_category_id ON Products(CategoryID);
CREATE INDEX idx_orders_customer_id ON Orders(CustomerID);
CREATE INDEX idx_orders_employee_id ON Orders(EmployeeID);
CREATE INDEX idx_orders_ship_via ON Orders(ShipVia);
CREATE INDEX idx_suppliers_companyname ON Suppliers(CompanyName);
CREATE INDEX idx_suppliers_region ON Suppliers(Region);
CREATE INDEX idx_products_productname ON Products(ProductName);
CREATE INDEX idx_employees_lastname ON Employees(LastName);
CREATE INDEX idx_employees_postalcode ON Employees(PostalCode);
CREATE INDEX idx_customers_city ON Customers(City);
CREATE INDEX idx_customers_companyname ON Customers(CompanyName);
CREATE INDEX idx_customers_postalcode ON Customers(PostalCode);
CREATE INDEX idx_customers_region ON Customers(Region);
CREATE INDEX idx_orders_orderdate ON Orders(OrderDate);
CREATE INDEX idx_orders_shippeddate ON Orders(ShippedDate);
CREATE INDEX idx_orders_shippostalcode ON Orders(ShipPostalCode);

COMMIT;


--Database
INSERT INTO Suppliers (CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage)
VALUES ('Compañía 1', 'Contacto 1', 'Título 1', 'Dirección 1', 'Ciudad 1', 'Región 1', '10001', 'País 1', '+57-300000001', '+57-300000001', 'https://compania1.com');

INSERT INTO Suppliers (CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage)
VALUES ('Compañía 2', 'Contacto 2', 'Título 2', 'Dirección 2', 'Ciudad 2', 'Región 2', '10002', 'País 2', '+57-300000002', '+57-300000002', 'https://compania2.com');

INSERT INTO Suppliers (CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage)
VALUES ('Compañía 3', 'Contacto 3', 'Título 3', 'Dirección 3', 'Ciudad 3', 'Región 3', '10003', 'País 3', '+57-300000003', '+57-300000003', 'https://compania3.com');

