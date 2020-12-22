package com.senadoonline.senadoUrsoMineiro.resource;

import com.senadoonline.senadoUrsoMineiro.model.Pauta;
import com.senadoonline.senadoUrsoMineiro.repository.PautaRepository;
import com.senadoonline.senadoUrsoMineiro.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pautas")
public class PautaResource {

    @Autowired
    PautaRepository pautaRepository;

    @Autowired
    PautaService pautaService;

    @GetMapping
    public List<Pauta> listarPautas(){
        return pautaRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pauta> buscarPeloCodigo(@PathVariable Long codigo){
        Pauta pautaSalva = pautaService.buscarPeloCodigo(codigo);
        return pautaSalva != null ? ResponseEntity.ok().body(pautaSalva) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo){
        pautaRepository.deleteById(codigo);
    }

    @PostMapping
    public ResponseEntity<Pauta> criar(@Valid @RequestBody Pauta pauta){
        Pauta pautaSalva = pautaService.salvar(pauta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(pautaSalva.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(pauta);
    }

    @PostMapping("/aprovarPauta/{codigo}")
    public void aprovarPauta(@PathVariable Long codigo){
        pautaService.aprovarPauta(codigo);
    }

    @PostMapping("/reprovarPauta/{codigo}")
    public void reprovarPauta(@PathVariable Long codigo){
        pautaService.reprovarPauta(codigo);
    }
}
