package com.bigpugloans.scoring.adapter.driving.auskunfteiErgebnisCluster;

import com.bigpugloans.scoring.application.ports.driven.AuskunfteiErgebnisClusterRepository;
import com.bigpugloans.scoring.domain.model.Antragsnummer;
import com.bigpugloans.scoring.domain.model.auskunfteiErgebnisCluster.AuskunfteiErgebnisCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuskunfteiErgebnisClusterMongoDbRepository implements AuskunfteiErgebnisClusterRepository {
    private AuskunfteiErgebnisClusterSpringDataRepository dao;

    @Autowired
    public AuskunfteiErgebnisClusterMongoDbRepository(AuskunfteiErgebnisClusterSpringDataRepository dao) {
        this.dao = dao;
    }

    @Override
    public void speichern(AuskunfteiErgebnisCluster auskunfteiErgebnisCluster) {
        if(auskunfteiErgebnisCluster == null) {
            throw new IllegalArgumentException("AuskunfteiErgebnisCluster darf nicht null sein");
        }
        AuskunfteiErgebnisClusterDocument clusterEntity = new AuskunfteiErgebnisClusterDocument();
        clusterEntity.setAntragsnummer(auskunfteiErgebnisCluster.antragsnummer().nummer());
        clusterEntity.setAuskunfteiErgebnisCluster(auskunfteiErgebnisCluster);
        dao.save(clusterEntity);

    }

    @Override
    public AuskunfteiErgebnisCluster lade(Antragsnummer antragsnummer) {
        if(antragsnummer == null) {
            throw new IllegalArgumentException("Antragsnummer darf nicht null sein");
        }
        AuskunfteiErgebnisClusterDocument clusterEntity = dao.findByAntragsnummer(antragsnummer.nummer());
        if(clusterEntity == null) {
            return null;
        }
        return clusterEntity.getAuskunfteiErgebnisCluster();
    }
}