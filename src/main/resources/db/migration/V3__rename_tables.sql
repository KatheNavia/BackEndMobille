DROP TABLE "vacunacion";
DROP TABLE "users";
DROP TABLE "vacunadores";

create table "pacientes"(
                            pcet_id serial primary key ,
                            pcet_tipo_documento varchar(50),
                            pcet_numero_documento varchar(15) not null,
                            pcet_nombres varchar(50),
                            pcet_apellidos varchar(50),
                            pcet_edad integer not null,
                            pcet_tipo_sangre varchar(20),
                            pcet_eps varchar(50),
                            pcet_telefono varchar(20),
                            pcet_email varchar(30),
                            pcet_ciudad varchar(30)
);

ALTER TABLE "pacientes" OWNER to postgres;

create table "enfermeros"(
                              efmr_id serial primary key ,
                              efmr_tipo_documento varchar(50),
                              efmr_numero_documento integer not null,
                              efmr_nombres varchar(50),
                              efmr_apellidos varchar(50),
                              efmr_telefono varchar(20),
                              efmr_email varchar(30),
                              efmr_ciudad varchar(30),
                              efmr_usuario varchar(20),
                              efmr_contrasena varchar(20)
);

ALTER TABLE "enfermeros" OWNER to postgres;

create table "vacunacion"(
                          va_id serial primary key ,
                          va_id_paciente integer not null,
                          va_id_enfermero integer not null,
                          va_cantidad_dosis integer,
                          va_nombre_vacuna_uno varchar(50),
                          va_nombre_vacuna_dos varchar(50),
                          va_fecha_vacuna_uno date,
                          va_fecha_vacuna_dos date,
                          va_punto_vacuna_uno varchar(30),
                          va_punto_vacuna_dos varchar(30),
                          foreign key (va_id_paciente) references pacientes(pcet_id),
                          foreign key (va_id_enfermero) references enfermeros(efmr_id)
);

ALTER TABLE "vacunacion" OWNER to postgres;
