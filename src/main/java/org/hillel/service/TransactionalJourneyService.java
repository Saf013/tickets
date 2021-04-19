package org.hillel.service;

import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.reposiory.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
