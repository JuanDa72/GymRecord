package com.jdcg.gymRecordApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "serie", schema = "gymrecords")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SerieId")
    private Integer serieId;

    @Column(name = "SerieOrden", nullable = false)
    private Integer serieOrden;

    @Column(name = "SerieWeight", precision = 5, scale = 2, nullable = false)
    private BigDecimal serieWeight;

    @Column(name = "SerieRepetitions", nullable = false)
    private Integer serieRepetitions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SerieExerciseId", nullable = false)
    @JsonBackReference // lado hijo
    private Exercise exercise;

    @Column(name = "SerieDate", nullable = false)
    private LocalDateTime serieDate;

    @Column(name = "SerieNotes", columnDefinition = "TEXT")
    private String serieNotes;
}

