package com.jdcg.gymRecordApi.controller;

import com.jdcg.gymRecordApi.dto.get.UserGetDto;
import com.jdcg.gymRecordApi.dto.save.UserSaveDto;
import com.jdcg.gymRecordApi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    private final UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserGetDto save(@Valid @RequestBody UserSaveDto userSaveDto){
        return userService.save(userSaveDto);
    }




}
