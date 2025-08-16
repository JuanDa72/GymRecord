package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.SessionGetDto;
import com.jdcg.gymRecordApi.dto.get.SessionGetDtoC;
import com.jdcg.gymRecordApi.dto.save.SessionSaveDto;
import com.jdcg.gymRecordApi.dto.update.SessionUpdateDto;
import com.jdcg.gymRecordApi.model.Routine;
import com.jdcg.gymRecordApi.model.Session;
import com.jdcg.gymRecordApi.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class SessionMapper {

    public ExerciseMapper exerciseMapper;

    public RoutineRepository routineRepository;

    @Autowired
    public SessionMapper(ExerciseMapper exerciseMapper, RoutineRepository routineRepository){
        this.exerciseMapper=exerciseMapper;
        this.routineRepository=routineRepository;
    }


    public SessionGetDto toSessionGetDto(Session session){

        return new SessionGetDto(
                session.getSessionId(),
                session.getSessionName(),
                session.getSessionNotes()
        );
    }

    public SessionGetDtoC toSessionGetDtoC(Session session){

        return new SessionGetDtoC(
                session.getSessionId(),
                session.getSessionName(),
                session.getSessionNotes(),
                session.getExercises().stream().map(exerciseMapper::toExerciseGetDto).collect(Collectors.toList())
        );
    }


    public Session toSession(SessionSaveDto sessionSaveDto){
        Session session=new Session();
        session.setSessionName(sessionSaveDto.sessionName());
        session.setSessionNotes(sessionSaveDto.sessionNotes());

        //Verificar que la rutina si exista
        Routine routine=routineRepository.findById(sessionSaveDto.routineId()).orElseThrow(
                ()->new RuntimeException("No routine was found with this ID")
        );
        session.setRoutine(routine);
        return session;
    }

    public Session updateToSession(SessionUpdateDto sessionUpdateDto, Session session){
        if(sessionUpdateDto.sessionName()!=null){
            session.setSessionName(sessionUpdateDto.sessionName());
        }
        if(sessionUpdateDto.sessionNotes()!=null){
            session.setSessionNotes(sessionUpdateDto.sessionNotes());
        }
        return session;
    }


}
