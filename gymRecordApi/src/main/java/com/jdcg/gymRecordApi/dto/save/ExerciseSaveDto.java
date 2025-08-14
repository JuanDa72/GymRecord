package com.jdcg.gymRecordApi.dto.save;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record ExerciseSaveDto(
        @NotEmpty(message = "Name can´t be empty ")
        String exerciseName,
        @Min(value = 1, message = "The number of series must be greater than 0")
        Integer exercisesNumberSeries,
        @Min(value = 1, message = "The number of series must be greater than 0")
        Integer exerciseOrden,
        String exerciseMachine,
        String exerciseNotes


) {
}
