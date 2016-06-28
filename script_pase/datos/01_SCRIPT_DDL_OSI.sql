alter table PGH_OPCION add APLICACION VARCHAR2(25);
comment on column PGH_OPCION.APLICACION  is 'Nombre de la aplicación que pertenece';
  
create table PGH_OPCION_ACTIVIDAD
(
  ID_OPCION_ACTIVIDAD    NUMBER(10) not null,
  ID_ACTIVIDAD           NUMBER(10),
  ID_OPCION              NUMBER(10),
  NRO_ORDEN              NUMBER(10),
  ID_PADRE               NUMBER,
  COD_TRAZABILIDAD       VARCHAR2(20),
  COD_ACCION             VARCHAR2(1),
  ESTADO                 CHAR(1) not null,
  USUARIO_CREACION       VARCHAR2(38) not null,
  FECHA_CREACION         DATE not null,
  TERMINAL_CREACION      VARCHAR2(38) not null,
  USUARIO_ACTUALIZACION  VARCHAR2(38),
  FECHA_ACTUALIZACION    DATE,
  TERMINAL_ACTUALIZACION VARCHAR2(38)
);

comment on column PGH_OPCION_ACTIVIDAD.ID_OPCION_ACTIVIDAD
  is 'Identificador de la Tabla Opción Actividad, es un número correlativo.';
comment on column PGH_OPCION_ACTIVIDAD.ID_ACTIVIDAD
  is 'Identificador del registro en la entidad / tabla. Secuencia: MDI_ACTIVIDAD_SEQ';
comment on column PGH_OPCION_ACTIVIDAD.ID_OPCION
  is 'Identificador de la opción.Secuencia: PGH_OPCION_SEQ';
comment on column PGH_OPCION_ACTIVIDAD.NRO_ORDEN
  is 'Indica el orden de las Opciones';
comment on column PGH_OPCION_ACTIVIDAD.ID_PADRE
  is 'Identificador referencial principal - creado para trazabilidad';
comment on column PGH_OPCION_ACTIVIDAD.COD_TRAZABILIDAD
  is 'Código identificador único de cambios a las entidades de obligaciones y de base legal';
comment on column PGH_OPCION_ACTIVIDAD.COD_ACCION
  is 'Código identificador de Acción usado para Trazabilidad (Valores: N-U-D, Significado: New-Update-Delete)';
comment on column PGH_OPCION_ACTIVIDAD.ESTADO
  is 'ndica si el registro se encuentra vigente: 0, no se encuentra vigente: 1.';
comment on column PGH_OPCION_ACTIVIDAD.USUARIO_CREACION
  is 'Usuario creador del registro.';
comment on column PGH_OPCION_ACTIVIDAD.FECHA_CREACION
  is 'Fecha en la que se creó el registro (Formato: DD/MM/YYYY hh:mm:ss).';
comment on column PGH_OPCION_ACTIVIDAD.TERMINAL_CREACION
  is 'Terminal de creación.';
comment on column PGH_OPCION_ACTIVIDAD.USUARIO_ACTUALIZACION
  is 'Usuario que modificó el registro por última vez.';
comment on column PGH_OPCION_ACTIVIDAD.FECHA_ACTUALIZACION
  is 'Fecha en la que se modificó el registro por última vez (Formato: DD/MM/YYYY hh:mm:ss).';
comment on column PGH_OPCION_ACTIVIDAD.TERMINAL_ACTUALIZACION
  is 'Terminal que modificó el registro por última vez.';
  
create unique index PGH_OPCION_ACTIVIDAD_IDX on PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD);

alter table PGH_OPCION_ACTIVIDAD
  add constraint PGH_OPCION_ACTIVIDAD_PK primary key (ID_OPCION_ACTIVIDAD);
alter table PGH_OPCION_ACTIVIDAD
  add constraint PGH_ACTI_OPCI_ACTI_FK foreign key (ID_ACTIVIDAD)
  references MDI_ACTIVIDAD (ID_ACTIVIDAD) on delete set null;
alter table PGH_OPCION_ACTIVIDAD
  add constraint PGH_OPCI_OPCI_ACTI_FK foreign key (ID_OPCION)
  references PGH_OPCION (ID_OPCION) on delete set null;
  
create sequence PGH_OPCION_ACTIVIDAD_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;


create table PGH_DETALLE_NORMA_TECNICA
(
  ID_DETALLE_NORMA_TECNICA  NUMBER(10) not null,
  ID_DETALLE_BASE_LEGAL     NUMBER(10),
  ID_TIPO_NORMA_TECNICA     NUMBER(10),
  DESCRIPCION_NORMA_TECNICA VARCHAR2(500),
  ID_PADRE                  NUMBER,
  COD_TRAZABILIDAD          VARCHAR2(20),
  COD_ACCION                VARCHAR2(1),
  ESTADO                    CHAR(1) not null,
  USUARIO_CREACION          VARCHAR2(38) not null,
  FECHA_CREACION            DATE not null,
  TERMINAL_CREACION         VARCHAR2(38) not null,
  USUARIO_ACTUALIZACION     VARCHAR2(38),
  FECHA_ACTUALIZACION       DATE,
  TERMINAL_ACTUALIZACION    VARCHAR2(38)
);

comment on column PGH_DETALLE_NORMA_TECNICA.ID_DETALLE_NORMA_TECNICA
  is 'Identificador principal de Detalle Norma Técnica, es un número correlativo.';
comment on column PGH_DETALLE_NORMA_TECNICA.ID_DETALLE_BASE_LEGAL
  is 'Identificador principal del Detalle de Base Legal, es un número correlativo.';
comment on column PGH_DETALLE_NORMA_TECNICA.ID_TIPO_NORMA_TECNICA
  is 'Tipo de Norma Técnica';
comment on column PGH_DETALLE_NORMA_TECNICA.DESCRIPCION_NORMA_TECNICA
  is 'Descripción de Norma Técnica.';
comment on column PGH_DETALLE_NORMA_TECNICA.ID_PADRE
  is 'Identificador referencial principal - creado para trazabilidad';
comment on column PGH_DETALLE_NORMA_TECNICA.COD_TRAZABILIDAD
  is 'Código identificador único de cambios a las entidades de obligaciones y de base legal';
comment on column PGH_DETALLE_NORMA_TECNICA.COD_ACCION
  is 'Código identificador de Acción usado para Trazabilidad (Valores: N-U-D, Significado: New-Update-Delete)';
comment on column PGH_DETALLE_NORMA_TECNICA.ESTADO
  is 'Indica si el registro se encuentra vigente: 0, no se encuentra vigente: 1.';
comment on column PGH_DETALLE_NORMA_TECNICA.USUARIO_CREACION
  is 'Usuario creador del registro.';
comment on column PGH_DETALLE_NORMA_TECNICA.FECHA_CREACION
  is 'Fecha en la que se creó el registro (Formato: DD/MM/YYYY hh:mm:ss).';
comment on column PGH_DETALLE_NORMA_TECNICA.TERMINAL_CREACION
  is 'Terminal de creación.';
comment on column PGH_DETALLE_NORMA_TECNICA.USUARIO_ACTUALIZACION
  is 'Usuario que modificó el registro por última vez.';
comment on column PGH_DETALLE_NORMA_TECNICA.FECHA_ACTUALIZACION
  is 'Fecha en la que se modificó el registro por última vez (Formato: DD/MM/YYYY hh:mm:ss).';
comment on column PGH_DETALLE_NORMA_TECNICA.TERMINAL_ACTUALIZACION
  is 'Terminal que modificó el registro por última vez.';
  
create unique index PGH_DETALLE_NORMA_TECNICA_IDX on PGH_DETALLE_NORMA_TECNICA (ID_DETALLE_NORMA_TECNICA);

alter table PGH_DETALLE_NORMA_TECNICA
  add constraint PGH_DETALLE_NORMA_TECNICA_PK primary key (ID_DETALLE_NORMA_TECNICA);
alter table PGH_DETALLE_NORMA_TECNICA
  add constraint PGH_DETA_BASE_NORM_TECN_FK foreign key (ID_DETALLE_BASE_LEGAL)
  references PGH_DETALLE_BASE_LEGAL (ID_DETALLE_BASE_LEGAL) on delete set null;
  
create sequence PGH_DETALLE_NORMA_TECNICA_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;
  