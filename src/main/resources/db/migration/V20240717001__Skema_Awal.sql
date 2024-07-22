create table c_security_permission
(
    id               varchar(36)  not null,
    created          datetime(6) not null,
    created_by       varchar(100) not null,
    updated          datetime(6),
    updated_by       varchar(100),
    permission_label varchar(100) not null,
    permission_value varchar(100) not null,
    primary key (id)
) engine=InnoDB;
create table c_security_reset_password
(
    id         varchar(36)  not null,
    created    datetime(6) not null,
    created_by varchar(100) not null,
    updated    datetime(6),
    updated_by varchar(100),
    token      varchar(100) not null,
    id_user    varchar(36),
    primary key (id)
) engine=InnoDB;
create table c_security_role
(
    id          varchar(36)  not null,
    created     datetime(6) not null,
    created_by  varchar(100) not null,
    updated     datetime(6),
    updated_by  varchar(100),
    description varchar(100),
    name        varchar(15)  not null,
    primary key (id)
) engine=InnoDB;
create table c_security_role_permission
(
    id_role       VARCHAR(36) not null,
    id_permission VARCHAR(36) not null,
    primary key (id_role, id_permission)
) engine=InnoDB;
create table c_security_user
(
    id           varchar(36)  not null,
    created      datetime(6) not null,
    created_by   varchar(100) not null,
    updated      datetime(6),
    updated_by   varchar(100),
    active       bit,
    company_name varchar(255),
    name         varchar(255),
    type         varchar(255),
    username     varchar(100) not null,
    id_role      varchar(36)  not null,
    primary key (id)
) engine=InnoDB;
create table c_security_user_password
(
    id_user       varchar(36)  not null,
    created       datetime(6) not null,
    created_by    varchar(100) not null,
    updated       datetime(6),
    updated_by    varchar(100),
    user_password varchar(255) not null,
    primary key (id_user)
) engine=InnoDB;


alter table c_security_reset_password
    add constraint UK7rn5sdpw3dum93c3oyo49xfks unique (token);

alter table c_security_role
    add constraint UKhliaoojt6u3a11d8svttju10l unique (name);

alter table c_security_user
    add constraint UKat8if7a9lnl90wxllb9divpdf unique (username);

alter table c_security_reset_password
    add constraint FKejjx0jqnpm3ab1jutkhjliet9
        foreign key (id_user)
            references c_security_user (id);

alter table c_security_role_permission
    add constraint FKnqcv2qdac1phe20qqnyi6n1n
        foreign key (id_permission)
            references c_security_permission (id);

alter table c_security_role_permission
    add constraint FKg9os4isbs19ssfahravousxes
        foreign key (id_role)
            references c_security_role (id);

alter table c_security_user
    add constraint FKe5ychpyk27l8vj47v36mrn0s1
        foreign key (id_role)
            references c_security_role (id);

alter table c_security_user_password
    add constraint FK80arji7i1u0styufcy8b91it5
        foreign key (id_user)
            references c_security_user (id);
