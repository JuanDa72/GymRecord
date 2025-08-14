package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.RoutineGetDto;
import com.jdcg.gymRecordApi.dto.save.RoutineSaveDto;
import com.jdcg.gymRecordApi.dto.update.RoutineUpdateDto;
import com.jdcg.gymRecordApi.model.Routine;

public class RoutineMapper {

    public RoutineGetDto toRoutineGetDto(Routine routine){
        return new RoutineGetDto(
                routine.getRoutineId(),
                routine.getRoutineName(),
                routine.getRoutineCreationDate(),
                routine.getRoutineLastAccess(),
                routine.getRoutineDescription()
        );
    }

    public Routine toRoutine(RoutineSaveDto routineSaveDto){
        Routine routine=new Routine();
        routine.setRoutineName(routineSaveDto.routineName());
        routine.setRoutineDescription(routineSaveDto.routineDescription());
        return routine;
    }

    public Routine updateToRoutine(RoutineUpdateDto routineUpdateDto, Routine routine){
        if(routineUpdateDto.routineName()!=null){
            routine.setRoutineName(routineUpdateDto.routineName());
        }
        if(routineUpdateDto.routineDescription()!=null){
            routine.setRoutineDescription(routineUpdateDto.routineDescription());
        }
        return routine;
    }


}
