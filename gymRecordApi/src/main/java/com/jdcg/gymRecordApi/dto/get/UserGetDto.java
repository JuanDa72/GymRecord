package com.jdcg.gymRecordApi.dto.get;

import java.math.BigDecimal;

public record UserGetDto(

        Integer userId,
        String userName,
        String userLastName,
        String userEmail,

        String userPhoneNumber,

        String UserGender,

        BigDecimal userWeight

) {

}
