
create table USERS
(
    id        bigint auto_increment
        primary key,
    age       tinyint      not null,
    email     varchar(225) not null,
    name      varchar(225) not null,
    last_name varchar(225) not null,
    password  varchar(225) not null,
        unique (email)
);

create table ROLES
(
    id   bigint auto_increment,
    name varchar(255) not null,
        unique (id),
        unique (name)
);

alter table ROLES
    add primary key (id);

create table USERS_ROLES
(
    users_id bigint not null,
    roles_id bigint not null,
        unique (users_id, roles_id),
        foreign key (users_id) references USERS (id),
        foreign key (roles_id) references ROLES (id)
);

create index roles_id
    on USERS_ROLES (roles_id);

