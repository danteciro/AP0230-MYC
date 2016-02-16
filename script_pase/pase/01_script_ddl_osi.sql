-- Add/modify columns 
alter table PGH_CNF_REQU_PROCEDIMIENTO add NRO_ORDEN number(10);
-- Add comments to the columns 
comment on column PGH_CNF_REQU_PROCEDIMIENTO.NRO_ORDEN
  is 'Indica el orden de los requisitos';