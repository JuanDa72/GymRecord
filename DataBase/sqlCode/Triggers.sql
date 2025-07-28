use gymRecords;
-- Triggers
-- Cálculo y actulización instantanea de la edad en base a la fecha de nacimiento

delimiter $$
create trigger insertAge
	before insert on user
	for each row 
    begin
		if new.userBirthdate is not null then
			set NEW.userAge = timestampdiff(year, new.userBirthdate, curdate());
        end if;

end $$


delimiter $$
create trigger updateAge
	before update on user
	for each row 
    begin
		if new.userBirthdate is not null then
			set NEW.userAge = timestampdiff(year, new.userBirthdate, curdate());
        end if;

end $$


delimiter $$
-- Triger para que se genere automaticamente la fecha de creación de la rutina cuando se inserte
create trigger setRoutineCreationDate
	before insert on routine 
    for each row
	begin 
		set new.RoutineCreationDate=curdate();
	end $$


-- Trigger para que se actualice la fecha de último acceso una vez se agrega un nuevo registro en algun ejercicio
DELIMITER $$

CREATE TRIGGER updateRoutineLastAccess
AFTER INSERT ON serie
FOR EACH ROW
BEGIN
    DECLARE id_routine int;
    

    SELECT r.RoutineId INTO id_routine 
    FROM routine r
    JOIN session s ON r.RoutineId = s.SessionRoutineId
    JOIN exercise e ON s.SessionId = e.ExerciseSessionId
    WHERE e.ExerciseId = NEW.SerieExerciseId;
    
    UPDATE routine SET RoutineLastAccess=NOW() WHERE RoutineId=id_routine;
END $$

DELIMITER ;

-- En caso de que el usuario no asigne un nombre a la rutina tenemos que modificar por código en api o androidStudio el nombre por defetcto

-- En caso de que el usuario no asigne un nombre a la sesión tenemos que modificar por código en api o androidStudio el nombre por defetcto

-- En caso de que el usuario no asigne un nombre al ejercicio tenemos que modificar por código en api o androidStudio el nombre por defetcto
    
    
-- Trigger para que se establezca la fecha de forma automática cuando se inserte algo en serie
delimiter $$
create trigger setSerieDate
	before insert on serie
    for each row
    begin
		set new.SerieDate=now();
	END $$
    
    
-- Trigger para que se establezca la fecha de forma automática cuando se actualice algo en serie
create trigger updateSerieDate
	before update on serie
    for each row
    begin 
		set new.SerieDate=now();
	end $$
    
    
    
-- Trigger para actualizar routineLastAccess cuando se crea una nueva sesión
DELIMITER $$

CREATE TRIGGER updateRoutineLastAccessBySession
AFTER INSERT ON session
FOR EACH ROW
BEGIN
    UPDATE routine
    SET RoutineLastAccess = NOW()
    WHERE RoutineId = NEW.SessionRoutineId;
END $$

DELIMITER ;