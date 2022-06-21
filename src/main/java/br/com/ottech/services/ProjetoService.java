package br.com.ottech.services;

import br.com.ottech.models.Projeto;
import br.com.ottech.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    public Optional<Projeto> cadastrarProjeto(Projeto projeto) {

        if (repository.findByNomeProjeto(projeto.getNomeProjeto()).isPresent())
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "CNPJ já cadastrado!", null);

        return Optional.of(repository.save(projeto));
    }

    public Optional<Projeto> atualizarProjeto(Projeto projeto) {

        if (repository.findById(projeto.getId()).isPresent()) {

            Optional<Projeto> retornaProjeto = repository.findByNomeProjeto(projeto.getNomeProjeto());

            if ((retornaProjeto.isPresent()) && (retornaProjeto.get().getId() != projeto.getId()))
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Projeto já existe!", null);

            return Optional.ofNullable(repository.save(projeto));

        }

        return Optional.empty();

    }

}