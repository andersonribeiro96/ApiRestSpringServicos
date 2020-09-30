package com.anderson.servicos.services;

import com.anderson.servicos.model.Cliente;
import com.anderson.servicos.model.ServicoPrestado;
import com.anderson.servicos.repository.ClienteRepository;
import com.anderson.servicos.repository.ServicoPrestadoRepository;
import com.anderson.servicos.web.rest.dto.ServicosPrestadosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosPrestadosServices {

    @Autowired
    private ServicoPrestadoRepository servicoPrestadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ServicoPrestado criarServico(ServicosPrestadosDto servicosPrestadosDto) {
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        Optional<Cliente> cliente = clienteRepository.findById(servicosPrestadosDto.getCliente());
        if(cliente.isPresent()){
            servicoPrestado.setCliente(cliente.get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado");
        }
        servicoPrestado.setDescricao(servicosPrestadosDto.getDescricao());
        servicoPrestado.setData(servicosPrestadosDto.getData());
        servicoPrestado.setValor(servicosPrestadosDto.getValor());
        return servicoPrestadoRepository.save(servicoPrestado);
    }

    public List<ServicoPrestado> pesquisarServico(Optional<Integer> mes, Optional<String> nome){
        return servicoPrestadoRepository.findByNomeDoClienteAndMes(mes, nome);
    }



}
