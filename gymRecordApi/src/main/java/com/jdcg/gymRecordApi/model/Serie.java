package com.jdcg.gymRecordApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "serie", schema = "gymrecordssecond")
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

    public Serie() {
    }

    public Integer getSerieId() {
        return serieId;
    }

    public void setSerieId(Integer serieId) {
        this.serieId = serieId;
    }

    public Integer getSerieOrden() {
        return serieOrden;
    }

    public void setSerieOrden(Integer serieOrden) {
        this.serieOrden = serieOrden;
    }

    public BigDecimal getSerieWeight() {
        return serieWeight;
    }

    public void setSerieWeight(BigDecimal serieWeight) {
        this.serieWeight = serieWeight;
    }

    public Integer getSerieRepetitions() {
        return serieRepetitions;
    }

    public void setSerieRepetitions(Integer serieRepetitions) {
        this.serieRepetitions = serieRepetitions;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public LocalDateTime getSerieDate() {
        return serieDate;
    }

    public void setSerieDate(LocalDateTime serieDate) {
        this.serieDate = serieDate;
    }

    public String getSerieNotes() {
        return serieNotes;
    }

    public void setSerieNotes(String serieNotes) {
        this.serieNotes = serieNotes;
    }
}

