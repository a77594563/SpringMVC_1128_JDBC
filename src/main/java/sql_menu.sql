CREATE TABLE Menu(
    menu_id integer primary key generated always as identity,
    menu_key varchar(50) not null,
    menu_path varchar(50) not null,
    menu_text varchar(50) not null,
    menu_ts timestamp default current_timestamp
);
