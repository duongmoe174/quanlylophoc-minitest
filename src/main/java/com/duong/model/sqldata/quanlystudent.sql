create database quanlylophoc;
use quanlylophoc;

create table Classes (
                         id int auto_increment primary key not null ,
                         name varchar(50),
                         description varchar(500)
);

create table Student (
                         id int auto_increment primary key not null ,
                         firstname varchar(50),
                         lastname varchar(50),
                         address varchar(200),
                         classes_id int,
                         foreign key (classes_id) references classes(id)
);

create table student_classes (
                                 student_id int,
                                 classes_id int,
                                 foreign key (student_id) references Student(id),
                                 foreign key (classes_id) references classes(id)
);

insert into classes (name, description)values ('PHP', 'dao tao lap trinh vien PHP');
insert into classes (name, description)values ('Python', 'dao tao lap trinh vien Python');