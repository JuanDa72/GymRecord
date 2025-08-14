package com.jdcg.gymRecordApi.dto.update;

import com.jdcg.gymRecordApi.dto.get.RoutineGetDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//Permitiremos datos nulos pero posteriormente tendremos que agregar la lógica en el service
//de solo modificar los datos que no vengan nulos.
public record UserUpdateDto(

        String userName,
        String userLastName,
        String userEmail,
        String userPassword,
        LocalDate userBirthdate,
        String userPhoneNumber,
        String userGender,
        BigDecimal userWeight,
        List<RoutineGetDto> routines

) {
}
