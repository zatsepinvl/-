INSERT INTO users(
            email, password, username)
    VALUES ('some1@mail.com','qwerty', 'some1');

INSERT INTO users(
            email,password, username)
    VALUES ('some2@mail.com', 'qwerty', 'some2');

INSERT INTO followers(
            user_id, follower_id)
    VALUES (1, 2);

INSERT INTO followers(
            user_id, follower_id)
    VALUES (2, 1);

INSERT INTO messages(
            text, user_id, time)
    VALUES ('Hi! Iam some1', 1, '01-01-2015');

INSERT INTO messages(
            text, user_id, time)
    VALUES ('Hi! Iam some2', 2, '01-01-2015');

