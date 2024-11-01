package com.bigpugloans.scoring.adapter.driven.auskunfteiErgebnisCluster;

import com.bigpugloans.scoring.domain.model.auskunfteiErgebnisCluster.AuskunfteiErgebnisCluster;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auskunfteiErgebnisCluster")
@InfrastructureRing
public class AuskunfteiErgebnisClusterDocument {
    @Id
    private String id;

    @Indexed(unique = true)
    private String antragsnummer;

    private AuskunfteiErgebnisCluster auskunfteiErgebnisCluster;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAntragsnummer() {
        return antragsnummer;
    }

    public void setAntragsnummer(String antragsnummer) {
        this.antragsnummer = antragsnummer;
    }

    public AuskunfteiErgebnisCluster getAuskunfteiErgebnisCluster() {
        return auskunfteiErgebnisCluster;
    }

    public void setAuskunfteiErgebnisCluster(AuskunfteiErgebnisCluster auskunfteiErgebnisCluster) {
        this.auskunfteiErgebnisCluster = auskunfteiErgebnisCluster;
    }
}
