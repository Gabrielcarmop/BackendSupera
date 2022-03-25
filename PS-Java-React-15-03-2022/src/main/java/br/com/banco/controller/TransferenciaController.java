package br.com.banco.controller;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/transferecia")
public class TransferenciaController {

    @Autowired
    private TransferenciaRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transferencia> GetById(@PathVariable(value = "id") Integer id)
    {

        Optional<Transferencia> transferencia = repository.findById(id);
        if(transferencia.isPresent())
            return new ResponseEntity<Transferencia>(transferencia.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public List<Transferencia> Get() {
        return repository.findAll();
    }

    @GetMapping(value = "/{nome_operador_transacao}")
    public ResponseEntity<Transferencia> findByNome_operador(String nome_operador_transacao) {
        Optional<Transferencia> transferencia = repository.findByNome_operador(nome_operador_transacao);
        if(transferencia.isPresent())
            return new ResponseEntity<Transferencia>(transferencia.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
