package br.com.ottech.models;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Long id;

    @NotNull
    @NotBlank(message = "O nome do projeto não deve ser vazio.")
    @Column(name = "nome_projeto")
    @Size(min = 5, max = 50)
    private String nomeProjeto;

    @Column(name = "descricao")
    @NotBlank(message = "A descrição do projeto não deve ser vazia.")
    private String descricaoProjeto;

    @ManyToMany
    @JoinTable(
            name = "projeto_cliente_id",
            joinColumns = @JoinColumn(name = "id_projeto"),
            inverseJoinColumns = @JoinColumn(name = "projeto_id"))
    Set<ProjetoCliente> projeto;

   /* @ManyToMany(mappedBy = "projeto")
    private List<Proposta> proposta;*/

}
