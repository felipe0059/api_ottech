package br.com.ottech.dtos;

import br.com.ottech.models.Cnpj;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nomeCliente;
    private Cnpj numCnpj;



}



