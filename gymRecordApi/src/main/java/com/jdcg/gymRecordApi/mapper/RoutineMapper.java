package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.RoutineGetDto;
import com.jdcg.gymRecordApi.dto.get.RoutineGetDtoC;
import com.jdcg.gymRecordApi.dto.save.RoutineSaveDto;
import com.jdcg.gymRecordApi.dto.save.SerieSaveDto;
import com.jdcg.gymRecordApi.dto.update.RoutineUpdateDto;
import com.jdcg.gymRecordApi.model.Routine;

import java.util.stream.Collectors;

public class RoutineMapper {

    public SessionMapper sessionMapper;

    public RoutineMapper(SessionMapper sessionMapper){
        this.sessionMapper=sessionMapper;
    }

    public RoutineGetDto toRoutineGetDto(Routine routine){
        return new RoutineGetDto(
                routine.getRoutineId(),
                routine.getRoutineName(),
                routine.getRoutineCreationDate(),
                routine.getRoutineLastAccess(),
                routine.getRoutineDescription()
        );
    }

    public RoutineGetDtoC toRoutineGetDtoC(Routine routine){
        return new RoutineGetDtoC(
                routine.getRoutineId(),
                routine.getRoutineName(),
                routine.getRoutineCreationDate(),
                routine.getRoutineLastAccess(),
                routine.getRoutineDescription(),
                routine.getSessions().stream().map(sessionMapper::toSessionGetDto).collect(Collectors.toList())
        );
    }


    public Routine toRoutine(RoutineSaveDto routineSaveDto){
        Routine routine=new Routine();
        routine.setRoutineName(routineSaveDto.routineName());
        routine.setRoutineDescription(routineSaveDto.routineDescription()),
                //Todo: ARREGLAR 
        routine.setUser(routineSaveDto);
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
