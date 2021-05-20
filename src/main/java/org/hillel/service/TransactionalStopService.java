package org.hillel.service;

import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.jpa.repository.StopJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class TransactionalStopService {

    @Autowired
    private StopJpaRepository stopRepository;

    @Transactional
    public StopEntity createOrUpdate(StopEntity stopEntity) {
        Objects.requireNonNull(stopEntity, "not must be null");
        return stopRepository.save(stopEntity);
    }

    @Transactional
    public void removeById(Long id) {
        stopRepository.deleteById(id);
    }

    @Transactional
    public void remove(StopEntity stopEntity) {
        stopRepository.delete(stopEntity);
    }

    @Transactional(readOnly = true)
    public List<StopEntity> pageSort(int page, int pageSize, String sortParam, Sort.Direction direction) {
        return stopRepository.pageSort(PageRequest.of(page, pageSize, Sort.by(direction, sortParam)));
    }
}
