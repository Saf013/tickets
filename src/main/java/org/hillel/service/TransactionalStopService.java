package org.hillel.service;

import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.reposiory.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class TransactionalStopService {

    @Autowired
    private StopRepository stopRepository;

    @Transactional
    public StopEntity createOrUpdate(StopEntity stopEntity) {
        Objects.requireNonNull(stopEntity, "not must be null");
        return stopRepository.createOrUpdate(stopEntity);
    }

    @Transactional
    public void removeById(Long id) {
        stopRepository.removeById(id);
    }

    @Transactional
    public void remove(StopEntity stopEntity) {
        stopRepository.remove(stopEntity);
    }
}
