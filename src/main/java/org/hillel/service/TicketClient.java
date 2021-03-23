package org.hillel.service;

import org.hillel.Journey;
import org.hillel.persistence.entity.JourneyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class TicketClient {

    private JourneyService journeyService;

    @Autowired
    private TransactionalJourneyService transactionalJourneyService;

    public TicketClient(@Qualifier("inDataBaseJourneyService")JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @Transactional
    public Long create(final JourneyEntity journeyEntity) {
        return transactionalJourneyService.create(journeyEntity);
    }

    public Collection<Journey> find(String stationFrom, String stationTo) {
        return journeyService.find(stationFrom, stationTo);
    }

    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate departure, LocalDate arrival) {
        return journeyService.find(stationFrom, stationTo, departure, arrival);
    }

}
