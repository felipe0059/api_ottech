package br.com.ottech.dtos;

import br.com.ottech.models.StatusProposta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropostaDTO {
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataHora;
    private StatusProposta status;
    private Long cliente_id;
    private Long projeto_id;

}
