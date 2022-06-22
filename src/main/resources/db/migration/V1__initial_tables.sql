create table "vacunados"(
    vc_id_vacunados serial primary key ,
    vc_tipo_documento varchar(50),
    vc_numero_documento varchar(15) not null,
    vc_nombres varchar(50),
    vc_apellidos varchar(50),
    vc_edad integer not null,
    vc_tipo_sangre varchar(20),
    vc_eps varchar(50),
    vc_telefono varchar(20),
    vc_email varchar(30),
    vc_ciudad varchar(30)
);

ALTER TABLE "vacunados" OWNER to postgres;

create table "vacunadores"(
    vd_id_vacunadores serial primary key ,
    vd_tipo_documento varchar(50),
    vd_numero_documento integer not null,
    vd_nombres varchar(50),
    vd_apellidos varchar(50),
    vd_telefono varchar(20),
    vd_email varchar(30),
    vd_ciudad varchar(30),
    vd_usuario varchar(20),
    vd_contrasena varchar(20)
);

ALTER TABLE "vacunadores" OWNER to postgres;

create table "vacunas"(
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
    foreign key (va_vc_id_vacunados) references vacunados(vc_id_vacunados),
    foreign key (va_vd_id_vacunadores) references vacunadores(vd_id_vacunadores)
);

ALTER TABLE "vacunas" OWNER to postgres;

