package org.hillel.persistence.reposiory;

import org.hillel.persistence.entity.StopEntity;
import org.springframework.stereotype.Repository;

@Repository
public class StopRepository extends CommonRepository<StopEntity, Long> {
    protected StopRepository() {
        super(StopEntity.class);
    }

    @Override
    public void remove(StopEntity entity) {
        entity = findById(entity.getId()).get();
        entity.removeJourney();
        super.remove(entity);
    }
}
