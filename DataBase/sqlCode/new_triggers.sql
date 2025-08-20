use gymrecordssecond;

delimiter $$
create trigger insert_age
	before insert on user
	for each row 
    begin
		if new.user_birthdate is not null then
			set NEW.user_age = timestampdiff(year, new.user_birthdate, curdate());
        end if;

end $$

delimiter $$
create trigger update_age
	before update on user
	for each row 
    begin
		if new.user_birthdate is not null then
			set NEW.user_age = timestampdiff(year, new.user_birthdate, curdate());
        end if;

end $$ 



delimiter $$
-- Triger para que se genere automaticamente la fecha de creación de la rutina cuando se inserte
create trigger set_routine_creation_date
	before insert on routine 
    for each row
	begin 
		set new.routine_creation_date=curdate();
	end $$
    
    
-- Trigger para que cuando se cree una rutina se ponga automaticamente la fecha del último acceso
delimiter $$
create trigger set_routine_last_access
		before insert on routine
        for each row 
        begin 
			set new.routine_last_access=curdate();
		end $$
        
        
        
CREATE TRIGGER update_routine_last_access
AFTER INSERT ON serie
FOR EACH ROW
BEGIN
    DECLARE id_routine int;
    

    SELECT r.routine_id INTO id_routine 
    FROM routine r
    JOIN session s ON r.routine_id = s.session_routine_id
    JOIN exercise e ON s.session_id = e.exercise_session_id
    WHERE e.exercise_Id = NEW.serie_exercise_id;
    
    UPDATE routine SET routine_last_access=NOW() WHERE routine_id=id_routine;
END $$


-- Trigger para que se establezca la fecha de forma automática cuando se inserte algo en serie
delimiter $$
create trigger set_serie_date
	before insert on serie
    for each row
    begin
		set new.serie_date=now();
	END $$



-- Trigger para que se establezca la fecha de forma automática cuando se actualice algo en serie
create trigger update_serie_date
	before update on serie
    for each row
    begin 
		set new.serie_date=now();
	end $$
    
    
    
    -- Trigger para actualizar routineLastAccess cuando se crea una nueva sesión
DELIMITER $$

CREATE TRIGGER update_routine_last_access_by_session
AFTER INSERT ON session
FOR EACH ROW
BEGIN
    UPDATE routine
    SET routine_last_access = NOW()
    WHERE routine_id = NEW.session_routine_id;
END $$

DELIMITER ;