package com.anderson.servicos.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ClienteDto {

    private Integer id;

    private String nome;

    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataCadastro;

}
