package br.com.ottech.controllers;

import br.com.ottech.models.Projeto;
import br.com.ottech.repositories.ProjetoRepository;
import br.com.ottech.services.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private ProjetoService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<Projeto> cadastraProjeto(@RequestBody Projeto projeto){
        return service.cadastrarProjeto(projeto)
                .map(responseCadastrar -> ResponseEntity.status(HttpStatus.CREATED).body(responseCadastrar))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping
    public ResponseEntity find(Projeto filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        List<Projeto> lista = repository.findAll(example);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/atualizar/{id}")
    public void update(@PathVariable Long id, @RequestBody Projeto projeto){
        repository.findById(id)
                .map( projetoExistente -> {
                    projetoExistente.setId(projetoExistente.getId());
                    repository.save(projeto);
                    return projetoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Projeto não encontrado") );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaProjeto(@PathVariable Long id) {

        return repository.findById(id)
                .map(resposta -> {
                    repository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
