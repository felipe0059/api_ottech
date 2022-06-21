package br.com.ottech.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
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
    @Column(name = "cliente_id")
    private Long id;

    @NotNull
    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Embedded
    private Cnpj numCnpj;


}