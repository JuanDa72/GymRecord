package com.jdcg.gymRecordApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routine", schema = "gymrecords")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoutineId")
    private Integer routineId;

    @Column(name = "RoutineName", nullable = false, length = 45)
    private String routineName;

    @Column(name = "RoutineCreationDate", nullable = false)
    private LocalDate routineCreationDate;

    @Column(name = "RoutineLastAccess", nullable = false)
    private LocalDateTime routineLastAccess;

    @Column(name = "RoutineDescription", columnDefinition = "TEXT")
    private String routineDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoutineUserId", nullable = false)
    @JsonBackReference // Lado "hijo"
    private User user;


    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Session> sessions;


}

