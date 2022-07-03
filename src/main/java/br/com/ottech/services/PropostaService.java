package br.com.ottech.services;

import br.com.ottech.config.regraDeNegocioException;
import br.com.ottech.dtos.PropostaDTO;
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

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PropostaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private PropostaRepository propostaRepository;

    @Transactional
    public Proposta registrarProposta(PropostaDTO proposta) {
        Long idCliente = proposta.getCliente_id();
        clienteRepository.findById(idCliente).orElseThrow(() -> new regraDeNegocioException("Código de cliente inválido."));

        Long idProjeto = proposta.getProjeto_id();
        projetoRepository.findById(idProjeto).orElseThrow(() -> new regraDeNegocioException("Código do projeto inválido"));

        Proposta novaProposta = new Proposta();

        novaProposta.setProjeto_id(proposta.getProjeto_id());
        novaProposta.setCliente_id(proposta.getCliente_id());
        novaProposta.setData(proposta.getDataHora());
        novaProposta.setStatus(proposta.getStatus());

        propostaRepository.save(novaProposta);

        return null;
    }
}

