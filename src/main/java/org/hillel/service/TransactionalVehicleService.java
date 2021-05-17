package org.hillel.service;

import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.persistence.reposiory.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class TransactionalVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public VehicleEntity createOrUpdate(VehicleEntity vehicleEntity) {
        return vehicleRepository.createOrUpdate(vehicleEntity);
    }

    @Transactional
    public void removeById(Long id) {
        vehicleRepository.removeById(id);
    }

    @Transactional
    public void remove(VehicleEntity entity) {
        vehicleRepository.remove(entity);
    }

    @Transactional(readOnly = true)
    public Collection<VehicleEntity> findAll(){
        return vehicleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Collection<VehicleEntity> findAllAsNative(){
        return vehicleRepository.findAllAsNative();
    }

    @Transactional(readOnly = true)
    public Collection<VehicleEntity> findAllAsCriteriaPageSort(int page, int pageSize, String exp, boolean ascen){
        return vehicleRepository.findAllAsCriteriaPageSort(page, pageSize, exp, ascen);
    }

    @Transactional(readOnly = true)
    public Collection<VehicleEntity> findAllAsNamedQuery(String name) {
        return vehicleRepository.findAllAsNamedQuery(name);
    }

    @Transactional(readOnly = true)
    public Collection<VehicleEntity> findAllAsStoredProcedure() {
        return vehicleRepository.findAllAsStoredProcedure();
    }

    @Transactional(readOnly = true)
    public Collection<VehicleEntity> findAllVehiclesMinPlaces(){
        return vehicleRepository.findAllVehiclesMinPlaces();
    }

    @Transactional(readOnly = true)
    public Collection<VehicleEntity> findAllVehiclesMaxPlaces(){
        return vehicleRepository.findAllVehiclesMaxPlaces();
    }
}
