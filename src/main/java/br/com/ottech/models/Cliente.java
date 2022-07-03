package br.com.ottech.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Cnpj numCnpj;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente") //Atenção aqui !!
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Proposta> propostas;





}