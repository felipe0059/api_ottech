package br.com.ottech.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @NotBlank(message = "Por favor digite o nome do cliente:")
    @Column(name = "nome_cliente")
    @Size(min = 5, max = 50)
    private String nomeCliente;

    @Embedded
    @Column(name = "nome_cliente",unique = true, nullable = false)
    @NotNull
    @CNPJ
    private Cnpj numCnpj;

    @ManyToMany
    @JoinTable(
            name = "projeto_cliente_id",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id"))
    Set<ProjetoCliente> projetos;

  /*  @ManyToMany(mappedBy = "cliente")
    private List<Proposta> propostas;*/





}