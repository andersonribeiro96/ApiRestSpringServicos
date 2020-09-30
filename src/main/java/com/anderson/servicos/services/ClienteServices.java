package com.anderson.servicos.services;

import com.anderson.servicos.model.Cliente;
import com.anderson.servicos.repository.ClienteRepository;
import com.anderson.servicos.web.rest.dto.ClienteDto;

import com.anderson.servicos.web.rest.dto.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteDto> listarClientes() {
        return ClienteMapper.listEntityToDto(repository.findAll());
    }

    public ClienteDto criarCliente(ClienteDto clienteDto) {
        Cliente cliente = repository.save(ClienteMapper.dtoToEntity(clienteDto));
        return ClienteMapper.entityToDto(cliente);
    }

    public ClienteDto buscarClientePorId(Integer id) {
        Optional<Cliente> byId = repository.findById(id);
        if (byId.isPresent()) {
            Cliente cliente = repository.findById(id).get();
            return ClienteMapper.entityToDto(cliente);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }

    public ClienteDto deletarCliente(Integer id) {
        Optional<Cliente> byId = repository.findById(id);
        if (byId.isPresent()) {
            Cliente cliente = repository.findById(id).get();
            repository.delete(cliente);
            return ClienteMapper.entityToDto(cliente);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Cliente não encontrado");
    }

    public ClienteDto atualizarCliente(Integer id, ClienteDto clienteDto) {
        Optional<Cliente> byId = repository.findById(id);
        if (byId.isPresent()) {
            Cliente cliente = repository.findById(id).get();
            cliente.setNome(clienteDto.getNome());
            cliente.setCpf(clienteDto.getCpf());
            return ClienteMapper.entityToDto(repository.save(cliente));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
