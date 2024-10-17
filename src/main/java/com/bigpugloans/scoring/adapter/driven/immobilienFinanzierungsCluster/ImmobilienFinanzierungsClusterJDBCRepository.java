package com.bigpugloans.scoring.adapter.driven.immobilienFinanzierungsCluster;

import com.bigpugloans.scoring.application.ports.driven.ImmobilienFinanzierungClusterRepository;
import com.bigpugloans.scoring.domain.model.Antragsnummer;
import com.bigpugloans.scoring.domain.model.immobilienFinanzierungsCluster.ImmobilienFinanzierungsCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ImmobilienFinanzierungsClusterJDBCRepository implements ImmobilienFinanzierungClusterRepository {
    private ImmobilienFinanzierungsClusterSpringDataRepository dao;

    @Autowired
    public ImmobilienFinanzierungsClusterJDBCRepository(ImmobilienFinanzierungsClusterSpringDataRepository dao) {
        this.dao = dao;
    }

    @Override
    public void speichern(ImmobilienFinanzierungsCluster immobilienFinanzierungsCluster) {
        ImmobilienFinanzierungsClusterRecord record = dao.findByAntragsnummer(immobilienFinanzierungsCluster.antragsnummer().nummer());
        if(record == null) {
            record = new ImmobilienFinanzierungsClusterRecord();
            record.setAntragsnummer(immobilienFinanzierungsCluster.antragsnummer().nummer());
        }
        record.setMemento(immobilienFinanzierungsCluster.memento());
        dao.save(record);
    }

    @Override
    public ImmobilienFinanzierungsCluster lade(Antragsnummer antragsnummer) {
        if(antragsnummer == null) {
            throw new IllegalArgumentException("Antragsnummer darf nicht null sein");
        }
        ImmobilienFinanzierungsClusterRecord record = dao.findByAntragsnummer(antragsnummer.nummer());
        if(record == null) {
            return null;
        } else {
            return ImmobilienFinanzierungsCluster.fromMemento(record.getMemento());
        }
    }
}
