package com.Qred.emprestimo.persistence.repository;

import com.Qred.emprestimo.persistence.entity.ClientePersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClientePersistenceEntity, String> {
}
