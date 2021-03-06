package org.hillel;

import org.hillel.persistence.entity.*;
import org.hillel.persistence.entity.enm.Direction;
import org.hillel.service.TicketClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.Instant;

public class Starter {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("common-beans.xml");
        TicketClient ticketClient = applicationContext.getBean(TicketClient.class);
        JourneyEntity journeyEntity = buildJourney("Kiev", "Odessa", Instant.now(), Instant.now().plusSeconds(1000000),
                "Kiev->Odessa", Direction.TO, true);

        StopEntity stopEntity = buildStop("Kievskaya", "Kiev", 249D, 269D,
                Instant.now().minusSeconds(10000000), "");

        VehicleEntity vehicleEntity1 = buildVehicle("Bus_250", 60);
        journeyEntity.addStop(stopEntity);
        journeyEntity.addVehicle(vehicleEntity1);
        ticketClient.createOrUpdate(journeyEntity);

        vehicleEntity1.addFreePlaces(buildPlaces(vehicleEntity1.getNameVehicle(), 50));
        ticketClient.createOrUpdate(vehicleEntity1);
        System.out.println(ticketClient.findAllVehiclesAsStoredProcedure());
        System.out.println(ticketClient.findAllAsNamedQueryStops("findAllNamedQueryStops"));
        System.out.println(ticketClient.findAllJourneys());

    }

    public static JourneyEntity buildJourney(final String from, final String to, final Instant departure,
                                             final Instant arrival, final String route, final Direction direction, boolean active) {
        JourneyEntity journeyEntity = new JourneyEntity();
        journeyEntity.setStationFrom(from);
        journeyEntity.setStationTo(to);
        journeyEntity.setDeparture(departure);
        journeyEntity.setArrival(arrival);
        journeyEntity.setRoute(route);
        journeyEntity.setDirection(direction);
        journeyEntity.setActive(active);
        return journeyEntity;
    }

    public static VehicleEntity buildVehicle(final  String name, final Integer seats) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setNameVehicle(name);
        vehicleEntity.setNumberOfSeats(seats);
        return vehicleEntity;
    }

    public static StopEntity buildStop(final String name, final String city, final Double latitude,
                                       final Double longitude, final Instant createDate, final  String description) {
        final StopAddInfoEntity addInfoEntity = new StopAddInfoEntity();
        addInfoEntity.setLatitude(latitude);
        addInfoEntity.setLongitude(longitude);
        addInfoEntity.setBuildDate(createDate);
        addInfoEntity.setDescription(description);

        final StopEntity stopEntity = new StopEntity();
        stopEntity.setName(name);
        stopEntity.setCity(city);
        stopEntity.addAddInfo(addInfoEntity);
        return stopEntity;
    }

    public static FreePlacesEntity buildPlaces(final String vehName, final Integer places) {
        final FreePlacesEntity freePlacesEntity = new FreePlacesEntity();
        freePlacesEntity.setVehicleName(vehName);
        freePlacesEntity.setFreePlaces(places);
        return freePlacesEntity;
    }

}
