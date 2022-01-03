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
public class FlussoEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    @Transient
    private Long totalOfAffidiDiFlusso;
}
