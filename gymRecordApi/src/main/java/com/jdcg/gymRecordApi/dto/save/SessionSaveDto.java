package com.jdcg.gymRecordApi.dto.save;

import jakarta.validation.constraints.NotEmpty;

public record SessionSaveDto(

        @NotEmpty(message = "Name can´t be empty ")
        String sessionName,
        String sessionNotes

) {
}
