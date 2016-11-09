-- INSERT MDI MAESTRO TABLA                       
insert into mdi_maestro_tabla ( descripcion, dominio,usuario_actualizacion, usuario_creacion,  fecha_creacion,  fecha_actualizacion, terminal_actualizacion,terminal_creacion,es_editable, aplicacion )
values ('RESPONSABLE TRAMITE','NPS_RESPONSABLE',null, USER,SYSDATE, null,null,SYS_CONTEXT('USERENV','IP_ADDRESS'),'SI','MYC');

insert into mdi_maestro_tabla ( descripcion, dominio,usuario_actualizacion, usuario_creacion,  fecha_creacion,  fecha_actualizacion, terminal_actualizacion,terminal_creacion,es_editable, aplicacion )
values ('SECTORES','NPS_SECTOR',null, USER,SYSDATE, null,null,SYS_CONTEXT('USERENV','IP_ADDRESS'),'SI','MYC');

-- Combo SECTOR
insert into mdi_maestro_columna (descripcion, codigo, id_maestro_columna,dominio,fecha_actualizacion, fecha_creacion, usuario_creacion,usuario_actualizacion,terminal_actualizacion,terminal_creacion,aplicacion,estado )
values ('DIVISION HIDROCARBUROS LÍQUIDOS','DSHL', mdi_maestro_columna_seq.nextval, 'NPS_SECTOR',null, SYSDATE, USER , NULL,SYS_CONTEXT('USERENV','IP_ADDRESS'),SYS_CONTEXT('USERENV','IP_ADDRESS'),'MYC' ,'1' );

insert into mdi_maestro_columna (descripcion, codigo, id_maestro_columna,dominio,fecha_actualizacion, fecha_creacion, usuario_creacion,usuario_actualizacion,terminal_actualizacion,terminal_creacion,aplicacion,estado )
values ('DIVISION SUPERVISION REGIONAL','DSR', mdi_maestro_columna_seq.nextval, 'NPS_SECTOR',null, SYSDATE, USER , NULL,SYS_CONTEXT('USERENV','IP_ADDRESS'),SYS_CONTEXT('USERENV','IP_ADDRESS'),'MYC' ,'1' );



-- Combo RESPONSABLE
insert into mdi_maestro_columna (descripcion, codigo, id_maestro_columna,dominio,fecha_actualizacion, fecha_creacion, usuario_creacion,usuario_actualizacion,terminal_actualizacion,terminal_creacion,aplicacion,estado )
values ('LOCALES DE VENTA','LV', mdi_maestro_columna_seq.nextval, 'NPS_RESPONSABLE',null, SYSDATE, USER , NULL,SYS_CONTEXT('USERENV','IP_ADDRESS'),SYS_CONTEXT('USERENV','IP_ADDRESS'),'MYC' ,'1' );

insert into mdi_maestro_columna (descripcion, codigo, id_maestro_columna,dominio,fecha_actualizacion, fecha_creacion, usuario_creacion,usuario_actualizacion,terminal_actualizacion,terminal_creacion,aplicacion,estado )
values ('PLANTA ENVASADORA','PE', mdi_maestro_columna_seq.nextval, 'NPS_RESPONSABLE',null, SYSDATE, USER , NULL,SYS_CONTEXT('USERENV','IP_ADDRESS'),SYS_CONTEXT('USERENV','IP_ADDRESS'),'MYC' ,'1' );

insert into mdi_maestro_columna (descripcion, codigo, id_maestro_columna,dominio,fecha_actualizacion, fecha_creacion, usuario_creacion,usuario_actualizacion,terminal_actualizacion,terminal_creacion,aplicacion,estado )
values ('OSINERGMIN','OS', mdi_maestro_columna_seq.nextval, 'NPS_RESPONSABLE',null, SYSDATE, USER , NULL,SYS_CONTEXT('USERENV','IP_ADDRESS'),SYS_CONTEXT('USERENV','IP_ADDRESS'),'MYC' ,'1' );

-- INSERT NPS_TRAMITE 
insert into nps_tramite(id_tramite, descripcion, estado, usuario_creacion,fecha_creacion,terminal_creacion,usuario_actualizacion,fecha_actualizacion,terminal_actualizacion)
values (nps_tramite_seq.nextval,'Incripción del registro de hidrocarburos del local de venta de GLP','1', USER, SYSDATE,SYS_CONTEXT('USERENV','IP_ADDRESS'),USER, SYSDATE,SYS_CONTEXT('USERENV','IP_ADDRESS'));




