package com.jdcg.gymRecordApi.dto.get;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RoutineGetDto(

        Integer routineId,
        String routineName,
        LocalDate routineCreationDate,
        LocalDateTime routineLastAccess,
        String routineDescription

) {
}
