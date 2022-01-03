package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.FlussoEntity;
import com.spring.data.rest2.entities.FlussoProjection;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FlussoRepositoryTest {

    private static final long FLUSSO_ID = 1L;

    @Autowired
    private FlussoRepository flussoRepository;

    @Autowired
    private AffidoDiFlussoRepository affidoDiFlussoRepository;

    @Test
    void addPerformance_shouldWork() {
        FlussoEntity performanceMensile = new FlussoEntity();
        performanceMensile.setName("Flusso Settembre");
        performanceMensile.setStatus("Aperto");
        final FlussoEntity performanceMensileSaved = flussoRepository.save(performanceMensile);
        Assertions.assertNotNull(performanceMensileSaved);
    }


    @Test
    void numberOfAffidoDiFlusso_shouldBe() {
        final FlussoProjection flusso = IterableUtils.first(flussoRepository.findAllById(FLUSSO_ID));
        final Long numberOfAffidiDiFlusso = flusso.getNumberOfAffidiDiFlusso();
        final Long totalByFlussoId = affidoDiFlussoRepository.getTotalByFlussoId(FLUSSO_ID);
        Assertions.assertEquals(numberOfAffidiDiFlusso, totalByFlussoId);

    }


}