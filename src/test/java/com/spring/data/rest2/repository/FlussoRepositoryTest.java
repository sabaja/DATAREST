package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.FlussoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FlussoRepositoryTest {

    @Autowired
    private FlussoRepository flussoRepository;

    @Test
    void addPerformance_shouldWork() {
        FlussoEntity performanceMensile = new FlussoEntity();
        performanceMensile.setName("Flusso Settembre");
        performanceMensile.setStatus("Aperto");
        final FlussoEntity performanceMensileSaved = flussoRepository.save(performanceMensile);
        Assertions.assertNotNull(performanceMensileSaved);
    }


}