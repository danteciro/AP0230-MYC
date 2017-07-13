ALTER TABLE PGH_OBLIGACION_TIPIFICACION ADD ID_ACTIVIDAD NUMBER(10);
ALTER TABLE PGH_OBLI_TIPI_CRITERIO ADD ID_ACTIVIDAD NUMBER(10);

COMMENT ON COLUMN PGH_OBLIGACION_TIPIFICACION.ID_ACTIVIDAD IS 'Identificador para determinar quE actividad est� asociada a la obligaci�n y tipificaci�n(TABLA MDI_ACTIVIDAD)';
COMMENT ON COLUMN PGH_OBLI_TIPI_CRITERIO.ID_ACTIVIDAD IS 'Identificador para determinar qu� actividad est� asociada a la obligaci�n, tipificaci�n y criterio(TABLA MDI_ACTIVIDAD)';