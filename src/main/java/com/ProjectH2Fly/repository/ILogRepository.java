package com.ProjectH2Fly.repository;

import com.ProjectH2Fly.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogRepository extends JpaRepository<Log,Integer> {
}
