package br.com.ottech.models;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_Cnpj")
public class Cnpj {

    @Id
    @Column(name = "numero_cnpj", unique = true, nullable = false)
    private String numCnpj;

}
