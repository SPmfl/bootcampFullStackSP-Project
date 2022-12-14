CREATE USER sophos WITH PASSWORD 'mybank';
DROP DATABASE IF EXISTS bank;
CREATE DATABASE bank;
GRANT ALL PRIVILEGES ON DATABASE bank TO sophos;
\connect bank sophos;
SET TIMEZONE = 'America/Bogota';

DROP TABLE IF EXISTS clients;
CREATE TABLE clients(
    id SERIAL,
    id_type VARCHAR(10),
    client_id INT NOT NULL CHECK (client_id > 0),
    client_name VARCHAR(20) NOT NULL,
    client_surname VARCHAR(20) NOT NULL,
    client_birthdate DATE NOT NULL,
    client_email VARCHAR(100) NOT NULL,
    creation_user VARCHAR(20) NOT NULL,
    last_modification_user VARCHAR(20) NOT NULL,
    last_modification_date TIMESTAMPTZ,
    creation_date DATE DEFAULT CURRENT_DATE,
    UNIQUE(client_email),
    PRIMARY KEY(client_id)
);

DROP TABLE  IF EXISTS accounts;
CREATE TABLE accounts(
    id SERIAL,
    client_id INT NOT NULL CHECK (client_id > 0),
    account_type VARCHAR(15),
    account_number INT NOT NULL CHECK(account_number > 0000000000),
    account_status VARCHAR(15) NOT NULL CHECK(account_status IN ('active','inactive','canceled')) DEFAULT 'active',
    account_balance FLOAT4 DEFAULT 0.00,
    account_balance_available FLOAT4 DEFAULT 0.00,
    account_gmf_status BOOLEAN NOT NULL,
    creation_user VARCHAR(20) NOT NULL,
    last_modification_user VARCHAR(20) NOT NULL,
    last_modification_date TIMESTAMPTZ,
    creation_date DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (account_number),
    CONSTRAINT fk_account FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

DROP TABLE  IF EXISTS transactions;
CREATE TABLE transactions(
    id SERIAL,
    account_number INT NOT NULL,
    transaction_description VARCHAR(256) DEFAULT 'none',
    transaction_value FLOAT4 NOT NULL DEFAULT 0.00,
    transaction_type_m VARCHAR(10) NOT NULL CHECK (transaction_type_m IN ('credit','debit')),
    transaction_balance FLOAT4 DEFAULT 0.00,
    transaction_balance_available FLOAT4 DEFAULT 0.00,
    transaction_creation_date DATE DEFAULT CURRENT_DATE,
    CONSTRAINT fk_transaction FOREIGN KEY (account_number) REFERENCES accounts(account_number)
);
 

