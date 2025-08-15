package com.jdcg.gymRecordApi.Service;

import com.jdcg.gymRecordApi.dto.get.RoutineGetDto;
import com.jdcg.gymRecordApi.dto.get.RoutineGetDtoC;
import com.jdcg.gymRecordApi.dto.save.RoutineSaveDto;
import com.jdcg.gymRecordApi.dto.update.RoutineUpdateDto;
import com.jdcg.gymRecordApi.mapper.RoutineMapper;
import com.jdcg.gymRecordApi.model.Routine;
import com.jdcg.gymRecordApi.model.User;
import com.jdcg.gymRecordApi.repository.RoutineRepository;
import com.jdcg.gymRecordApi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutineService {

    private final RoutineMapper routineMapper;
    private final RoutineRepository routineRepository;

    private final UserRepository userRepository;

    public RoutineService(RoutineMapper routineMapper, RoutineRepository routineRepository,
                          UserRepository userRepository){
        this.routineMapper=routineMapper;
        this.routineRepository=routineRepository;
        this.userRepository=userRepository;
    }

    //Save
    public RoutineGetDto save(RoutineSaveDto routineSaveDto){
        Routine routine=routineRepository.save(routineMapper.toRoutine(routineSaveDto));

        //Obtener el usuario al que pertenece
        User user=userRepository.findById(routine.getUser().getUserId()).orElseThrow(()
                -> new RuntimeException("No user was found with this ID")
        );

        user.getRoutines().add(routine);

        return routineMapper.toRoutineGetDto(routine);
    }



    //Update
    public RoutineGetDto update(Integer id, RoutineUpdateDto routineUpdateDto){
        Routine routine=routineRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No routine was found with this ID"));
        routine=routineMapper.updateToRoutine(routineUpdateDto,routine);
        return routineMapper.toRoutineGetDto(routine);
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



    //Delete
    public void deleteRoutine(Integer id){
        if(!routineRepository.existsById(id)){
            throw new RuntimeException("Routine not found with this ID"+id);
        }
        routineRepository.deleteById(id);
    }





}
