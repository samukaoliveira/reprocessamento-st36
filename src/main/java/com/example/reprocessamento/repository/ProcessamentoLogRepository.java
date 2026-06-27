package com.example.reprocessamento.repository;

import com.example.reprocessamento.model.ProcessamentoLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessamentoLogRepository
        extends JpaRepository<ProcessamentoLog, Long> {
}