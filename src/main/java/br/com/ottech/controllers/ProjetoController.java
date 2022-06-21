package br.com.ottech.controllers;

import br.com.ottech.models.Projeto;
import br.com.ottech.repositories.ProjetoRepository;
import br.com.ottech.services.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
    public ResponseEntity<Projeto> cadastraProjeto(@Valid @RequestBody Projeto projeto){
        return service.cadastrarProjeto(projeto)
                .map(responseCadastrar -> ResponseEntity.status(HttpStatus.CREATED).body(responseCadastrar))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping
    public List<Projeto> findAll(){
        return repository.findAll();
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Projeto> atualizaProjeto(@RequestBody Projeto projeto) {
        return service.atualizarProjeto(projeto)
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
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
