package com.bigpugloans.scoring.adapter.driving.auskunfteiErgebnisCluster;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuskunfteiErgebnisClusterSpringDataRepository extends MongoRepository<AuskunfteiErgebnisClusterDocument, Long> {
    public AuskunfteiErgebnisClusterDocument findByAntragsnummer(String antragsnummer);
}
