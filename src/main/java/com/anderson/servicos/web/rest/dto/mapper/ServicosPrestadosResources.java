package com.anderson.servicos.web.rest.dto.mapper;

import com.anderson.servicos.model.ServicoPrestado;
import com.anderson.servicos.services.ServicosPrestadosServices;
import com.anderson.servicos.web.rest.dto.ServicosPrestadosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos-prestado")
public class ServicosPrestadosResources {

    @Autowired
    ServicosPrestadosServices servicosPrestadosServices;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado criarServico(@RequestBody @Valid ServicosPrestadosDto servicosPrestadosDto) {
        return servicosPrestadosServices.criarServico(servicosPrestadosDto);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisarServico(
            @RequestParam(value = "nome", required = false, defaultValue = "") Optional<String> nome,
            @RequestParam(value = "mes", required = false) Optional<Integer>  mes) {
        return servicosPrestadosServices.pesquisarServico(mes, nome);
    }

}
