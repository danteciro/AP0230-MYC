
update
PGH_CONF_OBLIGACION o
set
o.id_obligacion_tipo = 4
where
o.id_conf_obligacion
in
(
SELECT o.id_conf_obligacion FROM PGH_CONF_OBLIGACION O WHERE O.ESTADO = '1' AND O.ID_ACTIVIDAD = 1653 AND O.ID_PROCESO = 2 and id_obligacion_tipo = 27
);

 update pgh_proceso_obligacion_tipo
    set 
    id_obligacion_tipo = 4
    where 
    id_obligacion_tipo = 27
    and id_actividad = 1653
    and id_proceso = 2
    and id_pro_obl_tip = 35;