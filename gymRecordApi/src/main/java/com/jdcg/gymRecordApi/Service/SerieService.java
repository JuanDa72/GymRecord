package com.jdcg.gymRecordApi.Service;

import com.jdcg.gymRecordApi.dto.get.SerieGetDto;
import com.jdcg.gymRecordApi.dto.save.ExerciseSaveDto;
import com.jdcg.gymRecordApi.dto.save.SerieSaveDto;
import com.jdcg.gymRecordApi.dto.update.SerieUpdateDto;
import com.jdcg.gymRecordApi.mapper.ExerciseMapper;
import com.jdcg.gymRecordApi.mapper.SerieMapper;
import com.jdcg.gymRecordApi.model.Exercise;
import com.jdcg.gymRecordApi.model.Serie;
import com.jdcg.gymRecordApi.repository.ExerciseRepository;
import com.jdcg.gymRecordApi.repository.SerieRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SerieService {

    private final SerieMapper serieMapper;
    private final SerieRepository serieRepository;
    private final ExerciseRepository exerciseRepository;

    public SerieService(SerieMapper serieMapper, SerieRepository serieRepository, ExerciseRepository exerciseRepository) {
        this.serieMapper = serieMapper;
        this.serieRepository = serieRepository;
        this.exerciseRepository = exerciseRepository;
    }


    //Save
    public SerieGetDto save(SerieSaveDto serieSaveDto) {
        //Encontramos el ejercicio al que pertenece
        Exercise exercise = exerciseRepository.findById(serieSaveDto.exerciseId()).orElseThrow(
                () -> new RuntimeException("No exercise was found with this ID")
        );

        //Guardamos la serie
        Serie serie = serieRepository.save(serieMapper.toSerie(serieSaveDto));

        //Actualizamos la lista de series en exercise
        exercise.getSeries().add(serie);

        return serieMapper.toSerieGetDto(serie);
    }



    //Update
    public SerieGetDto update(Integer id, SerieUpdateDto serieUpdateDto){
        //Verificar que si exista el serie
        Serie serie=serieRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No serie was found with this ID")
        );

        serie=serieMapper.updateToserie(serieUpdateDto,serie);
        return serieMapper.toSerieGetDto(serie);

    }



    //Read
    public SerieGetDto getSerie(Integer id){
        Serie serie=serieRepository.findById(id).orElseThrow(
                ()->new RuntimeException("No serie was found with this ID")
        );

        return serieMapper.toSerieGetDto(serie);
    }


    public List<SerieGetDto> getAllSeries(){
        return serieRepository.findAll().stream().map(serieMapper::toSerieGetDto).collect(Collectors.toList());

    }



    //Delete
    public void delete(Integer id){
        //Verificamos que exista
        if(!serieRepository.existsById(id)){
            throw new RuntimeException("No serie was found with this ID");
        }

        serieRepository.deleteById(id);

    }


}
