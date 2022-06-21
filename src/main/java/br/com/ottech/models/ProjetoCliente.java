package br.com.ottech.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_projeto_cliente")
public class ProjetoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeto_cliente_id")
    private Integer id;

    private String observacoes;

    @ManyToMany(mappedBy = "projetos")
    Set<Cliente> cliente;

    @ManyToMany(mappedBy = "projeto")
    Set<Projeto> projeto;


}
