package org.hillel.service;

import org.hillel.persistence.entity.FreePlacesEntity;
import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketClient {

    @Autowired
    private TransactionalJourneyService transactionalJourneyService;

    @Autowired
    private TransactionalVehicleService vehicleService;

    @Autowired
    private TransactionalFreePlaces freePlaces;

    @Autowired
    private TransactionalStopService stopService;

    public JourneyEntity createOrUpdate(final JourneyEntity journeyEntity) {
        return transactionalJourneyService.createOrUpdate(journeyEntity);
    }

    public VehicleEntity createOrUpdate(final VehicleEntity vehicleEntity) {
        return vehicleService.createOrUpdate(vehicleEntity);
    }

    public FreePlacesEntity createOrUpdate(FreePlacesEntity freePlacesEntity) {
        return freePlaces.createOrUpdate(freePlacesEntity);
    }

    public StopEntity createOrUpdate(StopEntity stopEntity) {
        return stopService.createOrUpdate(stopEntity);
    }
}
