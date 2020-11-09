
/**
 * Author:  Group EE
 * Created: Oct 27, 2020
 */

DROP DATABASE IF EXISTS groupDB;

CREATE DATABASE  groupDB;

USE groupDB;

DROP TABLE IF EXISTS users;

CREATE TABLE users(
username VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
firstname VARCHAR(20),
lastname VARCHAR(20),
email VARCHAR(40),
CONSTRAINT PK_username PRIMARY KEY (username));

INSERT INTO users VALUES('admin', 'password', 'AD', 'MIN', 'something@somesite.ca');
INSERT INTO users VALUES('user1', 'password', 'John', 'Smith', 'something@somesite.ca');
INSERT INTO users VALUES('somethingCreative', 'password', 'Jane', 'Doe', 'something@somesite.ca');
INSERT INTO users VALUES('otherUser', 'password', 'Curious', 'George', 'something@somesite.ca');

