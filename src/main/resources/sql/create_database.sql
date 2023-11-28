-- DROP DATABASE IF EXISTS blog;
--
-- CREATE DATABASE blog;

-- DROP OWNED BY admin;
--
-- DROP USER IF EXISTS blog;
--
-- CREATE USER admin WITH PASSWORD 'password' SUPERUSER;

CREATE TABLE users
(
    id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    is_admin BOOLEAN
);

CREATE TABLE comment
(
    id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    text VARCHAR(2000),
    date DATE,
    users_id INTEGER,
    post_id INTEGER
);

CREATE TABLE post
(
    id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    title VARCHAR(1000),
    image VARCHAR(1000),
    users_id INTEGER,
    date DATE,
    text VARCHAR(5000)
--     comment_id INTEGER REFERENCES comment (id) -- Uncommented this line
);

CREATE TABLE session
(
    id text PRIMARY KEY ,
    expires_at DATE,
    users_id INTEGER
);

ALTER TABLE post
    ADD CONSTRAINT fk_post_session
        FOREIGN KEY (users_id)
            REFERENCES users (id);

ALTER TABLE post
    ADD CONSTRAINT fk_post_user
        FOREIGN KEY (users_id)
            REFERENCES users (id);

-- ALTER TABLE post
--     ADD CONSTRAINT fk_post_comment
--         FOREIGN KEY (comment_id)
--             REFERENCES comment (id);

ALTER TABLE comment
    ADD CONSTRAINT fk_comment_user
        FOREIGN KEY (users_id)
            REFERENCES users (id);

ALTER TABLE comment
    ADD CONSTRAINT fk_comment_post
        FOREIGN KEY (post_id)
            REFERENCES post (id);
