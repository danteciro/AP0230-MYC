
/* MAESTRO TABLA */
insert into mdi_maestro_tabla
  (descripcion, dominio, usuario_actualizacion, usuario_creacion, fecha_creacion, fecha_actualizacion, terminal_actualizacion, terminal_creacion, es_editable, aplicacion)
values
  ('TIPO DE DISPOSICION', 'TIPO_DISPOSICION', NULL, 'SYSTEM', SYSDATE, NULL, NULL, 'LOCALHOST', 'SI', 'MYC');
  

insert into mdi_maestro_tabla
  (descripcion, dominio, usuario_actualizacion, usuario_creacion, fecha_creacion, fecha_actualizacion, terminal_actualizacion, terminal_creacion, es_editable, aplicacion)
values
  ('NUMERO DE DISPOSICION', 'NRO_DISPOSICION', NULL, 'SYSTEM', SYSDATE, NULL, NULL, 'LOCALHOST', 'SI', 'MYC');
  

/* MAESTRO COLUMNA */
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Unica', 'NDISP00', 1282, 'NRO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Primera', 'NDISP01', 1283, 'NRO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Segunda', 'NDISP02', 1284, 'NRO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Tercera', 'NDISP03', 1285, 'NRO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Cuarta', 'NDISP04', 1286, 'NRO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Quinta', 'NDISP05', 1287, 'NRO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');  
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Final', 'TDISP00', 1288, 'TIPO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Transitoria', 'TDISP01', 1289, 'TIPO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Modificatoria', 'TDISP02', 1290, 'TIPO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');
  
insert into mdi_maestro_columna
  (descripcion, codigo, id_maestro_columna, dominio, fecha_creacion, usuario_creacion, terminal_creacion, aplicacion, estado)
values
  ('Derogatoria', 'TDISP03', 1291, 'TIPO_DISPOSICION', SYSDATE, 'SYSTEM', '10.10.200.36', 'MYC', '1');
  
  

