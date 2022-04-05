package io.github.francelinom.clientes.model.repository;

import io.github.francelinom.clientes.model.entity.Cliente;
import io.github.francelinom.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(" select s from ServicoPrestado s join s.cliente c where upper( c.nome) like upper(:nome) and FUNCTION('MONTH',c.dataCadastro)= :mes")
    List<ServicoPrestado> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);
}
