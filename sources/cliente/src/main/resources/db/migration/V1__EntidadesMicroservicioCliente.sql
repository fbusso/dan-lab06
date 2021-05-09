CREATE TABLE usuario
(
    id             SERIAL PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL,
    contrasenia    VARCHAR(50) NOT NULL
);

CREATE TABLE tipo_cliente
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL
);

CREATE TABLE cliente
(
    id              SERIAL PRIMARY KEY,
    cuit            VARCHAR(11) NOT NULL,
    fecha_baja      DATE DEFAULT NULL,
    razon_social    VARCHAR(50) NOT NULL,
    usuario_id      INTEGER     NOT NULL,
    tipo_cliente_id INTEGER     NOT NULL,
    CONSTRAINT fk_cliente_tipo_cliente FOREIGN KEY (tipo_cliente_id) REFERENCES tipo_cliente (id),
    CONSTRAINT fk_cliente_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);


CREATE TABLE tipo_obra
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL
);

CREATE TABLE obra
(
    id           SERIAL PRIMARY KEY,
    nombre       VARCHAR(30)  NOT NULL,
    cliente_id   INTEGER      NOT NULL,
    descripcion  VARCHAR(255) NOT NULL,
    tipo_obra_id INTEGER      NOT NULL,
    CONSTRAINT fk_obra_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id),
    CONSTRAINT fk_obra_tipo_obra FOREIGN KEY (tipo_obra_id) REFERENCES tipo_obra (id)
);