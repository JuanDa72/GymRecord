package com.jdcg.gymRecordApi.repository;

import com.jdcg.gymRecordApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    //TODO: Tenemos que mirar si hay que definir algunas consultas específicas

    public User findByUserEmail(String userEmail);


}
