package com.bigpugloans.scoring.adapter.driven.scoringErgebnis;

import com.bigpugloans.scoring.domain.model.Antragsnummer;
import com.bigpugloans.scoring.domain.model.scoringErgebnis.ScoringErgebnis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoringErgebnisSpringDataRepository extends JpaRepository<ScoringErgebnis, Long> {
    ScoringErgebnis findByAntragsnummer(Antragsnummer antragsnummer);
}
