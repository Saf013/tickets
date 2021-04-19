package org.hillel.persistence.reposiory;

import org.hillel.persistence.entity.VehicleEntity;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepository extends CommonRepository<VehicleEntity, Long> {

    protected VehicleRepository() {
        super(VehicleEntity.class);
    }
}
