package com.jdcg.gymRecordApi.repository;

import com.jdcg.gymRecordApi.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutineRepository extends JpaRepository<Routine, Integer> {

    List<Routine> findAllByRoutineNameContaining(String routineName);

}
