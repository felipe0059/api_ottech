package br.com.ottech.repositories;

import br.com.ottech.models.Cliente;
import br.com.ottech.models.Cnpj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {

    Optional<Cliente> findByNumCnpj(Cnpj numCnpj);

    Optional<Cliente> findAllByNomeCliente(String nomeCliente);

    public List<Cliente> findAllByNomeClienteContainingIgnoreCase(String nomeCliente);

    public List<Cliente> findAllByNumCnpj(Cnpj numCnpj);
}
