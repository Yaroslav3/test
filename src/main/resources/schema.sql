/* CREATE TABLE */
create table users
(
    id bigint not null
        primary key,
    ip_address varchar(255) null,
    email varchar(255) null,
    first_name varchar(255) null,
    gender varchar(255) null,
    last_name varchar(255) null,
    new_column int null
)
    engine=MyISAM;

/* CREATE TABLE */
create table statistic
(
    id bigint not null AUTO_INCREMENT,
        primary key,
    clicks int null,
    date datetime null,
    page_views int null,
    user_id bigint null
)
    engine=MyISAM;

create index FKoifiete5h1dmj02jk2fwe6d65
    on statistic (user_id);
