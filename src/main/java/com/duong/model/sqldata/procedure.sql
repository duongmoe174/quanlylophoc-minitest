DELIMITER  //
create procedure selectAllClasses ()
begin
select * from classes;
end //
DELIMITER ;

DELIMITER //
create procedure insertClasses (
IN classes_name varchar(50),
IN classes_description varchar(500)
)
begin
insert into classes (name, description) values (classes_name, classes_description);
end //
DELIMITER ;

DELIMITER //
create procedure getClassesById (IN classes_id int)
begin
select name,description from classes
    where id = classes_id;
end //
DELIMITER  ;

DELIMITER //
create procedure deleteClasses (IN classes_id int)
begin
    delete from classes where id = classes_id;
end //
DELIMITER ;

DELIMITER //
create procedure updateClasses (
IN classes_id int,
IN classes_name varchar(50),
IN classes_description varchar(500)
)
begin
update classes set name = classes_name, description = classes_description
    where id = classes_id;
end //
DELIMITER ;