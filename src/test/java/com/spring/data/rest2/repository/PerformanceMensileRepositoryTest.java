package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.FlussoEntity;
import com.spring.data.rest2.entities.PerformanceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PerformanceMensileRepositoryTest {

    @Autowired
    private PerformanceMensileRepository performanceMensileRepository;

    @Autowired
    private FlussoRepository flussoRepository;

    @Test
    void populateDatabase_couldWorks() {
        PerformanceEntity performanceMensile = new PerformanceEntity();
        performanceMensile.setName("Perfomance Agosto");
        performanceMensile.setState("Aperto");
        FlussoEntity flusso = new FlussoEntity();
        flusso.setName("Luca");
        flusso.setSurname("Suca");

        performanceMensile.setFlusso(flusso);


        final PerformanceEntity performanceMensileSaved = performanceMensileRepository.save(performanceMensile);
        Assertions.assertNotNull(performanceMensileSaved);
    }

    @Test
    void addFlusso_shouldWorks() {
        final PerformanceEntity performance = performanceMensileRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(performance);
        FlussoEntity flusso = new FlussoEntity();
        flusso.setName("Flusso");
        flusso.setSurname("Vero");
        performance.setFlusso(flusso);
        final PerformanceEntity performanceSaved = performanceMensileRepository.save(performance);
        Assertions.assertNotNull(performanceSaved);

    }

    @Test
    void addAnyFlussoEntity_shouldWorks() {
        final PerformanceEntity performance = performanceMensileRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(performance);
        IntStream.range(0, 10).forEach(i -> {
            FlussoEntity flusso = new FlussoEntity();
            flusso.setName("Flusso".concat(String.valueOf(i)));
            flusso.setSurname("Vero".concat(String.valueOf(i)));
            performance.setFlusso(flusso);
            final PerformanceEntity performanceEntity = performanceMensileRepository.save(performance);
            final FlussoEntity flussoEntity = flussoRepository.findById(performanceEntity.getFlusso().getId()).orElse(null);
            Assertions.assertNotNull(flussoEntity);
            Assertions.assertTrue(flussoEntity.getName().contains(String.valueOf(i)));
        });
    }

}