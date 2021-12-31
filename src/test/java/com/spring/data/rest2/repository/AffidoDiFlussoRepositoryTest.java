package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.AffidoDiFlussoEntity;
import com.spring.data.rest2.entities.FlussoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AffidoDiFlussoRepositoryTest {

    @Autowired
    private FlussoRepository flussoRepository;

    @Autowired
    private AffidoDiFlussoRepository affidoDiFlussoRepository;

    @Test
    void addAffidoDiFlusso_shouldWorks() {
        final FlussoEntity flusso = flussoRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(flusso);
        AffidoDiFlussoEntity affidoDiFlusso = new AffidoDiFlussoEntity();
        affidoDiFlusso.setAffido("Affido");
        affidoDiFlusso.setContratto("01NN341V");
        affidoDiFlusso.setFlusso(flusso);
        final FlussoEntity performanceSaved = flussoRepository.save(flusso);
        Assertions.assertNotNull(performanceSaved);

    }

    @Test
    void addAnyAffidoDiFlussoEntity_shouldWorks() {
        final FlussoEntity flusso = flussoRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(flusso);
        IntStream.range(0, 10).forEach(i -> {
            AffidoDiFlussoEntity affidoDiFlusso = new AffidoDiFlussoEntity();
            affidoDiFlusso.setAffido("Affido_".concat(String.valueOf(i)));
            affidoDiFlusso.setContratto("0X123413".concat(String.valueOf(i)));
            affidoDiFlusso.setFlusso(flusso);
            final AffidoDiFlussoEntity savedAffidoDiFlusso = affidoDiFlussoRepository.save(affidoDiFlusso);
            final AffidoDiFlussoEntity foundedAffidoDiFlusso = affidoDiFlussoRepository.findById(savedAffidoDiFlusso.getId()).orElse(null);
            Assertions.assertNotNull(foundedAffidoDiFlusso);
            Assertions.assertTrue(foundedAffidoDiFlusso.getAffido().contains(String.valueOf(i)));
        });
    }

}