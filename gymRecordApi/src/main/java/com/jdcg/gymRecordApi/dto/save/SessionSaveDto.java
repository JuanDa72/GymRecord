package com.jdcg.gymRecordApi.dto.save;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SessionSaveDto(

        @NotEmpty(message = "Name can´t be empty ")
        String sessionName,
        String sessionNotes,
        @NotNull(message = "Routine id can´t be null")
        @Min(value = 1,message = "Routine id must be greater than 0")
        Integer routineId

) {
}
