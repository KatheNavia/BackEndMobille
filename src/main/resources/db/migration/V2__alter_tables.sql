create table "users"(
    us_id_vacunados serial primary key ,
    us_tipo_documento varchar(50),
    us_numero_documento varchar(15) not null,
    us_nombres varchar(50),
    us_apellidos varchar(50),
    us_edad integer not null,
    us_tipo_sangre varchar(20),
    us_eps varchar(50),
    us_telefono varchar(20),
    us_email varchar(30),
    us_ciudad varchar(30)
);

ALTER TABLE "users" OWNER to postgres;

insert into users (us_id_vacunados,
                   us_tipo_documento,
                   us_numero_documento,
                   us_nombres,
                   us_apellidos,
                   us_edad,
                   us_tipo_sangre,
                   us_eps,
                   us_telefono,
                   us_email,
                   us_ciudad)
select vc_id_vacunados,
       vc_tipo_documento,
       vc_numero_documento,
       vc_nombres,
       vc_apellidos,
       vc_edad,
       vc_tipo_sangre,
       vc_eps,
       vc_telefono,
       vc_email,
       vc_ciudad from vacunados;

DROP TABLE "vacunas";
DROP TABLE "vacunados";

create table "vacunacion"(
    va_id_vacunas serial primary key ,
    va_vc_id_vacunados integer not null,
    va_vd_id_vacunadores integer not null,
    va_cantidad_dosis integer,
    va_nombre_vacuna_uno varchar(50),
    va_nombre_vacuna_dos varchar(50),
    va_fecha_vacuna_uno date,
    va_fecha_vacuna_dos date,
    va_punto_vacuna_uno varchar(30),
    va_punto_vacuna_dos varchar(30),
    foreign key (va_vc_id_vacunados) references users(us_id_vacunados),
    foreign key (va_vd_id_vacunadores) references vacunadores(vd_id_vacunadores)
);

ALTER TABLE "vacunacion" OWNER to postgres;