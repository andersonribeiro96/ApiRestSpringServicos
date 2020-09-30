package com.anderson.servicos.repository;

import com.anderson.servicos.model.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

    @Query(value = "select s from ServicoPrestado s join s.cliente c where c.nome like %?2% and function('MONTH', s.data) = ?1")
    List<ServicoPrestado> findByNomeDoClienteAndMes(Optional<Integer> mes, Optional<String> nome);




}
