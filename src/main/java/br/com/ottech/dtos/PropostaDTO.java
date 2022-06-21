package br.com.ottech.dtos;

import br.com.ottech.models.Cliente;
import br.com.ottech.models.Projeto;
import br.com.ottech.models.Proposta;
import br.com.ottech.models.StatusProposta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropostaDTO {

    private LocalDate dataHora;
    private StatusProposta status;
    private Long cliente_id;
    private Long projeto_id;
    private List<Cliente> cliente;
    private List<Projeto> projeto;

    public PropostaDTO(Proposta proposta) {
        this.dataHora = dataHora;
        this.status = status;
        this.cliente_id = cliente_id;
        this.projeto_id = projeto_id;
        this.cliente = cliente;
        this.projeto = projeto;
    }
}
