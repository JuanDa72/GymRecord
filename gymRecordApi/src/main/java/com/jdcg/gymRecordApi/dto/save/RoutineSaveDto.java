package com.jdcg.gymRecordApi.dto.save;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RoutineSaveDto(

        @NotEmpty(message = "Name can´t be empty ")
        String routineName,

        String routineDescription,
        @NotNull(message = "User id can´t be null")
        @Min(value = 1, message = "The user id must to be greater than 0")
        Integer userId

) {
}
