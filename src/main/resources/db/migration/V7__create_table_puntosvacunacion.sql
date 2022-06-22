DROP TABLE "inventarios";

create table "inventarios"(
    vi_id_inventarios serial primary key ,
    vi_codigo_vacuna varchar(50),
    vi_nombre_vacuna varchar(50),
    vi_cantidad_vacuna integer,
    vi_lote varchar(50),
    vi_fecha_fabricacion date,
    vi_fecha_vencimiento date
);
ALTER TABLE "inventarios" OWNER to postgres;

create table "puntovacunacion" (
    pv_id serial primary key,
    pv_nombre    varchar(50),
    pv_direccion varchar(50),
    pv_telefono  varchar(50),
    pv_ciudad    varchar(50)
);

ALTER TABLE "puntovacunacion" OWNER to postgres;