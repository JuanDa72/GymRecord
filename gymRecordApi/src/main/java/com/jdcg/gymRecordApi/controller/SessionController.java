package com.jdcg.gymRecordApi.controller;


import com.jdcg.gymRecordApi.dto.get.ExerciseGetDto;
import com.jdcg.gymRecordApi.dto.get.SessionGetDto;
import com.jdcg.gymRecordApi.dto.get.SessionGetDtoC;
import com.jdcg.gymRecordApi.dto.save.SessionSaveDto;
import com.jdcg.gymRecordApi.dto.update.SessionUpdateDto;
import com.jdcg.gymRecordApi.model.Session;
import com.jdcg.gymRecordApi.service.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }


    @PostMapping("/session")
    public SessionGetDto save(@Valid  @RequestBody SessionSaveDto sessionSaveDto){
        return sessionService.save(sessionSaveDto);
    }



    @PutMapping("/session/{id}")
    public SessionGetDto update(@PathVariable Integer id, @RequestBody SessionUpdateDto sessionUpdateDto){
        return sessionService.update(id, sessionUpdateDto);
    }



    @GetMapping("/session/{id}")
    public SessionGetDto getSession(@PathVariable Integer id){
        return sessionService.getSession(id);
    }

    @GetMapping("/session/c/{id}")
    public SessionGetDtoC getSessionC(@PathVariable Integer id){
        return sessionService.getSessionC(id);
    }


    @GetMapping("/sessions")
    public List<SessionGetDto> getAllSession(){
        return sessionService.getAllSession();
    }

    @GetMapping("/sessions/c")
    public List<SessionGetDtoC> getAllSessionC(){
        return sessionService.getAllSessionC();
    }


    @GetMapping("/session/exercises/{id}")
    public List<ExerciseGetDto> getAllExerciseBySessionId(@PathVariable Integer id){
        return sessionService.getAllExerciseBySessionId(id);
    }



    @DeleteMapping("/session/{id}")
    public void deleteSession(@PathVariable Integer id){
        sessionService.delete(id);
    }



}
