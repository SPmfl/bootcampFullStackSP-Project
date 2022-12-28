--CREATE USER sophos WITH PASSWORD 'mybank';
--DROP DATABASE IF EXISTS bank;
--CREATE DATABASE bank;
--GRANT ALL PRIVILEGES ON DATABASE bank TO sophos;
--\connect bank sophos;
--SET TIMEZONE = 'America/Bogota';

DROP TABLE IF EXISTS clients;
CREATE TABLE clients(
    id SERIAL,
    id_type VARCHAR(10),
    client_id INTEGER NOT NULL CHECK (client_id > 0),
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

CREATE TYPE status_enum AS ENUM ('active','inactive','canceled');
CREATE TYPE acc_type_enum AS ENUM ('corriente','ahorros');

DROP TABLE  IF EXISTS accounts;
CREATE TABLE accounts(
    id SERIAL,
    client_id BIGINT NOT NULL CHECK (client_id > 0),
    account_type acc_type_enum NOT NULL DEFAULT 'ahorros',
    account_number BIGINT NOT NULL CHECK(account_number > 0000000000),
    account_status status_enum NOT NULL DEFAULT 'active',
    account_gmf_status BOOLEAN NOT NULL DEFAULT TRUE,
    account_balance FLOAT DEFAULT 0.00,
    account_balance_available FLOAT GENERATED ALWAYS AS (
        case
            when account_gmf_status = TRUE then ( account_balance - ( (account_balance * 4) / 1000))
            when account_gmf_status = FALSE then account_balance
            else account_balance
        end 
    ) STORED,
    creation_user VARCHAR(20) NOT NULL,
    last_modification_user VARCHAR(20) NOT NULL,
    last_modification_date TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    creation_date DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (account_number),
    CONSTRAINT fk_account FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

CREATE TYPE type_m_enum AS ENUM ('credit','debit');

DROP TABLE  IF EXISTS transactions;
CREATE TABLE transactions(
    id SERIAL,
    transaction_id SERIAL,
    account_number_from BIGINT NOT NULL,
    account_number_to BIGINT,
    transaction_description VARCHAR(256) DEFAULT 'none',
    transaction_type_m type_m_enum NOT NULL DEFAULT 'debit',
    transaction_value FLOAT4 NOT NULL DEFAULT 0.00,
    transaction_balance FLOAT4 DEFAULT 0.00,
    transaction_balance_available FLOAT4 DEFAULT 0.00,
    transaction_creation_date DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (transaction_id),
    CONSTRAINT fk_transaction_from FOREIGN KEY (account_number_from) REFERENCES accounts(account_number),
    CONSTRAINT fk_transaction_to FOREIGN KEY (account_number_to) REFERENCES accounts(account_number)
);


-- creating sample data for testing

-- data for clients table
INSERT INTO clients VALUES(0,'cc',11111,'name1','surname1','2000-01-01','email1@sample.co','admin','admin','2020-01-01 20:20:20-01',DEFAULT);

-- data for accounts table
INSERT INTO accounts VALUES(0, 11111, 'ahorros', 4612345678, 'active', 'FALSE', 3000.00,DEFAULT,'admin','admin','2020-06-07 19:20:20-01',DEFAULT);

-- data for transactions table
INSERT INTO transactions VALUES(0,101010,4612345678,NULL,'sample debit transaction','debit',200.00,3000.00,3000.00,DEFAULT);