
ALTER TABLE pgh_detalle_base_legal ADD NUMERO_TIPO_ANEXO VARCHAR2(38) NULL; 
COMMENT ON COLUMN pgh_detalle_base_legal.numero_tipo_anexo IS 'Extension del tipo de Anexos';

CREATE TABLE PGH_ESCENARIO_INCUMPLIMIENTO
(
  ID_ESCE_INCUMPLIMIENTO         NUMBER(10) NOT NULL ,
  ID_INFRACCION                  NUMBER(10) NOT NULL ,
  ID_ESCE_INCU_MAESTRO NUMBER(10) NOT NULL ,
  ID_PADRE                       NUMBER NULL ,
  COD_TRAZABILIDAD               VARCHAR2(20) NULL ,
  COD_ACCION                     VARCHAR(1) NULL,
  ESTADO                         CHAR(1) NOT NULL ,
  USUARIO_CREACION               VARCHAR2(38) NOT NULL ,
  FECHA_CREACION                 DATE NOT NULL ,
  TERMINAL_CREACION              VARCHAR(38) NOT NULL ,
  USUARIO_ACTUALIZACION          VARCHAR2(38) NULL ,
  FECHA_ACTUALIZACION            DATE NULL ,
  TERMINAL_ACTUALIZACION         VARCHAR(38) NULL  
);

  
CREATE UNIQUE INDEX PGH_ESNRIO_INCPNTO_IDX ON PGH_ESCENARIO_INCUMPLIMIENTO
(ID_ESCE_INCUMPLIMIENTO   ASC);

ALTER TABLE PGH_ESCENARIO_INCUMPLIMIENTO
  ADD CONSTRAINT  PGH_ESNRIO_INCPNTO_PK PRIMARY KEY (ID_ESCE_INCUMPLIMIENTO);


ALTER TABLE PGH_ESCENARIO_INCUMPLIMIENTO
  ADD (CONSTRAINT PGH_INFRA_INFR_FK FOREIGN KEY (ID_INFRACCION) REFERENCES PGH_INFRACCION (ID_INFRACCION) ON DELETE SET NULL);


comment on table PGH_ESCENARIO_INCUMPLIMIENTO
  is 'Tabla que contiene los escenarios de incumplimientos.';
  
comment on column PGH_ESCENARIO_INCUMPLIMIENTO.ID_ESCE_INCUMPLIMIENTO
  is 'Identificador principal de Escenario de Incumplimiento, es un número correlativo.';
  
comment on column PGH_ESCENARIO_INCUMPLIMIENTO.ID_INFRACCION
  is 'Identificador de la Tabla infracción.';

comment on column PGH_ESCENARIO_INCUMPLIMIENTO.ID_ESCE_INCU_MAESTRO
  is 'Indica Escenarios de Incumplimientos. Proviene de la tabla MDI_MAESTRO_COLUMNA.';
  
comment on column PGH_ESCENARIO_INCUMPLIMIENTO.ID_PADRE
  is 'Identificador referencial principal - creado para trazabilidad.';
  
comment on column PGH_ESCENARIO_INCUMPLIMIENTO.COD_TRAZABILIDAD
  is 'Código identificador único de cambios a las entidades de obligaciones y de base legal.';

comment on column PGH_ESCENARIO_INCUMPLIMIENTO.COD_ACCION
  is 'Código identificador de Acción usado para Trazabilidad (Valores: N-U-D, Significado: New-Update-Delete).';

comment on column PGH_ESCENARIO_INCUMPLIMIENTO.ESTADO
  is 'Indica si el registro se encuentra vigente: 0, no se encuentra vigente: 1.';
  
comment on column PGH_ESCENARIO_INCUMPLIMIENTO.USUARIO_CREACION
  is 'Usuario creador del registro.';
  
comment on column PGH_ESCENARIO_INCUMPLIMIENTO.FECHA_CREACION
  is 'Fecha en la que se creó el registro (Formato: DD/MM/YYYY hh:mm:ss).';  
  
comment on column PGH_ESCENARIO_INCUMPLIMIENTO.TERMINAL_CREACION
  is 'Terminal de creación.';

comment on column PGH_ESCENARIO_INCUMPLIMIENTO.USUARIO_ACTUALIZACION  
  is 'Usuario que modificó el registro por última vez.';

comment on column PGH_ESCENARIO_INCUMPLIMIENTO.FECHA_ACTUALIZACION 
  is 'Fecha en la que se modificó el registro por última vez (Formato: DD/MM/YYYY hh:mm:ss).';

comment on column PGH_ESCENARIO_INCUMPLIMIENTO.TERMINAL_ACTUALIZACION 
  is 'Terminal que modificó el registro por última vez.';


create sequence PGH_ESCE_INCUMPLIMIENTO_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

