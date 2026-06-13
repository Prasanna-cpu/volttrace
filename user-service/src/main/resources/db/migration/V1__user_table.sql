CREATE TABLE IF NOT EXISTS users (
                       id VARCHAR(255) NOT NULL PRIMARY KEY ,

                       name VARCHAR(255) NOT NULL,
                       surname VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       address VARCHAR(255) NOT NULL,
                       alerting BOOLEAN NOT NULL,
                       energy_alerting_threshold DOUBLE NOT NULL,

                       created_at DATETIME(6),
                       created_by VARCHAR(255),
                       updated_at DATETIME(6),
                       updated_by VARCHAR(255)
);

CREATE INDEX idx_email ON users (email);
