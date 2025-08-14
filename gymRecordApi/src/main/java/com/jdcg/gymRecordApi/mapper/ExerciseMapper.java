package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.ExerciseGetDto;
import com.jdcg.gymRecordApi.dto.save.ExerciseSaveDto;
import com.jdcg.gymRecordApi.dto.update.ExerciseUpdateDto;
import com.jdcg.gymRecordApi.model.Exercise;

public class ExerciseMapper {

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

    public Exercise toExercise(ExerciseSaveDto exerciseSaveDto){
        Exercise exercise=new Exercise();
        exercise.setExerciseName(exerciseSaveDto.exerciseName());
        exercise.setExercisesNumberSeries(exerciseSaveDto.exercisesNumberSeries());
        exercise.setExerciseOrden(exerciseSaveDto.exerciseOrden());
        exercise.setExerciseMachine(exerciseSaveDto.exerciseMachine());
        exercise.setExerciseNotes(exerciseSaveDto.exerciseNotes());
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
