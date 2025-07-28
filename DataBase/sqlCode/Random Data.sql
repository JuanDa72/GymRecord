use gymRecords;

-- Probando los triggers e insertando algunos datos

INSERT INTO user (
    UserName, UserLastName, UserEmail, userPassword, userBirthdate, userPhoneNumber, UserGender, UserWeight
) VALUES
('Camila', 'Torres', 'camila.torres@example.com', 'camila123', '2000-05-12', '3101234567', 'Femenino', 60.500),
('Andrés', 'Pérez', 'andres.perez@example.com', 'andres456', '1990-10-22', '3209876543', 'Masculino', 78.200),
('Lucía', 'Martínez', 'lucia.martinez@example.com', 'lucia789', '1997-03-30', '3001112233', 'Femenino', 65.000);

INSERT INTO user (
    UserName, UserLastName, UserEmail, userPassword, userBirthdate, userPhoneNumber, UserGender, UserWeight
) VALUES
('bad', 'bunny', 'jijo@gmail.com', 'tuturruru', '1995-09-25', '59693953', 'Masculino', 68.677);


update user set userBirthdate='1967-2-09' where user.UserId=4;

select * from user;
describe routine;


INSERT INTO routine (RoutineName, RoutineLastAccess, RoutineDescription, RoutineUserId)
VALUES 
('Rutina de fuerza', NOW(), 'Entrenamiento de fuerza para Camila', 1),
('Rutina de resistencia', NOW(), 'Rutina de cardio y resistencia para Andrés', 2),
('Rutina general', NOW(), 'Rutina equilibrada para Lucía', 3),
('Rutina explosiva', NOW(), 'Rutina intensa para Bad Bunny', 4);


select * from routine;

describe session;

INSERT INTO session (SessionName, SessionRoutineId, SessionNotes)
VALUES
('Sesión de piernas', 1, 'Piernas con peso libre y máquinas'),
('Sesión de HIIT', 2, 'Cardio de alta intensidad con poco descanso'),
('Sesión de abdomen', 3, 'Trabajo abdominal en circuito'),
('Sesión nocturna', 4, 'Sesión personalizada para terminar el día');

select * from session;

describe exercise;

INSERT INTO exercise (ExerciseName, ExercisesNumberSeries, ExerciseOrden, ExerciseSessionId, ExerciseMachine, ExerciseNotes)
VALUES 
('Prensa de piernas', 4, 1, 1, 'Prensa inclinada', 'Trabajar cuádriceps y glúteos'),
('Sentadilla libre', 3, 2, 1, NULL, 'Técnica controlada, enfoque en profundidad'),
('Bicicleta estática', 1, 1, 2, 'Bicicleta cardio', 'Calentamiento de 10 minutos'),
('Plancha abdominal', 3, 1, 3, NULL, 'Ejercicio isométrico'),
('Crunches', 3, 2, 3, NULL, '3 series de 20 repeticiones'),
('Cinta caminadora', 1, 1, 4, 'Caminadora eléctrica', '5 minutos a ritmo suave');

select * from exercise;

describe serie;

INSERT INTO serie (SerieOrden, SerieWeight, SerieRepetitions, SerieExerciseId, SerieNotes)
VALUES 
(1, 80.00, 12, 1, 'Buen control del movimiento'),
(2, 85.00, 10, 1, 'Incremento de peso'),
(3, 90.00, 8, 1, 'Fallo muscular al final'),

(1, NULL, 15, 2, 'Sentadilla sin peso'),
(2, NULL, 12, 2, 'Enfocarse en técnica'),
(3, NULL, 10, 2, 'Última con pausa abajo'),

(1, NULL, 1, 3, '10 minutos completados'),

(1, NULL, 1, 4, 'Plancha 45 segundos'),
(2, NULL, 1, 4, 'Plancha 1 minuto'),
(3, NULL, 1, 4, 'Plancha con variación'),

(1, NULL, 20, 5, 'Repeticiones controladas'),
(2, NULL, 20, 5, 'Últimas 5 con dificultad'),

(1, NULL, 1, 6, 'Caminata ligera');

select * from serie;

select * from routine;
