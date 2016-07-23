CREATE TABLE players (
	name VARCHAR(45) NOT NULL,
	id VARCHAR(128) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE discs (
	disc_id VARCHAR(128) NOT NULL,
	model VARCHAR(45) NOT NULL,
	owner_id VARCHAR(128) NOT NULL,
	brand VARCHAR(128) NOT NULL,
	description_text VARCHAR(512),
	weight INTEGER NOT NULL,
	PRIMARY KEY(disc_id),
	CONSTRAINT fk_disc_owner FOREIGN KEY (owner_id) REFERENCES players(id)
);

CREATE INDEX fk_disc_owner_idx ON discs (owner_id);

INSERT INTO players (name, id) VALUES (
	'brennan', 
	'user0'
);

INSERT INTO discs (disc_id, model, owner_id, brand, description_text, weight) VALUES (
	'disc0',
	'gauntlet',
	'user0',
	'Latitude 64',
	'gauntlet description',
	'172'
);

INSERT INTO discs (disc_id, model, owner_id, brand, description_text, weight) VALUES (
	'disc1',
	'saint pro',
	'user0',
	'Latitude 64',
	'saint pro description',
	'173'
);

INSERT INTO discs (disc_id, model, owner_id, brand, description_text, weight) VALUES (
	'disc2',
	'world',
	'user0',
	'Latitude 64',
	'world description',
	'174'
);

INSERT INTO discs (disc_id, model, owner_id, brand, description_text, weight) VALUES (
	'disc3',
	'enforcer',
	'user0',
	'Dynamic Discs',
	'enforcer description',
	'175'
);
