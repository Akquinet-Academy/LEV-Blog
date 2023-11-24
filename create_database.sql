CREATE TABLE user (
    user_id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    is_admin BOOLEAN
);

CREATE TABLE post (
    post_id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    title VARCHAR(50),
    user_id INTEGER,
    date DATE,
    text VARCHAR(50),

);

CREATE TABLE character (
    id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    actor_id INTEGER UNIQUE
);

CREATE TABLE season (
    id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    num INTEGER,
    series_id INTEGER
);

CREATE TABLE fraction (
    id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    num INTEGER,
    title VARCHAR(50),
    description VARCHAR(200),
    season_id INTEGER
);

ALTER TABLE post
ADD CONSTRAINT fk_post
FOREIGN KEY (user_id)
REFERENCES user(user_id);

ALTER TABLE actor
ADD CONSTRAINT fk_series_actor
FOREIGN KEY (series_id)
REFERENCES series(id);

ALTER TABLE season
ADD CONSTRAINT fk_series_season
FOREIGN KEY (series_id)
REFERENCES series(id);

ALTER TABLE fraction
ADD CONSTRAINT fk_season
FOREIGN KEY (season_id)
REFERENCES season(id);
