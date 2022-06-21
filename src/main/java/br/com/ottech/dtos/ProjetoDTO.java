package br.com.ottech.dtos;

import br.com.ottech.models.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {

    private String nomeProjeto;
    private String descricaoProjeto;

    public ProjetoDTO(Projeto projeto) {
        this.nomeProjeto = nomeProjeto;
        this.descricaoProjeto = descricaoProjeto;
    }
}
