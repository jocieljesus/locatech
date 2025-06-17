package br.com.fiap.locatech.entities;


import lombok.Data;

@Data
public class Pessoa {

    private Long id;

    private String nome;

    private String cpf;

    private String telefone;

    private String email;
}
