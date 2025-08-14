package com.jdcg.gymRecordApi.mapper;

import com.jdcg.gymRecordApi.dto.get.UserGetDto;
import com.jdcg.gymRecordApi.dto.get.UserGetDtoC;
import com.jdcg.gymRecordApi.dto.save.UserSaveDto;
import com.jdcg.gymRecordApi.dto.update.UserUpdateDto;
import com.jdcg.gymRecordApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class UserMapper {

    RoutineMapper routineMapper;

    @Autowired
    public UserMapper(RoutineMapper routineMapper){
        this.routineMapper=routineMapper;
    }

    //Mapper para get
    public UserGetDto toUserGetDto(User user){
        return new UserGetDto(
                user.getUserId(),
                user.getUserName(),
                user.getUserLastName(),
                user.getUserEmail(),
                user.getUserPhoneNumber(),
                user.getUserGender(),
                user.getUserWeight()
        );
    }

    public UserGetDtoC toUserGetDtoC(User user){
        return new UserGetDtoC(
                user.getUserId(),
                user.getUserName(),
                user.getUserLastName(),
                user.getUserEmail(),
                user.getUserPhoneNumber(),
                user.getUserGender(),
                user.getUserWeight(),
                user.getRoutines().stream().map(routineMapper::toRoutineGetDto).collect(Collectors.toList())
        );
    }



    //Mapper para save (userSaveDto --> user )
    public User toUser(UserSaveDto userSaveDto){
        User user=new User();
        user.setUserName(userSaveDto.userName());
        user.setUserLastName(userSaveDto.userLastName());
        user.setUserEmail(userSaveDto.userEmail());
        user.setUserPassword(userSaveDto.userPassword());
        user.setUserBirthdate(userSaveDto.userBirthdate());
        user.setUserPhoneNumber(userSaveDto.userPhoneNumber());
        user.setUserGender(userSaveDto.userGender());
        user.setUserWeight(userSaveDto.userWeight());

        return user;

    }


    //Mapper para update
    public User UpdateToUser(UserUpdateDto userUpdateDto, User user){
        if (userUpdateDto.userName() != null) {
            user.setUserName(userUpdateDto.userName());
        }
        if (userUpdateDto.userLastName() != null) {
            user.setUserLastName(userUpdateDto.userLastName());
        }
        if (userUpdateDto.userEmail() != null) {
            user.setUserEmail(userUpdateDto.userEmail());
        }
        if (userUpdateDto.userPassword() != null) {
            user.setUserPassword(userUpdateDto.userPassword());
        }
        if (userUpdateDto.userBirthdate() != null) {
            user.setUserBirthdate(userUpdateDto.userBirthdate());
        }
        if (userUpdateDto.userPhoneNumber() != null) {
            user.setUserPhoneNumber(userUpdateDto.userPhoneNumber());
        }
        if (userUpdateDto.userGender() != null) {
            user.setUserGender(userUpdateDto.userGender());
        }
        if (userUpdateDto.userWeight() != null) {
            user.setUserWeight(userUpdateDto.userWeight());
        }
        
        return user;
    }


}
