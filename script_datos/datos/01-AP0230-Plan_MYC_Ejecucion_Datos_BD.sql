insert into NPS_INTEGRADO.PGH_PERSONAL(ID_PERSONAL, ID_TIPO_DOCUMENTO_IDENTIDAD, NUMERO_DOC_IDENTIDAD, NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, CORREO_ELECTRONICO, NOMBRE_COMPLETO, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION, ID_ROL, ID_CARGO, ID_SUPERVISORA_EMPRESA, ID_LOCADOR, ID_PERSONAL_SIGED, APLICACION, NOMBRE_USUARIO_SIGED)
values (110, 1, 99999999, 'Karenn Isabelly', 'Estela', 'Ramos', 'kestelar@osinergmin.gob.pe', 'Estela Ramos Karenn Isabelly', '1', 'USU01', sysdate , '1.1.1.1', null, null, null, 11,(SELECT C.ID_CARGO FROM NPS_INTEGRADO.PGH_CARGO C WHERE C.NOMBRE_CARGO LIKE 'ESPECIALISTA LEGAL' AND C.ESTADO = '1'), null, null, 6783, 'MYC', 'KESTELAR');

insert into NPS_INTEGRADO.PGH_PERSONAL_UNIDAD_ORGANICA (ID_PERSONAL_UNIDAD_ORGANICA, ID_PERSONAL, ID_UNIDAD_ORGANICA, FLAG_DEFAULT, ESTADO, USUARIO_CREACION, FECHA_CREACION, TERMINAL_CREACION, USUARIO_ACTUALIZACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (72, (select ID_PERSONAL from pgh_personal where nombre_usuario_siged='KESTELAR' AND aplicacion='MYC'), 11511 , '1', '1', 'usu',SYSDATE, 'local', '', null, '');