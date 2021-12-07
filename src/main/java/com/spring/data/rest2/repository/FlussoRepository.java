package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.Flusso;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Flusso", path = "flusso")
public interface FlussoRepository extends PagingAndSortingRepository<Flusso, Long> {
}
