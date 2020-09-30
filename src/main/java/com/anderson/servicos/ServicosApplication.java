package com.anderson.servicos;

import com.anderson.servicos.model.Cliente;
import com.anderson.servicos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ServicosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicosApplication.class, args);
    }

}
