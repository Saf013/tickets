package org.hillel;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@ToString
public class Journey {
    private final String STATION_FROM;
    private final String STATION_TO;
    private final LocalDate DEPARTURE;
    private final LocalDate ARRIVAL;
    private final String ROUTE;

    public Journey(final String STATION_FROM, final String STATION_TO, final LocalDate DEPARTURE, final LocalDate ARRIVAL, final String ROUTE) {
        if (STATION_FROM == null || STATION_FROM.isEmpty()) throw new IllegalArgumentException("station from must be set");
        if (STATION_TO == null || STATION_TO.isEmpty()) throw new IllegalArgumentException("station to must be set");
        if (DEPARTURE == null) throw new IllegalArgumentException("departure must be set");
        if (ARRIVAL == null) throw new IllegalArgumentException("arrival must be set");
        if (ROUTE == null || ROUTE.isEmpty()) throw new IllegalArgumentException("route must be set");
        this.STATION_FROM = STATION_FROM;
        this.STATION_TO = STATION_TO;
        this.DEPARTURE = DEPARTURE;
        this.ARRIVAL = ARRIVAL;
        this.ROUTE = ROUTE;
    }

}
