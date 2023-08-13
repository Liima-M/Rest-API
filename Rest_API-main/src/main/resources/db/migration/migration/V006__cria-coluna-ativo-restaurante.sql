alter table  beicinhofood.restaurante add ativo tinyint(1) not null;
update beicinhofood.restaurante set ativo = true;