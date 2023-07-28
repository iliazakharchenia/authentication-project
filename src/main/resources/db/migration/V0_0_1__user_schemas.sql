create table user
(
    id        bigserial primary key,
    name      varchar(64),
    password  varchar(512),
    authority varchar(16)
)
