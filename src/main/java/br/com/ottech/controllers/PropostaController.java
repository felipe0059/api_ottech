package br.com.ottech.controllers;

import br.com.ottech.dtos.PropostaDTO;
import br.com.ottech.models.Proposta;
import br.com.ottech.repositories.PropostaRepository;
import br.com.ottech.services.PropostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/propostas")
@RequiredArgsConstructor
public class PropostaController {

    @Autowired
    private PropostaRepository repository;

    @Autowired
    private PropostaService service;

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> save( @RequestBody PropostaDTO propostaDTO) {
        Proposta proposta = service.registrarProposta(propostaDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity find(Proposta filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        List<Proposta> lista = repository.findAll(example);
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProposta(@PathVariable Long id) {

        return repository.findById(id)
                .map(resposta -> {
                    repository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}

