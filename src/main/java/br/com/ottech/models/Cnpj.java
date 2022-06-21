package br.com.ottech.models;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Table(name = "tb_Cnpj")
public class Cnpj {


    @NotNull
    @Column(name = "numero_cnpj", unique = true)
    private String numCnpj;

}
