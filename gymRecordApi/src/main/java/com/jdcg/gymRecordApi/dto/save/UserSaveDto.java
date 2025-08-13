package com.jdcg.gymRecordApi.dto.save;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserSaveDto(
        @NotEmpty(message = "Name can´t be empty ")
        String userName,
        @NotEmpty(message = "Last name can´t be empty")
        String userLastName,
        @NotEmpty(message = "Email can´t be empty")
        @Email(message = "Insert a valid email address")
        String userEmail,
        @NotBlank(message = "The password can´t be blank")
        @Size(min = 8, max = 20,message = "The password must have a minimum of 8 and a maximum of 20 characters.")
        String userPassword


) {
}
