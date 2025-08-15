package com.jdcg.gymRecordApi.Service;

import com.jdcg.gymRecordApi.dto.get.UserGetDto;
import com.jdcg.gymRecordApi.dto.get.UserGetDtoC;
import com.jdcg.gymRecordApi.dto.save.UserSaveDto;
import com.jdcg.gymRecordApi.dto.update.UserUpdateDto;
import com.jdcg.gymRecordApi.mapper.UserMapper;
import com.jdcg.gymRecordApi.model.User;
import com.jdcg.gymRecordApi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserMapper userMapper, UserRepository userRepository){
        this.userMapper=userMapper;
        this.userRepository=userRepository;
    }

    //Save
    public UserGetDto save(UserSaveDto userSaveDto){
        User user=userMapper.toUser(userSaveDto);
        return userMapper.toUserGetDto(userRepository.save(user));
    }

    //Update
    public UserGetDto update(Integer id, UserUpdateDto userUpdateDto){
        //Encontramos el user con el ID
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("No user was found with this ID"));

        //Actualizamos
        user=userMapper.UpdateToUser(userUpdateDto,user);
        return userMapper.toUserGetDto(userRepository.save(user));

    }

    //Read, aquí si pondremos ambos casos retornar con y sin la lista de las rutinas
    public UserGetDto getUser(Integer id){
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("No user was found with this ID"));
        return userMapper.toUserGetDto(user);
    }

    public UserGetDtoC getUserC(Integer id){
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("No user was found with this ID"));
        return userMapper.toUserGetDtoC(user);
    }

    public List<UserGetDto> getAllUser(){
        return userRepository.findAll().stream().map(userMapper::toUserGetDto).collect(Collectors.toList());
    }

    public List<UserGetDtoC> getAllUserC(){
        return userRepository.findAll().stream().map(userMapper::toUserGetDtoC).collect(Collectors.toList());
    }


    //Find by Email -> Útil para login
    public UserGetDto getUserByEmail(String userEmail){
        User user=userRepository.findByUserEmail(userEmail);
        if (user == null) {
            throw new RuntimeException("No user was found with this email");
        }
        return userMapper.toUserGetDto(user);
    }

    public UserGetDtoC getUserByEmailC(String userEmail){
        User user=userRepository.findByUserEmail(userEmail);
        if (user == null) {
            throw new RuntimeException("No user was found with this email");
        }
        return userMapper.toUserGetDtoC(user);
    }



    //Delete
    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }


}
