package com.senadoonline.senadoUrsoMineiro.model.dto;

import com.senadoonline.senadoUrsoMineiro.model.Pessoa;

import java.io.Serializable;

public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long codigo;

    private String nome;

    private String email;

    public PessoaDTO() {
    }

    public PessoaDTO(Long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public PessoaDTO(Pessoa pessoa){
        codigo = pessoa.getCodigo();
        nome = pessoa.getNome();
        email = pessoa.getEmail();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
