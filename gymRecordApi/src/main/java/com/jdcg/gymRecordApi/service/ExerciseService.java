package com.jdcg.gymRecordApi.service;

import com.jdcg.gymRecordApi.dto.get.ExerciseGetDto;
import com.jdcg.gymRecordApi.dto.get.ExerciseGetDtoC;
import com.jdcg.gymRecordApi.dto.get.SerieGetDto;
import com.jdcg.gymRecordApi.dto.save.ExerciseSaveDto;
import com.jdcg.gymRecordApi.dto.update.ExerciseUpdateDto;
import com.jdcg.gymRecordApi.mapper.ExerciseMapper;
import com.jdcg.gymRecordApi.mapper.SerieMapper;
import com.jdcg.gymRecordApi.model.Exercise;
import com.jdcg.gymRecordApi.model.Serie;
import com.jdcg.gymRecordApi.model.Session;
import com.jdcg.gymRecordApi.repository.ExerciseRepository;
import com.jdcg.gymRecordApi.repository.SerieRepository;
import com.jdcg.gymRecordApi.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ExerciseService {

    private final ExerciseMapper exerciseMapper;
    private final ExerciseRepository exerciseRepository;
    private final SessionRepository sessionRepository;
    private final SerieMapper serieMapper;

    private final SerieRepository serieRepository;

    @Autowired
    public ExerciseService(ExerciseMapper exerciseMapper, ExerciseRepository exerciseRepository,
                           SessionRepository sessionRepository, SerieMapper serieMapper,
                           SerieRepository serieRepository) {
        this.exerciseMapper = exerciseMapper;
        this.exerciseRepository = exerciseRepository;
        this.sessionRepository = sessionRepository;
        this.serieMapper = serieMapper;
        this.serieRepository = serieRepository;
    }

    //Save
    public ExerciseGetDto save(ExerciseSaveDto exerciseSaveDto){
        //Encontramos la session a la que pertenece
        Session session=sessionRepository.findById(exerciseSaveDto.sessionId()).orElseThrow(
                ()->new RuntimeException("No session was found with this ID")
        );

        //Guardamos el ejercicio
        Exercise exercise=exerciseRepository.save(exerciseMapper.toExercise(exerciseSaveDto));

        //Actualizamos la lista de exercises en Session
        session.getExercises().add(exercise);

        return exerciseMapper.toExerciseGetDto(exercise);

    }



    //Update
    public ExerciseGetDto update(Integer id, ExerciseUpdateDto exerciseUpdateDto) {
        //Verificamos que exista el exercise
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No exercise was found with this ID")
        );

        exercise=exerciseMapper.updateToExercise(exerciseUpdateDto,exercise);
        return exerciseMapper.toExerciseGetDto(exercise);

    }



    //Read
    public ExerciseGetDto getExercise(Integer id){
        Exercise exercise=exerciseRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No exercise was found with this ID")
        );

        return exerciseMapper.toExerciseGetDto(exercise);

    }

    public ExerciseGetDtoC getExerciseC(Integer id){
        Exercise exercise=exerciseRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No exercise was found with this ID")
        );

        return exerciseMapper.toExerciseGetDtoC(exercise);

    }


    public List<ExerciseGetDto> getAllExercises(){
        return exerciseRepository.findAll().stream().map
                (exerciseMapper::toExerciseGetDto).collect(Collectors.toList());

    }

    public List<ExerciseGetDtoC> getAllExercisesC(){
        return exerciseRepository.findAll().stream().map
                (exerciseMapper::toExerciseGetDtoC).collect(Collectors.toList());

    }


    public List<SerieGetDto> getAllSeriesByExerciseId(Integer id){
        Exercise exercise=exerciseRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No exercise was found with this ID")
        );

        List<Serie> series=serieRepository.findByExerciseIdOrderByCreatedAtDesc(id);
        return series.stream().map(serieMapper::toSerieGetDto).collect(Collectors.toList());

    }



    //Delete
    public void delete(Integer id){
        if(!exerciseRepository.existsById(id)){
            throw new RuntimeException("No exercise was found with this ID");
        }

        exerciseRepository.deleteById(id);

    }


}
