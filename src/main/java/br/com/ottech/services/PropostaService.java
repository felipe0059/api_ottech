package br.com.ottech.services;

import br.com.ottech.models.Cliente;
import br.com.ottech.models.Projeto;
import br.com.ottech.models.Proposta;
import br.com.ottech.repositories.ClienteRepository;
import br.com.ottech.repositories.ProjetoRepository;
import br.com.ottech.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class PropostaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private PropostaRepository propostaRepository;

    public Optional<Proposta> registrarProposta(Proposta proposta) {

        Optional<Cliente> buscaCliente = clienteRepository.findById(proposta.getCliente_id());
        Optional<Projeto> buscaProjeto = projetoRepository.findById(proposta.getProjeto_id());

        if (buscaCliente.get().getId() != proposta.getCliente_id())
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Cliente não registrado!", null);

        if (buscaProjeto.get().getId() != proposta.getProjeto_id())
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Projeto não registrado!", null);

        return Optional.of(propostaRepository.save(proposta));
    }
}

