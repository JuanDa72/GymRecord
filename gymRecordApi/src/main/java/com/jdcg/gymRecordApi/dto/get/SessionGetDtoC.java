package com.jdcg.gymRecordApi.dto.get;

import java.util.List;

public record SessionGetDtoC(
        Integer sessionId,
        String sessionName,
        String sessionNotes,
        List<ExerciseGetDto> exercises
) {}
