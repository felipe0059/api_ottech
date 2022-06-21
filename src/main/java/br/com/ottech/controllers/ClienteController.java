package br.com.ottech.controllers;

import br.com.ottech.dtos.ClienteDTO;
import br.com.ottech.models.Cliente;
import br.com.ottech.models.Cnpj;
import br.com.ottech.repositories.ClienteRepository;
import br.com.ottech.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService service;

    @PostMapping("/registrar")
    public ResponseEntity<Cliente> cadastraCliente(@Valid @RequestBody Cliente cliente){
        return service.cadastrarCliente(cliente)
                .map(respostaCadastrar -> ResponseEntity.status(HttpStatus.CREATED).body(respostaCadastrar))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente cliente) {
        return service.atualizarCliente(cliente)
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    //MÉTODO BUSCA POR NOME
    @GetMapping("/nome/{nomeCliente}")
    public ResponseEntity<List<Cliente>> findAllByNome(@PathVariable String nomeCliente){

        return ResponseEntity.ok(repository.findAllByNomeClienteContainingIgnoreCase(nomeCliente));
    }

    //MÉTODO BUSCA POR CNPJ
    @GetMapping("/cnpj/{numCnpj}")
    public ResponseEntity<List<Cliente>> findAllByNumCnpj(@PathVariable Cnpj numCnpj) {

        return ResponseEntity.ok(repository.findAllByNumCnpj(numCnpj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaCliente(@PathVariable Long id) {

        return repository.findById(id)
                .map(resposta -> {
                    repository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
