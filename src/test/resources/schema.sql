drop table if exists users_roles;
drop table if exists users;
drop table if exists roles;

create table users
(
    id        bigint auto_increment
        primary key not null,
    age       tinyint      not null,
    email     varchar(225) not null,
    name      varchar(225) not null,
    last_name varchar(225) not null,
    password  varchar(225) not null,
        unique (email)
) ENGINE = InnoDB;

create table roles
(
    id   bigint auto_increment primary key,
    name varchar(255) not null,
        unique (name)
) ENGINE = InnoDB;

create table users_roles
(
    users_id bigint not null,
    roles_id bigint not null,
        unique (users_id, roles_id),
        foreign key (users_id) references users (id),
        foreign key (roles_id) references roles (id)
) ENGINE = InnoDB;

