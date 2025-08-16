package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.SerieGetDto;
import com.jdcg.gymRecordApi.dto.save.SerieSaveDto;
import com.jdcg.gymRecordApi.dto.update.SerieUpdateDto;
import com.jdcg.gymRecordApi.model.Exercise;
import com.jdcg.gymRecordApi.model.Serie;
import com.jdcg.gymRecordApi.repository.ExerciseRepository;

public class SerieMapper {

    ExerciseRepository exerciseRepository;

    public SerieMapper(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public SerieGetDto toSerieGetDto(Serie serie){
        return new SerieGetDto(
                serie.getSerieId(),
                serie.getSerieOrden(),
                serie.getSerieWeight(),
                serie.getSerieRepetitions(),
                serie.getSerieDate(),
                serie.getSerieNotes()
        );
    }

    public Serie toSerie(SerieSaveDto serieSaveDto){
        Serie serie=new Serie();
        serie.setSerieOrden(serieSaveDto.serieOrden());
        serie.setSerieWeight(serieSaveDto.serieWeight());
        serie.setSerieRepetitions(serieSaveDto.serieRepetitions());
        serie.setSerieNotes(serieSaveDto.serieNotes());

        //Verificar que exista el ejercicio
        Exercise exercise=exerciseRepository.findById(serieSaveDto.exerciseId()).
                orElseThrow(()->new RuntimeException("No exercise was found with this id"));
        serie.setExercise(exercise);
        return serie;
    }

    public Serie updateToserie(SerieUpdateDto serieUpdateDto, Serie serie){
        if(serieUpdateDto.serieOrden()!=null){
            serie.setSerieOrden(serieUpdateDto.serieOrden());
        }
        if(serieUpdateDto.serieWeight()!=null){
            serie.setSerieWeight(serieUpdateDto.serieWeight());
        }
        if(serieUpdateDto.serieRepetitions()!=null){
            serie.setSerieWeight(serieUpdateDto.serieWeight());
        }
        if(serieUpdateDto.serieNotes()!=null){
            serie.setSerieNotes(serieUpdateDto.serieNotes());
        }
        return serie;
    }


}
