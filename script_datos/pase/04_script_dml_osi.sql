------------------------------------------------------------------------------------------
-- INSERCION EL VALOR EN LA TABLA PGH_VALOR_PARAMETRO, PARAMETRO DINAMICO -- TIPO PERSONA
------------------------------------------------------------------------------------------
INSERT INTO nps_integrado.pgh_valor_parametro(
            id_valor_parametro,
            id_parametro_dinamico,
            valor,
            descripcion,
            comentario,
            valor_defecto,
            estado,
            usuario_creacion,
            fecha_creacion,
            terminal_creacion,
            usuario_actualizacion,
            fecha_actualizacion,
            terminal_actualizacion
           )
    VALUES(
           nps_integrado.pgh_valor_parametro_seq.nextval,
           3,
           '--SELECCIONE--',
           '--Seleccione--',
           NULL,
           1,
           1,
           USER,
           SYSDATE,
           SYS_CONTEXT('USERENV', 'IP_ADDRESS'),
           NULL,
           NULL,
           NULL
           );
--------------------------------------------------------------------------------------
-- INSERCION DE VALOR EN LA TABLA PGH_VALOR_PARAMETRO, DEL PARAMETRO DINAMICO -- ETAPA
--------------------------------------------------------------------------------------
INSERT INTO nps_integrado.pgh_valor_parametro(
            id_valor_parametro,
            id_parametro_dinamico,
            valor,
            descripcion,
            comentario,
            valor_defecto,
            estado,
            usuario_creacion,
            fecha_creacion,
            terminal_creacion,
            usuario_actualizacion,
            fecha_actualizacion,
            terminal_actualizacion
           )
    VALUES(
           nps_integrado.pgh_valor_parametro_seq.nextval,
           2,
           '--SELECCIONE--',
           '--Seleccione--',
           NULL,
           1,
           1,
           USER,
           SYSDATE,
           SYS_CONTEXT('USERENV', 'IP_ADDRESS'),
           NULL,
           NULL,
           NULL
           );
-------------------------------------------------------------------------------------
-- ACTUALIZACION EN LA TABLA PGH_VALOR_PARAMETRO, VALOR DEL PARAMETRO DINAMICO ETAPA
-------------------------------------------------------------------------------------
UPDATE nps_integrado.pgh_valor_parametro pvp
   SET pvp.valor_defecto = '0',
       pvp.usuario_actualizacion = USER,
       pvp.fecha_actualizacion = SYSDATE,
       pvp.terminal_actualizacion = SYS_CONTEXT('USERENV','IP_ADDRESS')
 WHERE pvp.id_valor_parametro = '24'
   AND pvp.id_parametro_dinamico = '2';
