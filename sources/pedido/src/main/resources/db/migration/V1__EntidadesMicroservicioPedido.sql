CREATE TABLE estado_pedido
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE pedido
(
    id               SERIAL PRIMARY KEY,
    fecha_envio      DATE    NOT NULL,
    obra             INTEGER NOT NULL,
    estado_pedido_id INTEGER NOT NULL REFERENCES estado_pedido(id)
);

CREATE TABLE detalle
(
    id        SERIAL PRIMARY KEY,
    material  VARCHAR(20) NOT NULL,
    cantidad  INTEGER     NOT NULL,
    pedido_id INTEGER     NOT NULL REFERENCES pedido (id)
);

INSERT INTO estado_pedido (id, nombre)
VALUES (1, 'NUEVO'),
       (2, 'CONFIRMADO'),
       (3, 'PENDIENTE'),
       (4, 'CANCELADO'),
       (5, 'ACEPTADO'),
       (6, 'RECHAZADO'),
       (7, 'EN PREPARACIÓN'),
       (8, 'ENTREGADO');