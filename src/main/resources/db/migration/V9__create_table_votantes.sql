create table "users"(
    us_id_user serial primary key,
    us_number_document varchar(50),
    us_name varchar(50),
    us_lastname varchar(50),
    us_password varchar(20)
);
ALTER TABLE "users" OWNER to postgres;

create table "candidates"(
    ca_id_candidate serial primary key,
    ca_name varchar(50),
    ca_lastname varchar(50),
    ca_political_party varchar(100)
);
ALTER TABLE "candidates" OWNER to postgres;

create table "votes"(
    vo_id_vote serial primary key,
    vo_us_id_user integer not null,
    vo_ca_id_candidate integer not null,
    foreign key (vo_us_id_user) references users(us_id_user),
    foreign key (vo_ca_id_candidate) references candidates(ca_id_candidate)
);
ALTER TABLE "votes" OWNER to postgres;