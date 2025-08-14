package com.jdcg.gymRecordApi.dto.get;

import java.util.List;

public record ExerciseGetDtoC(
        Integer exerciseId,
        String exerciseName,
        Integer exercisesNumberSeries,
        Integer exerciseOrden,
        String exerciseMachine,
        String exerciseNotes,
        List<SerieGetDto> series
) {
}

