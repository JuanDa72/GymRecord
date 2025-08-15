package com.jdcg.gymRecordApi.Service;

import com.jdcg.gymRecordApi.dto.get.SessionGetDto;
import com.jdcg.gymRecordApi.dto.save.SessionSaveDto;
import com.jdcg.gymRecordApi.mapper.SessionMapper;
import com.jdcg.gymRecordApi.model.Routine;
import com.jdcg.gymRecordApi.model.Session;
import com.jdcg.gymRecordApi.repository.RoutineRepository;
import com.jdcg.gymRecordApi.repository.SessionRepository;

public class SessionService {

    private final SessionMapper sessionMapper;
    private final SessionRepository sessionRepository;

    private final RoutineRepository routineRepository;

    public SessionService(SessionMapper sessionMapper, SessionRepository sessionRepository, RoutineRepository routineRepository) {
        this.sessionMapper = sessionMapper;
        this.sessionRepository = sessionRepository;
        this.routineRepository = routineRepository;
    }

    //Save
    public SessionGetDto save(SessionSaveDto sessionSaveDto){
        Session session=sessionRepository.save(sessionMapper.toSession(sessionSaveDto));

    }

}
