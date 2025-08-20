package com.jdcg.gymRecordApi.controller;

import com.jdcg.gymRecordApi.dto.get.RoutineGetDto;
import com.jdcg.gymRecordApi.dto.get.RoutineGetDtoC;
import com.jdcg.gymRecordApi.dto.get.SessionGetDto;
import com.jdcg.gymRecordApi.dto.save.RoutineSaveDto;
import com.jdcg.gymRecordApi.dto.update.RoutineUpdateDto;
import com.jdcg.gymRecordApi.service.RoutineService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class routineController {

    private final RoutineService routineService;


    public routineController(RoutineService routineService) {
        this.routineService = routineService;
    }


    @PostMapping("/routine")
    public RoutineGetDto save(@Valid @RequestBody RoutineSaveDto routineSaveDto) {
        return routineService.save(routineSaveDto);
    }



    @PutMapping("/routine/{id}")
    public RoutineGetDto update(@PathVariable Integer id, @RequestBody RoutineUpdateDto routineUpdateDto){
        return routineService.update(id, routineUpdateDto);
    }



    @GetMapping("/routine/{id}")
    public RoutineGetDto getRoutine(@PathVariable Integer id){
        return routineService.getRoutine(id);
    }

    @GetMapping("/routine/c/{id}")
    public RoutineGetDtoC getRoutineC(@PathVariable Integer id){
        return routineService.getRoutineC(id);
    }


    @GetMapping("/routines")
    public List<RoutineGetDto> getAllRoutines(){
        return routineService.getAllRoutines();
    }

    @GetMapping("/routines/c")
    public List<RoutineGetDtoC> getAllRoutinesC(){
        return routineService.getAllRoutinesC();
    }


    @GetMapping("/routines/search")
    public List<RoutineGetDto> getRoutineByName(@RequestParam String name){
        return routineService.getRoutinesByName(name);
    }

    @GetMapping("/routines/c/search")
    public List<RoutineGetDtoC> getRoutineByNameC(@RequestParam String name){
        return routineService.getRoutinesByNameC(name);
    }



    @GetMapping("/routine/sessions/{id}")
    public List<SessionGetDto> getSessionByRoutineId(@PathVariable Integer id){
        return routineService.getSessionByRoutineId(id);
    }



    @DeleteMapping("/routine/{id}")
    public void deleteRoutine(@PathVariable Integer id){
        routineService.deleteRoutine(id);
    }


}
