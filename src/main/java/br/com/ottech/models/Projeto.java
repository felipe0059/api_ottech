package br.com.ottech.models;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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


}
