package io.github.manoeljr;


import io.github.manoeljr.domain.entity.Cliente;
import io.github.manoeljr.domain.entity.Pedido;
import io.github.manoeljr.domain.repository.ClienteRepository;
import io.github.manoeljr.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clientes, @Autowired PedidoRepository pedidos) {
        return args -> {
            System.out.println("Salvando um Cliente");
            Cliente fulano = new Cliente("Fulano");
            clientes.save(fulano);

            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(10));
            pedidos.save(p);

            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
