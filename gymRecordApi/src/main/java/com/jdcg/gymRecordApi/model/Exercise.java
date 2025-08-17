package com.jdcg.gymRecordApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    public Exercise() {
    }


    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public Integer getExercisesNumberSeries() {
        return exercisesNumberSeries;
    }

    public void setExercisesNumberSeries(Integer exercisesNumberSeries) {
        this.exercisesNumberSeries = exercisesNumberSeries;
    }

    public Integer getExerciseOrden() {
        return exerciseOrden;
    }

    public void setExerciseOrden(Integer exerciseOrden) {
        this.exerciseOrden = exerciseOrden;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getExerciseMachine() {
        return exerciseMachine;
    }

    public void setExerciseMachine(String exerciseMachine) {
        this.exerciseMachine = exerciseMachine;
    }

    public String getExerciseNotes() {
        return exerciseNotes;
    }

    public void setExerciseNotes(String exerciseNotes) {
        this.exerciseNotes = exerciseNotes;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}

