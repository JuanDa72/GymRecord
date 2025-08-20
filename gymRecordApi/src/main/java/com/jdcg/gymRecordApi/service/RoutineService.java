package com.jdcg.gymRecordApi.service;

import com.jdcg.gymRecordApi.dto.get.RoutineGetDto;
import com.jdcg.gymRecordApi.dto.get.RoutineGetDtoC;
import com.jdcg.gymRecordApi.dto.get.SessionGetDto;
import com.jdcg.gymRecordApi.dto.save.RoutineSaveDto;
import com.jdcg.gymRecordApi.dto.update.RoutineUpdateDto;
import com.jdcg.gymRecordApi.mapper.RoutineMapper;
import com.jdcg.gymRecordApi.mapper.SessionMapper;
import com.jdcg.gymRecordApi.model.Routine;
import com.jdcg.gymRecordApi.model.User;
import com.jdcg.gymRecordApi.repository.RoutineRepository;
import com.jdcg.gymRecordApi.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutineService {

    private final RoutineMapper routineMapper;
    private final RoutineRepository routineRepository;

    private final UserRepository userRepository;

    private final SessionMapper sessionMapper;
    private final EntityManager entityManager;

    @Autowired
    public RoutineService(RoutineMapper routineMapper, RoutineRepository routineRepository,
                          UserRepository userRepository, SessionMapper sessionMapper,
                          EntityManager entityManager){
        this.routineMapper=routineMapper;
        this.routineRepository=routineRepository;
        this.userRepository=userRepository;
        this.sessionMapper=sessionMapper;
        this.entityManager=entityManager;
    }

    //Save
    @Transactional
    public RoutineGetDto save(RoutineSaveDto routineSaveDto){

        //Obtener el usuario al que pertenece
        User user=userRepository.findById(routineSaveDto.userId()).orElseThrow(()
                -> new RuntimeException("No user was found with this ID")
        );

        //Lo convertimos a routine y lo guardamos
        Routine routine=routineRepository.save(routineMapper.toRoutine(routineSaveDto));


        //Agregamos la nueva rutina al usuario
        user.getRoutines().add(routine);

        entityManager.refresh(routine);

        return routineMapper.toRoutineGetDto(routine);
    }



    //Update
    public RoutineGetDto update(Integer id, RoutineUpdateDto routineUpdateDto){
        Routine routine=routineRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No routine was found with this ID"));
        routine=routineMapper.updateToRoutine(routineUpdateDto,routine);
        return routineMapper.toRoutineGetDto(routineRepository.save(routine));
    }



    //Read
    public RoutineGetDto getRoutine(Integer id){
        Routine routine=routineRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No routine was found with this Id"));
        return routineMapper.toRoutineGetDto(routine);
    }

    public RoutineGetDtoC getRoutineC(Integer id){
        Routine routine=routineRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No routine was found with this Id"));
        return routineMapper.toRoutineGetDtoC(routine);
    }


    public List<RoutineGetDto> getAllRoutines(){
        return routineRepository.findAll().stream().map(routineMapper::toRoutineGetDto)
                .collect(Collectors.toList());
    }

    public List<RoutineGetDtoC> getAllRoutinesC(){
        return routineRepository.findAll().stream().map(routineMapper::toRoutineGetDtoC)
                .collect(Collectors.toList());
    }


    //Find by name
    public List<RoutineGetDto> getRoutinesByName(String routineName){
        return routineRepository.findAllByRoutineNameContaining(routineName).stream()
                .map(routineMapper::toRoutineGetDto).collect(Collectors.toList());
    }

    public List<RoutineGetDtoC> getRoutinesByNameC(String routineName){
        return routineRepository.findAllByRoutineNameContaining(routineName).stream()
                .map(routineMapper::toRoutineGetDtoC).collect(Collectors.toList());
    }


    //Obtener todas las sesiones de una determinada rutina
    public List<SessionGetDto> getSessionByRoutineId(Integer id){
        Routine routine=routineRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Not routine was found with this ID")
        );
        return routine.getSessions().stream().map(sessionMapper::toSessionGetDto).collect(Collectors.toList());
    }



    //Delete
    public void deleteRoutine(Integer id){
        Routine routine=routineRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No routine was found with this ID")
        );
        User user=routine.getUser();
        user.getRoutines().remove(routine);
        routineRepository.delete(routine);
    }





}
