package com.spring.data.rest2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "AffidoDiFlusso")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AffidoDiFlussoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String affido;
    private String contratto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flusso_id")
    private FlussoEntity flusso;
}