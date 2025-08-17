package com.jdcg.gymRecordApi.service;

import com.jdcg.gymRecordApi.dto.get.ExerciseGetDto;
import com.jdcg.gymRecordApi.dto.get.SessionGetDto;
import com.jdcg.gymRecordApi.dto.get.SessionGetDtoC;
import com.jdcg.gymRecordApi.dto.save.SessionSaveDto;
import com.jdcg.gymRecordApi.dto.update.SessionUpdateDto;
import com.jdcg.gymRecordApi.mapper.ExerciseMapper;
import com.jdcg.gymRecordApi.mapper.SessionMapper;
import com.jdcg.gymRecordApi.model.Routine;
import com.jdcg.gymRecordApi.model.Session;
import com.jdcg.gymRecordApi.repository.RoutineRepository;
import com.jdcg.gymRecordApi.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class SessionService {

    private final SessionMapper sessionMapper;
    private final SessionRepository sessionRepository;
    private final RoutineRepository routineRepository;
    private final ExerciseMapper exerciseMapper;

     @Autowired
    public SessionService(SessionMapper sessionMapper, SessionRepository sessionRepository
            , RoutineRepository routineRepository, ExerciseMapper exerciseMapper) {
        this.sessionMapper = sessionMapper;
        this.sessionRepository = sessionRepository;
        this.routineRepository = routineRepository;
        this.exerciseMapper=exerciseMapper;
    }

    //Save
    public SessionGetDto save(SessionSaveDto sessionSaveDto){
        //Obtener la rutina a la que pertenece
        Routine routine=routineRepository.findById(sessionSaveDto.routineId()).orElseThrow(
                ()->new RuntimeException("No routine waos found with this ID")
        );

        //Lo convertimos a session y lo guardamos
        Session session=sessionRepository.save(sessionMapper.toSession(sessionSaveDto));

        //Agregamos esta session a la rutina correspondiente
        routine.getSessions().add(session);

        return sessionMapper.toSessionGetDto(session);

    }



    //Update
    public SessionGetDto update(Integer id, SessionUpdateDto sessionUpdateDto){
        //Verificamos que exista la session
        Session session=sessionRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No Session was found with this id")
        );

        //Actualizamos
        session=sessionMapper.updateToSession(sessionUpdateDto,session);

        return sessionMapper.toSessionGetDto(session);
    }



    //Read
    public SessionGetDto getSession(Integer id){
        Session session=sessionRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No Session was found with this ID")
        );
        return sessionMapper.toSessionGetDto(session);
    }

    public SessionGetDtoC getSessionC(Integer id){
        Session session=sessionRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No Session was found with this ID")
        );
        return sessionMapper.toSessionGetDtoC(session);
    }


    public List<SessionGetDto> getAllSession(){
        return sessionRepository.findAll().stream().
                map(sessionMapper::toSessionGetDto).collect(Collectors.toList());
    }

    public List<SessionGetDtoC> getAllSessionC(){
        return sessionRepository.findAll().stream().
                map(sessionMapper::toSessionGetDtoC).collect(Collectors.toList());
    }


    //Obteniendo todos los ejercicios de una session
    public List<ExerciseGetDto> getAllExerciseBySessionId(Integer id){
        Session session=sessionRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No Session was found with this ID")
        );
        return session.getExercises().stream().map(exerciseMapper::toExerciseGetDto).collect(Collectors.toList());
    }



    //Delete
    public void delete(Integer id){
        if(!sessionRepository.existsById(id)){
            throw new RuntimeException("No Session was found with this ID");
        }
        sessionRepository.deleteById(id);



    }



}
