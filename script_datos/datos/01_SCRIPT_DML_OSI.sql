insert into PGH_OPCION (ID_OPCION, NOMBRE_OPCION, DESCRIPCION_OPCION, IDENTIFICADOR_OPCION, PAGE_OPCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION, APLICACION)
values (PGH_OPCION_SEQ.nextval, 'TIPO DE SUPERVISION', null, 'ID_TIPIFICACION', null, '1', 'JSIFUENTES', SYSDATE, 'LOCALHOST', null, null, null, 'MYC');
insert into PGH_OPCION (ID_OPCION, NOMBRE_OPCION, DESCRIPCION_OPCION, IDENTIFICADOR_OPCION, PAGE_OPCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION, APLICACION)
values (PGH_OPCION_SEQ.nextval, 'SANCIONES', null, 'ID_SANCION', null, '1', 'JSIFUENTES', SYSDATE, 'LOCALHOST', null, null, null, 'MYC');
insert into PGH_OPCION (ID_OPCION, NOMBRE_OPCION, DESCRIPCION_OPCION, IDENTIFICADOR_OPCION, PAGE_OPCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION, APLICACION)
values (PGH_OPCION_SEQ.nextval, 'MEDIDA DE SEGURIDAD', null, 'ID_MED_SEG', null, '1', 'JSIFUENTES', SYSDATE, 'LOCALHOST', null, null, null, 'MYC');
insert into PGH_OPCION (ID_OPCION, NOMBRE_OPCION, DESCRIPCION_OPCION, IDENTIFICADOR_OPCION, PAGE_OPCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION, APLICACION)
values (PGH_OPCION_SEQ.nextval, 'DESCRIPCIONES', null, 'ID_DESCRP', null, '1', 'JSIFUENTES', SYSDATE, 'LOCALHOST', null, null, null, 'MYC');
insert into PGH_OPCION (ID_OPCION, NOMBRE_OPCION, DESCRIPCION_OPCION, IDENTIFICADOR_OPCION, PAGE_OPCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION, APLICACION)
values (PGH_OPCION_SEQ.nextval, 'REFERENCIAR BASE LEGAL', null, 'ID_REF_B_L', null, '1', 'JSIFUENTES', SYSDATE, 'LOCALHOST', null, null, null, 'MYC');
insert into PGH_OPCION (ID_OPCION, NOMBRE_OPCION, DESCRIPCION_OPCION, IDENTIFICADOR_OPCION, PAGE_OPCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION, APLICACION)
values (PGH_OPCION_SEQ.nextval, 'TEMAS', null, 'ID_TEMAS', null, '1', 'JSIFUENTES', SYSDATE, 'LOCALHOST', null, null, null, 'MYC');

UPDATE pgh_opcion SET aplicacion = 'INPS' WHERE  aplicacion <> 'MYC';

insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA ENVASADORA DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_SANCION'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA ENVASADORA DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_DESCRP'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA ENVASADORA DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_REF_B_L'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA ENVASADORA DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_TEMAS'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA DE ABASTECIMIENTO DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_TIPIFICACION'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA DE ABASTECIMIENTO DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_SANCION'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA DE ABASTECIMIENTO DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_MED_SEG'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA DE ABASTECIMIENTO DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_DESCRP'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA DE ABASTECIMIENTO DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_REF_B_L'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA DE ABASTECIMIENTO DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_TEMAS'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);
insert into PGH_OPCION_ACTIVIDAD (ID_OPCION_ACTIVIDAD, ID_ACTIVIDAD, ID_OPCION, NRO_ORDEN, ID_PADRE, COD_TRAZABILIDAD, COD_ACCION, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (PGH_OPCION_ACTIVIDAD_SEQ.nextval, (SELECT id_actividad FROM mdi_actividad WHERE nombre = 'PLANTA ENVASADORA DE GLP'), (SELECT ID_OPCION FROM PGH_OPCION WHERE identificador_opcion = 'ID_TIPIFICACION'), null, null, null, null, '1', '00001', SYSDATE, '10.241.162.93', null, null, null);


