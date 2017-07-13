ALTER TABLE PGH_OBLIGACION_TIPIFICACION ADD ID_ACTIVIDAD NUMBER(10);
ALTER TABLE PGH_OBLI_TIPI_CRITERIO ADD ID_ACTIVIDAD NUMBER(10);

COMMENT ON COLUMN PGH_OBLIGACION_TIPIFICACION.ID_ACTIVIDAD IS 'Identificador para determinar quE actividad está asociada a la obligación y tipificación(TABLA MDI_ACTIVIDAD)';
COMMENT ON COLUMN PGH_OBLI_TIPI_CRITERIO.ID_ACTIVIDAD IS 'Identificador para determinar qué actividad estó asociada a la obligación, tipificación y criterio(TABLA MDI_ACTIVIDAD)';