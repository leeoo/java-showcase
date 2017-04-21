
DROP TABLE IF EXISTS account;
CREATE TABLE account
(
  id SERIAL PRIMARY KEY NOT NULL,
  version INTEGER,
  username VARCHAR(32) NOT NULL,
  password VARCHAR(16) NOT NULL,
  gender CHAR(1),
  age INTEGER,
  group_id INTEGER NOT NULL,
  valid BOOLEAN DEFAULT true,
  create_at TIMESTAMP,
  update_at TIMESTAMP
);
CREATE UNIQUE INDEX account_username_key ON account (username);


DROP TABLE IF EXISTS account_group;
CREATE TABLE account_group
(
  id SERIAL PRIMARY KEY NOT NULL,
  version INTEGER,
  group_name VARCHAR(32) NOT NULL,
  group_id INTEGER NOT NULL,
  valid BOOLEAN DEFAULT true,
  create_at TIMESTAMP,
  update_at TIMESTAMP
);
CREATE UNIQUE INDEX account_group_group_name_key ON account_group (group_name);


