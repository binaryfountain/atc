DROP TABLE IF EXISTS aircraft;
CREATE TABLE aircraft (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    type VARCHAR,
    size VARCHAR
);

CREATE TABLE aircraft_type (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    type VARCHAR
);

CREATE TABLE aircraft_size (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    size VARCHAR
);