package br.com.ottech.repositories;

import br.com.ottech.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProjetoRepository extends JpaRepository <Projeto, Long> {

    Optional<Projeto> findByNomeProjeto(String nomeProjeto);
}
