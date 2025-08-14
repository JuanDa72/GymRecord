package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.SerieGetDto;
import com.jdcg.gymRecordApi.dto.save.SerieSaveDto;
import com.jdcg.gymRecordApi.dto.update.SerieUpdateDto;
import com.jdcg.gymRecordApi.model.Serie;

public class SerieMapper {

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
