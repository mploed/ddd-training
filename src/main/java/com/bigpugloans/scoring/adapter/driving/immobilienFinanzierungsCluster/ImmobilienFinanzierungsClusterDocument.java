package com.bigpugloans.scoring.adapter.driving.immobilienFinanzierungsCluster;

import com.bigpugloans.scoring.domain.model.immobilienFinanzierungsCluster.ImmobilienFinanzierungsCluster;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "immobilienFinanzierungsCluster")
public class ImmobilienFinanzierungsClusterDocument {
    @Id
    private String id;

    private String antragsnummer;

    private ImmobilienFinanzierungsCluster immobilienFinanzierungsCluster;

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

    public ImmobilienFinanzierungsCluster getImmobilienFinanzierungsCluster() {
        return immobilienFinanzierungsCluster;
    }

    public void setImmobilienFinanzierungsCluster(ImmobilienFinanzierungsCluster immobilienFinanzierungsCluster) {
        this.immobilienFinanzierungsCluster = immobilienFinanzierungsCluster;
    }
}
