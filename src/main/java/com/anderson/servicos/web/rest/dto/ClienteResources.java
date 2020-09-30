package com.anderson.servicos.web.rest.dto;

import com.anderson.servicos.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResources {

    @Autowired
    ClienteServices services;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarTodosClientes() {
        return ResponseEntity.ok(services.listarClientes());
    }

    @PostMapping
    public ResponseEntity<ClienteDto> criarCliente(@RequestBody @Valid ClienteDto clienteDto) {
        return ResponseEntity.ok(services.criarCliente(clienteDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscarClientePorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(services.buscarClientePorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDto> deletarCliente(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(services.deletarCliente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable("id") Integer id, @RequestBody ClienteDto clienteDto) {
        return ResponseEntity.ok(services.atualizarCliente(id, clienteDto));
    }

}
