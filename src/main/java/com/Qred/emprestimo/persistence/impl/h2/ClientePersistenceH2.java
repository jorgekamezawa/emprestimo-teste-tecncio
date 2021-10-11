package com.Qred.emprestimo.persistence.impl.h2;

import com.Qred.emprestimo.persistence.adapter.ClientePersistence;
import com.Qred.emprestimo.persistence.entity.ClientePersistenceEntity;
import com.Qred.emprestimo.persistence.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientePersistenceH2 implements ClientePersistence {
    private final ClienteRepository clienteRepository;

    @Override
    public boolean validarSeClienteExiste(String cnpj) {
        Optional<ClientePersistenceEntity> cliente = clienteRepository.findById(cnpj);
        return cliente.isPresent();
    }

    @Override
    public void cadastrarCliente(String cnpj) {
        clienteRepository.save(new ClientePersistenceEntity(cnpj));
    }
}
