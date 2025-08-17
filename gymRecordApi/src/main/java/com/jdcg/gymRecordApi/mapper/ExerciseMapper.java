package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.ExerciseGetDto;
import com.jdcg.gymRecordApi.dto.get.ExerciseGetDtoC;
import com.jdcg.gymRecordApi.dto.save.ExerciseSaveDto;
import com.jdcg.gymRecordApi.dto.update.ExerciseUpdateDto;
import com.jdcg.gymRecordApi.model.Exercise;
import com.jdcg.gymRecordApi.model.Session;
import com.jdcg.gymRecordApi.repository.SessionRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ExerciseMapper {

    public SerieMapper serieMapper;
    public SessionRepository sessionRepository;

    public ExerciseMapper(SerieMapper serieMapper,SessionRepository sessionRepository){
        this.serieMapper=serieMapper;
        this.sessionRepository=sessionRepository;
    }


    public ExerciseGetDto toExerciseGetDto(Exercise exercise){

        return new ExerciseGetDto(
                exercise.getExerciseId(),
                exercise.getExerciseName(),
                exercise.getExercisesNumberSeries(),
                exercise.getExerciseOrden(),
                exercise.getExerciseMachine(),
                exercise.getExerciseNotes()
        );

    }


    public ExerciseGetDtoC toExerciseGetDtoC(Exercise exercise){

        return new ExerciseGetDtoC(
                exercise.getExerciseId(),
                exercise.getExerciseName(),
                exercise.getExercisesNumberSeries(),
                exercise.getExerciseOrden(),
                exercise.getExerciseMachine(),
                exercise.getExerciseNotes(),
                exercise.getSeries().stream().map(serieMapper::toSerieGetDto).collect(Collectors.toList())
        );

    }


    public Exercise toExercise(ExerciseSaveDto exerciseSaveDto){
        Exercise exercise=new Exercise();
        exercise.setExerciseName(exerciseSaveDto.exerciseName());
        exercise.setExercisesNumberSeries(exerciseSaveDto.exercisesNumberSeries());
        exercise.setExerciseOrden(exerciseSaveDto.exerciseOrden());
        exercise.setExerciseMachine(exerciseSaveDto.exerciseMachine());
        exercise.setExerciseNotes(exerciseSaveDto.exerciseNotes());

        //Verificar que si exista la session
        Session session=sessionRepository.findById(exerciseSaveDto.sessionId()).
                orElseThrow(()->new RuntimeException("No session was found with this ID"));
        exercise.setSession(session);
        return exercise;
    }


    public Exercise updateToExercise(ExerciseUpdateDto exerciseUpdateDto, Exercise exercise){
        if(exerciseUpdateDto.exerciseName()!=null){
            exercise.setExerciseName(exerciseUpdateDto.exerciseName());
        }
        if(exerciseUpdateDto.exercisesNumberSeries()!=null){
            exercise.setExercisesNumberSeries(exerciseUpdateDto.exercisesNumberSeries());
        }
        if(exerciseUpdateDto.exerciseOrden()!=null){
            exercise.setExerciseOrden(exerciseUpdateDto.exerciseOrden());
        }
        if(exerciseUpdateDto.exerciseMachine()!=null){
            exercise.setExerciseMachine(exerciseUpdateDto.exerciseMachine());
        }
        if(exerciseUpdateDto.exerciseNotes()!=null){
            exercise.setExerciseNotes(exerciseUpdateDto.exerciseNotes());
        }
        return exercise;
    }


}
