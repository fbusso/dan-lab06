CREATE TABLE producto
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    precio NUMERIC(18, 2)     NOT NULL,
    stock  INTEGER            NOT NULL
);
