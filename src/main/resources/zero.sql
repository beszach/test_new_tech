DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

create table users
(
    id        bigint auto_increment
        primary key,
    age       tinyint      not null,
    email     varchar(225) not null,
    name      varchar(225) not null,
    last_name varchar(225) not null,
    password  varchar(225) not null,
        unique (id),
        unique (email)
);

create table roles
(
    id   bigint auto_increment primary key,
    name varchar(255) not null,
        unique (id),
        unique (name)
);

create table users_roles
(
    users_id bigint not null,
    roles_id bigint not null,
        unique (users_id, roles_id),
        foreign key (users_id) references users (id),
        foreign key (roles_id) references roles (id)
);

