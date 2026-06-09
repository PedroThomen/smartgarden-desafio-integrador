package br.com.smartgarden.smartgarden_api.controller;

import br.com.smartgarden.smartgarden_api.entity.Leitura;
import br.com.smartgarden.smartgarden_api.repository.LeituraRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/leituras")
public class LeituraController {

    private final LeituraRepository repository;

    public LeituraController(LeituraRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Leitura salvar(@RequestBody Leitura leitura) {

        leitura.setDataHora(LocalDateTime.now());

        return repository.save(leitura);
    }

    @GetMapping
    public List<Leitura> listar() {
        return repository.findAll();
    }
}