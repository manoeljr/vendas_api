package io.github.manoeljr.domain.repository;

import io.github.manoeljr.domain.entity.Cliente;
import io.github.manoeljr.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
