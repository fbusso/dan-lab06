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
    observacion VARCHAR(255),
    dtype VARCHAR(50),
    pago_id INTEGER,
    cbu_origen VARCHAR(50),
    cbu_destino VARCHAR(50),
    codigo_transferencia VARCHAR(50),
    numero_recibo INTEGER UNIQUE,
    numero_cheque INTEGER UNIQUE,
    fecha_cobro DATE,
    banco VARCHAR(50),
    CONSTRAINT fk_pago FOREIGN KEY (pago_id) REFERENCES pago(id)
);



