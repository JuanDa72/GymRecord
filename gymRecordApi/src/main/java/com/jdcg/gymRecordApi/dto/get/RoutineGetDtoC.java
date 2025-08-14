package com.jdcg.gymRecordApi.dto.get;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record RoutineGetDtoC(
        Integer routineId,
        String routineName,
        LocalDate routineCreationDate,
        LocalDateTime routineLastAccess,
        String routineDescription,
        List<SessionGetDto> sessions
) {}
