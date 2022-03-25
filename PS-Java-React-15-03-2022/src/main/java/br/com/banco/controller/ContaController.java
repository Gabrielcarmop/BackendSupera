package br.com.banco.controller;

import br.com.banco.entity.Conta;
import br.com.banco.entity.Transferencia;
import br.com.banco.repository.ContaRepository;
import br.com.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Conta")
public class ContaController {
    @Autowired
    private ContaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Conta> findById(@PathVariable Integer id) {
       Conta obj = service.findById(id);
       return ResponseEntity.ok().body(obj) ;
    }
    @GetMapping
    public ResponseEntity<List<Conta>> findAll(){
        List<Conta> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


}
