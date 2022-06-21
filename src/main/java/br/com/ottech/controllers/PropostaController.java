package br.com.ottech.controllers;

import br.com.ottech.models.Projeto;
import br.com.ottech.models.Proposta;
import br.com.ottech.repositories.PropostaRepository;
import br.com.ottech.services.PropostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Proposta> registrarProposta(@Valid @RequestBody Proposta proposta) {
        return service.registrarProposta(proposta)
                .map(respostaAgendar -> ResponseEntity.status(HttpStatus.CREATED).body(respostaAgendar))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping
    public List<Proposta> findAll(){
        return repository.findAll();
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

