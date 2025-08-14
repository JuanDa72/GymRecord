package com.jdcg.gymRecordApi.dto.update;

import jakarta.validation.constraints.NotEmpty;

public record SessionUpdateDto(
        String sessionName,
        String sessionNotes
) {
}
