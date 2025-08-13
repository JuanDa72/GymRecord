package com.jdcg.gymRecordApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "session", schema = "gymrecords")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SessionId")
    private Integer sessionId;

    @Column(name = "SessionName", nullable = false, length = 45)
    private String sessionName;

    @Column(name = "SessionNotes", columnDefinition = "TEXT")
    private String sessionNotes;

    // Relación con Routine (Muchos a Uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SessionRoutineId", nullable = false)
    @JsonBackReference
    private Routine routine;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Lado padre
    private List<Exercise> exercises = new ArrayList<>();


}

