create table if not exists authors (
    id number not null,
    first_name varchar2(150) not null,
    last_name varchar2(150) not null,
    primary key (id)
);

create table if not exists books (
    id number not null,
    title varchar2(150) not null,
    author_id number not null,
    year_num number not null,
    foreign key (author_id) references authors(id),
    primary key (id)
);


insert into authors (id, first_name, last_name) VALUES
(1, 'A', 'B'),
(2, 'B', 'C'),
(3, 'C', 'D'),
(4, 'D', 'E');


insert into books (id, title, author_id, year_num) VALUES
(1, 'Abba', 1, 2023),
(2, 'Babba', 1, 2022),
(3, 'Cat', 2, 2021),
(4, 'Deb', 3, 2020),
(5, 'Ever', 3, 2019),
(6, 'Dave', 4, 2021),
(7, 'Veal', 1, 2001),
(8, 'Beyond the Vale', 2, 2020),
(9, 'Dreamer', 4, 2014);
