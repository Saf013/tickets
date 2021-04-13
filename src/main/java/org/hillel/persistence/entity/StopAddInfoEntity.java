package org.hillel.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "stop_info")
@Getter
@Setter
@NoArgsConstructor
public class StopAddInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "build_date", nullable = false)
    private Instant buildDate;

    @Column(name = "description", length = 2000)
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "stop_id")
    private StopEntity stop;
}
