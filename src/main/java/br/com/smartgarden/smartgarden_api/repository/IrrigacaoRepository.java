package br.com.smartgarden.smartgarden_api.repository;

import br.com.smartgarden.smartgarden_api.entity.Irrigacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrrigacaoRepository extends JpaRepository<Irrigacao, Long> {

    Irrigacao findTopByOrderByIdDesc();

}