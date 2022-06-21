package br.com.ottech.services;

import br.com.ottech.models.Cliente;
import br.com.ottech.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Optional<Cliente> cadastrarCliente(Cliente cliente) {

        if (repository.findByNumCnpj(cliente.getNumCnpj()).isPresent())
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "CNPJ já cadastrado!", null);

        return Optional.of(repository.save(cliente));
    }

    public Optional<Cliente> atualizarCliente(Cliente cliente) {

        if(repository.findById(cliente.getId()).isPresent()) {

            Optional<Cliente> retornaCliente = repository.findAllByNomeCliente(cliente.getNomeCliente());

            if ( (retornaCliente.isPresent()) && ( retornaCliente.get().getId() != cliente.getId()))
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "É necessário alterar o nome e o cnpj do cliente", null);

            return Optional.ofNullable(repository.save(cliente));

        }

        return Optional.empty();

    }

}
