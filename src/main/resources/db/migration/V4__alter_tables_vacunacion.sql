alter table vacunacion rename column va_nombre_vacuna_uno to va_fabricante;
alter table vacunacion drop column va_nombre_vacuna_dos;

alter table vacunacion rename column va_fecha_vacuna_uno to va_fecha_aplicacion;
alter table vacunacion drop column va_fecha_vacuna_dos;

alter table vacunacion rename column va_punto_vacuna_uno to va_ips_vacunadora;
alter table vacunacion drop column va_punto_vacuna_dos;

alter table vacunacion add lote varchar(10);