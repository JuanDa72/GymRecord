package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.SessionGetDto;
import com.jdcg.gymRecordApi.dto.save.SessionSaveDto;
import com.jdcg.gymRecordApi.dto.update.SessionUpdateDto;
import com.jdcg.gymRecordApi.model.Session;

public class SessionMapper {

    public SessionGetDto toSessionGetDto(Session session){

        return new SessionGetDto(
                session.getSessionId(),
                session.getSessionName(),
                session.getSessionNotes()
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
