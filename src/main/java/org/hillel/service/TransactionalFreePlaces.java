package org.hillel.service;

import org.hillel.persistence.entity.FreePlacesEntity;
import org.hillel.persistence.reposiory.FreePlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class TransactionalFreePlaces {

    @Autowired
    private FreePlacesRepository freePlacesRepository;

    @Transactional
    public FreePlacesEntity createOrUpdate(FreePlacesEntity freePlacesEntity) {
        return freePlacesRepository.createOrUpdate(freePlacesEntity);
    }

    @Transactional(readOnly = true)
    public Collection<FreePlacesEntity> findAll(){
        return freePlacesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Collection<FreePlacesEntity> findAllAsNative(){
        return freePlacesRepository.findAllAsNative();
    }

    @Transactional(readOnly = true)
    public Collection<FreePlacesEntity> findAllAsCriteria(){
        return freePlacesRepository.findAllAsCriteria();
    }

    @Transactional(readOnly = true)
    public Collection<FreePlacesEntity> findAllAsNamedQuery(String name) {
        return freePlacesRepository.findAllAsNamedQuery(name);
    }

    @Transactional(readOnly = true)
    public Collection<FreePlacesEntity> findAllAsStoredProcedure() {
        return freePlacesRepository.findAllAsStoredProcedure();
    }
}
