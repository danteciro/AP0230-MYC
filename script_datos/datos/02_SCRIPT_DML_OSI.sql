-- ACTULIZAR ESTADO DE ACTIVIDAD
UPDATE MDI_ACTIVIDAD MA SET MA.ESTADO = '1' WHERE MA.CODIGO = '050';

--MAESTRO_COLUMNA TIPO DIRECCION OPERATIVA
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('OPERATIVA','OPE',mdi_maestro_columna_seq.nextval,'TIPO_DIRECCION',sysdate,'usu01','localhost','SGLSS',1);

--MAESTRO_COLUMNA SUPERVISION_MUESTRAL PARA metodologia de Selecion para supervision muestral
INSERT INTO mdi_maestro_tabla (DESCRIPCION, DOMINIO, Usuario_Creacion,FECHA_CREACION,Terminal_Creacion,ES_EDITABLE,Aplicacion) VALUES 
('PORCENTAJE SUPERVISION MUESTRAL','PORC_SUPERV_MUESTRAL','USU01',SYSDATE,'LOCALHOST','NO','INPS');
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('25','PROBABILIDAD',mdi_maestro_columna_seq.nextval,'PORC_SUPERV_MUESTRAL',sysdate,'usu01','localhost','INPS',1);
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('20','CONTINGENCIA',mdi_maestro_columna_seq.nextval,'PORC_SUPERV_MUESTRAL',sysdate,'usu01','localhost','INPS',1);
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('1.96','VALOR_CRITICO',mdi_maestro_columna_seq.nextval,'PORC_SUPERV_MUESTRAL',sysdate,'usu01','localhost','INPS',1);
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('2.5','ERROR',mdi_maestro_columna_seq.nextval,'PORC_SUPERV_MUESTRAL',sysdate,'usu01','localhost','INPS',1);

--MAESTRO_COLUMNA niveles unidad organica
INSERT INTO mdi_maestro_tabla (DESCRIPCION, DOMINIO, Usuario_Creacion,FECHA_CREACION,Terminal_Creacion,ES_EDITABLE,Aplicacion) VALUES 
('NIVEL UNIDAD ORGANICA','NIVEL_UNIDAD_ORGA','USU01',SYSDATE,'LOCALHOST','SI','MYC');
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('EMPRESA','1',mdi_maestro_columna_seq.nextval,'NIVEL_UNIDAD_ORGA',sysdate,'usu01','localhost','MYC',1);
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('GERENCIA','2',mdi_maestro_columna_seq.nextval,'NIVEL_UNIDAD_ORGA',sysdate,'usu01','localhost','MYC',1);
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('DIVISION','3',mdi_maestro_columna_seq.nextval,'NIVEL_UNIDAD_ORGA',sysdate,'usu01','localhost','MYC',1);
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('SUBDIVISION','4',mdi_maestro_columna_seq.nextval,'NIVEL_UNIDAD_ORGA',sysdate,'usu01','localhost','MYC',1);
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('UNIDAD','5',mdi_maestro_columna_seq.nextval,'NIVEL_UNIDAD_ORGA',sysdate,'usu01','localhost','MYC',1);

-- MAESTRO_COLUMNA FILTRO_EMP_SUP opciones disponibles para Filtro x Gerencia (MYC)
insert into MDI_MAESTRO_TABLA (DESCRIPCION, DOMINIO, USUARIO_ACTUALIZACION, USUARIO_CREACION, FECHA_CREACION, FECHA_ACTUALIZACION, TERMINAL_ACTUALIZACION, TERMINAL_CREACION, ES_EDITABLE, APLICACION)
values ('FILTRO_EMPRESA_SUPERVISORA', 'FILTRO_EMP_SUP', '', 'SYSTEM', to_date('13-05-2016 12:06:22', 'dd-mm-yyyy hh24:mi:ss'), null, '', 'LOCALHOST', 'SI', 'INPS');
insert into MDI_MAESTRO_COLUMNA (DESCRIPCION, CODIGO, ID_MAESTRO_COLUMNA, DOMINIO, FECHA_ACTUALIZACION, FECHA_CREACION, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION, TERMINAL_CREACION, APLICACION, ESTADO)
values ('PROCESO', 'PROC', mdi_maestro_columna_seq.nextval, 'FILTRO_EMP_SUP', null, to_date('13-05-2016 12:06:22', 'dd-mm-yyyy hh24:mi:ss'), 'USU01', '', '', 'LOCALHOST', 'INPS', '1');
insert into MDI_MAESTRO_COLUMNA (DESCRIPCION, CODIGO, ID_MAESTRO_COLUMNA, DOMINIO, FECHA_ACTUALIZACION, FECHA_CREACION, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION, TERMINAL_CREACION, APLICACION, ESTADO)
values ('OBLIGACION TIPO', 'OBLI', mdi_maestro_columna_seq.nextval, 'FILTRO_EMP_SUP', null, to_date('13-05-2016 12:06:22', 'dd-mm-yyyy hh24:mi:ss'), 'USU01', '', '', 'LOCALHOST', 'INPS', '1');
insert into MDI_MAESTRO_COLUMNA (DESCRIPCION, CODIGO, ID_MAESTRO_COLUMNA, DOMINIO, FECHA_ACTUALIZACION, FECHA_CREACION, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION, TERMINAL_CREACION, APLICACION, ESTADO)
values ('RUBRO', 'RUBR', mdi_maestro_columna_seq.nextval, 'FILTRO_EMP_SUP', null, to_date('13-05-2016 12:06:22', 'dd-mm-yyyy hh24:mi:ss'), 'USU01', '', '', 'LOCALHOST', 'INPS', '1');
insert into MDI_MAESTRO_COLUMNA (DESCRIPCION, CODIGO, ID_MAESTRO_COLUMNA, DOMINIO, FECHA_ACTUALIZACION, FECHA_CREACION, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION, TERMINAL_CREACION, APLICACION, ESTADO)
values ('UBIGEO UNIDAD OPERATIVA', 'UBIG', mdi_maestro_columna_seq.nextval, 'FILTRO_EMP_SUP', null, to_date('13-05-2016 12:06:22', 'dd-mm-yyyy hh24:mi:ss'), 'USU01', '', '', 'LOCALHOST', 'INPS', '1');

-- SE INSERTA OBLIGACION SUB_TIPO
-- SUB METROLOGICO
INSERT INTO PGH_OBLIGACION_SUB_TIPO (ID_OBLIGACION_SUB_TIPO,NOMBRE,ESTADO,ID_OBLIGACION_TIPO,IDENTIFICADOR_SELECCION,
                FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                                FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                                VALUES(PGH_OBLIGACION_SUB_TIPO_SEQ.NEXTVAL,'Supervisión metrológica de los dispensadores de combustibles líquidos',
                                '1',(SELECT ID_OBLIGACION_TIPO FROM PGH_OBLIGACION_TIPO WHERE UPPER(NOMBRE) LIKE '%CONTROL METROL%GICO%'),'S',
                                TO_DATE(SYSDATE,'DD/MM/YYYY'),'MIGRACION','1.1.1.1',NULL,NULL,NULL);
-- SUB CALIDAD                               
INSERT INTO PGH_OBLIGACION_SUB_TIPO (ID_OBLIGACION_SUB_TIPO,NOMBRE,ESTADO,ID_OBLIGACION_TIPO,IDENTIFICADOR_SELECCION,
                FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                                FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                                VALUES(PGH_OBLIGACION_SUB_TIPO_SEQ.NEXTVAL,'Supervisión para el Control de Calidad Muestral de combustibles líquidos en Grifos y Estaciones de Servicio',
                                '1',(SELECT ID_OBLIGACION_TIPO FROM PGH_OBLIGACION_TIPO WHERE UPPER(NOMBRE) LIKE '%CONTROL DE CALIDAD%'),'S',
                                TO_DATE(SYSDATE,'DD/MM/YYYY'),'MIGRACION','1.1.1.1',NULL,NULL,NULL);
								

-- UPDATE activar obligacion_tipo CONTROL CALIDAD y CONTROL METROLOGICO								
UPDATE pgh_obligacion_tipo pot SET pot.estado = '1' WHERE UPPER(pot.nombre) LIKE '%CONTROL DE CALIDAD%' OR UPPER(pot.nombre) LIKE '%CONTROL METROL%GICO%';
								
-- INSERCION MAESTRO COLUMNA SELECCION MUESTRAL
INSERT INTO mdi_maestro_tabla (DESCRIPCION, DOMINIO, Usuario_Creacion,FECHA_CREACION,Terminal_Creacion,ES_EDITABLE,Aplicacion) VALUES 
('OFICINA','DIRE_INPS_SM','USU01',SYSDATE,'LOCALHOST','NO','INPS');
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('OFICINA','OFIC',mdi_maestro_columna_seq.nextval,'DIRE_INPS_SM',sysdate,'USU01','LOCALHOST','INPS',1);

-- INSERCION MAESTRO COLUMNA PERIODOS PARA SELECCION MUESTRAL
INSERT INTO mdi_maestro_tabla (DESCRIPCION, DOMINIO, Usuario_Creacion,FECHA_CREACION,Terminal_Creacion,ES_EDITABLE,Aplicacion) VALUES 
('PERIODOS','SUPERV_MUEST_PERIODO','USU01',SYSDATE,'LOCALHOST','NO','INPS');
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('4','PERIODO',mdi_maestro_columna_seq.nextval,'SUPERV_MUEST_PERIODO',sysdate,'USU01','LOCALHOST','INPS',1);

-- INSERCION MAESTRO COLUMNA CODIGO ACTIVIDAD PARA BUSQUEDA ACTIVIDAD
INSERT INTO mdi_maestro_tabla (DESCRIPCION, DOMINIO, Usuario_Creacion,FECHA_CREACION,Terminal_Creacion,ES_EDITABLE,Aplicacion) VALUES 
('CODIGO ACTIVIDAD','SUP_MUE_COD_ACTI','USU01',SYSDATE,'LOCALHOST','NO','INPS');
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('050','CODACT',mdi_maestro_columna_seq.nextval,'SUP_MUE_COD_ACTI',sysdate,'USU01','LOCALHOST','INPS',1);

-- INSERCION MAESTRO COLUMNA TIPO DE SELECCION
INSERT INTO mdi_maestro_tabla (DESCRIPCION, DOMINIO, Usuario_Creacion,FECHA_CREACION,Terminal_Creacion,ES_EDITABLE,Aplicacion) VALUES 
('TIPO SELECCION','TIPO_SEL_ORD_SER','USU01',SYSDATE,'LOCALHOST','NO','INPS');
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('ASIGNACION','TPOS01',mdi_maestro_columna_seq.nextval,'TIPO_SEL_ORD_SER',sysdate,'USU01','LOCALHOST','INPS',1);
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('MUESTRAL','TPOS02',mdi_maestro_columna_seq.nextval,'TIPO_SEL_ORD_SER',sysdate,'USU01','LOCALHOST','INPS',1);
INSERT INTO mdi_maestro_columna (descripcion,Codigo,Id_Maestro_Columna,Dominio,fecha_creacion,usuario_creacion,terminal_creacion,aplicacion,estado) values 
('CONTINGENCIA','TPOS03',mdi_maestro_columna_seq.nextval,'TIPO_SEL_ORD_SER',sysdate,'USU01','LOCALHOST','INPS',1);

-- INSERCION ESTRATO
-- ESTRATOS                           
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(1,'1','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(2,'2','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(3,'3','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(4,'4','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(5,'5','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
                               
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(6,'6','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(7,'7','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                               
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(8,'8','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(9,'9','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(10,'10','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(11,'11','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(12,'12','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(13,'13','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(14,'14','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(15,'15','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(16,'16','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(17,'17','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(18,'18','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(19,'19','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(20,'20','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(21,'21','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(22,'22','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(23,'23','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(24,'24','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(25,'25','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(26,'26','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(27,'27','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(28,'28','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                               
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(29,'29','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);      
                                                                                              
INSERT INTO PGH_ESTRATO (ID_ESTRATO,NOMBRE,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(30,'30','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  						   
--------------------------------------------------------------------------------------------------------------------


--  INSERCION ESTRATO UBIGEO

-- AMAZONAS                           
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,1,
                               '01','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
-- CAJAMARCA                               
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,2,
                               '06','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               
-- CHICLAYO                              
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,3,
                               '14','01','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                  
-- ALTO AMAZONAS                             
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,4,
                               '16','02','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
-- PIURA                             
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,5,
                               '20','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               

-- SAN MARTIN                            
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,6,
                               '22','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);     

-- TUMBES                            
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,7,
                               '24','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);    

-- HUANUCO                        
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,9,
                               '10','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
                               
-- HUANCAVELICA                       
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,8,
                               '09','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
                               
-- ICA - CHINCHA                       
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,10,
                               '11','02','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);   
-- ICA - PISCO                       
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,10,
                               '11','05','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
                               
-- JUNIN                      
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,11,
                               '12','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                                                              
-- PASCO                      
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,13,
                               '19','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);    
-- UCAYALI                      
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,14,
                               '25','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
-- ANCASH                      
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,15,
                               '02','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);   
-- LA LIBERTAD                      
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,16,
                               '13','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
                               
-- LAMBAYEQUE - LAMBAYEQUE                    
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,17,
                               '14','03','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                
-- LAMBAYEQUE - FERREÑAFE                    
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,17,
                               '14','02','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               
                                                                                                                                                                                                                                                                        
-- LORETO - MAYNAS                    
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,19,
                               '16','01','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
-- LORETO - REQUENA                    
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,19,
                               '16','05','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               
-- LORETO - MARISCAL RAMON CASTILLA                    
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,19,
                               '16','04','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
-- AYACUCHO                 
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,20,
                               '05','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               

-- APURIMAC                   
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,21,
                               '03','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
-- AREQUIPA                    
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,22,
                               '04','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
-- ICA - ICA                 
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,23,
                               '11','01','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
-- ICA - NAZCA                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,23,
                               '11','03','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
-- ICA - PALPA                 
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,23,
                               '11','04','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);

-- CUZCO                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,24,
                               '08','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
-- MADRE DE DIOS              
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,25,
                               '17','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
-- MOQUEGUA              
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,26,
                               '18','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
 -- PUNO                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,27,
                               '21','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                                             
-- TACNA                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,28,
                               '23','00','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);	
-- LIMA - HUAURA                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','08','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);     
-- LIMA - BARRANCA                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','02','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                                        
-- LIMA - CAJATAMBO               
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','03','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                
-- LIMA - HUARAL                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','06','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
-- LIMA - CANTA                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','04','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               
-- LIMA - OYON                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','09','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);   
-- LIMA - CALLAO                
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','11','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                 
                                                          
-- LIMA - CAÑETE              
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','05','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                
-- LIMA - HUAROCHIRI              
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','07','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                
-- LIMA - YAUYOS              
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','10','00','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               

-- LIMA - ANCON             
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','02','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);      

-- LIMA - SANTA ROSA             
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','39','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  

-- LIMA - PUENTE PIEDRA             
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','25','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
-- LIMA - CARABAYLLO            
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','06','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);

-- LIMA - LOS OLIVOS           
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','17','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);

-- LIMA - COMAS            
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','10','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
-- LIMA - SAN MARTIN DE PORRRES          
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','35','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
-- LIMA - INDEPENDENCIA         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','04','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
-- LIMA - RIMAC         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','28','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                               
-- LIMA - EL AGUSTINO         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','11','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               
                                                  
-- LIMA - SAN JUAN DE LURIGANCHO         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','32','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               
 
-- LIMA - SANTA ANITA         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','37','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
                               
-- LIMA - LIMA         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','01','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               

-- LIMA - BREÑA         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','05','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                                                      
 
-- LIMA - LINCE         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','16','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);

-- LIMA - SAN MIGUEL         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','36','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
 -- LIMA - MAGDALENA DEL MAR         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','20','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                              

-- LIMA - JESUS MARIA         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','13','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               
 

-- LIMA - PUEBLO LIBRE   -- 21 O 44      
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','21','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);

-- LIMA - SAN ISIDRO         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,29,
                               '15','01','31','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);
                               
-- LIMA - ATE         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','03','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               
                               
-- LIMA - BARRANCO         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','04','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                  
 
-- LIMA - CHACLACAYO         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','07','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                               

-- LIMA - CHORRILLOS         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','08','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
-- LIMA - CIENEGUILLA         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','09','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
-- LIMA - LA MOLINA         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','14','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 

-- LIMA - LA VICTORIA         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','15','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                

-- LIMA - LURIGANCHO         
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','18','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);    

-- LIMA - LURIN        
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','19','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  

-- LIMA - MIRAFLORES        
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','22','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
                               
-- LIMA - PACHACAMAC        
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','23','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                 
                               
-- LIMA - PUCUSANA        
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','24','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  

-- LIMA - PUNTA HERMOSA        
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','26','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
-- LIMA - PUNTA NEGRA        
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','27','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  

-- LIMA - SAN BARTOLO       
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','29','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  

-- LIMA - SAN BORJA       
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','30','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  

-- LIMA - SAN JUAN DE MIRAFLORES       
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','33','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL); 
                               
-- LIMA - SAN LUIS       
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','34','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);   
                               
-- LIMA - SANTA MARIA DEL MAR      
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','38','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);                                 

-- LIMA - SANTIAGO DE SURCO       
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','40','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
                               
-- LIMA - SURQUILLO      
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','41','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  

-- LIMA - VILLA EL SALVADOR   
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','42','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);  
 
-- LIMA - VILLA MARIA DEL TRIUNFO  
INSERT INTO PGH_ESTRATO_UBIGEO (ID_ESTRATO_UBIGEO,ID_ESTRATO,
                               ID_DEPARTAMENTO,ID_PROVINCIA,ID_DISTRITO,ESTADO,
                               FECHA_CREACION,USUARIO_CREACION,TERMINAL_CREACION,
                               FECHA_ACTUALIZACION,USUARIO_ACTUALIZACION,TERMINAL_ACTUALIZACION)
                               VALUES(PGH_ESTRATO_UBIGEO_SEQ.NEXTVAL,30,
                               '15','01','43','1',
                               TO_DATE(SYSDATE,'DD/MM/YYYY'),'USU01','1.1.1.1',
                               NULL,NULL,NULL);				

-- INSERCION UBIGEO_REGION
insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (289, '03', '01', '08', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (290, '03', '01', '09', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (291, '03', '02', '00', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (292, '03', '02', '01', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (293, '03', '02', '02', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (294, '03', '02', '03', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (295, '03', '02', '04', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (296, '03', '02', '05', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (297, '03', '02', '06', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (298, '03', '02', '07', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (299, '03', '02', '08', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (300, '03', '02', '09', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (301, '03', '02', '10', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (302, '03', '02', '11', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (303, '03', '02', '12', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (304, '03', '02', '13', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (305, '03', '02', '14', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (306, '03', '02', '15', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (307, '03', '02', '16', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (308, '03', '02', '17', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (309, '03', '02', '18', 3, '1', to_date('09-06-2016 12:04:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (310, '03', '02', '19', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (311, '03', '03', '00', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (312, '03', '03', '01', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (313, '03', '03', '02', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (314, '03', '03', '03', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (315, '03', '03', '04', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (316, '03', '03', '05', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (317, '03', '03', '06', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (318, '03', '03', '07', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (319, '03', '04', '00', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (320, '03', '04', '01', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (321, '03', '04', '02', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (322, '03', '04', '03', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (323, '03', '04', '04', 3, '1', to_date('09-06-2016 12:04:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (324, '03', '04', '05', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (325, '03', '04', '06', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (326, '03', '04', '07', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (327, '03', '04', '08', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (328, '03', '04', '09', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (329, '03', '04', '10', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (330, '03', '04', '11', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (331, '03', '04', '12', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (332, '03', '04', '13', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (333, '03', '04', '14', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (334, '03', '04', '15', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (335, '03', '04', '16', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (336, '03', '04', '17', 3, '1', to_date('09-06-2016 12:04:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (337, '03', '05', '00', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (338, '03', '05', '01', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (339, '03', '05', '02', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (340, '03', '05', '03', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (341, '03', '05', '04', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (342, '03', '05', '05', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (343, '03', '05', '06', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (344, '03', '06', '00', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (345, '03', '06', '01', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (346, '03', '06', '02', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (347, '03', '06', '03', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (348, '03', '06', '04', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (349, '03', '06', '05', 3, '1', to_date('09-06-2016 12:04:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (350, '03', '06', '06', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (351, '03', '06', '07', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (352, '03', '06', '08', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (353, '03', '07', '00', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (354, '03', '07', '01', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (355, '03', '07', '02', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (356, '03', '07', '03', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (357, '03', '07', '04', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (358, '03', '07', '05', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (359, '03', '07', '06', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (360, '03', '07', '07', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (361, '03', '07', '08', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (362, '03', '07', '09', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (363, '03', '07', '10', 3, '1', to_date('09-06-2016 12:04:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (364, '03', '07', '11', 3, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (365, '03', '07', '12', 3, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (366, '03', '07', '13', 3, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (367, '03', '07', '14', 3, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (368, '04', '00', '00', 4, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (369, '04', '01', '00', 4, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (370, '04', '01', '01', 4, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (371, '04', '01', '02', 4, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (372, '04', '01', '03', 4, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (373, '04', '01', '04', 4, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (374, '04', '01', '05', 4, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (375, '04', '01', '06', 4, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (376, '04', '01', '07', 4, '1', to_date('09-06-2016 12:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (377, '04', '01', '08', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (378, '04', '01', '09', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (379, '04', '01', '10', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (380, '04', '01', '11', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (381, '04', '01', '12', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (382, '04', '01', '13', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (383, '04', '01', '14', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (384, '04', '01', '15', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (385, '04', '01', '16', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (386, '04', '01', '17', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (387, '04', '01', '18', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (388, '04', '01', '19', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (389, '04', '01', '20', 4, '1', to_date('09-06-2016 12:04:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (390, '04', '01', '21', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (391, '04', '01', '22', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (392, '04', '01', '23', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (393, '04', '01', '24', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (394, '04', '01', '25', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (395, '04', '01', '26', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (396, '04', '01', '27', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (397, '04', '01', '28', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (398, '04', '01', '29', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (399, '04', '02', '00', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (400, '04', '02', '01', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (401, '04', '02', '02', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (402, '04', '02', '03', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (403, '04', '02', '04', 4, '1', to_date('09-06-2016 12:04:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (404, '04', '02', '05', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (405, '04', '02', '06', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (406, '04', '02', '07', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (407, '04', '02', '08', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (408, '04', '03', '00', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (409, '04', '03', '01', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (410, '04', '03', '02', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (411, '04', '03', '03', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (412, '04', '03', '04', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (413, '04', '03', '05', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (414, '04', '03', '06', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (415, '04', '03', '07', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (416, '04', '03', '08', 4, '1', to_date('09-06-2016 12:04:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (417, '04', '03', '09', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (418, '04', '03', '10', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (419, '04', '03', '11', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (420, '04', '03', '12', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (421, '04', '03', '13', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (422, '04', '04', '00', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (423, '04', '04', '01', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (424, '04', '04', '02', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (425, '04', '04', '03', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (426, '04', '04', '04', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (427, '04', '04', '05', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (428, '04', '04', '06', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (429, '04', '04', '07', 4, '1', to_date('09-06-2016 12:04:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (430, '04', '04', '08', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (431, '04', '04', '09', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (432, '04', '04', '10', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (433, '04', '04', '11', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (434, '04', '04', '12', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (435, '04', '04', '13', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (436, '04', '04', '14', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (437, '04', '05', '00', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (438, '04', '05', '01', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (439, '04', '05', '02', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (440, '04', '05', '03', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (441, '04', '05', '04', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (442, '04', '05', '05', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (443, '04', '05', '06', 4, '1', to_date('09-06-2016 12:04:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (444, '04', '05', '07', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (445, '04', '05', '08', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (446, '04', '05', '09', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (447, '04', '05', '10', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (448, '04', '05', '11', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (449, '04', '05', '12', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (450, '04', '05', '13', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (451, '04', '05', '14', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (452, '04', '05', '15', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (453, '04', '05', '16', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (454, '04', '05', '17', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (455, '04', '05', '18', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (456, '04', '05', '19', 4, '1', to_date('09-06-2016 12:04:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (457, '04', '05', '20', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (458, '04', '06', '00', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (459, '04', '06', '01', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (460, '04', '06', '02', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (461, '04', '06', '03', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (462, '04', '06', '04', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (463, '04', '06', '05', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (464, '04', '06', '06', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (465, '04', '06', '07', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (466, '04', '06', '08', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (467, '04', '07', '00', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (468, '04', '07', '01', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (469, '04', '07', '02', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (470, '04', '07', '03', 4, '1', to_date('09-06-2016 12:04:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (471, '04', '07', '04', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (472, '04', '07', '05', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (473, '04', '07', '06', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (474, '04', '08', '00', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (475, '04', '08', '01', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (476, '04', '08', '02', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (477, '04', '08', '03', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (478, '04', '08', '04', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (479, '04', '08', '05', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (480, '04', '08', '06', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (481, '04', '08', '07', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (482, '04', '08', '08', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (483, '04', '08', '09', 4, '1', to_date('09-06-2016 12:04:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (484, '04', '08', '10', 4, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (485, '04', '08', '11', 4, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (486, '05', '00', '00', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (487, '05', '01', '00', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (488, '05', '01', '01', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (489, '05', '01', '02', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (490, '05', '01', '03', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (491, '05', '01', '04', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (492, '05', '01', '05', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (493, '05', '01', '06', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (494, '05', '01', '07', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (495, '05', '01', '08', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (496, '05', '01', '09', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (497, '05', '01', '10', 5, '1', to_date('09-06-2016 12:04:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (498, '05', '01', '11', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (499, '05', '01', '12', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (500, '05', '01', '13', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (501, '05', '01', '14', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (502, '05', '01', '15', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (503, '05', '02', '00', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (504, '05', '02', '01', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (505, '05', '02', '02', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (506, '05', '02', '03', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (507, '05', '02', '04', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (508, '05', '02', '05', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (509, '05', '02', '06', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (510, '05', '03', '00', 5, '1', to_date('09-06-2016 12:04:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (511, '05', '03', '01', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (512, '05', '03', '02', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (513, '05', '03', '03', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (514, '05', '03', '04', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (515, '05', '04', '00', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (516, '05', '04', '01', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (517, '05', '04', '02', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (518, '05', '04', '03', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (519, '05', '04', '04', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (520, '05', '04', '05', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (521, '05', '04', '06', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (522, '05', '04', '07', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (523, '05', '04', '08', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (524, '05', '05', '00', 5, '1', to_date('09-06-2016 12:04:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (525, '05', '05', '01', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (526, '05', '05', '02', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (527, '05', '05', '03', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (528, '05', '05', '04', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (529, '05', '05', '05', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (530, '05', '05', '06', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (531, '05', '05', '07', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (532, '05', '05', '08', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (533, '05', '05', '09', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (534, '05', '06', '00', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (535, '05', '06', '01', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (536, '05', '06', '02', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (537, '05', '06', '03', 5, '1', to_date('09-06-2016 12:05:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (538, '05', '06', '04', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (539, '05', '06', '05', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (540, '05', '06', '06', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (541, '05', '06', '07', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (542, '05', '06', '08', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (543, '05', '06', '09', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (544, '05', '06', '10', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (545, '05', '06', '11', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (546, '05', '06', '12', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (547, '05', '06', '13', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (548, '05', '06', '14', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (549, '05', '06', '15', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (550, '05', '06', '16', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (551, '05', '06', '17', 5, '1', to_date('09-06-2016 12:05:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (552, '05', '06', '18', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (553, '05', '06', '19', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (554, '05', '06', '20', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (555, '05', '06', '21', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (556, '05', '07', '00', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (557, '05', '07', '01', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (558, '05', '07', '02', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (559, '05', '07', '03', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (560, '05', '07', '04', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (561, '05', '07', '05', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (562, '05', '07', '06', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (563, '05', '07', '07', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (564, '05', '07', '08', 5, '1', to_date('09-06-2016 12:05:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (565, '05', '08', '00', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (566, '05', '08', '01', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (567, '05', '08', '02', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (568, '05', '08', '03', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (569, '05', '08', '04', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (570, '05', '08', '05', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (571, '05', '08', '06', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (572, '05', '08', '07', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (573, '05', '08', '08', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (574, '05', '08', '09', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (575, '05', '08', '10', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (576, '05', '09', '00', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (864, '08', '12', '04', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (865, '08', '12', '05', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (866, '08', '12', '06', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (867, '08', '12', '07', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (868, '08', '12', '08', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (869, '08', '12', '09', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (870, '08', '12', '10', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (871, '08', '12', '11', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (872, '08', '12', '12', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (873, '08', '13', '00', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (874, '08', '13', '01', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (875, '08', '13', '02', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (876, '08', '13', '03', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (877, '08', '13', '04', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (878, '08', '13', '05', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (879, '08', '13', '06', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (880, '08', '13', '07', 8, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (881, '09', '00', '00', 9, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (882, '09', '01', '00', 9, '1', to_date('09-06-2016 12:05:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (883, '09', '01', '01', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (884, '09', '01', '02', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (885, '09', '01', '03', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (886, '09', '01', '04', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (887, '09', '01', '05', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (888, '09', '01', '06', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (889, '09', '01', '07', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (890, '09', '01', '08', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (891, '09', '01', '09', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (892, '09', '01', '10', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (893, '09', '01', '11', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (894, '09', '01', '12', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (895, '09', '01', '13', 9, '1', to_date('09-06-2016 12:05:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (896, '09', '01', '14', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (897, '09', '01', '15', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (898, '09', '01', '16', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (899, '09', '01', '17', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (900, '09', '01', '18', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (901, '09', '01', '19', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (902, '09', '02', '00', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (903, '09', '02', '01', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (904, '09', '02', '02', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (905, '09', '02', '03', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (906, '09', '02', '04', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (907, '09', '02', '05', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (908, '09', '02', '06', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (909, '09', '02', '07', 9, '1', to_date('09-06-2016 12:05:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (910, '09', '02', '08', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (911, '09', '03', '00', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (912, '09', '03', '01', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (913, '09', '03', '02', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (914, '09', '03', '03', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (915, '09', '03', '04', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (916, '09', '03', '05', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (917, '09', '03', '06', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (918, '09', '03', '07', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (919, '09', '03', '08', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (920, '09', '03', '09', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (921, '09', '03', '10', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (922, '09', '03', '11', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (923, '09', '03', '12', 9, '1', to_date('09-06-2016 12:05:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (924, '09', '04', '00', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (925, '09', '04', '01', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (926, '09', '04', '02', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (927, '09', '04', '03', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (928, '09', '04', '04', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (929, '09', '04', '05', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (930, '09', '04', '06', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (931, '09', '04', '07', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (932, '09', '04', '08', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (933, '09', '04', '09', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (934, '09', '04', '10', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (935, '09', '04', '11', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (936, '09', '04', '12', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (937, '09', '04', '13', 9, '1', to_date('09-06-2016 12:05:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (938, '09', '05', '00', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (939, '09', '05', '01', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (940, '09', '05', '02', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (941, '09', '05', '03', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (942, '09', '05', '04', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (943, '09', '05', '05', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (944, '09', '05', '06', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (945, '09', '05', '07', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (946, '09', '05', '08', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (947, '09', '05', '09', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (948, '09', '05', '10', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (949, '09', '05', '11', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (950, '09', '06', '00', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (951, '09', '06', '01', 9, '1', to_date('09-06-2016 12:05:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (952, '09', '06', '02', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (953, '09', '06', '03', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (954, '09', '06', '04', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (955, '09', '06', '05', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (956, '09', '06', '06', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (957, '09', '06', '07', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (958, '09', '06', '08', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (959, '09', '06', '09', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (960, '09', '06', '10', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (961, '09', '06', '11', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (962, '09', '06', '12', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (963, '09', '06', '13', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (964, '09', '06', '14', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (965, '09', '06', '15', 9, '1', to_date('09-06-2016 12:05:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (966, '09', '06', '16', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (967, '09', '07', '00', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (968, '09', '07', '01', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (969, '09', '07', '02', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (970, '09', '07', '03', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (971, '09', '07', '04', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (972, '09', '07', '05', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (973, '09', '07', '06', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (974, '09', '07', '07', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (975, '09', '07', '09', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (976, '09', '07', '10', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (977, '09', '07', '11', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (978, '09', '07', '13', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (979, '09', '07', '14', 9, '1', to_date('09-06-2016 12:05:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (980, '09', '07', '15', 9, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (981, '09', '07', '16', 9, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (982, '09', '07', '17', 9, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (983, '09', '07', '18', 9, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (984, '10', '00', '00', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (985, '10', '01', '00', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (986, '10', '01', '01', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (987, '10', '01', '02', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (988, '10', '01', '03', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (989, '10', '01', '04', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (990, '10', '01', '05', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (991, '10', '01', '06', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (992, '10', '01', '07', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (993, '10', '01', '08', 10, '1', to_date('09-06-2016 12:05:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (994, '10', '01', '09', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (995, '10', '01', '10', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (996, '10', '01', '11', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (997, '10', '01', '12', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (998, '10', '02', '00', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (999, '10', '02', '01', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1000, '10', '02', '02', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1001, '10', '02', '03', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1002, '10', '02', '04', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1003, '10', '02', '05', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1004, '10', '02', '06', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1005, '10', '02', '07', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1006, '10', '02', '08', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1007, '10', '03', '00', 10, '1', to_date('09-06-2016 12:05:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1008, '10', '03', '01', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1009, '10', '03', '07', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1010, '10', '03', '11', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1011, '10', '03', '13', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1012, '10', '03', '16', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1013, '10', '03', '17', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1014, '10', '03', '21', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1015, '10', '03', '22', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1016, '10', '03', '23', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1017, '10', '04', '00', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1018, '10', '04', '01', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1019, '10', '04', '02', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1020, '10', '04', '03', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1021, '10', '04', '04', 10, '1', to_date('09-06-2016 12:05:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1022, '10', '05', '00', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1023, '10', '05', '01', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1024, '10', '05', '02', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1025, '10', '05', '03', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1026, '10', '05', '04', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1027, '10', '05', '05', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1028, '10', '05', '06', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1029, '10', '05', '07', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1030, '10', '05', '08', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1031, '10', '05', '09', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1032, '10', '05', '10', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1033, '10', '05', '11', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1034, '10', '06', '00', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1035, '10', '06', '01', 10, '1', to_date('09-06-2016 12:05:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1036, '10', '06', '02', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1037, '10', '06', '03', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1038, '10', '06', '04', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1039, '10', '06', '05', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1040, '10', '06', '06', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1041, '10', '07', '00', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1042, '10', '07', '01', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1043, '10', '07', '02', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1044, '10', '07', '03', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1045, '10', '08', '00', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1046, '10', '08', '01', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1047, '10', '08', '02', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1048, '10', '08', '03', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1049, '10', '08', '04', 10, '1', to_date('09-06-2016 12:05:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1050, '10', '09', '00', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1051, '10', '09', '01', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1052, '10', '09', '02', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1053, '10', '09', '03', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1054, '10', '09', '04', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1055, '10', '09', '05', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1056, '10', '10', '00', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1057, '10', '10', '01', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1058, '10', '10', '02', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1059, '10', '10', '03', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1060, '10', '10', '04', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1061, '10', '10', '05', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1062, '10', '10', '06', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1063, '10', '10', '07', 10, '1', to_date('09-06-2016 12:05:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1064, '10', '11', '00', 10, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1065, '10', '11', '01', 10, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1066, '10', '11', '02', 10, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1067, '10', '11', '03', 10, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1068, '10', '11', '04', 10, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1069, '10', '11', '05', 10, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1070, '10', '11', '06', 10, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1071, '10', '11', '07', 10, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1072, '10', '11', '08', 10, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1073, '11', '00', '00', 11, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1074, '11', '01', '00', 11, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1075, '11', '01', '01', 11, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1076, '11', '01', '02', 11, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1077, '11', '01', '03', 11, '1', to_date('09-06-2016 12:05:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1078, '11', '01', '04', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1079, '11', '01', '05', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1080, '11', '01', '06', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1081, '11', '01', '07', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1082, '11', '01', '08', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1083, '11', '01', '09', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1084, '11', '01', '10', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1085, '11', '01', '11', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1086, '11', '01', '12', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1087, '11', '01', '13', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1088, '11', '01', '14', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1089, '11', '02', '00', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1090, '11', '02', '01', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1091, '11', '02', '02', 11, '1', to_date('09-06-2016 12:05:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1092, '11', '02', '03', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1093, '11', '02', '04', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1094, '11', '02', '05', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1095, '11', '02', '06', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1096, '11', '02', '07', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1097, '11', '02', '08', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1098, '11', '02', '09', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1099, '11', '02', '10', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1100, '11', '02', '11', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1101, '11', '03', '00', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1102, '11', '03', '01', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1103, '11', '03', '02', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1104, '11', '03', '03', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1105, '11', '03', '04', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1106, '11', '03', '05', 11, '1', to_date('09-06-2016 12:05:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1107, '11', '04', '00', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1108, '11', '04', '01', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1109, '11', '04', '02', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1110, '11', '04', '03', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1111, '11', '04', '04', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1112, '11', '04', '05', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1113, '11', '05', '00', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1114, '11', '05', '01', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1115, '11', '05', '02', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1116, '11', '05', '03', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1117, '11', '05', '04', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1118, '11', '05', '05', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1119, '11', '05', '06', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1120, '11', '05', '07', 11, '1', to_date('09-06-2016 12:05:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1121, '11', '05', '08', 11, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1122, '12', '00', '00', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1123, '12', '01', '00', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1124, '12', '01', '01', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1125, '12', '01', '04', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1126, '12', '01', '05', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1127, '12', '01', '06', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1128, '12', '01', '07', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1129, '12', '01', '08', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1130, '12', '01', '11', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1131, '12', '01', '12', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1132, '12', '01', '13', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1133, '12', '01', '14', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1134, '12', '01', '16', 12, '1', to_date('09-06-2016 12:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1135, '12', '01', '17', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1136, '12', '01', '19', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1137, '12', '01', '20', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1138, '12', '01', '21', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1139, '12', '01', '22', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1140, '12', '01', '24', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1141, '12', '01', '25', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1142, '12', '01', '26', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1143, '12', '01', '27', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1144, '12', '01', '28', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1145, '12', '01', '29', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1146, '12', '01', '30', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1147, '12', '01', '32', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1148, '12', '01', '33', 12, '1', to_date('09-06-2016 12:05:44', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1149, '12', '01', '34', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1150, '12', '01', '35', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1151, '12', '01', '36', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1152, '12', '02', '00', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1153, '12', '02', '01', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1154, '12', '02', '02', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1155, '12', '02', '03', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1156, '12', '02', '04', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1157, '12', '02', '05', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1158, '12', '02', '06', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1159, '12', '02', '07', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1160, '12', '02', '08', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1161, '12', '02', '09', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1162, '12', '02', '10', 12, '1', to_date('09-06-2016 12:05:45', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1163, '12', '02', '11', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1164, '12', '02', '12', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1165, '12', '02', '13', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1166, '12', '02', '14', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1167, '12', '02', '15', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1168, '12', '03', '00', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1169, '12', '03', '01', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1170, '12', '03', '02', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1171, '12', '03', '03', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1172, '12', '03', '04', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1173, '12', '03', '05', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1174, '12', '03', '06', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1175, '12', '04', '00', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1176, '12', '04', '01', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1177, '12', '04', '02', 12, '1', to_date('09-06-2016 12:05:46', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1178, '12', '04', '03', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1179, '12', '04', '04', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1180, '12', '04', '05', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1181, '12', '04', '06', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1182, '12', '04', '07', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1183, '12', '04', '08', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1184, '12', '04', '09', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1185, '12', '04', '10', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1186, '12', '04', '11', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1187, '12', '04', '12', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1188, '12', '04', '13', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1189, '12', '04', '14', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1190, '12', '04', '15', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1191, '12', '04', '16', 12, '1', to_date('09-06-2016 12:05:47', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1192, '12', '04', '17', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1193, '12', '04', '18', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1194, '12', '04', '19', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1195, '12', '04', '20', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1196, '12', '04', '21', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1197, '12', '04', '22', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1198, '12', '04', '23', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1199, '12', '04', '24', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1200, '12', '04', '25', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1201, '12', '04', '26', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1202, '12', '04', '27', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1203, '12', '04', '28', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1204, '12', '04', '29', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1205, '12', '04', '30', 12, '1', to_date('09-06-2016 12:05:48', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1206, '12', '04', '31', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1207, '12', '04', '32', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1208, '12', '04', '33', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1209, '12', '04', '34', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1210, '12', '05', '00', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1211, '12', '05', '01', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1212, '12', '05', '02', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1213, '12', '05', '03', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1214, '12', '05', '04', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1215, '12', '06', '00', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1216, '12', '06', '01', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1217, '12', '06', '02', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1218, '12', '06', '03', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1219, '12', '06', '05', 12, '1', to_date('09-06-2016 12:05:49', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1220, '12', '06', '07', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1221, '12', '06', '08', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1222, '12', '06', '99', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1223, '12', '07', '00', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1224, '12', '07', '01', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1225, '12', '07', '02', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1226, '12', '07', '03', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1227, '12', '07', '04', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1228, '12', '07', '05', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1229, '12', '07', '06', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1230, '12', '07', '07', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1231, '12', '07', '08', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1232, '12', '07', '09', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1233, '12', '08', '00', 12, '1', to_date('09-06-2016 12:05:50', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1234, '12', '08', '01', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1235, '12', '08', '02', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1236, '12', '08', '03', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1237, '12', '08', '04', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1238, '12', '08', '05', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1239, '12', '08', '06', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1240, '12', '08', '07', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1241, '12', '08', '08', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1242, '12', '08', '09', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1243, '12', '08', '10', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1244, '12', '09', '00', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1245, '12', '09', '01', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1246, '12', '09', '02', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1247, '12', '09', '03', 12, '1', to_date('09-06-2016 12:05:51', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1248, '12', '09', '04', 12, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1249, '12', '09', '05', 12, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1250, '12', '09', '06', 12, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1251, '12', '09', '07', 12, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1252, '12', '09', '08', 12, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1253, '12', '09', '09', 12, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1254, '13', '00', '00', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1255, '13', '01', '00', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1256, '13', '01', '01', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1257, '13', '01', '02', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1258, '13', '01', '03', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1259, '13', '01', '04', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1260, '13', '01', '05', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1261, '13', '01', '06', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1262, '13', '01', '07', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1263, '13', '01', '08', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1264, '13', '01', '09', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1265, '13', '01', '10', 13, '1', to_date('09-06-2016 12:05:52', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1266, '13', '01', '11', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1267, '13', '02', '00', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1268, '13', '02', '01', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1269, '13', '02', '02', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1270, '13', '02', '03', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1271, '13', '02', '04', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1272, '13', '02', '05', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1273, '13', '02', '06', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1274, '13', '02', '07', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1275, '13', '02', '08', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1276, '13', '03', '00', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1277, '13', '03', '01', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1278, '13', '03', '02', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1279, '13', '03', '03', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1280, '13', '03', '04', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1281, '13', '03', '05', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1282, '13', '03', '06', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1283, '13', '04', '00', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1284, '13', '04', '01', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1285, '13', '04', '02', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1286, '13', '04', '03', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1287, '13', '05', '00', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1288, '13', '05', '01', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1289, '13', '05', '02', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1290, '13', '05', '03', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1291, '13', '05', '04', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1292, '13', '06', '00', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1293, '13', '06', '01', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1294, '13', '06', '02', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1295, '13', '06', '04', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1296, '13', '06', '05', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1297, '13', '06', '06', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1298, '13', '06', '08', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1299, '13', '06', '10', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1300, '13', '06', '11', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1301, '13', '06', '13', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1302, '13', '06', '14', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1303, '13', '07', '00', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1304, '13', '07', '01', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1305, '13', '07', '02', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1306, '13', '07', '03', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1307, '13', '07', '04', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1308, '13', '07', '05', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1309, '13', '08', '00', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1310, '13', '08', '01', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1311, '13', '08', '02', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1312, '13', '08', '03', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1313, '13', '08', '04', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1314, '13', '08', '05', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1315, '13', '08', '06', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1316, '13', '08', '07', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1317, '13', '08', '08', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1318, '13', '08', '09', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1319, '13', '08', '10', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1320, '13', '08', '11', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1321, '13', '08', '12', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1322, '13', '08', '13', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1323, '13', '09', '00', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1324, '13', '09', '01', 13, '1', to_date('09-06-2016 12:05:53', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1325, '13', '09', '02', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1326, '13', '09', '03', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1327, '13', '09', '04', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1328, '13', '09', '05', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1329, '13', '09', '06', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1330, '13', '09', '07', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1331, '13', '09', '08', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1332, '13', '10', '00', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1333, '13', '10', '01', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1334, '13', '10', '02', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1335, '13', '10', '03', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1336, '13', '10', '04', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1337, '13', '10', '05', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1338, '13', '10', '06', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1339, '13', '10', '07', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1340, '13', '10', '08', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1341, '13', '11', '00', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1342, '13', '11', '01', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1343, '13', '11', '02', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1344, '13', '11', '03', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1345, '13', '11', '04', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1346, '13', '12', '00', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1347, '13', '12', '01', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1348, '13', '12', '02', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1349, '13', '12', '03', 13, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1350, '14', '00', '00', 14, '1', to_date('09-06-2016 12:05:54', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1351, '14', '01', '00', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1352, '14', '01', '01', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1353, '14', '01', '02', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1354, '14', '01', '03', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1355, '14', '01', '04', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1356, '14', '01', '05', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1357, '14', '01', '06', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1358, '14', '01', '07', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1359, '14', '01', '08', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1360, '14', '01', '09', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1361, '14', '01', '10', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1362, '14', '01', '11', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1363, '14', '01', '12', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1364, '14', '01', '13', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1365, '14', '01', '14', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1366, '14', '01', '15', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1367, '14', '01', '16', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1368, '14', '01', '17', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1369, '14', '01', '18', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1370, '14', '01', '19', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1371, '14', '01', '20', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1372, '14', '02', '00', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1373, '14', '02', '01', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1374, '14', '02', '02', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1375, '14', '02', '03', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1376, '14', '02', '04', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1377, '14', '02', '05', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1378, '14', '02', '06', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1379, '14', '03', '00', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1380, '14', '03', '01', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1381, '14', '03', '02', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1382, '14', '03', '03', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1383, '14', '03', '04', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1384, '14', '03', '05', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1385, '14', '03', '06', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1386, '14', '03', '07', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1387, '14', '03', '08', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1388, '14', '03', '09', 14, '1', to_date('09-06-2016 12:05:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1389, '14', '03', '10', 14, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1390, '14', '03', '11', 14, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1391, '14', '03', '12', 14, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1392, '15', '00', '00', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1393, '15', '01', '00', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1394, '15', '01', '01', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1395, '15', '01', '02', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1396, '15', '01', '03', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1397, '15', '01', '04', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1398, '15', '01', '05', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1399, '15', '01', '06', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1400, '15', '01', '07', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1401, '15', '01', '08', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1402, '15', '01', '09', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1403, '15', '01', '10', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1404, '15', '01', '11', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1405, '15', '01', '12', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1406, '15', '01', '13', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1407, '15', '01', '14', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1408, '15', '01', '15', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1409, '15', '01', '16', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1410, '15', '01', '17', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1411, '15', '01', '18', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1412, '15', '01', '19', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1413, '15', '01', '20', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1414, '15', '01', '21', 15, '1', to_date('09-06-2016 12:05:56', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1415, '15', '01', '22', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1416, '15', '01', '23', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1417, '15', '01', '24', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1418, '15', '01', '25', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1419, '15', '01', '26', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1420, '15', '01', '27', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1421, '15', '01', '28', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1422, '15', '01', '29', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1423, '15', '01', '30', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1424, '15', '01', '31', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1425, '15', '01', '32', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1426, '15', '01', '33', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1427, '15', '01', '34', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1428, '15', '01', '35', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1429, '15', '01', '36', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1430, '15', '01', '37', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1431, '15', '01', '38', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1432, '15', '01', '39', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1433, '15', '01', '40', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1434, '15', '01', '41', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1435, '15', '01', '42', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1436, '15', '01', '43', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (577, '05', '09', '01', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (578, '05', '09', '02', 5, '1', to_date('09-06-2016 12:05:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (579, '05', '09', '03', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (580, '05', '09', '04', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (581, '05', '09', '05', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (582, '05', '09', '06', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (583, '05', '09', '07', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (584, '05', '09', '08', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (585, '05', '09', '09', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (586, '05', '09', '10', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (587, '05', '09', '11', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (588, '05', '10', '00', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (589, '05', '10', '01', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (590, '05', '10', '02', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (591, '05', '10', '03', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (592, '05', '10', '04', 5, '1', to_date('09-06-2016 12:05:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (593, '05', '10', '05', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (594, '05', '10', '06', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (595, '05', '10', '07', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (596, '05', '10', '08', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (597, '05', '10', '09', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (598, '05', '10', '10', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (599, '05', '10', '11', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (600, '05', '10', '12', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (601, '05', '11', '00', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (602, '05', '11', '01', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (603, '05', '11', '02', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (604, '05', '11', '03', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (605, '05', '11', '04', 5, '1', to_date('09-06-2016 12:05:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (606, '05', '11', '05', 5, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (607, '05', '11', '06', 5, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (608, '05', '11', '07', 5, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (609, '05', '11', '08', 5, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (610, '06', '00', '00', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (611, '06', '01', '00', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (612, '06', '01', '01', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (613, '06', '01', '02', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (614, '06', '01', '03', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (615, '06', '01', '04', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (616, '06', '01', '05', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (617, '06', '01', '06', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (618, '06', '01', '07', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (619, '06', '01', '08', 6, '1', to_date('09-06-2016 12:05:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (620, '06', '01', '09', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (621, '06', '01', '10', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (622, '06', '01', '11', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (623, '06', '01', '12', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (624, '06', '02', '00', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (625, '06', '02', '01', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (626, '06', '02', '02', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (627, '06', '02', '03', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (628, '06', '02', '04', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (629, '06', '03', '00', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (630, '06', '03', '01', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (631, '06', '03', '02', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (632, '06', '03', '03', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (633, '06', '03', '04', 6, '1', to_date('09-06-2016 12:05:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (634, '06', '03', '05', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (635, '06', '03', '06', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (636, '06', '03', '07', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (637, '06', '03', '08', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (638, '06', '03', '09', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (639, '06', '03', '10', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (640, '06', '03', '11', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (641, '06', '03', '12', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (642, '06', '04', '00', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (643, '06', '04', '01', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (644, '06', '04', '02', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (645, '06', '04', '03', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (646, '06', '04', '04', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (647, '06', '04', '05', 6, '1', to_date('09-06-2016 12:05:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (648, '06', '04', '06', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (649, '06', '04', '07', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (650, '06', '04', '08', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (651, '06', '04', '09', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (652, '06', '04', '10', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (653, '06', '04', '11', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (654, '06', '04', '12', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (655, '06', '04', '13', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (656, '06', '04', '14', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (657, '06', '04', '15', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (658, '06', '04', '16', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (659, '06', '04', '17', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (660, '06', '04', '18', 6, '1', to_date('09-06-2016 12:05:09', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (661, '06', '04', '19', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (662, '06', '05', '00', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (663, '06', '05', '01', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (664, '06', '05', '02', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (665, '06', '05', '03', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (666, '06', '05', '04', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (667, '06', '05', '05', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (668, '06', '05', '06', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (669, '06', '05', '07', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (670, '06', '05', '08', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (671, '06', '06', '00', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (672, '06', '06', '01', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (673, '06', '06', '02', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (674, '06', '06', '03', 6, '1', to_date('09-06-2016 12:05:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (675, '06', '06', '04', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (676, '06', '06', '05', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (677, '06', '06', '06', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (678, '06', '06', '07', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (679, '06', '06', '08', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (680, '06', '06', '09', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (681, '06', '06', '10', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (682, '06', '06', '11', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (683, '06', '06', '12', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (684, '06', '06', '13', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (685, '06', '06', '14', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (686, '06', '06', '15', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (687, '06', '07', '00', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (688, '06', '07', '01', 6, '1', to_date('09-06-2016 12:05:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (689, '06', '07', '02', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (690, '06', '07', '03', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (691, '06', '08', '00', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (692, '06', '08', '01', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (693, '06', '08', '02', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (694, '06', '08', '03', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (695, '06', '08', '04', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (696, '06', '08', '05', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (697, '06', '08', '06', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (698, '06', '08', '07', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (699, '06', '08', '08', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (700, '06', '08', '09', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (701, '06', '08', '10', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (702, '06', '08', '11', 6, '1', to_date('09-06-2016 12:05:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (703, '06', '08', '12', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (704, '06', '09', '00', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (705, '06', '09', '01', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (706, '06', '09', '02', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (707, '06', '09', '03', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (708, '06', '09', '04', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (709, '06', '09', '05', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (710, '06', '09', '06', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (711, '06', '09', '07', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (712, '06', '10', '00', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (713, '06', '10', '01', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (714, '06', '10', '02', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (715, '06', '10', '03', 6, '1', to_date('09-06-2016 12:05:13', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (716, '06', '10', '04', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (717, '06', '10', '05', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (718, '06', '10', '06', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (719, '06', '10', '07', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (720, '06', '11', '00', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (721, '06', '11', '01', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (722, '06', '11', '02', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (723, '06', '11', '03', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (724, '06', '11', '04', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (725, '06', '11', '05', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (726, '06', '11', '06', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (727, '06', '11', '07', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (728, '06', '11', '08', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (729, '06', '11', '09', 6, '1', to_date('09-06-2016 12:05:14', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (730, '06', '11', '10', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (731, '06', '11', '11', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (732, '06', '11', '12', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (733, '06', '11', '13', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (734, '06', '12', '00', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (735, '06', '12', '01', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (736, '06', '12', '02', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (737, '06', '12', '03', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (738, '06', '12', '04', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (739, '06', '13', '00', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (740, '06', '13', '01', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (741, '06', '13', '02', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (742, '06', '13', '03', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (743, '06', '13', '04', 6, '1', to_date('09-06-2016 12:05:15', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (744, '06', '13', '05', 6, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (745, '06', '13', '06', 6, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (746, '06', '13', '07', 6, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (747, '06', '13', '08', 6, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (748, '06', '13', '09', 6, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (749, '06', '13', '10', 6, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (750, '06', '13', '11', 6, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (751, '07', '00', '00', 7, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (752, '07', '01', '00', 7, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (753, '07', '01', '01', 7, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (754, '07', '01', '02', 7, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (755, '07', '01', '03', 7, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (756, '07', '01', '04', 7, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (757, '07', '01', '05', 7, '1', to_date('09-06-2016 12:05:16', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (758, '07', '01', '06', 7, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (759, '08', '00', '00', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (760, '08', '01', '00', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (761, '08', '01', '01', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (762, '08', '01', '02', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (763, '08', '01', '03', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (764, '08', '01', '04', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (765, '08', '01', '05', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (766, '08', '01', '06', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (767, '08', '01', '07', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (768, '08', '01', '08', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (769, '08', '02', '00', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (770, '08', '02', '01', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (771, '08', '02', '02', 8, '1', to_date('09-06-2016 12:05:17', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (772, '08', '02', '03', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (773, '08', '02', '04', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (774, '08', '02', '05', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (775, '08', '02', '06', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (776, '08', '02', '07', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (777, '08', '03', '00', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (778, '08', '03', '01', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (779, '08', '03', '02', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (780, '08', '03', '03', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (781, '08', '03', '04', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (782, '08', '03', '05', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (783, '08', '03', '06', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (784, '08', '03', '07', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (785, '08', '03', '08', 8, '1', to_date('09-06-2016 12:05:18', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (786, '08', '03', '09', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (787, '08', '04', '00', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (788, '08', '04', '01', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (789, '08', '04', '02', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (790, '08', '04', '03', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (791, '08', '04', '04', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (792, '08', '04', '05', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (793, '08', '04', '06', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (794, '08', '04', '07', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (795, '08', '04', '08', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (796, '08', '05', '00', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (797, '08', '05', '01', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (798, '08', '05', '02', 8, '1', to_date('09-06-2016 12:05:19', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (799, '08', '05', '03', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (800, '08', '05', '04', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (801, '08', '05', '05', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (802, '08', '05', '06', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (803, '08', '05', '07', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (804, '08', '05', '08', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (805, '08', '06', '00', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (806, '08', '06', '01', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (807, '08', '06', '02', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (808, '08', '06', '03', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (809, '08', '06', '04', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (810, '08', '06', '05', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (811, '08', '06', '06', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (812, '08', '06', '07', 8, '1', to_date('09-06-2016 12:05:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (813, '08', '06', '08', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (814, '08', '07', '00', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (815, '08', '07', '01', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (816, '08', '07', '02', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (817, '08', '07', '03', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (818, '08', '07', '04', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (819, '08', '07', '05', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (820, '08', '07', '06', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (821, '08', '07', '07', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (822, '08', '07', '08', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (823, '08', '08', '00', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (824, '08', '08', '01', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (825, '08', '08', '02', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (826, '08', '08', '03', 8, '1', to_date('09-06-2016 12:05:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (827, '08', '08', '04', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (828, '08', '08', '05', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (829, '08', '08', '06', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (830, '08', '08', '07', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (831, '08', '08', '08', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (832, '08', '09', '00', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (833, '08', '09', '01', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (834, '08', '09', '02', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (835, '08', '09', '03', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (836, '08', '09', '04', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (837, '08', '09', '05', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (838, '08', '09', '06', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (839, '08', '09', '07', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (840, '08', '09', '08', 8, '1', to_date('09-06-2016 12:05:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (841, '08', '09', '09', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (842, '08', '09', '10', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (843, '08', '10', '00', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (844, '08', '10', '01', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (845, '08', '10', '02', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (846, '08', '10', '03', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (847, '08', '10', '04', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (848, '08', '10', '05', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (849, '08', '10', '06', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (850, '08', '10', '07', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (851, '08', '10', '08', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (852, '08', '10', '09', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (853, '08', '11', '00', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (854, '08', '11', '01', 8, '1', to_date('09-06-2016 12:05:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (855, '08', '11', '02', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (856, '08', '11', '03', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (857, '08', '11', '04', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (858, '08', '11', '05', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (859, '08', '11', '06', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (860, '08', '12', '00', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (861, '08', '12', '01', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (862, '08', '12', '02', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (863, '08', '12', '03', 8, '1', to_date('09-06-2016 12:05:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1, '01', '00', '00', 1, '1', to_date('09-06-2016 11:54:55', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2, '01', '01', '00', 1, '1', to_date('09-06-2016 12:04:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (3, '01', '01', '01', 1, '1', to_date('09-06-2016 12:04:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (4, '01', '01', '02', 1, '1', to_date('09-06-2016 12:04:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (5, '01', '01', '03', 1, '1', to_date('09-06-2016 12:04:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (6, '01', '01', '04', 1, '1', to_date('09-06-2016 12:04:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (7, '01', '01', '05', 1, '1', to_date('09-06-2016 12:04:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (8, '01', '01', '06', 1, '1', to_date('09-06-2016 12:04:20', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (9, '01', '01', '07', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (10, '01', '01', '08', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (11, '01', '01', '09', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (12, '01', '01', '10', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (13, '01', '01', '11', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (14, '01', '01', '12', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (15, '01', '01', '13', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (16, '01', '01', '14', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (17, '01', '01', '15', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (18, '01', '01', '16', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (19, '01', '01', '17', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (20, '01', '01', '18', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (21, '01', '01', '19', 1, '1', to_date('09-06-2016 12:04:21', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (22, '01', '01', '20', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (23, '01', '01', '21', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (24, '01', '02', '00', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (25, '01', '02', '01', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (26, '01', '02', '02', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (27, '01', '02', '03', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (28, '01', '02', '04', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (29, '01', '02', '05', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (30, '01', '02', '06', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (31, '01', '03', '00', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (32, '01', '03', '01', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (33, '01', '03', '02', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (34, '01', '03', '03', 1, '1', to_date('09-06-2016 12:04:22', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (35, '01', '03', '04', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (36, '01', '03', '05', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (37, '01', '03', '06', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (38, '01', '03', '07', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (39, '01', '03', '08', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (40, '01', '03', '09', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (41, '01', '03', '10', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (42, '01', '03', '11', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (43, '01', '03', '12', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (44, '01', '04', '00', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (45, '01', '04', '01', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (46, '01', '04', '02', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (47, '01', '04', '03', 1, '1', to_date('09-06-2016 12:04:23', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (48, '01', '05', '00', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (49, '01', '05', '01', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (50, '01', '05', '02', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (51, '01', '05', '03', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (52, '01', '05', '04', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (53, '01', '05', '05', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (54, '01', '05', '06', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (55, '01', '05', '07', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (56, '01', '05', '08', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (57, '01', '05', '09', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (58, '01', '05', '10', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (59, '01', '05', '11', 1, '1', to_date('09-06-2016 12:04:24', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (60, '01', '05', '12', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (61, '01', '05', '13', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (62, '01', '05', '14', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (63, '01', '05', '15', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (64, '01', '05', '16', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (65, '01', '05', '17', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (66, '01', '05', '18', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (67, '01', '05', '19', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (68, '01', '05', '20', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (69, '01', '05', '21', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (70, '01', '05', '22', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (71, '01', '05', '23', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (72, '01', '06', '00', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (73, '01', '06', '01', 1, '1', to_date('09-06-2016 12:04:25', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (74, '01', '06', '02', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (75, '01', '06', '03', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (76, '01', '06', '04', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (77, '01', '06', '05', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (78, '01', '06', '06', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (79, '01', '06', '07', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (80, '01', '06', '08', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (81, '01', '06', '09', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (82, '01', '06', '10', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (83, '01', '06', '11', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (84, '01', '06', '12', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (85, '01', '07', '00', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (86, '01', '07', '01', 1, '1', to_date('09-06-2016 12:04:26', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (87, '01', '07', '02', 1, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (88, '01', '07', '03', 1, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (89, '01', '07', '04', 1, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (90, '01', '07', '05', 1, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (91, '01', '07', '06', 1, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (92, '01', '07', '07', 1, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (93, '02', '00', '00', 2, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (94, '02', '01', '00', 2, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (95, '02', '01', '01', 2, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (96, '02', '01', '02', 2, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (97, '02', '01', '03', 2, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (98, '02', '01', '04', 2, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (99, '02', '01', '05', 2, '1', to_date('09-06-2016 12:04:27', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (100, '02', '01', '06', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (101, '02', '01', '07', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (102, '02', '01', '08', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (103, '02', '01', '09', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (104, '02', '01', '10', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (105, '02', '01', '11', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (106, '02', '01', '12', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (107, '02', '02', '00', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (108, '02', '02', '01', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (109, '02', '02', '02', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (110, '02', '02', '03', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (111, '02', '02', '04', 2, '1', to_date('09-06-2016 12:04:28', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (112, '02', '02', '05', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (113, '02', '03', '00', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (114, '02', '03', '01', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (115, '02', '03', '02', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (116, '02', '03', '03', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (117, '02', '03', '04', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (118, '02', '03', '05', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (119, '02', '03', '06', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (120, '02', '04', '00', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (121, '02', '04', '01', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (122, '02', '04', '02', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (123, '02', '05', '00', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (124, '02', '05', '01', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (125, '02', '05', '02', 2, '1', to_date('09-06-2016 12:04:29', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (126, '02', '05', '03', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (127, '02', '05', '04', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (128, '02', '05', '05', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (129, '02', '05', '06', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (130, '02', '05', '07', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (131, '02', '05', '08', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (132, '02', '05', '09', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (133, '02', '05', '10', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (134, '02', '05', '11', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (135, '02', '05', '12', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (136, '02', '05', '13', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (137, '02', '05', '14', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (138, '02', '05', '15', 2, '1', to_date('09-06-2016 12:04:30', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (139, '02', '06', '00', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (140, '02', '06', '01', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (141, '02', '06', '02', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (142, '02', '06', '03', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (143, '02', '06', '04', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (144, '02', '06', '05', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (145, '02', '06', '06', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (146, '02', '06', '07', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (147, '02', '06', '08', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (148, '02', '06', '09', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (149, '02', '06', '10', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (150, '02', '06', '11', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (151, '02', '07', '00', 2, '1', to_date('09-06-2016 12:04:31', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (152, '02', '07', '01', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (153, '02', '07', '02', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (154, '02', '07', '03', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (155, '02', '08', '00', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (156, '02', '08', '01', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (157, '02', '08', '02', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (158, '02', '08', '03', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (159, '02', '08', '04', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (160, '02', '09', '00', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (161, '02', '09', '01', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (162, '02', '09', '02', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (163, '02', '09', '03', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (164, '02', '09', '04', 2, '1', to_date('09-06-2016 12:04:32', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (165, '02', '09', '05', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (166, '02', '09', '06', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (167, '02', '09', '07', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (168, '02', '10', '00', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (169, '02', '10', '01', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (170, '02', '10', '02', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (171, '02', '10', '03', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (172, '02', '10', '04', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (173, '02', '10', '05', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (174, '02', '10', '06', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (175, '02', '10', '07', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (176, '02', '10', '08', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (177, '02', '10', '09', 2, '1', to_date('09-06-2016 12:04:33', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (178, '02', '10', '10', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (179, '02', '10', '11', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (180, '02', '10', '12', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (181, '02', '10', '13', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (182, '02', '10', '14', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (183, '02', '10', '15', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (184, '02', '10', '16', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (185, '02', '11', '00', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (186, '02', '11', '01', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (187, '02', '11', '02', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (188, '02', '11', '03', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (189, '02', '11', '04', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (190, '02', '11', '05', 2, '1', to_date('09-06-2016 12:04:34', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (191, '02', '12', '00', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (192, '02', '12', '01', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (193, '02', '12', '02', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (194, '02', '12', '03', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (195, '02', '12', '04', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (196, '02', '12', '05', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (197, '02', '12', '06', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (198, '02', '12', '07', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (199, '02', '12', '08', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (200, '02', '12', '09', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (201, '02', '12', '10', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (202, '02', '13', '00', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (203, '02', '13', '01', 2, '1', to_date('09-06-2016 12:04:35', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (204, '02', '13', '02', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (205, '02', '13', '03', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (206, '02', '13', '04', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (207, '02', '13', '05', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (208, '02', '13', '06', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (209, '02', '13', '07', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (210, '02', '13', '08', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (211, '02', '14', '00', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (212, '02', '14', '01', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (213, '02', '14', '02', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (214, '02', '14', '03', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (215, '02', '14', '04', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (216, '02', '14', '05', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (217, '02', '14', '06', 2, '1', to_date('09-06-2016 12:04:36', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (218, '02', '14', '07', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (219, '02', '14', '08', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (220, '02', '14', '09', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (221, '02', '14', '10', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (222, '02', '15', '00', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (223, '02', '15', '01', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (224, '02', '15', '02', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (225, '02', '15', '03', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (226, '02', '15', '04', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (227, '02', '15', '05', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (228, '02', '15', '06', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (229, '02', '15', '07', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (230, '02', '15', '08', 2, '1', to_date('09-06-2016 12:04:37', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (231, '02', '15', '09', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (232, '02', '15', '10', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (233, '02', '15', '11', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (234, '02', '16', '00', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (235, '02', '16', '01', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (236, '02', '16', '02', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (237, '02', '16', '03', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (238, '02', '16', '04', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (239, '02', '17', '00', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (240, '02', '17', '01', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (241, '02', '17', '02', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (242, '02', '17', '03', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (243, '02', '17', '04', 2, '1', to_date('09-06-2016 12:04:38', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (244, '02', '17', '05', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (245, '02', '17', '06', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (246, '02', '17', '07', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (247, '02', '17', '08', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (248, '02', '17', '09', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (249, '02', '17', '10', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (250, '02', '18', '00', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (251, '02', '18', '01', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (252, '02', '18', '02', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (253, '02', '18', '03', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (254, '02', '18', '04', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (255, '02', '18', '05', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (256, '02', '18', '06', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (257, '02', '18', '07', 2, '1', to_date('09-06-2016 12:04:39', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (258, '02', '18', '08', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (259, '02', '18', '09', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (260, '02', '19', '00', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (261, '02', '19', '01', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (262, '02', '19', '02', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (263, '02', '19', '03', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (264, '02', '19', '04', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (265, '02', '19', '05', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (266, '02', '19', '06', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (267, '02', '19', '07', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (268, '02', '19', '08', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (269, '02', '19', '09', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (270, '02', '19', '10', 2, '1', to_date('09-06-2016 12:04:40', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (271, '02', '20', '00', 2, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (272, '02', '20', '01', 2, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (273, '02', '20', '02', 2, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (274, '02', '20', '03', 2, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (275, '02', '20', '04', 2, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (276, '02', '20', '05', 2, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (277, '02', '20', '06', 2, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (278, '02', '20', '07', 2, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (279, '02', '20', '08', 2, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (280, '03', '00', '00', 3, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (281, '03', '01', '00', 3, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (282, '03', '01', '01', 3, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (283, '03', '01', '02', 3, '1', to_date('09-06-2016 12:04:41', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (284, '03', '01', '03', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (285, '03', '01', '04', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (286, '03', '01', '05', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (287, '03', '01', '06', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (288, '03', '01', '07', 3, '1', to_date('09-06-2016 12:04:42', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2011, '23', '03', '03', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2012, '23', '04', '00', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2013, '23', '04', '01', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2014, '23', '04', '02', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2015, '23', '04', '03', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2016, '23', '04', '04', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2017, '23', '04', '05', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2018, '23', '04', '06', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2019, '23', '04', '07', 23, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2020, '23', '04', '08', 23, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2021, '24', '00', '00', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2022, '24', '01', '00', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2023, '24', '01', '01', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2024, '24', '01', '02', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2025, '24', '01', '03', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2026, '24', '01', '04', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2027, '24', '01', '05', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2028, '24', '01', '06', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2029, '24', '02', '00', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2030, '24', '02', '01', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2031, '24', '02', '02', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2032, '24', '02', '03', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2033, '24', '03', '00', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2034, '24', '03', '01', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2035, '24', '03', '02', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2036, '24', '03', '03', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2037, '24', '03', '04', 24, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2038, '25', '00', '00', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2039, '25', '01', '00', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2040, '25', '01', '01', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2041, '25', '01', '02', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2042, '25', '01', '03', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2043, '25', '01', '04', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2044, '25', '01', '05', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2045, '25', '01', '06', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2046, '25', '01', '07', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2047, '25', '02', '00', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2048, '25', '02', '01', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2049, '25', '02', '02', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2050, '25', '02', '03', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2051, '25', '02', '04', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2052, '25', '03', '00', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2053, '25', '03', '01', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2054, '25', '03', '02', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2055, '25', '03', '03', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2056, '25', '04', '00', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2057, '25', '04', '01', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2058, '15', '11', '00', 15, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2059, '25', '05', '00', 25, '1', to_date('09-06-2016 12:06:08', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2060, '01', '07', '08', 1, '1', to_date('09-06-2016 12:07:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2061, '04', '01', '30', 4, '1', to_date('09-06-2016 12:07:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2062, '05', '01', '16', 5, '1', to_date('09-06-2016 12:07:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2063, '05', '04', '09', 5, '1', to_date('09-06-2016 12:07:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2064, '05', '12', '00', 5, '1', to_date('09-06-2016 12:07:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2065, '08', '08', '09', 8, '1', to_date('09-06-2016 12:07:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2066, '09', '07', '08', 9, '1', to_date('09-06-2016 12:07:10', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2067, '10', '06', '07', 10, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2068, '10', '06', '08', 10, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2069, '10', '06', '09', 10, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2070, '10', '06', '10', 10, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2071, '12', '06', '04', 12, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2072, '12', '06', '06', 12, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2073, '14', '01', '21', 14, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2074, '14', '01', '22', 14, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2075, '15', '01', '44', 15, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2076, '15', '01', '45', 15, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2077, '15', '11', '01', 15, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2078, '15', '11', '02', 15, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2079, '15', '11', '03', 15, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2080, '15', '11', '04', 15, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2081, '15', '11', '05', 15, '1', to_date('09-06-2016 12:07:11', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2082, '15', '11', '16', 15, '1', to_date('09-06-2016 12:07:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2083, '16', '02', '03', 16, '1', to_date('09-06-2016 12:07:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2084, '16', '02', '04', 16, '1', to_date('09-06-2016 12:07:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2085, '16', '02', '07', 16, '1', to_date('09-06-2016 12:07:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2086, '16', '02', '08', 16, '1', to_date('09-06-2016 12:07:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2087, '16', '02', '09', 16, '1', to_date('09-06-2016 12:07:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2088, '20', '01', '15', 20, '1', to_date('09-06-2016 12:07:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2089, '25', '05', '01', 25, '1', to_date('09-06-2016 12:07:12', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1437, '15', '02', '00', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1438, '15', '02', '01', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1439, '15', '02', '02', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1440, '15', '02', '03', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1441, '15', '02', '04', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1442, '15', '02', '05', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1443, '15', '03', '00', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1444, '15', '03', '01', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1445, '15', '03', '02', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1446, '15', '03', '03', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1447, '15', '03', '04', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1448, '15', '03', '05', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1449, '15', '04', '00', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1450, '15', '04', '01', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1451, '15', '04', '02', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1452, '15', '04', '03', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1453, '15', '04', '04', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1454, '15', '04', '05', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1455, '15', '04', '06', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1456, '15', '04', '07', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1457, '15', '05', '00', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1458, '15', '05', '01', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1459, '15', '05', '02', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1460, '15', '05', '03', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1461, '15', '05', '04', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1462, '15', '05', '05', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1463, '15', '05', '06', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1464, '15', '05', '07', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1465, '15', '05', '08', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1466, '15', '05', '09', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1467, '15', '05', '10', 15, '1', to_date('09-06-2016 12:05:57', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1468, '15', '05', '11', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1469, '15', '05', '12', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1470, '15', '05', '13', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1471, '15', '05', '14', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1472, '15', '05', '15', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1473, '15', '05', '16', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1474, '15', '06', '00', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1475, '15', '06', '01', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1476, '15', '06', '02', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1477, '15', '06', '03', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1478, '15', '06', '04', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1479, '15', '06', '05', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1480, '15', '06', '06', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1481, '15', '06', '07', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1482, '15', '06', '08', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1483, '15', '06', '09', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1484, '15', '06', '10', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1485, '15', '06', '11', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1486, '15', '06', '12', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1487, '15', '07', '00', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1488, '15', '07', '01', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1489, '15', '07', '02', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1490, '15', '07', '03', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1491, '15', '07', '04', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1492, '15', '07', '05', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1493, '15', '07', '06', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1494, '15', '07', '07', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1495, '15', '07', '08', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1496, '15', '07', '09', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1497, '15', '07', '10', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1498, '15', '07', '11', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1499, '15', '07', '12', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1500, '15', '07', '13', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1501, '15', '07', '14', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1502, '15', '07', '15', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1503, '15', '07', '16', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1504, '15', '07', '17', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1505, '15', '07', '18', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1506, '15', '07', '19', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1507, '15', '07', '20', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1508, '15', '07', '21', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1509, '15', '07', '22', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1510, '15', '07', '23', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1511, '15', '07', '24', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1512, '15', '07', '25', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1513, '15', '07', '26', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1514, '15', '07', '27', 15, '1', to_date('09-06-2016 12:05:58', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1515, '15', '07', '28', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1516, '15', '07', '29', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1517, '15', '07', '30', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1518, '15', '07', '31', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1519, '15', '07', '32', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1520, '15', '08', '00', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1521, '15', '08', '01', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1522, '15', '08', '02', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1523, '15', '08', '03', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1524, '15', '08', '04', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1525, '15', '08', '05', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1526, '15', '08', '06', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1527, '15', '08', '07', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1528, '15', '08', '08', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1529, '15', '08', '09', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1530, '15', '08', '10', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1531, '15', '08', '11', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1532, '15', '08', '12', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1533, '15', '09', '00', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1534, '15', '09', '01', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1535, '15', '09', '02', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1536, '15', '09', '03', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1537, '15', '09', '04', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1538, '15', '09', '05', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1539, '15', '09', '06', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1540, '15', '10', '00', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1541, '15', '10', '01', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1542, '15', '10', '02', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1543, '15', '10', '03', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1544, '15', '10', '04', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1545, '15', '10', '05', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1546, '15', '10', '06', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1547, '15', '10', '07', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1548, '15', '10', '08', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1549, '15', '10', '09', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1550, '15', '10', '10', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1551, '15', '10', '11', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1552, '15', '10', '12', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1553, '15', '10', '13', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1554, '15', '10', '14', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1555, '15', '10', '15', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1556, '15', '10', '16', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1557, '15', '10', '17', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1558, '15', '10', '18', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1559, '15', '10', '19', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1560, '15', '10', '20', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1561, '15', '10', '21', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1562, '15', '10', '22', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1563, '15', '10', '23', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1564, '15', '10', '24', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1565, '15', '10', '25', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1566, '15', '10', '26', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1567, '15', '10', '27', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1568, '15', '10', '28', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1569, '15', '10', '29', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1570, '15', '10', '30', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1571, '15', '10', '31', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1572, '15', '10', '32', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1573, '15', '10', '33', 15, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1574, '16', '00', '00', 16, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1575, '16', '01', '00', 16, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1576, '16', '01', '01', 16, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1577, '16', '01', '02', 16, '1', to_date('09-06-2016 12:05:59', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1578, '16', '01', '03', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1579, '16', '01', '04', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1580, '16', '01', '05', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1581, '16', '01', '06', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1582, '16', '01', '07', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1583, '16', '01', '08', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1584, '16', '01', '09', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1585, '16', '01', '10', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1586, '16', '01', '12', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1587, '16', '01', '13', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1588, '16', '01', '14', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1589, '16', '02', '00', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1590, '16', '02', '01', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1591, '16', '02', '02', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1592, '16', '02', '05', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1593, '16', '02', '06', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1594, '16', '02', '10', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1595, '16', '02', '11', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1596, '16', '03', '00', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1597, '16', '03', '01', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1598, '16', '03', '02', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1599, '16', '03', '03', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1600, '16', '03', '04', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1601, '16', '03', '05', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1602, '16', '04', '00', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1603, '16', '04', '01', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1604, '16', '04', '02', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1605, '16', '04', '03', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1606, '16', '04', '04', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1607, '16', '05', '00', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1608, '16', '05', '01', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1609, '16', '05', '02', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1610, '16', '05', '03', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1611, '16', '05', '04', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1612, '16', '05', '05', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1613, '16', '05', '06', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1614, '16', '05', '07', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1615, '16', '05', '08', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1616, '16', '05', '09', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1617, '16', '05', '10', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1618, '16', '05', '11', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1619, '16', '06', '00', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1620, '16', '06', '01', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1621, '16', '06', '02', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1622, '16', '06', '03', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1623, '16', '06', '04', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1624, '16', '06', '05', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1625, '16', '06', '06', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1626, '16', '07', '00', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1627, '16', '07', '01', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1628, '16', '07', '02', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1629, '16', '07', '03', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1630, '16', '07', '04', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1631, '16', '07', '05', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1632, '16', '07', '06', 16, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1633, '17', '00', '00', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1634, '17', '01', '00', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1635, '17', '01', '01', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1636, '17', '01', '02', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1637, '17', '01', '03', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1638, '17', '01', '04', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1639, '17', '02', '00', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1640, '17', '02', '01', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1641, '17', '02', '02', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1642, '17', '02', '03', 17, '1', to_date('09-06-2016 12:06:00', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1643, '17', '02', '04', 17, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1644, '17', '03', '00', 17, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1645, '17', '03', '01', 17, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1646, '17', '03', '02', 17, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1647, '17', '03', '03', 17, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1648, '18', '00', '00', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1649, '18', '01', '00', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1650, '18', '01', '01', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1651, '18', '01', '02', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1652, '18', '01', '03', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1653, '18', '01', '04', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1654, '18', '01', '05', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1655, '18', '01', '06', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1656, '18', '02', '00', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1657, '18', '02', '01', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1658, '18', '02', '02', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1659, '18', '02', '03', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1660, '18', '02', '04', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1661, '18', '02', '05', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1662, '18', '02', '06', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1663, '18', '02', '07', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1664, '18', '02', '08', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1665, '18', '02', '09', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1666, '18', '02', '10', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1667, '18', '02', '11', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1668, '18', '03', '00', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1669, '18', '03', '01', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1670, '18', '03', '02', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1671, '18', '03', '03', 18, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1672, '19', '00', '00', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1673, '19', '01', '00', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1674, '19', '01', '01', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1675, '19', '01', '02', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1676, '19', '01', '03', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1677, '19', '01', '04', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1678, '19', '01', '05', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1679, '19', '01', '06', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1680, '19', '01', '07', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1681, '19', '01', '08', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1682, '19', '01', '09', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1683, '19', '01', '10', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1684, '19', '01', '11', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1685, '19', '01', '12', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1686, '19', '01', '13', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1687, '19', '02', '00', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1688, '19', '02', '01', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1689, '19', '02', '02', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1690, '19', '02', '03', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1691, '19', '02', '04', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1692, '19', '02', '05', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1693, '19', '02', '06', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1694, '19', '02', '07', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1695, '19', '02', '08', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1696, '19', '03', '00', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1697, '19', '03', '01', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1698, '19', '03', '02', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1699, '19', '03', '03', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1700, '19', '03', '04', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1701, '19', '03', '05', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1702, '19', '03', '06', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1703, '19', '03', '07', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1704, '19', '03', '08', 19, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1705, '20', '00', '00', 20, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1706, '20', '01', '00', 20, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1707, '20', '01', '01', 20, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1708, '20', '01', '04', 20, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1709, '20', '01', '05', 20, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1710, '20', '01', '07', 20, '1', to_date('09-06-2016 12:06:01', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1711, '20', '01', '08', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1712, '20', '01', '09', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1713, '20', '01', '10', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1714, '20', '01', '11', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1715, '20', '01', '14', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1716, '20', '02', '00', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1717, '20', '02', '01', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1718, '20', '02', '02', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1719, '20', '02', '03', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1720, '20', '02', '04', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1721, '20', '02', '05', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1722, '20', '02', '06', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1723, '20', '02', '07', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1724, '20', '02', '08', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1725, '20', '02', '09', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1726, '20', '02', '10', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1727, '20', '03', '00', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1728, '20', '03', '01', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1729, '20', '03', '02', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1730, '20', '03', '03', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1731, '20', '03', '04', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1732, '20', '03', '05', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1733, '20', '03', '06', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1734, '20', '03', '07', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1735, '20', '03', '08', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1736, '20', '04', '00', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1737, '20', '04', '01', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1738, '20', '04', '02', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1739, '20', '04', '03', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1740, '20', '04', '04', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1741, '20', '04', '05', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1742, '20', '04', '06', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1743, '20', '04', '07', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1744, '20', '04', '08', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1745, '20', '04', '09', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1746, '20', '04', '10', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1747, '20', '05', '00', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1748, '20', '05', '01', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1749, '20', '05', '02', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1750, '20', '05', '03', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1751, '20', '05', '04', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1752, '20', '05', '05', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1753, '20', '05', '06', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1754, '20', '05', '07', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1755, '20', '06', '00', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1756, '20', '06', '01', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1757, '20', '06', '02', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1758, '20', '06', '03', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1759, '20', '06', '04', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1760, '20', '06', '05', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1761, '20', '06', '06', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1762, '20', '06', '07', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1763, '20', '06', '08', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1764, '20', '07', '00', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1765, '20', '07', '01', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1766, '20', '07', '02', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1767, '20', '07', '03', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1768, '20', '07', '04', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1769, '20', '07', '05', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1770, '20', '07', '06', 20, '1', to_date('09-06-2016 12:06:02', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1771, '20', '08', '00', 20, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1772, '20', '08', '01', 20, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1773, '20', '08', '02', 20, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1774, '20', '08', '03', 20, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1775, '20', '08', '04', 20, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1776, '20', '08', '05', 20, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1777, '20', '08', '06', 20, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1778, '21', '00', '00', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1779, '21', '01', '00', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1780, '21', '01', '01', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1781, '21', '01', '02', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1782, '21', '01', '03', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1783, '21', '01', '04', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1784, '21', '01', '05', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1785, '21', '01', '06', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1786, '21', '01', '07', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1787, '21', '01', '08', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1788, '21', '01', '09', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1789, '21', '01', '10', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1790, '21', '01', '11', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1791, '21', '01', '12', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1792, '21', '01', '13', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1793, '21', '01', '14', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1794, '21', '01', '15', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1795, '21', '02', '00', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1796, '21', '02', '01', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1797, '21', '02', '02', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1798, '21', '02', '03', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1799, '21', '02', '04', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1800, '21', '02', '05', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1801, '21', '02', '06', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1802, '21', '02', '07', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1803, '21', '02', '08', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1804, '21', '02', '09', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1805, '21', '02', '10', 21, '1', to_date('09-06-2016 12:06:03', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1806, '21', '02', '11', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1807, '21', '02', '12', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1808, '21', '02', '13', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1809, '21', '02', '14', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1810, '21', '02', '15', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1811, '21', '03', '00', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1812, '21', '03', '01', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1813, '21', '03', '02', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1814, '21', '03', '03', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1815, '21', '03', '04', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1816, '21', '03', '05', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1817, '21', '03', '06', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1818, '21', '03', '07', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1819, '21', '03', '08', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1820, '21', '03', '09', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1821, '21', '03', '10', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1822, '21', '04', '00', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1823, '21', '04', '01', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1824, '21', '04', '02', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1825, '21', '04', '03', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1826, '21', '04', '04', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1827, '21', '04', '05', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1828, '21', '04', '06', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1829, '21', '04', '07', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1830, '21', '05', '00', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1831, '21', '05', '01', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1832, '21', '05', '02', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1833, '21', '05', '03', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1834, '21', '05', '04', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1835, '21', '05', '05', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1836, '21', '06', '00', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1837, '21', '06', '01', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1838, '21', '06', '02', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1839, '21', '06', '03', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1840, '21', '06', '04', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1841, '21', '06', '05', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1842, '21', '06', '06', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1843, '21', '06', '07', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1844, '21', '06', '08', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1845, '21', '07', '00', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1846, '21', '07', '01', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1847, '21', '07', '02', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1848, '21', '07', '03', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1849, '21', '07', '04', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1850, '21', '07', '05', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1851, '21', '07', '06', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1852, '21', '07', '07', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1853, '21', '07', '08', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1854, '21', '07', '09', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1855, '21', '07', '10', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1856, '21', '08', '00', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1857, '21', '08', '01', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1858, '21', '08', '02', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1859, '21', '08', '03', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1860, '21', '08', '04', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1861, '21', '08', '05', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1862, '21', '08', '06', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1863, '21', '08', '07', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1864, '21', '08', '08', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1865, '21', '08', '09', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1866, '21', '09', '00', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1867, '21', '09', '01', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1868, '21', '09', '02', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1869, '21', '09', '03', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1870, '21', '09', '04', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1871, '21', '10', '00', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1872, '21', '10', '01', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1873, '21', '10', '02', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1874, '21', '10', '03', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1875, '21', '10', '04', 21, '1', to_date('09-06-2016 12:06:04', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1876, '21', '10', '05', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1877, '21', '11', '00', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1878, '21', '11', '01', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1879, '21', '11', '02', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1880, '21', '11', '03', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1881, '21', '11', '04', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1882, '21', '12', '00', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1883, '21', '12', '01', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1884, '21', '12', '02', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1885, '21', '12', '03', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1886, '21', '12', '04', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1887, '21', '12', '05', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1888, '21', '12', '06', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1889, '21', '12', '07', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1890, '21', '12', '08', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1891, '21', '12', '09', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1892, '21', '12', '10', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1893, '21', '13', '00', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1894, '21', '13', '01', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1895, '21', '13', '02', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1896, '21', '13', '03', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1897, '21', '13', '04', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1898, '21', '13', '05', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1899, '21', '13', '06', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1900, '21', '13', '07', 21, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1901, '22', '00', '00', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1902, '22', '01', '00', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1903, '22', '01', '01', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1904, '22', '01', '02', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1905, '22', '01', '03', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1906, '22', '01', '04', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1907, '22', '01', '05', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1908, '22', '01', '06', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1909, '22', '02', '00', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1910, '22', '02', '01', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1911, '22', '02', '02', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1912, '22', '02', '03', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1913, '22', '02', '04', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1914, '22', '02', '05', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1915, '22', '02', '06', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1916, '22', '03', '00', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1917, '22', '03', '01', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1918, '22', '03', '02', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1919, '22', '03', '03', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1920, '22', '03', '04', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1921, '22', '03', '05', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1922, '22', '04', '00', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1923, '22', '04', '01', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1924, '22', '04', '02', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1925, '22', '04', '03', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1926, '22', '04', '04', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1927, '22', '04', '05', 22, '1', to_date('09-06-2016 12:06:05', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1928, '22', '04', '06', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1929, '22', '05', '00', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1930, '22', '05', '01', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1931, '22', '05', '02', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1932, '22', '05', '03', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1933, '22', '05', '04', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1934, '22', '05', '05', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1935, '22', '05', '06', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1936, '22', '05', '07', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1937, '22', '05', '08', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1938, '22', '05', '09', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1939, '22', '05', '10', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1940, '22', '05', '11', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1941, '22', '06', '00', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1942, '22', '06', '01', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1943, '22', '06', '02', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1944, '22', '06', '03', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1945, '22', '06', '04', 22, '1', to_date('09-06-2016 12:06:06', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1946, '22', '06', '05', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1947, '22', '07', '00', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1948, '22', '07', '01', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1949, '22', '07', '02', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1950, '22', '07', '03', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1951, '22', '07', '04', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1952, '22', '07', '05', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1953, '22', '07', '06', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1954, '22', '07', '07', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1955, '22', '07', '08', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1956, '22', '07', '09', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1957, '22', '07', '10', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1958, '22', '08', '00', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1959, '22', '08', '01', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1960, '22', '08', '02', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1961, '22', '08', '03', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1962, '22', '08', '04', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1963, '22', '08', '05', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1964, '22', '08', '06', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1965, '22', '08', '07', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1966, '22', '08', '08', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1967, '22', '08', '09', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1968, '22', '09', '00', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1969, '22', '09', '01', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1970, '22', '09', '02', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1971, '22', '09', '03', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1972, '22', '09', '04', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1973, '22', '09', '05', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1974, '22', '09', '06', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1975, '22', '09', '07', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1976, '22', '09', '08', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1977, '22', '09', '09', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1978, '22', '09', '10', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1979, '22', '09', '11', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1980, '22', '09', '12', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1981, '22', '09', '13', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1982, '22', '09', '14', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1983, '22', '10', '00', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1984, '22', '10', '01', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1985, '22', '10', '02', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1986, '22', '10', '03', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1987, '22', '10', '04', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1988, '22', '10', '05', 22, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1989, '23', '00', '00', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1990, '23', '01', '00', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1991, '23', '01', '01', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1992, '23', '01', '02', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1993, '23', '01', '03', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1994, '23', '01', '04', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1995, '23', '01', '05', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1996, '23', '01', '06', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1997, '23', '01', '07', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1998, '23', '01', '08', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (1999, '23', '01', '09', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2000, '23', '01', '10', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2001, '23', '02', '00', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2002, '23', '02', '01', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2003, '23', '02', '02', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2004, '23', '02', '03', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2005, '23', '02', '04', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2006, '23', '02', '05', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2007, '23', '02', '06', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2008, '23', '03', '00', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2009, '23', '03', '01', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

insert into pgh_ubigeo_region (ID_UBIGEO_REGION, ID_DEPARTAMENTO, ID_PROVINCIA, ID_DISTRITO, ID_REGION, ESTADO, FECHA_CREACION, USUARIO_CREACION, TERMINAL_CREACION, FECHA_ACTUALIZACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION)
values (2010, '23', '03', '02', 23, '1', to_date('09-06-2016 12:06:07', 'dd-mm-yyyy hh24:mi:ss'), 'LOCALHOST', 'LOCALHOST', null, '', '');

-- INSERCION unidad_organica
UPDATE MDI_UNIDAD_ORGANICA U SET U.NIVEL = 1, U.NOMBRE_NIVEL = (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'NIVEL_UNIDAD_ORGA' AND M.DESCRIPCION = 'EMPRESA') WHERE U.ID_UNIDAD_ORGANICA = (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1 AND U.COD_DEP_SIGA = '1' AND U.SIGLA = 'OSINERGMIN');

INSERT INTO MDI_UNIDAD_ORGANICA (ID_UNIDAD_ORGANICA, ID_UNIDAD_ORGANICA_SUPERIOR, SEDE, DESCRIPCION, DETALLE, COD_DEP_SIGA, ID_TIPO_UNIDAD_ORGANICA, SIGLA, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION, NIVEL, NOMBRE_NIVEL)
VALUES (MDI_UNIDAD_ORGANICA_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1 AND U.COD_DEP_SIGA = '1' AND U.SIGLA = 'OSINERGMIN'), 1, 'GSE', 'GERENCIA GSE', 'GSE', NULL, 'GSE', '1', 'USU1', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL, 2, (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'NIVEL_UNIDAD_ORGA' AND M.DESCRIPCION = 'GERENCIA'));

INSERT INTO MDI_UNIDAD_ORGANICA (ID_UNIDAD_ORGANICA, ID_UNIDAD_ORGANICA_SUPERIOR, SEDE, DESCRIPCION, DETALLE, COD_DEP_SIGA, ID_TIPO_UNIDAD_ORGANICA, SIGLA, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION, NIVEL, NOMBRE_NIVEL)
VALUES (MDI_UNIDAD_ORGANICA_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.COD_DEP_SIGA = 'GSE' AND U.SIGLA = 'GSE' AND U.NIVEL IS NOT NULL), 1, 'DSHL', 'DIVISION DE HIDRO LIQUIDOS', 'DSHL', NULL, 'DSHL', '1', 'USU1', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL, 3, (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'NIVEL_UNIDAD_ORGA' AND M.DESCRIPCION = 'DIVISION'));

INSERT INTO MDI_UNIDAD_ORGANICA (ID_UNIDAD_ORGANICA, ID_UNIDAD_ORGANICA_SUPERIOR, SEDE, DESCRIPCION, DETALLE, COD_DEP_SIGA, ID_TIPO_UNIDAD_ORGANICA, SIGLA, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION, NIVEL, NOMBRE_NIVEL)
VALUES (MDI_UNIDAD_ORGANICA_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1 AND U.COD_DEP_SIGA = 'GSE' AND U.SIGLA = 'GSE'), 1, 'DSR', 'DSR', 'DSR', NULL, 'DSR', '1', 'USU1', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL, 3, (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'NIVEL_UNIDAD_ORGA' AND M.DESCRIPCION = 'DIVISION'));

INSERT INTO MDI_UNIDAD_ORGANICA (ID_UNIDAD_ORGANICA, ID_UNIDAD_ORGANICA_SUPERIOR, SEDE, DESCRIPCION, DETALLE, COD_DEP_SIGA, ID_TIPO_UNIDAD_ORGANICA, SIGLA, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION, NIVEL, NOMBRE_NIVEL)
VALUES (MDI_UNIDAD_ORGANICA_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.DESCRIPCION = 'DSHL' AND U.SIGLA = 'DSHL' AND U.NIVEL IS NOT NULL), 1, 'DO', 'DIVISION DE OERACIONES', 'DO', NULL, 'DO', '1', 'USU1', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL, 4, (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'NIVEL_UNIDAD_ORGA' AND M.DESCRIPCION = 'SUBDIVISION'));

INSERT INTO MDI_UNIDAD_ORGANICA (ID_UNIDAD_ORGANICA, ID_UNIDAD_ORGANICA_SUPERIOR, SEDE, DESCRIPCION, DETALLE, COD_DEP_SIGA, ID_TIPO_UNIDAD_ORGANICA, SIGLA, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION, NIVEL, NOMBRE_NIVEL)
VALUES (MDI_UNIDAD_ORGANICA_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.DESCRIPCION = 'DSR' AND U.SIGLA = 'DSR' AND U.NIVEL IS NOT NULL), 1, '--', '--', '--', NULL, '--', '1', 'USU1', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL, 4, (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'NIVEL_UNIDAD_ORGA' AND M.DESCRIPCION = 'SUBDIVISION'));

INSERT INTO MDI_UNIDAD_ORGANICA (ID_UNIDAD_ORGANICA, ID_UNIDAD_ORGANICA_SUPERIOR, SEDE, DESCRIPCION, DETALLE, COD_DEP_SIGA, ID_TIPO_UNIDAD_ORGANICA, SIGLA, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION, NIVEL, NOMBRE_NIVEL)
VALUES (MDI_UNIDAD_ORGANICA_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.DESCRIPCION = 'DO' AND U.SIGLA = 'DO' AND U.NIVEL IS NOT NULL), 1, 'UPPD', 'UNIDAD PPD', 'UPPD', NULL, 'UPPD', '1', 'USU1', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL, 5, (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'NIVEL_UNIDAD_ORGA' AND M.DESCRIPCION = 'UNIDAD'));

INSERT INTO MDI_UNIDAD_ORGANICA (ID_UNIDAD_ORGANICA, ID_UNIDAD_ORGANICA_SUPERIOR, SEDE, DESCRIPCION, DETALLE, COD_DEP_SIGA, ID_TIPO_UNIDAD_ORGANICA, SIGLA, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION, NIVEL, NOMBRE_NIVEL)
VALUES (MDI_UNIDAD_ORGANICA_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.DESCRIPCION = 'DO' AND U.SIGLA = 'DO' AND U.NIVEL IS NOT NULL), 1, 'UNP', 'UNP', 'UNP', NULL, 'UNP', '1', 'USU1', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL, 5, (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'NIVEL_UNIDAD_ORGA' AND M.DESCRIPCION = 'UNIDAD'));

INSERT INTO MDI_UNIDAD_ORGANICA (ID_UNIDAD_ORGANICA, ID_UNIDAD_ORGANICA_SUPERIOR, SEDE, DESCRIPCION, DETALLE, COD_DEP_SIGA, ID_TIPO_UNIDAD_ORGANICA, SIGLA, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION, NIVEL, NOMBRE_NIVEL)
VALUES (MDI_UNIDAD_ORGANICA_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.DESCRIPCION = '--' AND U.SIGLA = '--' AND U.NIVEL = 4 AND U.ID_UNIDAD_ORGANICA_SUPERIOR = (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.DESCRIPCION = 'DSR' AND U.SIGLA = 'DSR' AND U.NIVEL IS NOT NULL) AND U.NIVEL IS NOT NULL), 1, 'UNP', 'UNP', 'UNP', NULL, 'UNP', '1', 'USU1', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL, 5, (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'NIVEL_UNIDAD_ORGA' AND M.DESCRIPCION = 'UNIDAD'));

-- INSERCION conf_filtro_emp_sup
INSERT INTO PGH_CONF_FILTRO_EMP_SUP (ID_FILTRO_EMP_SUP, ID_UNIDAD_ORGANICA, ID_FILTRO, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION)
VALUES (PGH_CONF_FILTRO_EMP_SUP_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.DESCRIPCION = 'DSHL' AND U.SIGLA = 'DSHL' AND U.NIVEL IS NOT NULL), (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'FILTRO_EMP_SUP' AND M.DESCRIPCION = 'RUBRO'), '1', 'USU01', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL);

INSERT INTO PGH_CONF_FILTRO_EMP_SUP (ID_FILTRO_EMP_SUP, ID_UNIDAD_ORGANICA, ID_FILTRO, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION)
VALUES (PGH_CONF_FILTRO_EMP_SUP_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.DESCRIPCION = 'DSR' AND U.SIGLA = 'DSR' AND U.NIVEL IS NOT NULL), (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'FILTRO_EMP_SUP' AND M.DESCRIPCION = 'OBLIGACION TIPO'), '1', 'USU01', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL);

INSERT INTO PGH_CONF_FILTRO_EMP_SUP (ID_FILTRO_EMP_SUP, ID_UNIDAD_ORGANICA, ID_FILTRO, ESTADO, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_CREACION, TERMINAL_ACTUALIZACION, FECHA_CREACION, FECHA_ACTUALIZACION)
VALUES (PGH_CONF_FILTRO_EMP_SUP_SEQ.NEXTVAL, (SELECT U.ID_UNIDAD_ORGANICA FROM MDI_UNIDAD_ORGANICA U WHERE U.ESTADO = 1  AND U.DESCRIPCION = 'DSR' AND U.SIGLA = 'DSR' AND U.NIVEL IS NOT NULL), (SELECT M.ID_MAESTRO_COLUMNA FROM MDI_MAESTRO_COLUMNA M WHERE M.DOMINIO = 'FILTRO_EMP_SUP' AND M.DESCRIPCION = 'UBIGEO UNIDAD OPERATIVA'), '1', 'USU01', NULL, '1.1.1.1', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), NULL);

-- INSERCION tipo documento OFICIO segun SIGED Prod
INSERT INTO MDI_MAESTRO_COLUMNA (DESCRIPCION, CODIGO, ID_MAESTRO_COLUMNA, DOMINIO, FECHA_ACTUALIZACION, FECHA_CREACION, USUARIO_CREACION, USUARIO_ACTUALIZACION, TERMINAL_ACTUALIZACION, TERMINAL_CREACION, APLICACION, ESTADO)
VALUES ('OFICIO', '3', MDI_MAESTRO_COLUMNA_SEQ.NEXTVAL, 'TIPO_DOC_ADJUNTO', NULL, TO_DATE(SYSDATE,'DD/MM/YYYY'), 'USER01', NULL, NULL, '1.1.1.1', 'INPS', '1');
