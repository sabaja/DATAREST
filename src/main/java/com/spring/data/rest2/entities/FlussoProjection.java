package com.spring.data.rest2.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "flussoProjection", types = {FlussoEntity.class})
public interface FlussoProjection {

    Long getId();

    String getStatus();

    String getName();

    @Value(value = "#{@affidoDiFlussoRepository.getTotalByFlussoId(target.id)}")
    Long getNumberOfAffidiDiFlusso();
}
