package com.spring.data.rest2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "Flusso")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flusso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String surname;

    //https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private PerformanceMensile performanceMensile;
}