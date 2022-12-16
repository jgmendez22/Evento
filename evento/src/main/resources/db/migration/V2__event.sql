CREATE TABLE IF NOT EXISTS event(
    id SERIAL NOT NULL,
    fullname VARCHAR(50) NOT NULL,
    description VARCHAR(25) NOT NULL,
    place VARCHAR(25) NOT NULL,
    PRIMARY KEY(id)
    )