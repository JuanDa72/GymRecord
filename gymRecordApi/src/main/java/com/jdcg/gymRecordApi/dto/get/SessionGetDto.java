package com.jdcg.gymRecordApi.dto.get;

public record SessionGetDto(
        Integer sessionId,
        String sessionName,
        String sessionNotes

) {
}
