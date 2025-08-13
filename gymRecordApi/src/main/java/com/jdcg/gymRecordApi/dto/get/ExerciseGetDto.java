package com.jdcg.gymRecordApi.dto.get;

public record ExerciseGetDto(
        Integer exerciseId,
        String exerciseName,
        Integer exercisesNumberSeries,
        Integer exerciseOrden,
        String exerciseMachine,
        String exerciseNotes

) {
}
