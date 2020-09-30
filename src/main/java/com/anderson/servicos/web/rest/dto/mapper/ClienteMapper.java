package com.anderson.servicos.web.rest.dto.mapper;

import com.anderson.servicos.model.Cliente;
import com.anderson.servicos.web.rest.dto.ClienteDto;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {


    public static Cliente dtoToEntity(ClienteDto clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setDataCadastro(clienteDTO.getDataCadastro());
        return cliente;
    }

    public static ClienteDto entityToDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setCpf(cliente.getCpf());
        clienteDto.setDataCadastro(cliente.getDataCadastro());
        return clienteDto;
    }

    public static List<Cliente> listDtoToEntity(List<ClienteDto> clienteDtos){
        List<Cliente> clientes = new ArrayList<>();
        for (ClienteDto cliente: clienteDtos) {
            clientes.add(dtoToEntity(cliente));
        }
        return clientes;
    }

    public static  List<ClienteDto> listEntityToDto(List<Cliente> clientes){
        List<ClienteDto> clienteDtos = new ArrayList<>();
        for (Cliente cliente: clientes) {
            clienteDtos.add(entityToDto(cliente));
        }
        return clienteDtos;
    }



}
