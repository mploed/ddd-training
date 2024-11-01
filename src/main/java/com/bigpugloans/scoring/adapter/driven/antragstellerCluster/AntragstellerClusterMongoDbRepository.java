package com.bigpugloans.scoring.adapter.driven.antragstellerCluster;

import com.bigpugloans.scoring.application.ports.driven.AntragstellerClusterRepository;
import com.bigpugloans.scoring.domain.model.Antragsnummer;
import com.bigpugloans.scoring.domain.model.antragstellerCluster.AntragstellerCluster;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@InfrastructureRing
@org.jmolecules.ddd.annotation.Repository
@SecondaryAdapter
public class AntragstellerClusterMongoDbRepository implements AntragstellerClusterRepository {
    private AntragstellerClusterSpringDataRepository dao;

    @Autowired
    public AntragstellerClusterMongoDbRepository(AntragstellerClusterSpringDataRepository dao) {
        this.dao = dao;
    }

    @Override
    public void speichern(AntragstellerCluster antragstellerCluster) {
        if(antragstellerCluster == null) {
            throw new IllegalArgumentException("AntragstellerCluster darf nicht null sein");
        }
        AntragstellerClusterDocument document = dao.findByAntragsnummer(antragstellerCluster.antragsnummer().nummer());
        if(document == null) {
            document = new AntragstellerClusterDocument();
            document.setAntragsnummer(antragstellerCluster.antragsnummer().nummer());
        }
        document.setAntragstellerCluster(antragstellerCluster);
        dao.save(document);
    }

    @Override
    public AntragstellerCluster lade(Antragsnummer antragsnummer) {
        if(antragsnummer == null) {
            throw new IllegalArgumentException("Antragsnummer darf nicht null sein");
        }
        AntragstellerClusterDocument document = dao.findByAntragsnummer(antragsnummer.nummer());
        if(document == null) {
            return null;
        } else {
            return document.getAntragstellerCluster();
        }
    }
}
