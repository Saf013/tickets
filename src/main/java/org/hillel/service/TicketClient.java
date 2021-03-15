package org.hillel.service;

import org.hillel.Journey;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
public class TicketClient {

    private JourneyService journeyService;

    public TicketClient(@Qualifier("inDataBaseJourneyService")JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    public Collection<Journey> find(String stationFrom, String stationTo) {
        return journeyService.find(stationFrom, stationTo);
    }

    public Collection<Journey> find(String stationFrom, String stationTo, LocalDate departure, LocalDate arrival) {
        return journeyService.find(stationFrom, stationTo, departure, arrival);
    }

}
