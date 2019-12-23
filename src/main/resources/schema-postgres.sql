/*DROP TABLE IF EXISTS friend;*/
/*DROP TABLE IF EXISTS profile;*/

CREATE TABLE profile(
	id SERIAL PRIMARY KEY,
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

CREATE TABLE friend(
	relation_id SERIAL PRIMARY KEY,
	profile_id INTEGER REFERENCES profile(id),
	friend_id INTEGER REFERENCES profile(id)
);
