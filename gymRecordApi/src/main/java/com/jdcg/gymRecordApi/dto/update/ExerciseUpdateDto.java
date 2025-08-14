package com.jdcg.gymRecordApi.dto.update;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record ExerciseUpdateDto(

        String exerciseName,
        Integer exercisesNumberSeries,
        Integer exerciseOrden,
        String exerciseMachine,
        String exerciseNotes

) {
}
