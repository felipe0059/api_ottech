package br.com.ottech.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proposta")
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    @Column(name = "data_hora")
    private LocalDate dataHora;

    @Enumerated(EnumType.STRING)
    private StatusProposta status;

    @Column(name = "id_cliente")
    private Long cliente_id;

    @Column(name = "id_projeto")
    private Long projeto_id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_cliente")
    private List<Cliente> cliente= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "projeto_id")
    private List<Projeto> projeto = new ArrayList<>();

}
