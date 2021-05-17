package org.hillel.persistence.reposiory;

import org.hillel.persistence.entity.VehicleEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class VehicleRepository extends CommonRepository<VehicleEntity, Long> {

    protected VehicleRepository() {
        super(VehicleEntity.class);
    }

    @Override
    public void removeById(Long id) {
        final VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setId(id);
        remove(vehicleEntity);
    }

    @Override
    public void remove(VehicleEntity entity) {
        entity = findById(entity.getId()).get();
        entity.removeAllJourneys();
        super.remove(entity);
    }

    public Collection<VehicleEntity> findAllVehiclesMinPlaces(){
        return entityManager.createNativeQuery("select * from vehicle vh inner join free_places fp " +
                "on vh.id = fp.vehicle_id group by fp.id, vh.id " +
                "order by min(fp.free_places), fp.id", VehicleEntity.class).getResultList();
    }

    public Collection<VehicleEntity> findAllVehiclesMaxPlaces(){
        return entityManager.createNativeQuery("select * from vehicle vh inner join free_places fp " +
                "on vh.id = fp.vehicle_id group by fp.id, vh.id " +
                "order by max(fp.free_places) DESC, fp.id", VehicleEntity.class).getResultList();
    }
}
