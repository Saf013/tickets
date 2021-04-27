package org.hillel.service;

import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.reposiory.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

@Service
public class TransactionalJourneyService {

    @Autowired
    private JourneyRepository journeyRepository;

    @Transactional
    public JourneyEntity createOrUpdate(final JourneyEntity journeyEntity) {
        Objects.requireNonNull(journeyEntity);
        return journeyRepository.createOrUpdate(journeyEntity);
    }

    @Transactional(readOnly = true)
    public Collection<JourneyEntity> findAll(){
        return journeyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Collection<JourneyEntity> findAllAsNative(){
        return journeyRepository.findAllAsNative();
    }

    @Transactional(readOnly = true)
    public Collection<JourneyEntity> findAllAsCriteria(){
        return journeyRepository.findAllAsCriteria();
    }

    @Transactional(readOnly = true)
    public Collection<JourneyEntity> findAllAsNamedQuery(String name) {
        return journeyRepository.findAllAsNamedQuery(name);
    }

    @Transactional(readOnly = true)
    public Collection<JourneyEntity> findAllAsStoredProcedure(){
        return journeyRepository.findAllAsStoredProcedure();
    }
}
