package br.com.fiap.locatech.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class Aluguel {

    private Long id;

    private Long pessoaId;

    private Long veiculoId;

    private String veiculoModelo;

    private String veiculoPlaca;

    private String pessoaCpf;

    private String pessoaNome;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private BigDecimal valorTotal;
}
