CREATE TABLE Users (
	user_id bigserial NOT NULL,
	email TEXT NOT NULL UNIQUE,
	password TEXT NOT NULL,
	username TEXT NOT NULL UNIQUE,
	last_name TEXT,
	first_name TEXT,
	image_id TEXT,
	CONSTRAINT Users_pk PRIMARY KEY (user_id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE Followers (
	user_id bigint NOT NULL,
	follower_id bigint NOT NULL,
	CONSTRAINT Followers_pk PRIMARY KEY (user_id,follower_id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE Messages (
	message_id bigserial NOT NULL,
	text TEXT NOT NULL,
	user_id bigint NOT NULL,
	time TIMESTAMP NOT NULL,
	file_id bigint,
	CONSTRAINT Messages_pk PRIMARY KEY (message_id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE Files (
	file_id bigserial NOT NULL,
	url TEXT,
	CONSTRAINT Files_pk PRIMARY KEY (file_id)
) WITH (
  OIDS=FALSE
);



ALTER TABLE Users ADD CONSTRAINT Users_fk0 FOREIGN KEY (image_id) REFERENCES Files(file_id);

ALTER TABLE Followers ADD CONSTRAINT Followers_fk0 FOREIGN KEY (user_id) REFERENCES Users(user_id);
ALTER TABLE Followers ADD CONSTRAINT Followers_fk1 FOREIGN KEY (follower_id) REFERENCES Users(user_id);

ALTER TABLE Messages ADD CONSTRAINT Messages_fk0 FOREIGN KEY (user_id) REFERENCES Users(user_id);
ALTER TABLE Messages ADD CONSTRAINT Messages_fk1 FOREIGN KEY (file_id) REFERENCES Files(file_id);



