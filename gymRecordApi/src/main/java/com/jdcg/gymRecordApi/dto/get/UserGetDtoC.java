package com.jdcg.gymRecordApi.dto.get;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record UserGetDtoC(
        Integer userId,
        String userName,
        String userLastName,
        String userEmail,

        String userPhoneNumber,

        String UserGender,

        BigDecimal userWeight,
        List<RoutineGetDto> routines
) {}

