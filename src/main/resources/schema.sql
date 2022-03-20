create table if not exists t_toys(
id integer NOT NULL auto_increment,
nume varchar(50),
producator varchar(50),
varsta varchar(50),
pret double,
cantitate integer,
primary key(id)
);

create table if not exists t_categories(
id integer NOT NULL auto_increment,
tipjucarii varchar(50),
cantitate integer,
primary key(id)
);