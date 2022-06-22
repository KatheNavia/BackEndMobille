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