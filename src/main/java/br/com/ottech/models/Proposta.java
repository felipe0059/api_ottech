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

    /*   @ManyToOne
 @JoinTable(
            name = "tb_cliente",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id"))
    private List<Cliente> cliente = new ArrayList<>();

    @ManyToOne
  /*  @JoinTable(
            name = "tb_projetos",
            joinColumns = @JoinColumn(name = "id_projeto"),
            inverseJoinColumns = @JoinColumn(name = "projeto_id"))
    private List<Projeto> projeto = new ArrayList<>();*/

}
