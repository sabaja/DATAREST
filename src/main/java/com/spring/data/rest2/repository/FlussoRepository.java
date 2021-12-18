package com.spring.data.rest2.repository;

import com.spring.data.rest2.entities.FlussoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "FlussoEntity", path = "flusso")
public interface FlussoRepository extends PagingAndSortingRepository<FlussoEntity, Long> {
}
