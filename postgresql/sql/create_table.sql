create table users
(
    id       bigserial primary key,
    username varchar(20) unique                     not null,
    active   boolean                  default false not null,
    created  timestamp with time zone default now() not null,
    updated  timestamp with time zone default now() not null
)
