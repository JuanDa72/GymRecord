package com.jdcg.gymRecordApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercise", schema = "gymrecords")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExerciseId")
    private Integer exerciseId;

    @Column(name = "ExerciseName", nullable = false, length = 45)
    private String exerciseName;

    @Column(name = "ExercisesNumberSeries", nullable = false)
    private Integer exercisesNumberSeries;

    @Column(name = "ExerciseOrden", nullable = false)
    private Integer exerciseOrden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExerciseSessionId", nullable = false)
    @JsonBackReference // Lado hijo
    private Session session;

    @Column(name = "ExerciseMachine", length = 45)
    private String exerciseMachine;

    @Column(name = "ExerciseNotes", columnDefinition = "TEXT")
    private String exerciseNotes;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // lado padre
    private List<Serie> series = new ArrayList<>();


}

