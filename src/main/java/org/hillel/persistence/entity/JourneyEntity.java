package org.hillel.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "journey")
@Getter
@Setter
@NoArgsConstructor
public class JourneyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_from", length = 80, nullable = false)
    private String stationFrom;

    @Column(name = "station_to", length = 80, nullable = false)
    private String stationTo;

    @Column(name = "departure")
    private LocalDate departure;

    @Column(name = "arrival")
    private LocalDate arrival;

    @Column(name = "route", length = 80, nullable = false)
    private String route;
}
