package br.com.ottech.models;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Table(name = "tb_Cnpj")
public class Cnpj {


    @CNPJ
    @Column(name = "numero_cnpj", unique = true, nullable = false)
    private String numCnpj;

}
