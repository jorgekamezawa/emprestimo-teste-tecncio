package com.Qred.emprestimo.persistence.repository;

import com.Qred.emprestimo.persistence.entity.RespostaPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaPersistenceEntity, Long> {
}
