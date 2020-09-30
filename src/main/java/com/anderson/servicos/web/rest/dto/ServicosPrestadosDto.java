package com.anderson.servicos.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ServicosPrestadosDto {


    private Integer id;

    private String descricao;

    private Integer cliente;

    private double valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Sao_Paulo")
    private LocalDate data;


}
