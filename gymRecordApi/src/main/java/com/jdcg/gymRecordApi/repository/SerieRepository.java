package com.jdcg.gymRecordApi.repository;

import com.jdcg.gymRecordApi.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

    List<Serie> findByExerciseExerciseIdOrderBySerieDateDesc(Integer exerciseId);


}
