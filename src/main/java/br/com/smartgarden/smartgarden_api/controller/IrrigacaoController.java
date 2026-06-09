package br.com.smartgarden.smartgarden_api.controller;

import br.com.smartgarden.smartgarden_api.entity.Irrigacao;
import br.com.smartgarden.smartgarden_api.repository.IrrigacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/irrigacoes")
public class IrrigacaoController {

    private final IrrigacaoRepository repository;

    public IrrigacaoController(IrrigacaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Irrigacao salvar(@RequestBody Irrigacao irrigacao) {

        irrigacao.setDataHora(LocalDateTime.now());

        return repository.save(irrigacao);
    }

    @GetMapping
    public List<Irrigacao> listar() {
        return repository.findAll();
    }
}