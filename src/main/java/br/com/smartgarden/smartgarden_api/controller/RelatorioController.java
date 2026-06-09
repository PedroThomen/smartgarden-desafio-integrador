package br.com.smartgarden.smartgarden_api.controller;

import br.com.smartgarden.smartgarden_api.entity.Irrigacao;
import br.com.smartgarden.smartgarden_api.entity.Leitura;
import br.com.smartgarden.smartgarden_api.repository.IrrigacaoRepository;
import br.com.smartgarden.smartgarden_api.repository.LeituraRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final LeituraRepository leituraRepository;
    private final IrrigacaoRepository irrigacaoRepository;

    public RelatorioController(LeituraRepository leituraRepository, IrrigacaoRepository irrigacaoRepository) {
        this.leituraRepository = leituraRepository;
        this.irrigacaoRepository = irrigacaoRepository;
    }

    @GetMapping
    public Map<String, Object> gerarRelatorio() {

        List<Leitura> leituras = leituraRepository.findAll();
        List<Irrigacao> irrigacoes = irrigacaoRepository.findAll();

        double media = 0;
        double maxima = 0;
        double minima = 0;

        if (!leituras.isEmpty()) {
            media = leituras.stream()
                    .mapToDouble(Leitura::getUmidade)
                    .average()
                    .orElse(0);

            maxima = leituras.stream()
                    .mapToDouble(Leitura::getUmidade)
                    .max()
                    .orElse(0);

            minima = leituras.stream()
                    .mapToDouble(Leitura::getUmidade)
                    .min()
                    .orElse(0);
        }

        long totalIrrigacoes = irrigacoes.stream()
                .filter(i -> Boolean.TRUE.equals(i.getLigada()))
                .count();

        Map<String, Object> relatorio = new HashMap<>();
        relatorio.put("mediaUmidade", media);
        relatorio.put("maximaUmidade", maxima);
        relatorio.put("minimaUmidade", minima);
        relatorio.put("totalIrrigacoes", totalIrrigacoes);

        return relatorio;
    }
}