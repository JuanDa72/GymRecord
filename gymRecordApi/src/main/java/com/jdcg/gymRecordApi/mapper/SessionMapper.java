package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.SessionGetDto;
import com.jdcg.gymRecordApi.dto.get.SessionGetDtoC;
import com.jdcg.gymRecordApi.dto.save.SessionSaveDto;
import com.jdcg.gymRecordApi.dto.update.SessionUpdateDto;
import com.jdcg.gymRecordApi.model.Session;

import java.util.stream.Collectors;

public class SessionMapper {

    public ExerciseMapper exerciseMapper;

    public SessionMapper(ExerciseMapper exerciseMapper){
        this.exerciseMapper=exerciseMapper;
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
