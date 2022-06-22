alter table inventarios rename column vi_id_inventarios to vi_id;

alter table vacunacion drop column va_ips_vacunadora;
alter table vacunacion drop column va_lote;
alter table vacunacion drop column va_fabricante;

alter table vacunacion add va_id_vacuna integer;
alter table vacunacion add va_id_ips_vacunadora integer;

update vacunacion set va_id_vacuna = 1;
update vacunacion set va_id_ips_vacunadora = 4;

alter table vacunacion alter column va_id_vacuna set not null;
alter table vacunacion alter column va_id_ips_vacunadora set not null;

alter table vacunacion add foreign key (va_id_vacuna) references inventarios(vi_id);
alter table vacunacion add foreign key (va_id_ips_vacunadora) references puntovacunacion(pv_id);

