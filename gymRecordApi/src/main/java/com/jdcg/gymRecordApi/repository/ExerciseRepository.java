package com.jdcg.gymRecordApi.repository;

import com.jdcg.gymRecordApi.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {


}
