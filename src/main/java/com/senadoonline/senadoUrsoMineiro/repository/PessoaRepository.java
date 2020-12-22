package com.senadoonline.senadoUrsoMineiro.repository;

import com.senadoonline.senadoUrsoMineiro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
