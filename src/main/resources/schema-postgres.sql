DROP TABLE IF EXISTS profile;
	
CREATE TABLE profile(
	id BIGINT PRIMARY KEY,
	email VARCHAR (150) UNIQUE NOT NULL,
	username VARCHAR (15) UNIQUE NOT NULL,
	description VARCHAR(500)
);

INSERT INTO profile (id, email, username, description)
VALUES (
	1,
	'admin@superduper.com',
	'Adminboi',
	'Admin maestro'
);