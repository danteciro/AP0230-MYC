ALTER TABLE PGH_DETALLE_BASE_LEGAL ADD ID_NRO_DISPOSICION NUMBER(10);
ALTER TABLE PGH_DETALLE_BASE_LEGAL ADD ID_TIPO_DISPOSICION NUMBER(10);
ALTER TABLE PGH_DETALLE_BASE_LEGAL ADD FLG_DISPOSICION CHAR(1);

comment on column PGH_DETALLE_BASE_LEGAL.Id_Nro_Disposicion  is 'Indica el numero de disposicion asociado a una base legal(MDI_MAESTRO_COLUMNA,NRO_DISPOSICION)';
comment on column PGH_DETALLE_BASE_LEGAL.Id_Tipo_Disposicion  is 'Indica el tipo de disposicion asociado a una base legal(MDI_MAESTRO_COLUMNA,TIPO_DISPOSICION)';
comment on column PGH_DETALLE_BASE_LEGAL.Flg_Disposicion  is 'Indica si la base legal registrada es una disposicion complementaria(SI : 1, NO : NULL)';