package com.senadoonline.senadoUrsoMineiro.service;

import com.senadoonline.senadoUrsoMineiro.model.Pessoa;
import com.senadoonline.senadoUrsoMineiro.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public Pessoa buscarPessoaPorCodigo(Long codigo){
        return this.pessoaRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public Pessoa atualizarPessoa(Long codigo, Pessoa pessoa){
        Pessoa pessoaSalva = buscarPessoaPorCodigo(codigo);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return pessoaRepository.save(pessoaSalva);
    }
}
