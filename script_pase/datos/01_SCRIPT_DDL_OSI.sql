CREATE OR REPLACE Function nps_es_numero_fun
   ( value_in IN varchar2 )
   RETURN number
IS
   cnumber number;
BEGIN
   cnumber := TO_NUMBER(value_in);
RETURN 1;

EXCEPTION
WHEN OTHERS THEN
 RETURN 0;
END;

CREATE OR REPLACE FUNCTION nps_ordenar_numeral_fun (valor  IN VARCHAR)
  RETURN VARCHAR
 IS
  devolver VARCHAR2(10);
 BEGIN
  IF nps_es_numero_fun(valor)= 1 THEN
    devolver :=(lpad(trim(valor), 9, '0'));
  ELSE
    devolver:= valor;
  END IF ;

   RETURN devolver ;
END ;

-- Create table
create table PGH_NORMA_AGENTE_PRIORIDAD
(
  ID_NORMA_AGENTE_PRIORIDAD NUMBER not null,
  ID_AGENTE                 NUMBER not null,
  ID_BASE_LEGAL             NUMBER not null,
  ESTADO                    CHAR(1) not null,
  USUARIO_CREACION          VARCHAR2(38) not null,
  TERMINAL_CREACION         VARCHAR2(38) not null,
  FECHA_CREACION            DATE not null,
  USUARIO_ACTUALIZACION     VARCHAR2(38),
  TERMINAL_ACTUALIZACION    VARCHAR2(38),
  FECHA_ACTUALIZACION       DATE,
  ORDEN                     NUMBER
);
-- Add comments to the table 
comment on table PGH_NORMA_AGENTE_PRIORIDAD
  is 'Tabla que almacena el orden de normas y agentes para módulo consultas';
-- Add comments to the columns 
comment on column PGH_NORMA_AGENTE_PRIORIDAD.ID_NORMA_AGENTE_PRIORIDAD
  is 'Id del orden norma prioridad secuencia: NORM_AGENTE_PRIORIDAD_SEQ';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.ID_AGENTE
  is 'Id del agente';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.ID_BASE_LEGAL
  is 'Id de la base legal';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.ESTADO
  is 'Indica si el registro está vigente.
0: El registro ya no se encuentra vigente.
1: El registro está vigente.';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.USUARIO_CREACION
  is 'Usuario creador del registro.';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.TERMINAL_CREACION
  is 'Terminal de creación';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.FECHA_CREACION
  is 'Fecha de creación del registro.';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.USUARIO_ACTUALIZACION
  is 'Usuario que modificó el registro por última vez.';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.TERMINAL_ACTUALIZACION
  is 'Terminal de modificación';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.FECHA_ACTUALIZACION
  is 'Fecha en la que se modificó el registro por última vez.';
comment on column PGH_NORMA_AGENTE_PRIORIDAD.ORDEN
  is 'Orden de norma legal en la actividad para NPS';
-- Create/Recreate primary, unique and foreign key constraints 
alter table PGH_NORMA_AGENTE_PRIORIDAD
  add constraint PGH_NORMA_AGENTE_PRIORIDAD_PK primary key (ID_NORMA_AGENTE_PRIORIDAD);
alter table PGH_NORMA_AGENTE_PRIORIDAD
  add constraint PGH_NORMAGENTPRIO__AGEN_FK foreign key (ID_AGENTE)
  references MDI_ACTIVIDAD (ID_ACTIVIDAD);
alter table PGH_NORMA_AGENTE_PRIORIDAD
  add constraint PGH_NORMAGENTPRIO__BASE_FK foreign key (ID_BASE_LEGAL)
  references PGH_BASE_LEGAL (ID_BASE_LEGAL);
  
  
-- Add/modify columns 
alter table MDI_ACTIVIDAD add ORDEN_NPS number;
-- Add comments to the columns 
comment on column MDI_ACTIVIDAD.ORDEN_NPS
  is 'Número de orden del registro: Actividad y/o Agente/ Instalación para NPS';
  
  
-- Create sequence 
create sequence PGH_NORM_AGENTE_PRIORIDAD_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 241
increment by 1
cache 20;


-- Alter sequence 
alter sequence MDI_ACTIVIDAD_SEQ 
minvalue 201;

--cambio de paquete bd

CREATE OR REPLACE PACKAGE "PKG_CONSULTAS" is

  -- Author  : CFLORIAN
  -- Created : 14/01/2015 05:03:02 p.m.

  TYPE micursor IS REF CURSOR;

  procedure LISTAR_OBLIGACIONES(pRubro          IN NUMBER,
                                pObligacionTipo IN NUMBER,
                                pClasificacion  IN NUMBER,
                                pCriticidad     IN NUMBER,
                                cursorOut       OUT micursor);

  FUNCTION FUN_OBTIENE_BASE_LEGAL(pObligacion NUMBER) return varchar2;

  FUNCTION FUN_OBTIENE_TIPIFICACION(pObligacion NUMBER) return varchar2;

  procedure CONSULTAS_OBLIGACIONES_WEB_PRC(pRubro          IN NUMBER,
                                 pObligacionTipo IN NUMBER,
                                 pClasificacion  IN NUMBER,
                                 pCriticidad     IN NUMBER,
                                 cursorOut       OUT micursor);

  FUNCTION FUN_DESC_BASE_LEGAL_CONC_PRC(p_id_obligacion NUMBER, p_id_agente NUMBER) return varchar2;
  FUNCTION FUN_DESC_TIPI_CONC_PRC(p_id_tipificacion NUMBER) return varchar2;
  FUNCTION FUN_DESC_TIPI_CRI_CONC_PRC(p_id_tipificacion NUMBER,
                                  p_id_criterio     NUMBER) return varchar2;
end PKG_CONSULTAS;
/
CREATE OR REPLACE PACKAGE BODY "PKG_CONSULTAS" is

  /*********************************************************************/
  PROCEDURE LISTAR_OBLIGACIONES(pRubro          IN NUMBER,
                                pObligacionTipo IN NUMBER,
                                pClasificacion  IN NUMBER,
                                pCriticidad     IN NUMBER,
                                cursorOut       OUT micursor)
  
   IS
  BEGIN
  
    IF (pClasificacion = 0) THEN
      OPEN cursorOut FOR
        SELECT (select PGD.DESCRIPCION
                  from PGH_DETALLE_OBLIGACION PGD
                 WHERE 1 = 1
                   AND PGD.ID_OBLIGACION(+) = OBL.ID_OBLIGACION
                   AND PGD.ESTADO = '1'
                   AND ROWNUM < 2) DESOBLIGA,
               FUN_OBTIENE_BASE_LEGAL(OBL.ID_OBLIGACION) AS DESBASELEGAL,
               FUN_OBTIENE_TIPIFICACION(OBL.ID_OBLIGACION) AS DESTIPIFICACION_UIT,
               CONF.NOMBRE AS DESOBLIGTIPO,
               CONF.ID_ACTIVIDAD,
               CONF.ID_OBLIGACION,
               CONF.ID_OBLIGACION_TIPO,
               MDA.ID_DOCUMENTO_ADJUNTO
          FROM pgh_obligacion OBL,
               (select OT.NOMBRE,
                       CO.ID_ACTIVIDAD,
                       CO.ID_OBLIGACION,
                       CO.ID_OBLIGACION_TIPO
                  from PGH_CONF_OBLIGACION         CO,
                       PGH_PROCESO_OBLIGACION_TIPO POT,
                       PGH_OBLIGACION_TIPO         OT
                 where 1 = 1
                   AND CO.ID_PRO_OBL_TIP = POT.ID_PRO_OBL_TIP
                   AND OT.ID_OBLIGACION_TIPO = POT.ID_OBLIGACION_TIPO
                   AND CO.ID_ACTIVIDAD = pRubro
                   AND NVL2(DECODE(pObligacionTipo, 0, null, pObligacionTipo),
                            CO.ID_OBLIGACION_TIPO,
                            1) =
                       NVL(DECODE(pObligacionTipo, 0, null, pObligacionTipo),
                           1)
                   AND CO.ESTADO = '1') CONF,
               MDI_DOCUMENTO_ADJUNTO MDA
         where 1 = 1
           and obl.id_obligacion = conf.id_obligacion
           and mda.id_documento_adjunto(+) = obl.id_documento_adjunto
           and obl.estado = 1
           AND NVL2(DECODE(pCriticidad, 0, null, pCriticidad),
                    OBL.ID_CRITICIDAD,
                    1) = NVL(DECODE(pCriticidad, 0, null, pCriticidad), 1)
           AND NOT EXISTS
         (SELECT 1
                  FROM PGH_BASE_LEGAL SBL, PGH_OBLIGACION_BASE_LEGAL SOBL
                 WHERE SBL.ID_BASE_LEGAL = SOBL.Id_Base_Legal
                   AND SOBL.ID_OBLIGACION = OBL.ID_OBLIGACION
                   AND trunc(SBL.FECHA_ENTRADA_VIGENCIA) >= TRUNC(SYSDATE)
                   AND SBL.ESTADO = 1
                   AND SOBL.ESTADO = 1)
         ORDER BY OBL.ID_OBLIGACION ASC;
    ELSE
      OPEN cursorOut FOR
        SELECT (select PGD.DESCRIPCION
                  from PGH_DETALLE_OBLIGACION PGD
                 WHERE 1 = 1
                   AND PGD.ID_OBLIGACION(+) = OBL.ID_OBLIGACION
                   AND ROWNUM < 2) DESOBLIGA,
               FUN_OBTIENE_BASE_LEGAL(OBL.ID_OBLIGACION) AS DESBASELEGAL,
               FUN_OBTIENE_TIPIFICACION(OBL.ID_OBLIGACION) AS DESTIPIFICACION_UIT,
               CONF.NOMBRE AS DESOBLIGTIPO,
               CONF.ID_ACTIVIDAD,
               CONF.ID_OBLIGACION,
               CONF.ID_OBLIGACION_TIPO,
               MDA.ID_DOCUMENTO_ADJUNTO,
               TOM.ID_TEMA_OBLIGACION
          FROM pgh_obligacion OBL,
               (select OT.NOMBRE,
                       CO.ID_ACTIVIDAD,
                       CO.ID_OBLIGACION,
                       CO.ID_OBLIGACION_TIPO
                  from PGH_CONF_OBLIGACION         CO,
                       PGH_PROCESO_OBLIGACION_TIPO POT,
                       PGH_OBLIGACION_TIPO         OT
                 where 1 = 1
                   AND CO.ID_PRO_OBL_TIP = POT.ID_PRO_OBL_TIP
                   AND OT.ID_OBLIGACION_TIPO = POT.ID_OBLIGACION_TIPO
                   AND CO.ID_ACTIVIDAD = pRubro
                   AND NVL2(DECODE(pObligacionTipo, 0, null, pObligacionTipo),
                            CO.ID_OBLIGACION_TIPO,
                            1) =
                       NVL(DECODE(pObligacionTipo, 0, null, pObligacionTipo),
                           1)
                   AND CO.ESTADO = '1') CONF,
               MDI_DOCUMENTO_ADJUNTO MDA,
               PGH_TEMA_OBLIGACION_MAESTRO TOM,
               MDI_MAESTRO_COLUMNA MC
         where 1 = 1
           and obl.id_obligacion = conf.id_obligacion
           and mda.id_documento_adjunto(+) = obl.id_documento_adjunto
           AND OBL.ID_OBLIGACION = TOM.ID_OBLIGACION
           AND TOM.ID_TEMA_OBLIGACION = MC.ID_MAESTRO_COLUMNA
           and obl.estado = 1
           and tom.estado = 1
           AND TOM.ID_TEMA_OBLIGACION = pClasificacion
           AND NVL2(DECODE(pCriticidad, 0, null, pCriticidad),
                    OBL.ID_CRITICIDAD,
                    1) = NVL(DECODE(pCriticidad, 0, null, pCriticidad), 1)
           AND NOT EXISTS
         (SELECT 1
                  FROM PGH_BASE_LEGAL SBL, PGH_OBLIGACION_BASE_LEGAL SOBL
                 WHERE SBL.ID_BASE_LEGAL = SOBL.Id_Base_Legal
                   AND SOBL.ID_OBLIGACION = OBL.ID_OBLIGACION
                   AND trunc(SBL.FECHA_ENTRADA_VIGENCIA) >= TRUNC(SYSDATE)
                   AND SBL.ESTADO = 1
                   AND SOBL.ESTADO = 1)
         ORDER BY OBL.ID_OBLIGACION ASC;
    END IF;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.put_line(SQLERRM);
    
  END LISTAR_OBLIGACIONES;

  /*********************************************************************/
  FUNCTION FUN_OBTIENE_BASE_LEGAL(pObligacion NUMBER) return varchar2 IS
    baseLegal varchar2(5000) := '';
    CURSOR cursor_baseLegal is
      SELECT BL.DESCRIPCION
        from PGH_BASE_LEGAL BL, PGH_OBLIGACION_BASE_LEGAL DOBL
       WHERE BL.ID_BASE_LEGAL = DOBL.ID_BASE_LEGAL
         AND DOBL.ID_OBLIGACION = pObligacion
         AND DOBL.ESTADO = 1
         AND BL.ESTADO = 1;
  
    row_baseLegal cursor_baseLegal%ROWTYPE;
  
  BEGIN
    /*
    select CADENA into baseLegal from
      (WITH t AS (SELECT BL.DESCRIPCION col
                from PGH_BASE_LEGAL BL, PGH_OBLIGACION_BASE_LEGAL DOBL
               WHERE BL.ID_BASE_LEGAL = DOBL.ID_BASE_LEGAL
                 AND DOBL.ID_OBLIGACION = pObligacion
                 AND DOBL.ESTADO = 1)
      SELECT SUBSTR(MAX(col), 6) CADENA
      FROM (SELECT SYS_CONNECT_BY_PATH(col, '<br/>') col
              FROM (SELECT col, ROW_NUMBER() OVER(ORDER BY col) FILA FROM t)
             START WITH FILA = 1
            CONNECT BY PRIOR FILA = FILA - 1));
    
      return baseLegal;  
      */
  
    FOR row_baseLegal IN cursor_baseLegal LOOP
      baseLegal := baseLegal || row_baseLegal.Descripcion || '<br/>';
      EXIT WHEN cursor_baseLegal%NOTFOUND;
    END LOOP;
  
    baseLegal := SUBSTR(baseLegal, 1, LENGTH(baseLegal) - 5);
  
    return baseLegal;
  
  END;

  /*********************************************************************/
  FUNCTION FUN_OBTIENE_TIPIFICACION(pObligacion NUMBER) return varchar2 IS
    tipificacion varchar2(5000) := '';
    CURSOR cursor_tipificacion is
      SELECT TI.COD_TIPIFICACION || '/' || TI.SANCION_MONETARIA || '/' ||
             TI.BASES_LEGALES col
        from PGH_OBLIGACION_TIPIFICACION OT, PGH_TIPIFICACION TI
       WHERE OT.ID_TIPIFICACION = TI.ID_TIPIFICACION
         AND OT.ID_OBLIGACION = pObligacion
         AND OT.ESTADO = 1
         AND TI.ESTADO = 1;
  
    row_tipificacion cursor_tipificacion%ROWTYPE;
  
  BEGIN
    /*
    select CADENA into tipificacion from
      (WITH t AS (SELECT TI.COD_TIPIFICACION || '/' || TI.SANCION_MONETARIA || '/' || TI.BASES_LEGALES col
                from PGH_OBLIGACION_TIPIFICACION OT, PGH_TIPIFICACION TI
               WHERE OT.ID_TIPIFICACION = TI.ID_TIPIFICACION
                 AND OT.ID_OBLIGACION = pObligacion
                 AND OT.ESTADO = 1)
    SELECT SUBSTR(MAX(col), 4) CADENA
      FROM (SELECT SYS_CONNECT_BY_PATH(col, '-@-') col
              FROM (SELECT col, ROW_NUMBER() OVER(ORDER BY col) FILA FROM t)
             START WITH FILA = 1
            CONNECT BY PRIOR FILA = FILA - 1));
    
      return tipificacion;     
    */
  
    FOR row_tipificacion IN cursor_tipificacion LOOP
      tipificacion := tipificacion || row_tipificacion.col || '-@-';
    
      EXIT WHEN cursor_tipificacion%NOTFOUND;
    END LOOP;
  
    tipificacion := SUBSTR(tipificacion, 1, LENGTH(tipificacion) - 3);
    return tipificacion;
  
  END;
  PROCEDURE CONSULTAS_OBLIGACIONES_WEB_PRC (pRubro          IN NUMBER,
                                 pObligacionTipo IN NUMBER,
                                 pClasificacion  IN NUMBER,
                                 pCriticidad     IN NUMBER,
                                 cursorOut       OUT micursor)
  
   IS
  BEGIN
    IF (pClasificacion = 0) THEN
      open cursorOut for
        select (count(resultado.id_obligacion)
                over(partition by resultado.id_obligacion)) cnt_obligacion,
               resultado.id_obligacion,
               resultado.desc_obligacion,
               desc_base_legal,
               (count(resultado.id_tipificacion)
                over(partition by resultado.id_obligacion,
                     resultado.id_tipificacion)) cnt_tipificacion,
               resultado.id_tipificacion,
               nvl(resultado.desc_tipificacion, ' - ') desc_tipificacion,
               resultado.desc_tipi_legal,
               nvl(resultado.sancion, ' - ') sancion,
               (count(resultado.id_criterio)
                over(partition by resultado.id_obligacion,
                     resultado.id_tipificacion,
                     resultado.id_criterio /*,
                                                                                    resultado.id_obligacion_tipo)*/)) cnt_criterio,
               resultado.id_criterio,
               nvl(resultado.desc_criterio, ' - ') desc_criterio,
               nvl(resultado.sanc_criterio, ' - ') sanc_criterio,
               nvl(resultado.desc_criterio_legal, ' - ') desc_criterio_legal,
               resultado.id_criticidad,
               resultado.desc_criticidad,
               resultado.documento_adjunto id_documento_adjunto
        /*,
        resultado.id_obligacion_tipo,
        resultado.nombre
        */
          from (select distinct ob.id_obligacion,
                                nvl(dob.id_documento_adjunto,0) documento_adjunto, 
                                ob.descripcion desc_obligacion,
                                (pkg_consultas.fun_desc_base_legal_conc_prc(ob.id_obligacion, pRubro)) desc_base_legal,
                                pgti.id_tipificacion,
                                (select dpt.cod_tipificacion
                                   from pgh_tipificacion dpt
                                  where 1 = 1
                                    and dpt.estado = '1'
                                    and dpt.id_tipificacion =
                                        pgti.id_tipificacion
                                    and rownum < 2) desc_tipificacion,
                                pkg_consultas.fun_desc_tipi_conc_prc(pgti.id_tipificacion) sancion,
                                (select ptf.bases_legales
                                   from pgh_tipificacion ptf
                                  where ptf.estado = '1'
                                    and ptf.id_tipificacion =
                                        pgti.id_tipificacion
                                    and rownum < 2) desc_tipi_legal,
                                (select potcc.id_criterio
                                   from PGH_OBLI_TIPI_CRITERIO potcc
                                  where potcc.estado = '1'
                                    and potcc.id_criterio = otc.id_criterio
                                    and potcc.id_tipificacion =
                                        pgti.id_tipificacion
                                    and potcc.id_obligacion =
                                        otc.id_obligacion
                                    and rownum < 2) id_criterio,
                                (select pcri.descripcion
                                   from pgh_criterio pcri
                                  where 1 = 1
                                    and pcri.estado = '1'
                                    and pcri.id_criterio =
                                        (select potcc.id_criterio
                                           from PGH_OBLI_TIPI_CRITERIO potcc
                                          where potcc.estado = '1'
                                            and potcc.id_criterio =
                                                otc.id_criterio
                                            and potcc.id_tipificacion =
                                                pgti.id_tipificacion
                                            and potcc.id_obligacion =
                                                otc.id_obligacion
                                            and rownum < 2)
                                    and rownum < 2) desc_criterio,
                                pkg_consultas.fun_desc_tipi_cri_conc_prc(pgti.id_tipificacion,
                                                                     otc.id_criterio) sanc_criterio,
                                (select pcri.bases_legales
                                   from pgh_criterio pcri
                                  where 1 = 1
                                    and pcri.estado = '1'
                                    and pcri.id_criterio =
                                        (select potcc.id_criterio
                                           from PGH_OBLI_TIPI_CRITERIO potcc
                                          where potcc.estado = '1'
                                            and potcc.id_criterio =
                                                otc.id_criterio
                                            and potcc.id_tipificacion =
                                                pgti.id_tipificacion
                                            and potcc.id_obligacion =
                                                otc.id_obligacion
                                            and rownum < 2)
                                    and rownum < 2) desc_criterio_legal,
                                ob.id_criticidad,
                                (select trim(mmc.descripcion) criticidad
                                   from mdi_maestro_tabla   mmt,
                                        mdi_maestro_columna mmc
                                  where 1 = 1
                                    and mmt.dominio = mmc.dominio
                                    and mmt.aplicacion = mmc.aplicacion
                                    and mmc.estado = '1'
                                    and mmt.dominio = 'PGH_OBLIG_CRITIC'
                                    and mmc.id_maestro_columna =
                                        ob.id_criticidad
                                    and rownum < 2) desc_criticidad
                /* ,
                pco.id_obligacion_tipo,
                poti.nombre*/
                  from pgh_obligacion ob,
                       pgh_detalle_obligacion dob,
                       (select dpco.*
                          from PGH_CONF_OBLIGACION dpco
                         where dpco.estado = '1'
                           and dpco.id_padre is null) pco,
                       (select dpoti.*
                          from PGH_OBLIGACION_TIPO dpoti
                         where dpoti.estado = '1') poti,
                       (select dpgti.*
                          from pgh_obligacion_tipificacion dpgti
                         where dpgti.estado = '1') pgti,
                       (select dotc.*
                          from PGH_OBLI_TIPI_CRITERIO dotc
                         where dotc.estado = '1') otc
                 where 1 = 1
                   and ob.estado = '1'                   
                   and ob.id_padre is null
                   and ob.id_obligacion = dob.id_obligacion
                   and dob.estado = '1'
                   and pco.id_obligacion = ob.id_obligacion
                   and pco.id_obligacion_tipo = poti.id_obligacion_tipo
                   and otc.id_obligacion(+) = ob.id_obligacion
                   and pgti.id_obligacion(+) = ob.id_obligacion
                   and pco.id_actividad = pRubro
                   and (pObligacionTipo = 0 or
                       (pObligacionTipo <> 0 and
                       pco.id_obligacion_tipo = pObligacionTipo))
                   and (pCriticidad = 0 or
                       (pCriticidad <> 0 and ob.id_criticidad = pCriticidad))
                   and EXISTS
                 (SELECT 1
                          FROM PGH_BASE_LEGAL            SBL,
                               PGH_OBLIGACION_BASE_LEGAL SOBL
                         WHERE SBL.ID_BASE_LEGAL = SOBL.Id_Base_Legal
                           AND sbl.id_base_legal_padre is not null
                           AND SOBL.ID_OBLIGACION = ob.ID_OBLIGACION
                           AND trunc(nvl(nvl((select PBLS.fecha_entrada_vigencia
                                               FROM PGH_BASE_LEGAL PBLS
                                              where PBLS.id_base_legal =
                                                    SBL.ID_BASE_LEGAL_PADRE
                                                and rownum < 2),
                                             SBL.FECHA_ENTRADA_VIGENCIA),
                                         sysdate)) <= TRUNC(SYSDATE)
                           AND SBL.ESTADO = 1
                           AND SOBL.ESTADO = 1)
                 order by ob.id_obligacion, pgti.id_tipificacion) resultado
         order by resultado.id_obligacion,
                  resultado.id_tipificacion,
                  resultado.id_criterio;
    
    else
      open cursorOut for
        select (count(resultado.id_obligacion)
                over(partition by resultado.id_obligacion)) cnt_obligacion,
               resultado.id_obligacion,
               resultado.desc_obligacion,
               desc_base_legal,
               (count(resultado.id_tipificacion)
                over(partition by resultado.id_obligacion,
                     resultado.id_tipificacion)) cnt_tipificacion,
               resultado.id_tipificacion,
               nvl(resultado.desc_tipificacion, ' - ') desc_tipificacion,
               resultado.desc_tipi_legal,
               nvl(resultado.sancion, ' - ') sancion,
               (count(resultado.id_criterio)
                over(partition by resultado.id_obligacion,
                     resultado.id_tipificacion,
                     resultado.id_criterio /*,
                                                                                    resultado.id_obligacion_tipo)*/)) cnt_criterio,
               resultado.id_criterio,
               nvl(resultado.desc_criterio, ' - ') desc_criterio,
               nvl(resultado.sanc_criterio, ' - ') sanc_criterio,
               nvl(resultado.desc_criterio_legal, ' - ') desc_criterio_legal,
               resultado.id_criticidad,
               resultado.desc_criticidad,
               resultado.documento_adjunto id_documento_adjunto
        /*,
        resultado.id_obligacion_tipo,
        resultado.nombre*/
          from (select distinct ob.id_obligacion,
                                nvl(dob.id_documento_adjunto,0) documento_adjunto,
                                ob.descripcion desc_obligacion,
                                (pkg_consultas.fun_desc_base_legal_conc_prc(ob.id_obligacion, pRubro)) desc_base_legal,
                                pgti.id_tipificacion,
                                (select dpt.cod_tipificacion
                                   from pgh_tipificacion dpt
                                  where 1 = 1
                                    and dpt.estado = '1'
                                    and dpt.id_tipificacion =
                                        pgti.id_tipificacion
                                    and rownum < 2) desc_tipificacion,
                                pkg_consultas.fun_desc_tipi_conc_prc(pgti.id_tipificacion) sancion,
                                (select ptf.bases_legales
                                   from pgh_tipificacion ptf
                                  where ptf.estado = '1'
                                    and ptf.id_tipificacion =
                                        pgti.id_tipificacion
                                    and rownum < 2) desc_tipi_legal,
                                (select potcc.id_criterio
                                   from PGH_OBLI_TIPI_CRITERIO potcc
                                  where potcc.estado = '1'
                                    and potcc.id_criterio = otc.id_criterio
                                    and potcc.id_tipificacion =
                                        pgti.id_tipificacion
                                    and potcc.id_obligacion =
                                        otc.id_obligacion
                                    and rownum < 2) id_criterio,
                                (select pcri.descripcion
                                   from pgh_criterio pcri
                                  where 1 = 1
                                    and pcri.estado = '1'
                                    and pcri.id_criterio =
                                        (select potcc.id_criterio
                                           from PGH_OBLI_TIPI_CRITERIO potcc
                                          where potcc.estado = '1'
                                            and potcc.id_criterio =
                                                otc.id_criterio
                                            and potcc.id_tipificacion =
                                                pgti.id_tipificacion
                                            and potcc.id_obligacion =
                                                otc.id_obligacion
                                            and rownum < 2)
                                    and rownum < 2) desc_criterio,
                                pkg_consultas.fun_desc_tipi_cri_conc_prc(pgti.id_tipificacion,
                                                                     otc.id_criterio) sanc_criterio,
                                (select pcri.bases_legales
                                   from pgh_criterio pcri
                                  where 1 = 1
                                    and pcri.estado = '1'
                                    and pcri.id_criterio =
                                        (select potcc.id_criterio
                                           from PGH_OBLI_TIPI_CRITERIO potcc
                                          where potcc.estado = '1'
                                            and potcc.id_criterio =
                                                otc.id_criterio
                                            and potcc.id_tipificacion =
                                                pgti.id_tipificacion
                                            and potcc.id_obligacion =
                                                otc.id_obligacion
                                            and rownum < 2)
                                    and rownum < 2) desc_criterio_legal,
                                ob.id_criticidad,
                                (select trim(mmc.descripcion) criticidad
                                   from mdi_maestro_tabla   mmt,
                                        mdi_maestro_columna mmc
                                  where 1 = 1
                                    and mmt.dominio = mmc.dominio
                                    and mmt.aplicacion = mmc.aplicacion
                                    and mmc.estado = '1'
                                    and mmt.dominio = 'PGH_OBLIG_CRITIC'
                                    and mmc.id_maestro_columna =
                                        ob.id_criticidad
                                    and rownum < 2) desc_criticidad
                /*,
                pco.id_obligacion_tipo,
                poti.nombre*/
                  from pgh_obligacion ob,
                       pgh_detalle_obligacion dob,
                       (select dpco.*
                          from PGH_CONF_OBLIGACION dpco
                         where dpco.estado = '1'
                           and dpco.id_padre is null) pco,
                       (select dpoti.*
                          from PGH_OBLIGACION_TIPO dpoti
                         where dpoti.estado = '1') poti,
                       (select dpgti.*
                          from pgh_obligacion_tipificacion dpgti
                         where dpgti.estado = '1') pgti,
                       (select dotc.*
                          from PGH_OBLI_TIPI_CRITERIO dotc
                         where dotc.estado = '1') otc,
                       (select dptom.*
                          from pgh_tema_obligacion_maestro dptom
                         where dptom.estado = '1') ptom
                 where 1 = 1
                   and ob.estado = '1'
                   and ob.id_padre is null
                   and ob.id_obligacion = dob.id_obligacion
                   and dob.estado = '1'
                   and pco.id_obligacion = ob.id_obligacion
                   and pco.id_obligacion_tipo = poti.id_obligacion_tipo
                   and otc.id_obligacion(+) = ob.id_obligacion
                   and pgti.id_obligacion(+) = ob.id_obligacion
                   and pco.id_actividad = pRubro
                   and ptom.id_obligacion(+) = ob.id_obligacion
                   and (pClasificacion = 0 or
                       (pClasificacion <> 0 and
                       ptom.id_tema_obligacion = pClasificacion))
                   and (pObligacionTipo = 0 or
                       (pObligacionTipo <> 0 and
                       pco.id_obligacion_tipo = pObligacionTipo))
                   and (pCriticidad = 0 or
                       (pCriticidad <> 0 and ob.id_criticidad = pCriticidad))
                   and EXISTS
                 (SELECT 1
                          FROM PGH_BASE_LEGAL            SBL,
                               PGH_OBLIGACION_BASE_LEGAL SOBL
                         WHERE SBL.ID_BASE_LEGAL = SOBL.Id_Base_Legal
                           AND sbl.id_base_legal_padre is not null
                           AND SOBL.ID_OBLIGACION = ob.ID_OBLIGACION
                           AND trunc(nvl(nvl((select PBLS.fecha_entrada_vigencia
                                               FROM PGH_BASE_LEGAL PBLS
                                              where PBLS.id_base_legal =
                                                    SBL.ID_BASE_LEGAL_PADRE
                                                and rownum < 2),
                                             SBL.FECHA_ENTRADA_VIGENCIA),
                                         sysdate)) <= TRUNC(SYSDATE)
                           AND SBL.ESTADO = 1
                           AND SOBL.ESTADO = 1)
                 order by ob.id_obligacion, pgti.id_tipificacion) resultado
         order by resultado.id_obligacion,
                  resultado.id_tipificacion,
                  resultado.id_criterio;
    
    end if;
  End;

  FUNCTION FUN_DESC_BASE_LEGAL_CONC_PRC(p_id_obligacion NUMBER, p_id_agente NUMBER) return varchar2 IS
    desc_base_legal varchar2(5000) := '';
    CURSOR cursor_base_legal is
      /*select trim(bl.descripcion) descripcion
        from pgh_obligacion_base_legal obl, pgh_base_legal bl
       where 1 = 1
         and obl.id_obligacion = p_id_obligacion
         and obl.id_base_legal = bl.id_base_legal
         and obl.estado = '1'
         and obl.id_padre is null
         and bl.estado = '1'
         and bl.id_padre is null
         and bl.id_base_legal_padre is not null
         and (bl.flag_padre is null or bl.flag_padre <> 'P')
       order by obl.id_obl_base asc;*/
       /* OSINE_SFS-600 - REQF-0014 - Inicio */
       select t1.descripcion from
       (
         select 
           co.id_actividad id_actividad,
           normlgl.id_base_legal id_norma_legal,
           bl.id_base_legal id_base_legal,
           trim(bl.descripcion) descripcion,
           dbl.articulo articulo,
           nps_ordenar_numeral_fun(dbl.inciso_1) inciso_1,
           nps_ordenar_numeral_fun(dbl.inciso_2) inciso_2,
           dbl.id_tipo_anexo id_tipo_anexo,
           to_number(dbl.articulo_anexo) articulo_anexo,
           nps_ordenar_numeral_fun(dbl.inciso_1_anexo) inciso1_anexo,
           nps_ordenar_numeral_fun(dbl.inciso_2_anexo) inciso2_anexo,
           dbl.descripcion descripcion_bl
         from 
          pgh_base_legal normlgl,
          pgh_base_legal bl,
          pgh_obligacion_base_legal obl,         
          pgh_detalle_base_legal dbl,
          pgh_conf_obligacion co,
          mdi_actividad a
         where 1 = 1
           and normlgl.id_base_legal = bl.id_base_legal_padre
           and normlgl.estado = '1'
           and normlgl.flag_padre = 'P'
           and obl.id_obligacion = p_id_obligacion
           and obl.id_base_legal = bl.id_base_legal
           and obl.estado = '1'
           and obl.id_padre is null
           and bl.estado = '1'
           and bl.id_padre is null
           and bl.id_base_legal_padre is not null
           and (bl.flag_padre is null or bl.flag_padre <> 'P')
           and bl.id_base_legal = dbl.id_base_legal
           and dbl.estado = '1'
           and obl.id_obligacion = co.id_obligacion
           and co.estado = 1
           and co.id_actividad = a.id_actividad
           and a.estado = 1   
           and a.id_actividad = p_id_agente    
       ) t1,
       (select * from pgh_norma_agente_prioridad pri1
       where pri1.estado = '1'
       and pri1.id_agente = p_id_agente) pri
       where 1 = 1 
       and t1.id_actividad  = pri.id_agente (+)
       and t1.id_norma_legal  = pri.id_base_legal (+)
       order by 
       pri.orden nulls last,
       articulo,
       inciso_1 nulls first,
       inciso_2 nulls first,
       id_tipo_anexo,
       articulo_anexo,
       inciso1_anexo nulls first,
       inciso2_anexo nulls first,
       descripcion_bl;
        /* OSINE_SFS-600 - REQF-0014 - Fin */
    linea_base_legal cursor_base_legal%ROWTYPE;
  
  BEGIN
    FOR linea_base_legal IN cursor_base_legal LOOP
      desc_base_legal := desc_base_legal || linea_base_legal.descripcion ||
                         ' <br/>';
      EXIT WHEN cursor_base_legal%NOTFOUND;
    END LOOP;
    desc_base_legal := SUBSTR(desc_base_legal,
                              1,
                              LENGTH(desc_base_legal) - 5);
    return desc_base_legal;
  END;

  FUNCTION FUN_DESC_TIPI_CONC_PRC(p_id_tipificacion NUMBER) return varchar2 IS
    desc_sanc_tipi varchar2(5000) := '';
    CURSOR cursor_tipififacion is
      select TRIM(pt.sancion_monetaria) sancion_monetaria,
             TRIM(UPPER(ptsa.abreviatura)) abreviatura
        from pgh_tipificacion         pt,
             pgh_tipificacion_sancion pts,
             pgh_tipo_sancion         ptsa
       where 1 = 1
         and pt.id_tipificacion(+) = pts.id_tipificacion
         and pts.id_tipo_sancion = ptsa.id_tipo_sancion
         and ptsa.estado = '1'
         and pt.estado = '1'
         and pts.estado = '1'
         and pts.id_criterio is null
         and pts.id_detalle_criterio is null
         and pt.id_tipificacion = p_id_tipificacion;
    linea_tipififacion cursor_tipififacion%ROWTYPE;
  
  BEGIN
    FOR linea_tipififacion IN cursor_tipififacion LOOP
      if (cursor_tipififacion%rowcount = 1) then
        desc_sanc_tipi := 'HASTA ' || nvl(linea_tipififacion.sancion_monetaria,0) ||
                          ' UIT; ';
      end if;
      desc_sanc_tipi := desc_sanc_tipi || linea_tipififacion.abreviatura || ', ';
      EXIT WHEN cursor_tipififacion%NOTFOUND;
    END LOOP;
    desc_sanc_tipi := SUBSTR(desc_sanc_tipi, 1, LENGTH(desc_sanc_tipi) - 2);
    return desc_sanc_tipi;
  END;

  FUNCTION FUN_DESC_TIPI_CRI_CONC_PRC(p_id_tipificacion NUMBER,
                                  p_id_criterio     NUMBER) return varchar2 IS
    desc_sanc_crit varchar2(5000) := '';
    CURSOR cursor_tipi_criterio is
      select TRIM(pc.sancion_monetaria) sancion_monetaria,
             TRIM(UPPER(ptsa.abreviatura)) abreviatura
        from pgh_tipificacion         pt,
             pgh_tipificacion_sancion pts,
             pgh_tipo_sancion         ptsa,
             pgh_criterio             pc
       where 1 = 1
         and pt.id_tipificacion(+) = pts.id_tipificacion
         and pts.id_criterio(+) = pc.id_criterio
         and pts.id_tipo_sancion = ptsa.id_tipo_sancion
         and ptsa.estado = '1'
         and pt.estado = '1'
         and pts.estado = '1'
         and pts.id_criterio is not null
         and pc.id_criterio is not null
         and pt.id_tipificacion = p_id_tipificacion
         and pts.id_criterio = p_id_criterio;
    linea_tipi_criterio cursor_tipi_criterio%ROWTYPE;
  
  BEGIN
    FOR linea_tipi_criterio IN cursor_tipi_criterio LOOP
      if (cursor_tipi_criterio%rowcount = 1) then
        desc_sanc_crit := nvl(linea_tipi_criterio.sancion_monetaria,0) || ' UIT; ';
      end if;
      desc_sanc_crit := desc_sanc_crit || linea_tipi_criterio.abreviatura || ', ';
      EXIT WHEN cursor_tipi_criterio%NOTFOUND;
    END LOOP;
    desc_sanc_crit := SUBSTR(desc_sanc_crit, 1, LENGTH(desc_sanc_crit) - 2);
    return desc_sanc_crit;
  END;

end PKG_CONSULTAS;
/
