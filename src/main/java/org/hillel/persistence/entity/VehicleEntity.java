package org.hillel.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
public class VehicleEntity extends AbstractModifyEntity<Long>{

    @Column(name = "name", length = 100)
    private String nameVehicle;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @OneToMany(mappedBy = "vehicle")
    private List<JourneyEntity> journeys = new ArrayList<>();

    @OneToMany(mappedBy = "vehicleEntity", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<FreePlacesEntity> freePlaces = new ArrayList<>();

    public void addJourney(final JourneyEntity journeyEntity) {
        if (journeys == null) {
            journeys = new ArrayList<>();
        }
        journeys.add(journeyEntity);
        journeyEntity.addVehicle(this);
    }

    public void addFreePlaces(final FreePlacesEntity places) {
        if (freePlaces == null) {
            freePlaces = new ArrayList<>();
            return;
        }
        freePlaces.add(places);
        places.setVehicleEntity(this);
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "nameVehicle='" + nameVehicle + '\'' +
                '}';
    }
}
