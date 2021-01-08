package com.senadoonline.senadoUrsoMineiro.service;

import com.senadoonline.senadoUrsoMineiro.model.Pauta;
import com.senadoonline.senadoUrsoMineiro.model.Pessoa;
import com.senadoonline.senadoUrsoMineiro.model.Status;
import com.senadoonline.senadoUrsoMineiro.repository.PautaRepository;
import com.senadoonline.senadoUrsoMineiro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PautaService {

    @Autowired
    PautaRepository pautaRepository;

    @Autowired
    PessoaService pessoaService;

    public Pauta buscarPeloCodigo(Long codigo){
        return this.pautaRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public void aprovarPauta(Long codigo){
        Pauta pautaSalva = buscarPeloCodigo(codigo);
        pautaSalva.setStatus(Status.APROVADA);
        pautaRepository.save(pautaSalva);
    }

    public void reprovarPauta(Long codigo){
        Pauta pautaSalva = buscarPeloCodigo(codigo);
        pautaSalva.setStatus(Status.REPROVADA);
        pautaRepository.save(pautaSalva);
    }

    public Pauta salvar(Pauta pauta) {
        pauta.setStatus(Status.ABERTA);
        return pautaRepository.save(pauta);
    }
}
