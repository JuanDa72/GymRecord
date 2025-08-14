package com.jdcg.gymRecordApi.dto.update;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;

//TODO: No olvides aplicar validadores manuales en el service ya que aquí estamos aceptando todo nulo
public record SerieUpdateDto(
        Integer serieOrden,
        BigDecimal serieWeight,
        Integer serieRepetitions,
        String serieNotes

) {
}
