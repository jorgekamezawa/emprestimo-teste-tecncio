package com.Qred.emprestimo.util;

import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
public class ValidaCnpj {
    public boolean isCNPJ(String cnpj) {
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
                (cnpj.length() != 14))
            return false;

        char dig13, dig14;
        int soma, i, resultadoDigito, numeroProcessando, digitoMultiplicador;

        try {
// Calculo do 1o. Digito Verificador
            soma = 0;
            digitoMultiplicador = 2;
            for (i=11; i>=0; i--) {
// (48 eh a posição de '0' na tabela ASCII)
                numeroProcessando = (cnpj.charAt(i) - 48);
                soma += (numeroProcessando * digitoMultiplicador);
                digitoMultiplicador++;
                if (digitoMultiplicador == 10)
                    digitoMultiplicador = 2;
            }

            resultadoDigito = soma % 11;
            if ((resultadoDigito == 0) || (resultadoDigito == 1))
                dig13 = '0';
            else dig13 = (char)((11-resultadoDigito) + 48);

// Calculo do 2o. Digito Verificador
            soma = 0;
            digitoMultiplicador = 2;
            for (i=12; i>=0; i--) {
                numeroProcessando = (cnpj.charAt(i)- 48);
                soma += (numeroProcessando * digitoMultiplicador);
                digitoMultiplicador++;
                if (digitoMultiplicador == 10)
                    digitoMultiplicador = 2;
            }

            resultadoDigito = soma % 11;
            if ((resultadoDigito == 0) || (resultadoDigito == 1))
                dig14 = '0';
            else dig14 = (char)((11-resultadoDigito) + 48);

// Verifica se os dígitos calculados conferem com os dígitos informados.
            return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    public String imprimeCNPJ(String cnpj) {
        if(cnpj.length() != 14) return "CNPJ com tamanho diferente de 14!";
        return "Constatada invalidacao do CNPJ: " +
                (cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." +
                cnpj.substring(5, 8) + "." + cnpj.substring(8, 12) + "-" +
                cnpj.substring(12, 14));
    }
}
