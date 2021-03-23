package org.hillel.persistence.reposiory;

import org.hillel.persistence.entity.JourneyEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;

@Repository
public class JourneyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public  Long create(final JourneyEntity journeyEntity) {
        Objects.requireNonNull(journeyEntity);
        entityManager.persist(journeyEntity);
        return journeyEntity.getId();
    }
}
