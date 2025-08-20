package com.jdcg.gymRecordApi.controller;

import com.jdcg.gymRecordApi.dto.get.RoutineGetDto;
import com.jdcg.gymRecordApi.dto.get.UserGetDto;
import com.jdcg.gymRecordApi.dto.get.UserGetDtoC;
import com.jdcg.gymRecordApi.dto.save.UserSaveDto;
import com.jdcg.gymRecordApi.dto.update.UserUpdateDto;
import com.jdcg.gymRecordApi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/user/{id}")
    public UserGetDto update(@Valid @PathVariable Integer id, @RequestBody UserUpdateDto userUpdateDto){
        return userService.update(id,userUpdateDto);
    }

    @GetMapping("/user/{id}")
    public UserGetDto getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @GetMapping("/user/c/{id}")
    public UserGetDtoC getUserC(@PathVariable Integer id){
        return userService.getUserC(id);
    }

    @GetMapping("/users")
    public List<UserGetDto> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/users/c")
    public List<UserGetDtoC> getAllUserC(){
        return userService.getAllUserC();
    }


    @GetMapping("/user/search")
    public UserGetDto getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/user/search/c")
    public UserGetDtoC getUserByEmailC(@RequestParam String email){
        return userService.getUserByEmailC(email);
    }



    @GetMapping("/user/routines/{id}")
    public List<RoutineGetDto> getRoutinesByUserId(@PathVariable Integer id){
        return userService.getRoutinesByUserId(id);
    }



    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }


}
