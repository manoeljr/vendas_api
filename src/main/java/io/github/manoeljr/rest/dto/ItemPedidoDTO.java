package io.github.manoeljr.rest.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {
    private Integer produto;
    private Integer quantidade;
}
