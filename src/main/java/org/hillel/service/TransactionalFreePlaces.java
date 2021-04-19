package org.hillel.service;

import org.hillel.persistence.entity.FreePlacesEntity;
import org.hillel.persistence.reposiory.FreePlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalFreePlaces {

    @Autowired
    private FreePlacesRepository freePlacesRepository;

    @Transactional
    public FreePlacesEntity createOrUpdate(FreePlacesEntity freePlacesEntity) {
        return freePlacesRepository.createOrUpdate(freePlacesEntity);
    }
}
