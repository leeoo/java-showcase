/* Master on Postgres */
CREATE DATABASE master_slave_demo;

CREATE TABLE account(
    id SERIAL,
    version INTEGER NOT NULL,
    account_group_id INTEGER,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    salt VARCHAR(255),
    password_hint VARCHAR(50),
    gender VARCHAR(20),
    age INTEGER,
    phone_number VARCHAR(50),
    email VARCHAR(50),
    description VARCHAR(255),
    account_enabled BOOLEAN,
    account_locked BOOLEAN,
    account_expired BOOLEAN,
    credentials_expired BOOLEAN,
    created_by VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50),
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE account_group(
    id SERIAL,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
    created_by VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50),
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

/* Slave on MySQL */
CREATE DATABASE IF NOT EXISTS master_slave_demo;
USE master_slave_demo;

CREATE TABLE account(
    id INTEGER,
    version INTEGER NOT NULL,
    account_group_id INTEGER,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    salt VARCHAR(255),
    password_hint VARCHAR(50),
    gender VARCHAR(20),
    age INTEGER,
    phone_number VARCHAR(50),
    email VARCHAR(50),
    description VARCHAR(255),
    account_enabled BOOLEAN,
    account_locked BOOLEAN,
    account_expired BOOLEAN,
    credentials_expired BOOLEAN,
    created_by VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_by VARCHAR(50),
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
);

CREATE TABLE account_group(
    id INTEGER,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
    created_by VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_by VARCHAR(50),
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
);

