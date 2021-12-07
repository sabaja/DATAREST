package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.Flusso;
import com.spring.data.rest2.entities.PerformanceMensile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PerformanceMensileRepositoryTest {

    @Autowired
    private PerformanceMensileRepository performanceMensileRepository;

    @Test
    void populateDatabase_couldWorks() {
        PerformanceMensile performanceMensile = new PerformanceMensile();
        performanceMensile.setNome("Perfomance Agosto");
        performanceMensile.setStato("Aperto");
        Flusso flusso = new Flusso();
        flusso.setName("Luca");
        flusso.setSurname("Suca");

        performanceMensile.setFlusso(flusso);


        final PerformanceMensile performanceMensileSaved = performanceMensileRepository.save(performanceMensile);
        Assertions.assertNotNull(performanceMensileSaved);
    }
}