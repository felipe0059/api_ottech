package br.com.ottech.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

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
    @Column(name = "data")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatusProposta status;

    @Column(name = "id_cliente")
    private Long cliente_id;

    @Column(name = "id_projeto")
    private Long projeto_id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proposta")
    private Projeto projeto;

}
