package org.hillel.persistence.reposiory;

import org.hillel.persistence.entity.JourneyEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;

@Repository
public class JourneyRepository extends CommonRepository<JourneyEntity, Long>{

    protected JourneyRepository() {
        super(JourneyEntity.class);
    }
}
