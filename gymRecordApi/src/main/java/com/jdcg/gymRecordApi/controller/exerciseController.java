package com.jdcg.gymRecordApi.controller;

import com.jdcg.gymRecordApi.dto.get.ExerciseGetDto;
import com.jdcg.gymRecordApi.dto.get.ExerciseGetDtoC;
import com.jdcg.gymRecordApi.dto.get.SerieGetDto;
import com.jdcg.gymRecordApi.dto.get.SessionGetDto;
import com.jdcg.gymRecordApi.dto.save.ExerciseSaveDto;
import com.jdcg.gymRecordApi.dto.update.ExerciseUpdateDto;
import com.jdcg.gymRecordApi.model.Serie;
import com.jdcg.gymRecordApi.service.ExerciseService;
import jakarta.persistence.PreUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class exerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public exerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }


    @PostMapping("/exercise")
    public ExerciseGetDto save(@Valid @RequestBody ExerciseSaveDto exerciseSaveDto) {
        return exerciseService.save(exerciseSaveDto);
    }


    @PutMapping("/exercise/{id}")
    public ExerciseGetDto update(@PathVariable Integer id, @RequestBody ExerciseUpdateDto exerciseUpdateDto) {
        return exerciseService.update(id, exerciseUpdateDto);
    }


    @GetMapping("/exercise/{id}")
    public ExerciseGetDto getExercise(@PathVariable Integer id) {
        return exerciseService.getExercise(id);
    }

    @GetMapping("/exercise/c/{id}")
    public ExerciseGetDtoC getExerciseC(@PathVariable Integer id) {
        return exerciseService.getExerciseC(id);
    }


    @GetMapping("/exercises")
    public List<ExerciseGetDto> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/exercises/c")
    public List<ExerciseGetDtoC> getAllExercisesC() {
        return exerciseService.getAllExercisesC();
    }


    @GetMapping("/exercise/series/{id}")
    public List<SerieGetDto> getAllSeriesByExerciseId(@PathVariable Integer id) {
        return exerciseService.getAllSeriesByExerciseId(id);
    }


    @DeleteMapping("/exercise/{id}")
    public void delete(@PathVariable Integer id) {
        exerciseService.delete(id);
    }




}
