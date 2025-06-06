-- Tabla de tarifas (solo para microservicio tarifa-reserva)
CREATE TABLE IF NOT EXISTS tarifas (
                                       id SERIAL PRIMARY KEY,
                                       tipo_dia INT NOT NULL,        -- 0: NORMAL, 1: FINDE, 2: FERIADO
                                       tipo_reserva INT NOT NULL,    -- 0: VUELTAS_10, 1: VUELTAS_15, 2: VUELTAS_20
                                       valor INT NOT NULL,
                                       CONSTRAINT unique_tarifa UNIQUE (tipo_dia, tipo_reserva)
);

-- Insertar tarifas base
INSERT INTO tarifas (tipo_dia, tipo_reserva, valor) VALUES
-- Tarifas para días NORMALES (tipo_dia = 0)
(0, 0, 15000),  -- NORMAL, VUELTAS_10
(0, 1, 20000),  -- NORMAL, VUELTAS_15
(0, 2, 25000),  -- NORMAL, VUELTAS_20

-- Tarifas para FINES DE SEMANA (tipo_dia = 1)
(1, 0, 30),     -- FINDE, VUELTAS_10
(1, 1, 17000),  -- FINDE, VUELTAS_15
(1, 2, 21000),  -- FINDE, VUELTAS_20

-- Tarifas para FERIADOS (tipo_dia = 2)
(2, 0, 15000),  -- FERIADO, VUELTAS_10
(2, 1, 20000),  -- FERIADO, VUELTAS_15
(2, 2, 25000)   -- FERIADO, VUELTAS_20
ON CONFLICT DO NOTHING;