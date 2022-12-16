CREATE TABLE IF NOT EXISTS people(
    id SERIAL NOT NULL,
    fullname VARCHAR(50) NOT NULL,
    email VARCHAR(25) NOT NULL,
    PRIMARY KEY(id)
    )