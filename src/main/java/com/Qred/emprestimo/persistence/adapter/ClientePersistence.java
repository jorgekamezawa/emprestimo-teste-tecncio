package com.Qred.emprestimo.persistence.adapter;

public interface ClientePersistence {
    boolean validarSeClienteExiste(String cnpj);

    void cadastrarCliente(String cnpj);
}
