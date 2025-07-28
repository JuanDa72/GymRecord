-- Practicando algunas consultas xd
select user.UserId, user.UserEmail from user where user.UserWeight>65;

-- Seleccionar rutinas modificadas en una determinada fecha o antes 
select * from routine where routine.RoutineCreationDate<'2026-09-22';

-- Ordenar a los usuarios de menor a mayor en base a su edad
select user.UserLastName from user order by user.userAge asc;

-- Contar cuantas rutinas tiene cada usuario 
select user.UserName, COUNT(routine.RoutineName) as 'Número de rutinas' from user join routine on (user.UserId=routine.RoutineUserId) group by routine.RoutineUserId;

-- Contar cuantos ejercicios tiene cada rútina en total 
select routine.RoutineId, routine.RoutineName, count(exercise.ExerciseId) as 'Número de ejercicios' from routine join session on (routine.RoutineId=session.SessionRoutineId) join exercise on (session.SessionId=ExerciseSessionId) group by routine.RoutineId; 

-- Total de repeticiones realizadas por rutina (sumando todas las series)
select routine.RoutineName, sum(serie.SerieRepetitions) as 'Número de repeticiones totales' from routine join session on (routine.RoutineId=session.SessionRoutineId) join exercise on (session.SessionId=exercise.ExerciseSessionId) join serie on (exercise.ExerciseId=serie.SerieExerciseId) group by routine.RoutineId;


