package com.jdcg.gymRecordApi.repository;

import com.jdcg.gymRecordApi.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Integer> {
}
