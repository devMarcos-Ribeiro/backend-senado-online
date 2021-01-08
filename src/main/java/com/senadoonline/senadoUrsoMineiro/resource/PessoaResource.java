package com.senadoonline.senadoUrsoMineiro.resource;

import com.senadoonline.senadoUrsoMineiro.model.Pessoa;
import com.senadoonline.senadoUrsoMineiro.model.dto.PessoaDTO;
import com.senadoonline.senadoUrsoMineiro.repository.PessoaRepository;
import com.senadoonline.senadoUrsoMineiro.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTO> criar(@Valid @RequestBody Pessoa pessoa){
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        PessoaDTO pessoaDTO = new PessoaDTO(pessoaSalva);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(pessoaSalva.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listar(){
        List<Pessoa> pessoas =  pessoaRepository.findAll();
        return pessoas.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());

    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PessoaDTO> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaService.atualizarPessoa(codigo, pessoa);
        return ResponseEntity.ok(new PessoaDTO(pessoaSalva));
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo){
        pessoaRepository.deleteById(codigo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PessoaDTO> buscarPeloCodigo(@PathVariable Long codigo) {
        Pessoa pessoa = pessoaService.buscarPessoaPorCodigo(codigo);
        return ResponseEntity.ok().body(new PessoaDTO(pessoa));
    }
}
