declare 
  c_norma_legal  varchar2(1000);
  n_len_norma  number;
  n_pos_caracter  number;
  c_sigla_desc  varchar2(1000);
  c_sigla_norma_legal  varchar2(1000);
  n_numero number;
  c_numero_validado varchar2(1000);
  n_anio number;
  c_anio_validado varchar2(1000);
  c_sigla varchar2(1000);
  c_sigla_validado varchar2(1000);
  c_articulo varchar2(1000);
  c_articulo_validado varchar2(1000);
  c_inciso1 varchar2(1000);
  c_letra1 varchar2(1000);
  c_inciso1_validado varchar2(1000);
  c_inciso2 varchar2(1000);
  c_letra2 varchar2(1000);
  c_inciso2_validado varchar2(1000);
  c_tipo_anexo varchar2(1000);
  c_tipo_anexo_validado varchar2(1000);
  c_articulo_anexo varchar2(1000);
  c_letra5 varchar2(1000);   
  c_articulo_anexo_validado varchar2(1000);
  c_inciso3 varchar2(1000);
  c_letra3 varchar2(1000);   
  c_inciso3_validado varchar2(1000);
  c_inciso4 varchar2(1000);
  c_letra4 varchar2(1000);
  c_inciso4_validado varchar2(1000);  
  c_norma_tecnica varchar2(1000);
  c_norma_tecnica_validada varchar2(1000);
  c_descripcion_norma_tecnica varchar2(1000);
  c_modificatorias_validado varchar2(1000);
  c_lbl_concordancia_array varchar2(3000); 
  c_d_concordancia_validada varchar2(4000);
  c_concatenado varchar2(5000);
  
  c_tiene_normas_tecnicas varchar2(2000);
  c_contador_normas_tecnicas number;
  
  cursor c_listado_bl(p_id_base_legal number) is
    select 
    bl1.codigo_base_legal codigo_base_legal,
    bl1.descripcion descripcion
    from 
    PGH_LISTADO_BASE_LEGAL p, 
    pgh_base_legal bl1 
    where 1 = 1 
    and bl1.id_base_legal = p.id_base_legal_dest
    and bl1.estado = '1'  
    and p.estado = '1' 
    and p.ID_BASE_LEGAL_ORI = p_id_base_legal;
  
  --parametros trazabilidad
  p_usuario varchar2(38);
  p_terminal varchar2(38);
  p_fecha date;
  c_cod_trazabilidad varchar2(20);
  n_id_trazabilidad number;
  n_id_trazabilidad_find number;
  f_fila_base_legal pgh_base_legal%rowtype;
  f_fila_dbl pgh_detalle_base_legal%rowtype;
  c_new_cod_trazabilidad varchar2(20);
   
begin  
  p_fecha := sysdate;
  p_usuario := '00002';
  p_terminal := 'localhost';
  
  FOR fila in (    
      select 
      tnl.descripcion norma_legal,
      sgl.descripcion sigla,
      dbl.id_detalle_base_legal,
      dbl.articulo articulo,
      dbl.inciso_1 inciso1,
      dbl.inciso_2 inciso2,
      ta.descripcion tipo_anexo,
      dbl.articulo_anexo articuloanexo,
      dbl.inciso_1_anexo inciso1anexo,
      dbl.inciso_2_anexo inciso2anexo,
--      nt.descripcion norma_tecnica,
      dbl.norma_tecnica norma_tecnica_descripcion,
      dbl.modificatorias modificatorias,
      dbl.concordancias concordancias,
      p.* 
      from 
      pgh_base_legal p,
      pgh_detalle_base_legal dbl,
      (
        select * from mdi_maestro_columna mc
        where mc.dominio = 'TIPO_NORMALEGAL'
        and mc.aplicacion = 'OBLIGACIONES'
        and mc.estado = 1
        order by mc.descripcion
      ) tnl,
      (
        select * from mdi_maestro_columna mc
        where mc.dominio = 'SIGLA_BASELEGAL'
        and mc.aplicacion = 'OBLIGACIONES'
        and mc.estado = 1
        order by mc.descripcion
      ) sgl,
      (
        select * from mdi_maestro_columna mc
        where mc.dominio = 'TIPO_ANEXONORMA'
        and mc.aplicacion = 'OBLIGACIONES'
        and mc.estado = 1
        order by mc.descripcion
      ) ta
      /*(
        select * from mdi_maestro_columna mc
        where mc.dominio = 'TIPO_NORMATECNICA'
        and mc.aplicacion = 'OBLIGACIONES'
        and mc.estado = 1
        order by mc.descripcion
      ) nt*/
       where 1 = 1 
      and p.id_sigla = sgl.id_maestro_columna (+)
      and p.id_tipo_norma_legal = tnl.id_maestro_columna (+)
      and p.id_base_legal = dbl.id_base_legal (+)
      and dbl.id_tipo_anexo = ta.id_maestro_columna (+)
--      and dbl.id_tipo_norma_tecnica = nt.id_maestro_columna (+)
      and dbl.estado = 1
      and p.estado = 1
--      --and p.flag_padre = 'P'  
--      and p.id_base_legal = 977
      order by dbl.concordancias nulls first
  ) LOOP
   c_norma_legal := fila.norma_legal;
   c_sigla_norma_legal := '';
   n_len_norma := length(c_norma_legal);
   n_pos_caracter := instr(c_norma_legal, '-');
   c_sigla_desc := SUBSTR(c_norma_legal, n_pos_caracter +2, n_len_norma);
   c_sigla_norma_legal := c_sigla_desc;
   
   n_numero := fila.numero;
   if n_numero is null then
     c_numero_validado := '';
   else
     c_numero_validado := ' N° ' || n_numero;
   end if;  
   
   n_anio := fila.anio;
   if n_anio is null then
     c_anio_validado := '';
   else
     if n_anio <= 1999 then
       n_anio := to_number(substr(n_anio, 3,2));
     end if;
     c_anio_validado := '-' || n_anio;
   end if;
   
   c_sigla := fila.sigla;
   if c_sigla is null then
     c_sigla_validado := '';
   else
     c_sigla_validado := '-' || c_sigla;
   end if;
   
   c_articulo := fila.articulo;
   if c_articulo is null then
     c_articulo_validado := '';
   else
     c_articulo_validado := ' ' || 'Art. N° ' || c_articulo || ',';
   end if;      
   
   c_inciso1 := fila.inciso1;
   c_letra1 := SUBSTR(c_inciso1, 0, 1);
   if c_inciso1 is null then
     c_inciso1_validado := '';
   else
     if nps_es_numero_fun(c_letra1) = 0 then
       c_inciso1_validado := ' lit. ' || c_inciso1 || ',';
     else
       c_inciso1_validado := ' num. ' || c_inciso1 || ',';
     end if;
   end if;
   
   c_inciso2 := fila.inciso2;
   c_letra2 := SUBSTR(c_inciso2, 0, 1);
   if c_inciso2 is null then
     c_inciso2_validado := '';
   else
     if nps_es_numero_fun(c_letra2) = 0 then
       c_inciso2_validado := ' lit. ' || c_inciso2 || ',';
     else
       c_inciso2_validado := ' num. ' || c_inciso2 || ',';
     end if;
   end if;
   
   c_tipo_anexo := fila.tipo_anexo;
   if c_tipo_anexo is null then
      c_tipo_anexo_validado := '';      
   else
      c_tipo_anexo_validado := ' ' || c_tipo_anexo || ' aprobado por ';
   end if;
   
   c_articulo_anexo := fila.articuloanexo;
   c_letra5 := SUBSTR(c_articulo_anexo, 0, 1);
   if  c_articulo_anexo is null then
      c_articulo_anexo_validado := '';
   else
      c_articulo_anexo_validado := 'Art. N° ' || c_articulo_anexo || ',';
   end if;
   
   c_inciso3 := fila.inciso1anexo;
   c_letra3 := SUBSTR(c_inciso3, 0, 1);
   if c_inciso3 is null then
     c_inciso3_validado := '';
   else
     if nps_es_numero_fun(c_letra3) = 0 then
       c_inciso3_validado := ' lit. ' || c_inciso3 || ',';
     else
       c_inciso3_validado := ' num. ' || c_inciso3 || ',';
     end if;
   end if;
   
   c_inciso4 := fila.inciso2anexo;
   c_letra4 := SUBSTR(c_inciso4, 0, 1);
   if c_inciso4 is null then
     c_inciso4_validado := '';
   else
     if nps_es_numero_fun(c_letra4) = 0 then
       c_inciso4_validado := ' lit. ' || c_inciso4 || ',';
     else
       c_inciso4_validado := ' num. ' || c_inciso4 || ',';
     end if;
   end if;
   
   --c_norma_tecnica := fila.norma_tecnica;
   
   c_tiene_normas_tecnicas := '';  
   c_contador_normas_tecnicas := 0; 
   for filaNormaTecnica in (select nt.descripcion norma_tecnica, 
                                   dnt.descripcion_norma_tecnica descripcion_nt 
                             from 
                             pgh_detalle_norma_tecnica  dnt,
                             (  select * from mdi_maestro_columna mc
                                where mc.dominio = 'TIPO_NORMATECNICA'
                                and mc.aplicacion = 'OBLIGACIONES'
                                and mc.estado = 1
                                order by mc.descripcion ) nt 
                             where 1 = 1
                             and dnt.id_tipo_norma_tecnica = nt.id_maestro_columna
                             and dnt.id_detalle_base_legal = fila.id_detalle_base_legal 
                             and dnt.estado = 1
                            )
   loop
     c_contador_normas_tecnicas := c_contador_normas_tecnicas + 1;
     c_tiene_normas_tecnicas := c_tiene_normas_tecnicas || filaNormaTecnica.norma_tecnica || ' ' || filaNormaTecnica.descripcion_nt;
   end loop; 
     
--   if c_norma_tecnica is null then
   c_norma_tecnica := null;
   if c_contador_normas_tecnicas = 0 then 
     c_norma_tecnica_validada := '';
   else        
     c_norma_tecnica := 1;
     c_norma_tecnica_validada := ' de acuerdo a lo establecido en ';
   end if;  
      
--   c_descripcion_norma_tecnica := fila.norma_tecnica_descripcion;
   c_descripcion_norma_tecnica := c_tiene_normas_tecnicas;
   
   if fila.modificatorias = '1' then 
      c_modificatorias_validado := ' y Modificatorias';
   else
      c_modificatorias_validado := '';
   end if; 
   
   if fila.concordancias = '1' then 
      c_lbl_concordancia_array := '';      
      for filaListado in c_listado_bl(fila.id_base_legal) loop  
          c_lbl_concordancia_array := c_lbl_concordancia_array || chr(13)||chr(10) || '>' ||filaListado.descripcion;
      end loop;
      c_d_concordancia_validada  := ' en Concordancia con: ' || substr(c_lbl_concordancia_array,3000);
   else
      c_d_concordancia_validada := '';
   end if;   
   
   if c_articulo is null and c_tipo_anexo is null and c_norma_tecnica is null then
     c_concatenado := c_sigla_norma_legal || c_numero_validado || c_anio_validado || c_sigla_validado || c_modificatorias_validado || c_d_concordancia_validada;
   elsif c_articulo is not null and c_tipo_anexo is null and c_norma_tecnica  is null then
     c_concatenado := c_articulo_validado || c_inciso1_validado || c_inciso2_validado || ' de ' ||
                      c_sigla_norma_legal || c_numero_validado || c_anio_validado || c_sigla_validado || c_modificatorias_validado || c_d_concordancia_validada;
   elsif c_articulo is null and c_tipo_anexo is not null and c_norma_tecnica is null then
     c_concatenado := c_articulo_anexo_validado || c_inciso3_validado || c_inciso4_validado || ' del ' || c_tipo_anexo_validado || c_sigla_norma_legal ||
                      c_numero_validado || c_anio_validado || c_sigla_validado || c_modificatorias_validado || c_d_concordancia_validada;
   elsif c_articulo is null and c_tipo_anexo is null and c_norma_tecnica is not null then
     c_concatenado := c_sigla_norma_legal || c_numero_validado || c_anio_validado || c_sigla_validado || c_modificatorias_validado ||
                      c_norma_tecnica_validada  || c_descripcion_norma_tecnica  || c_d_concordancia_validada;
   elsif c_articulo is null and c_tipo_anexo is not null and c_norma_tecnica is not null then
     c_concatenado := c_articulo_anexo_validado  || c_inciso3_validado || c_inciso4_validado  || c_tipo_anexo_validado ||
                      c_sigla_norma_legal || c_numero_validado || c_anio_validado || c_sigla_validado || c_modificatorias_validado ||
                      c_norma_tecnica_validada || c_descripcion_norma_tecnica || c_d_concordancia_validada;
   elsif c_articulo is not null and c_tipo_anexo is not null and c_norma_tecnica is not null then
     c_concatenado := c_articulo_anexo_validado || c_inciso3_validado || c_inciso4_validado  || ' del ' || c_tipo_anexo_validado ||
                      c_sigla_norma_legal || c_numero_validado || c_anio_validado || c_sigla_validado || c_modificatorias_validado ||
                      c_norma_tecnica_validada || c_descripcion_norma_tecnica || c_d_concordancia_validada;
   elsif c_articulo is not null and c_tipo_anexo is not null and c_norma_tecnica is null then
     c_concatenado := c_articulo_anexo_validado || c_inciso3_validado || c_inciso4_validado || ' del ' || c_tipo_anexo_validado ||
                      c_sigla_norma_legal || c_numero_validado || c_anio_validado || c_sigla_validado || c_modificatorias_validado || c_d_concordancia_validada;   
   elsif c_articulo is not null and c_tipo_anexo is null and c_norma_tecnica is not null then
     c_concatenado := c_articulo_validado || c_inciso1_validado || c_inciso2_validado || ' de ' ||
                      c_sigla_norma_legal || c_numero_validado || c_anio_validado ||  c_sigla_validado || c_modificatorias_validado ||
                      c_norma_tecnica_validada || c_descripcion_norma_tecnica || c_d_concordancia_validada;
   else
     c_concatenado := '';
   end if;      
   c_concatenado := trim(c_concatenado); 
   
   c_concatenado := substr(c_concatenado, 0,2000);
   
   ----empezamos las actualizaciones 
   
   --generamos nuevo codigo de trazabilidad
   c_new_cod_trazabilidad := TO_CHAR(sysdate,'MIhhddMMyyyy') || '_' || lpad(pgh_codigo_trazabilidad_seq.nextval,7,'0');
        
   select bl11.* into f_fila_base_legal from pgh_base_legal bl11 where bl11.estado = 1 and bl11.id_base_legal = fila.id_base_legal;
   c_cod_trazabilidad := c_new_cod_trazabilidad; --fila.cod_trazabilidad;
   n_id_trazabilidad := to_number(substr(c_cod_trazabilidad, INSTR(c_cod_trazabilidad, '_') + 1, 20));
   
   begin
      select pto.id_trazabilidad into n_id_trazabilidad_find from PGH_TRAZABILIDAD_OBLIGACIONES pto 
      where pto.id_trazabilidad = n_id_trazabilidad;
    exception
      when NO_DATA_FOUND then
        n_id_trazabilidad_find := null;
    end;
      
    if n_id_trazabilidad_find is null then
      --insertamos en registro de trazabilidad
      insert into PGH_TRAZABILIDAD_OBLIGACIONES(
        id_trazabilidad,
        cod_trazabilidad,
        fecha_vigencia,
        usuario_creacion,
        terminal_creacion,
        fecha_creacion
      ) values (
        n_id_trazabilidad,
        c_cod_trazabilidad,
        p_fecha,
        p_usuario,
        p_terminal,
        p_fecha
      );      
    end if;     
   
    insert into pgh_base_legal(
    id_base_legal,
    codigo_base_legal,
    id_tipo_norma_legal,
    numero,
    anio,
    id_sigla,
    fecha_entrada_vigencia,
    fecha_publicacion,
    titulo,
    descripcion,
    id_base_legal_ref,
    estado,
    usuario_creacion,
    fecha_creacion,
    terminal_creacion,
    usuario_actualizacion,
    fecha_actualizacion,
    terminal_actualizacion,
    fecha_termino_vigencia,
    id_documento_adjunto,
    id_padre,
    cod_trazabilidad,
    cod_accion,
    flag_padre,
    id_base_legal_padre
    ) values (
    pgh_base_legal_seq.nextval,
    f_fila_base_legal.codigo_base_legal,
    f_fila_base_legal.id_tipo_norma_legal,
    f_fila_base_legal.numero,
    f_fila_base_legal.anio,
    f_fila_base_legal.id_sigla,
    f_fila_base_legal.fecha_entrada_vigencia,
    f_fila_base_legal.fecha_publicacion,
    f_fila_base_legal.titulo,
    f_fila_base_legal.descripcion,
    f_fila_base_legal.id_base_legal_ref,
    0,
    f_fila_base_legal.usuario_creacion,
    f_fila_base_legal.fecha_creacion,
    f_fila_base_legal.terminal_creacion,
    null,
    null,
    null,
    f_fila_base_legal.fecha_termino_vigencia,
    f_fila_base_legal.id_documento_adjunto,
    f_fila_base_legal.id_base_legal,
    c_new_cod_trazabilidad,
    'U',
    f_fila_base_legal.flag_padre,
    f_fila_base_legal.id_base_legal_padre    
    );   
    
    --actualizamos la descripcion de base legal
    update pgh_base_legal bl1 
    set 
    bl1.descripcion = c_concatenado,
    bl1.cod_trazabilidad = c_new_cod_trazabilidad,
    bl1.usuario_actualizacion = p_usuario,
    bl1.terminal_creacion = p_terminal,
    bl1.fecha_actualizacion = p_fecha
    where bl1.id_base_legal = fila.id_base_legal;    
    
    --actualizamos el detalle base legal
    --no insertamos PGH_TRAZABILIDAD_OBLIGACIONES por que lo anterior ya lo inserto
    --buscamos el detalle base legal para la base legal
    select dbl1.* into f_fila_dbl from pgh_detalle_base_legal dbl1 
    where 1 = 1 
    and dbl1.estado = 1 
    and dbl1.id_base_legal = fila.id_base_legal;
    
    
    insert into pgh_detalle_base_legal(
           id_detalle_base_legal,
           articulo,
           inciso_1,
           inciso_2,
           norma_tecnica,
           fecha_entrada_vigencia,
           fecha_publicacion,
           modificatorias,
           concordancias,
           descripcion,
           id_nivel_articulo,
           id_base_legal,
           id_tipo_anexo,
           articulo_anexo,
           inciso_1_anexo,
           inciso_2_anexo,
           id_tipo_norma_tecnica,
           estado,
           usuario_creacion,
           fecha_creacion,
           terminal_creacion,
           usuario_actualizacion,
           fecha_actualizacion,
           terminal_actualizacion,
           id_padre,
           cod_trazabilidad,
           cod_accion,
           numero_tipo_anexo        
    ) values(
           pgh_detalle_base_legal_seq.nextval,
           f_fila_dbl.articulo,
           f_fila_dbl.inciso_1,
           f_fila_dbl.inciso_2,
           f_fila_dbl.norma_tecnica,
           f_fila_dbl.fecha_entrada_vigencia,
           f_fila_dbl.fecha_publicacion,
           f_fila_dbl.modificatorias,
           f_fila_dbl.concordancias,
           f_fila_dbl.descripcion,
           f_fila_dbl.id_nivel_articulo,
           f_fila_dbl.id_base_legal,
           f_fila_dbl.id_tipo_anexo,
           f_fila_dbl.articulo_anexo,
           f_fila_dbl.inciso_1_anexo,
           f_fila_dbl.inciso_2_anexo,
           f_fila_dbl.id_tipo_norma_tecnica,
           0,
           f_fila_dbl.usuario_creacion,
           f_fila_dbl.fecha_creacion,
           f_fila_dbl.terminal_creacion,
           null,
           null,
           null,
           f_fila_dbl.id_detalle_base_legal,
           c_new_cod_trazabilidad,
           'U',
           f_fila_dbl.numero_tipo_anexo
    );    
    
    update pgh_detalle_base_legal dbl1 set
    dbl1.descripcion = c_concatenado,
    dbl1.cod_trazabilidad = c_new_cod_trazabilidad,
    dbl1.usuario_actualizacion = p_usuario,
    dbl1.terminal_creacion = p_terminal,
    dbl1.fecha_actualizacion = p_fecha
    where dbl1.id_detalle_base_legal = f_fila_dbl.id_detalle_base_legal;     
  END LOOP;
end;
/
