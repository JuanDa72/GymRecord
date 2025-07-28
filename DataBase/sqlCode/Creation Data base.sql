CREATE DATABASE gymRecords;
use gymRecords;
Create table user (
	UserId INT primary key auto_increment,
    UserName varchar(45) not null, 
    UserLastName varchar(45) not null,
    UserEmail varchar(45) not null, 
    userPassword varchar(45) not null, 
    userAge int not null, 
    userBirthdate date not null, 
    userPhoneNumber varchar(45) not null
    );
    
    
create table routine(
	RoutineId INT primary key auto_increment,
    RoutineName varchar(45) not null,
    RoutineCreationDate DATE not null,
    RoutineLastAccess DATETIME not null,
    RoutineDescription TEXT,
    RoutineUserId int not null,
    constraint fk_routine_user foreign key (RoutineUserId) references user(UserId)
    );
    

create table session(
	SessionId INT PRIMARY KEY auto_increment,
    SessionName varchar(45) not null, 
    SessionRoutineId int not null, 
    SessionNotes text,
    constraint fk_session_routine foreign key (SessionRoutineId) references routine(RoutineId)
    );
    
CREATE TABLE exercise (
    ExerciseId INT PRIMARY KEY AUTO_INCREMENT,
    ExerciseName VARCHAR(45) not null,
    ExercisesNumberSeries INT not null,
    ExerciseOrden INT not null,
    ExerciseSessionId INT not null,
    ExerciseMachine VARCHAR(45),
    constraint fk_exercise_session foreign key (ExerciseSessionId) references session(SessionId)
);


CREATE TABLE serie (
    SerieId INT PRIMARY KEY AUTO_INCREMENT,
    SerieOrden INT not null,
    SerieWeight DECIMAL(5,2),
    SerieRepetitions INT not null,
    SerieExerciseId INT not null,
    SerieDate DATETIME not null,
    SerieNotes text,
    CONSTRAINT fk_serie_exercise FOREIGN KEY (SerieExerciseId) REFERENCES exercise(ExerciseId)
);

alter table user add userGender varchar(45);
alter table user add weight decimal(6,3); 
alter table exercise add ExerciseNotes text;

alter table user rename column userGender to UserGender;
alter table user rename column weight to UserWeight;

describe routine;
