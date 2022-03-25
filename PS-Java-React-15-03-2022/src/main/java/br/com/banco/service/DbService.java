package br.com.banco.service;

import br.com.banco.entity.Conta;
import br.com.banco.entity.Transferencia;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransferenciaRepository produtoRepository;

    public void instanciarBancoDeDados() {
        Conta conta1 = new Conta(1, "Fulano");
        Conta conta2 = new Conta(2, "Sicrano");


        Transferencia tf1 = new Transferencia(1, "2019-01-01 12:00:00+03", 30895.46, "DEPOSITO", null,conta1);
        Transferencia tf2 = new Transferencia(2, "2019-02-03 09:53:27+03", 12.24, "DEPOSITO", null, conta2);
        Transferencia tf3 = new Transferencia(3, "2019-05-04 08:12:45+03", -500.50, "SAQUE", null, conta1);
        Transferencia tf4 = new Transferencia(4, "2019-08-07 08:12:45+03", -530.50, "SAQUE", null, conta2);
        Transferencia tf5 = new Transferencia(5, "2020-06-08 10:15:01+03", 3241.23, "TRANSFERENCIA", "Beltrano", conta1);


        conta1.getTransferencias().addAll(Arrays.asList(tf1, tf2, tf3));
        conta2.getTransferencias().addAll(Arrays.asList(tf4, tf5));

        contaRepository.saveAll(Arrays.asList(conta1, conta2));
        produtoRepository.saveAll(Arrays.asList(tf1, tf2, tf3, tf4, tf5));
    }
}
