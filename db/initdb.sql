--CREATE USER sophos WITH PASSWORD 'mybank';
--DROP DATABASE IF EXISTS bank;
--CREATE DATABASE bank;
--GRANT ALL PRIVILEGES ON DATABASE bank TO sophos;
--\connect bank sophos;
--SET TIMEZONE = 'America/Bogota';

DROP TABLE IF EXISTS customers;
CREATE TABLE customers(
    id SERIAL,
    id_type VARCHAR(10),
    customer_id INTEGER NOT NULL CHECK (customer_id > 0),
    customer_name VARCHAR(20) NOT NULL,
    customer_surname VARCHAR(20) NOT NULL,
    customer_birthdate DATE NOT NULL,
    customer_email VARCHAR(100) NOT NULL,
    customer_phone VARCHAR(10) NOT NULL DEFAULT '0000000000',
    creation_user VARCHAR(20) NOT NULL DEFAULT 'admin',
    last_modification_user VARCHAR(20) NOT NULL DEFAULT 'admin',
    last_modification_date TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    creation_date DATE DEFAULT CURRENT_DATE,
    UNIQUE(customer_email),
    PRIMARY KEY(customer_id)
);

CREATE TYPE status_enum AS ENUM ('active','inactive','canceled');
CREATE TYPE acc_type_enum AS ENUM ('corriente','ahorros');

DROP TABLE  IF EXISTS accounts;
CREATE TABLE accounts(
    id SERIAL,
    customer_id BIGINT NOT NULL CHECK (customer_id > 0),
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
    CONSTRAINT fk_account FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
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

-- data for customers table
INSERT INTO customers VALUES(1,'cc',11111,'name1','surname1','2000-01-01','email1@sample.co','3126547777','admin','admin',DEFAULT,'2020-01-01 20:20:20-01');
INSERT INTO customers VALUES(2,'cc',22222,'name2','surname2','1998-03-15','email2@sample.dev','3026549999','admin','admin',DEFAULT,'2019-01-24 20:20:20-01');
INSERT INTO customers VALUES(3,'cc',33333,'name3','surname3','1992-17-04','email3@sample.co','3216542222','admin','admin',DEFAULT,'2006-06-05 20:20:20-01');
-- data for accounts table
INSERT INTO accounts VALUES(1, 11111, 'ahorros', 4612345678, 'active', 'TRUE', 2000.00, DEFAULT,'admin','admin',DEFAULT,'2020-01-01 20:20:20-01');
INSERT INTO accounts VALUES(2, 22222, 'ahorros', 4666666666, 'active', 'TRUE', 5000.00, DEFAULT,'admin','admin',DEFAULT,'2019-01-24 20:20:20-01');
INSERT INTO accounts VALUES(3, 33333, 'corriente', 2398765432, 'active', 'FALSE', 12000.00, DEFAULT,'admin','admin',DEFAULT,'2006-06-05 20:20:20-01');
-- data for transactions table
INSERT INTO transactions VALUES(0,101010,4612345678,NULL,'sample transaction','debit',200.00,3000.00,3000.00,DEFAULT);

INSERT INTO transactions VALUES(1,202020,4612345678,4666666666,'sample transaction','credit',200.00,3000.00,3000.00,DEFAULT);
INSERT INTO transactions VALUES(2,303030,4666666666,NULL,'sample transaction','debit',200.00,3000.00,3000.00,DEFAULT);
INSERT INTO transactions VALUES(3,404040,4612345678,NULL,'sampletransaction','debit',200.00,3000.00,3000.00,DEFAULT);
INSERT INTO transactions VALUES(4,505050,4666666666,2398765432,'sample transaction','credit',200.00,3000.00,3000.00,DEFAULT);
INSERT INTO transactions VALUES(5,606060,2398765432,NULL,'sample transaction','debit',200.00,3000.00,3000.00,DEFAULT);
INSERT INTO transactions VALUES(6,707070,2398765432,4666666666,'sample transaction','credit',200.00,3000.00,3000.00,DEFAULT);