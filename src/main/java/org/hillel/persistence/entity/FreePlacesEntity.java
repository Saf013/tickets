package org.hillel.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "free_places")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class FreePlacesEntity extends AbstractModifyEntity<Long> {

    @Column(name = "vehicel_name")
    private String vehicleName;

    @Column(name = "free_places")
    private Integer freePlaces;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicleEntity;

}
