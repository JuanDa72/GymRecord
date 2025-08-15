package com.jdcg.gymRecordApi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "gymrecords")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Integer userId;

    @Column(name = "UserName", nullable = false, length = 45)
    private String userName;

    @Column(name = "UserLastName", nullable = false, length = 45)
    private String userLastName;

    @Column(name = "UserEmail", nullable = false, length = 45, unique = true)
    private String userEmail;

    @Column(name = "userPassword", nullable = false, length = 45)
    private String userPassword;

    @Column(name = "userAge", nullable = false)
    private Integer userAge;

    @Column(name = "userBirthdate", nullable = false)
    private LocalDate userBirthdate;

    @Column(name = "userPhoneNumber", nullable = false, length = 45)
    private String userPhoneNumber;

    @Column(name = "UserGender", length = 45)
    private String userGender;

    @Column(name = "UserWeight", precision = 6, scale = 3)
    private BigDecimal userWeight;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Para evitar posibles bucles infinitos en la serialización
    private List<Routine> routines = new ArrayList<>();



}
