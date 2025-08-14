package com.jdcg.gymRecordApi.dto.save;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SerieSaveDto(

        @Min(value = 1, message = "The number of series must be greater than 0")
        Integer serieOrden,
        @NotNull(message = "Serie Weight date is required")
        @DecimalMin(value = "0.01", inclusive = true, message = "El valor debe ser mayor a 0")
        BigDecimal serieWeight,
        @Min(value = 1, message = "The number of series must be greater than 0")
        Integer serieRepetitions,
        String serieNotes

) {
}
