package com.Qred.emprestimo.persistence.repository;

import com.Qred.emprestimo.persistence.entity.PerguntaPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<PerguntaPersistenceEntity, Long> {
}
