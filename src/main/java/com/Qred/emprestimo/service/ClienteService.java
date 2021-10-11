package com.Qred.emprestimo.service;

import com.Qred.emprestimo.exception.ValidacaoCnpjException;
import com.Qred.emprestimo.persistence.adapter.ClientePersistence;
import com.Qred.emprestimo.util.ValidaCnpj;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClientePersistence clientePersistence;
    private final ValidaCnpj validaCnpj;

    public void validarCliente(String cnpj) {
        if (!validaCnpj.isCNPJ(cnpj)) {
            throw new ValidacaoCnpjException(validaCnpj.imprimeCNPJ(cnpj));
        }
        if (!validarSeClienteJaExiste(cnpj)) {
            cadastrarCliente(cnpj);
        }
    }

    private boolean validarSeClienteJaExiste(String cnpj) {
        return clientePersistence.validarSeClienteExiste(cnpj);
    }

    private void cadastrarCliente(String cnpj) {
        clientePersistence.cadastrarCliente(cnpj);
    }
}
