CREATE TABLE pago
(
    id             SERIAL PRIMARY KEY,
    fecha_pago DATE UNIQUE NOT NULL,
    cliente_id INTEGER NOT NULL,
    monto NUMERIC NOT NULL
);

CREATE TABLE medio_pago
(
    id     SERIAL PRIMARY KEY,
    observacion VARCHAR(255) NOT NULL,
    pago_id INTEGER NOT NULL,
    CONSTRAINT fk_pago FOREIGN KEY (pago_id) REFERENCES pago(id)
);

CREATE TABLE cheque
(
    id     SERIAL PRIMARY KEY,
    numero_cheque INTEGER UNIQUE NOT NULL,
    fecha_cobro DATE NOT NULL,
    banco VARCHAR(50) NOT NULL,
    medio_pago_id INTEGER NOT NULL,
    CONSTRAINT fk_cheque_medio_pago FOREIGN KEY (medio_pago_id) REFERENCES medio_pago(id)
);

CREATE TABLE efectivo
(
    id     SERIAL PRIMARY KEY,
    numero_recibo INTEGER UNIQUE NOT NULL,
    medio_pago_id INTEGER NOT NULL,
    CONSTRAINT fk_efectivo_medio_pago FOREIGN KEY (medio_pago_id) REFERENCES medio_pago(id)
);

CREATE TABLE transferencia
(
    id     SERIAL PRIMARY KEY,
    cbu_origen VARCHAR(50) NOT NULL,
    cbu_destino VARCHAR(50) NOT NULL,
    codigo_transferencia VARCHAR(50) NOT NULL,
    medio_pago_id INTEGER NOT NULL,
    CONSTRAINT fk_transferencia_medio_pago FOREIGN KEY (medio_pago_id) REFERENCES medio_pago(id)
);



