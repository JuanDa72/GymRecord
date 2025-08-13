package com.jdcg.gymRecordApi.dto.get;

import com.jdcg.gymRecordApi.model.Exercise;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SerieGetDto(

        Integer serieId,
        Integer serieOrden,
        BigDecimal serieWeight,
        Integer serieRepetitions,
        LocalDateTime serieDate,
        String serieNotes

) {
}
